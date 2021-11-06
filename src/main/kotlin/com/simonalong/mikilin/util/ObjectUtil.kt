package com.simonalong.mikilin.util

/**
 * @author     shizi
 * @since      2021-11-06 16:42:03
 */
object ObjectUtil {

    fun isEmpty(value: Any?): Boolean {
        return if (value is String) {
            val str = value
            "" == str || "null" == str || "undefined" == str
        } else if (value is Map<*, *>) {
            CollectionUtil.isEmpty(value)
        } else if (value is Collection<*>) {
            CollectionUtil.isEmpty(value)
        } else {
            value == null
        }
    }
}
