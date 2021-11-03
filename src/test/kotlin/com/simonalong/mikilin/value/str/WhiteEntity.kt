package com.simonalong.mikilin.value.str

import com.simonalong.mikilin.annotation.Matcher

/**
 * @author     shizi
 * @since      2021-11-04 00:20:34
 */
class WhiteEntity {

    @Matcher(["a", "b", "c", "null"])
    val name: String? = null
    val address: String? = null
}
