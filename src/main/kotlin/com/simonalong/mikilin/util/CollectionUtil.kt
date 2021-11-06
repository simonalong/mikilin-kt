package com.simonalong.mikilin.util

/**
 * @author     shizi
 * @since      2021-11-06 16:43:17
 */
object CollectionUtil {

    fun isEmpty(collection: Collection<*>?): Boolean {
        return collection == null || collection.isEmpty()
    }

    fun isEmpty(map: Map<*, *>?): Boolean {
        return map == null || map.isEmpty()
    }
}
