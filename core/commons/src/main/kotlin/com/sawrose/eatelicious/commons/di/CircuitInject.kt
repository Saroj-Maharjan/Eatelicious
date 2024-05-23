package com.sawrose.eatelicious.commons.di

import kotlin.reflect.KClass

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class CircuitInject(
    val scope: KClass<*>,
    val screen: KClass<*>,
)
