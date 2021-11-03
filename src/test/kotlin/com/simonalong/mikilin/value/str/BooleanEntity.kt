package com.simonalong.mikilin.value.str

import com.simonalong.mikilin.annotation.Matcher

/**
 * @author     shizi
 * @since      2021-11-04 00:27:50
 */
class BooleanEntity {

    @Matcher(value = ["true", "null"])
    val flag: Boolean? = null
}
