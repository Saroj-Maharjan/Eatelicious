package com.sawrose.eatelicious.core.data.remote

import com.sawrose.eatelicious.commons.network.SponcularEndpoints

object SponcularApiClient : BaseKtorClient(
    baseUrl = SponcularEndpoints.baseUrl,
)
