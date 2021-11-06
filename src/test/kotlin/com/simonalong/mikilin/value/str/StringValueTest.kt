package com.simonalong.mikilin.value.str

import com.simonalong.mikilin.MkValidators
import org.jetbrains.annotations.TestOnly
import org.junit.Test
import kotlin.test.assertTrue

/**
 * @author     shizi
 * @since      2021-11-06 15:20:28
 */
class StringValueTest {

    @Test
    fun test1() {
        assertTrue(MkValidators.check("sdf"))
    }
}
