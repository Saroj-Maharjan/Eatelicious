package com.sawrose.eatelicious.commons.arch

interface Reducer<Mutation, ViewState> {
    operator fun invoke(mutation: Mutation, currentState: ViewState): ViewState
}