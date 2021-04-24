package com.unidev.business.repositories

object RepositoryFactory {
    private val factories = mutableSetOf<IFactory>()

    fun register(factory: IFactory) {
        factories.add(factory)
    }

    fun <T> acquire(clazz: Class<T>): T {
        factories.forEach {
            val tmp = it.acquire(clazz)
            if (tmp != null) {
                return tmp
            }
        }

        throw IllegalStateException("cant create implementation: $clazz")
    }

    interface IFactory {
        fun <T> acquire(clazz: Class<T>): T?
    }
}
