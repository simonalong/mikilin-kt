package com.simonalong.mikilin

/**
 * @author     shizi
 * @since      2021-10-27 21:08:21
 */
object MkValidators {


        fun check(value: Any?): Boolean {
            return true
        }

        fun check(value: Any, vararg fieldSet: String): Boolean {
            return true
        }

        fun check(group: String, value: Any): Boolean {
            return true
        }

        fun check(group: String, value: Any, vararg fieldSet: String): Boolean {
            return true
        }

        fun validate(value: Any) {
            // todo
        }

        fun validate(value: Any, vararg fieldSet: String) {
            // todo
        }

        fun validate(group: String, value: Any) {
            // todo
        }

        fun validate(group: String, value: Any, vararg fieldSet: String) {
            // todo
        }
}
