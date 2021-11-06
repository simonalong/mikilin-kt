package com.simonalong.mikilin

import com.simonalong.mikilin.util.ClassUtil
import com.simonalong.mikilin.util.ObjectUtil
import java.lang.reflect.Field

/**
 * @author     shizi
 * @since      2021-10-27 21:08:21
 */
object MkValidators {

    fun check(value: Any?): Boolean {
        return check(DEFAULT_GROUP, value)
    }

    fun check(group: String?, value: Any?): Boolean {
        if (ObjectUtil.isEmpty(value)) {
            return true
        }
        val groupDelegate = if (null == group || "" == group) DEFAULT_GROUP else group

        // 待核查类型不核查，直接返回核查成功
        return if (ClassUtil.isCheckedType(value.javaClass)) {
            true
        } else {
            check(groupDelegate, value, ClassUtil.allFieldsOfClass(ClassUtil.peel(value)), MkValidators.getObjFieldMap(value), MkValidators.getWhiteMap(), MkValidators.getBlackMap())
        }
    }

    private fun check(group: String, value: Any?, fieldSet: Set<Field>, objectFieldMap: Map<String, Set<String>>, whiteSet: Map<String, MatchManager>,
                      blackSet: Map<String, MatchManager>): Boolean {
        MkValidators.delegate.setParameter(group, value)
        return try {
            MkValidators.delegate.available(null, value, fieldSet, objectFieldMap, whiteSet, blackSet)
        } finally {
            MkValidators.delegate.clear()
        }
    }
}
