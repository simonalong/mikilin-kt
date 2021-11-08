package com.simonalong.mikilin

import com.simonalong.mikilin.util.ClassUtil
import com.simonalong.mikilin.util.ClassUtil.isCheckedType
import com.simonalong.mikilin.util.ObjectUtil
import java.lang.reflect.Field
import kotlin.reflect.KClass

/**
 * @author     shizi
 * @since      2021-10-27 21:08:21
 */
object MkValidators {

    fun check(value: Any?): Boolean {
        if (null == value) {
            return true
        }

        if (ObjectUtil.isEmpty(value)) {
            return true
        }

        // 基本类型
        if (ClassUtil.isCheckedType(value::class)) {
            return true
        }

        // 搜集match

        var matcherMap = MutableMap

    }
}
