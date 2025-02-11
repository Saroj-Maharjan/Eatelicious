package com.sawrose.eatelicious.login

import android.content.Context
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.NoCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException

object GoogleSignInManager {
    private lateinit var credentialManager: CredentialManager

    suspend fun googleSignIn(
        context: Context,
        clientId: String,
        filterByAuthorizedAccounts: Boolean,
        doOnSuccess: (String) -> Unit,
        doOnFailure: (Exception) -> Unit,
    ) {
        if (::credentialManager.isInitialized.not()) {
            credentialManager = CredentialManager
                .create(context)
        }

        val googleIdOptions = GetGoogleIdOption
            .Builder()
            .setFilterByAuthorizedAccounts(true)
            .setServerClientId(clientId)
            .setAutoSelectEnabled(true)
            .build()

        val request = GetCredentialRequest
            .Builder()
            .addCredentialOption(googleIdOptions)
            .build()

        requestSignIn(
            context,
            request,
            clientId,
            filterByAuthorizedAccounts,
            doOnSuccess,
            doOnFailure,
        )
    }

    private suspend fun requestSignIn(
        context: Context,
        request: GetCredentialRequest,
        clientId: String,
        filterByAuthorizedAccounts: Boolean,
        doOnSuccess: (String) -> Unit,
        doOnFailure: (Exception) -> Unit,
    ) {
        runCatching {
            credentialManager.getCredential(
                request = request,
                context = context,
            )

        }.onFailure { exception ->
            if (exception is NoCredentialException && filterByAuthorizedAccounts) {
                googleSignIn(
                    context,
                    clientId,
                    false,
                    doOnSuccess,
                    doOnFailure,
                )
            } else {
                doOnFailure(Exception("Google Sign In Failed"))
            }
        }
            .onSuccess { response ->
                val displayName = handleCredential(response.credential)
                displayName?.let {
                    doOnSuccess(it)
                } ?: doOnFailure(Exception("Invalid User"))
            }
    }

    private fun handleCredential(credential: Credential): String? {
        when (credential) {
            is CustomCredential -> {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        // Use googleIdTokenCredential and extract id to validate and
                        // authenticate on your server.
                        val googleIdTokenCredential = GoogleIdTokenCredential
                            .createFrom(credential.data)
                        return googleIdTokenCredential.displayName
                    } catch (e: GoogleIdTokenParsingException) {
                        println("Received an invalid google id token response $e")
                    }
                } else {
                    // Catch any unrecognized custom credential type here.
                    println("Unexpected type of credential")
                }
            }

            else -> {
                // Catch any unrecognized credential type here.
                println("Unexpected type of credential")
            }
        }
        return null
    }

    suspend fun signOut(context: Context) {
        if (::credentialManager.isInitialized.not()) {
            credentialManager = CredentialManager
                .create(context)
        }

        credentialManager.clearCredentialState(ClearCredentialStateRequest())
    }
}