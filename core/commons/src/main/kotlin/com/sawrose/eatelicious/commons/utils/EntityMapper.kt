package com.sawrose.eatelicious.commons.utils

/**
 * Helper function to transform a specific input to desired object output
 * */
interface EntityMapper<E, D> {
    fun mapFromEntity(entity: E): D

    fun mapToEntity(domain: D): E

    fun mapFromEntityList(entities: List<E>): List<D> {
        return entities
            .mapTo(
                mutableListOf(),
                ::mapFromEntity,
            )
    }

    fun mapFromDomainList(domainModels: List<D>): List<E> {
        return domainModels
            .mapTo(
                mutableListOf(),
                ::mapToEntity,
            )
    }
}
