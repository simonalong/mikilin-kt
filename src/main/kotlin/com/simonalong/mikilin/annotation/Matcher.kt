package com.simonalong.mikilin.annotation

/**
 * @author     shizi
 * @since      2021-11-04 00:13:41
 */
@Repeatable
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Matcher(
        val value: Array<String> = []
)

