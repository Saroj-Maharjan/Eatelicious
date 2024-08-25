package com.sawrose.eatelicious.feature.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sawrose.eatelicious.feature.LogFileViewmodel
import com.sawrose.eatelicious.feature.LogScreen
import org.koin.androidx.compose.koinViewModel

const val LOGFILE_ROUTE = "logfile"
fun NavGraphBuilder.logfileScreen() {
    composable(LOGFILE_ROUTE) {
        val viewmodel: LogFileViewmodel = koinViewModel()
        val viewstate by viewmodel.viewState.collectAsStateWithLifecycle()

        LogScreen(
            viewState = viewstate,
        )
    }
}
