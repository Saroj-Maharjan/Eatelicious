package com.sawrose.eatelicious.feature.bookmark.di

import com.sawrose.eatelicious.feature.bookmark.BookmarkViewmodel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val bookmarkKoinModule = module {
    viewModelOf(::BookmarkViewmodel)
}
