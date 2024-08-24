package com.sawrose.eatelicious.core.data.remote

import com.sawrose.eatelicious.commons.network.SponcularEndpoints

/**
 * Provide various common state needed for the API to function
 * */
interface ApiStateProvider {
    /**
     * The base address of the server. this cannot be null when making api calls
     * */
    var serverAddress: String?

    /**
     * An [Authorisation] to use for every api calls. This cannot be null when making api calls.
     * */
    var authorisation: Authorisation?
}

/**
 * A sealed class that defines the various authorisation types that can be used for the API
 * */
sealed class Authorisation {

    /**
     * Basic (username, password) authorisation.
     *
     * @property username The username for auth.
     * @property password The password for the auth.
     * */
    data class Basic(val username: String, val password: String) : Authorisation()

    /**
     * Authorisation via API key
     *
     * @property apiKey The API key to use for authorisation.
     * */
    data class ApiKey(val apiKey: String) : Authorisation()

    /**
     * Authorisation via Bearer token
     *
     * @property token The token to use for authorisation.
     * */
    data class Bearer(val token: String) : Authorisation()
}

internal class SpooncularApiStateProvider: ApiStateProvider {
    override var serverAddress: String? = SponcularEndpoints.baseUrl
    override var authorisation: Authorisation? = Authorisation.ApiKey(SponcularEndpoints.apiKey)
}