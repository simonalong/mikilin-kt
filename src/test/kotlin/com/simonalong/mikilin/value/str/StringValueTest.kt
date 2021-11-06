package com.simonalong.mikilin.value.str

import com.simonalong.mikilin.MkValidators
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * @author     shizi
 * @since      2021-11-06 15:20:28
 */
class StringValueTest {

    @Test
    fun numberTest() {
        assertTrue(MkValidators.check(BooleanEntity(true)))
//        assertFalse(MkValidators.check(BooleanEntity(false)))
//        assertTrue(MkValidators.check(BooleanEntity(null)))
    }
}
