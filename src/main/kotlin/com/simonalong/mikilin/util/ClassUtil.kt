package com.simonalong.mikilin.util

import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberExtensionProperties
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberExtensionProperties
import kotlin.reflect.full.memberProperties

/**
 * @author     shizi
 * @since      2021-11-06 16:44:15
 */
object ClassUtil {

    /**
     * 获取一个对象类的所有属性，包括继承的
     *
     * @param cls 待获取的类
     * @return 类的所有属性
     */
    fun allFieldsOfClass(cls: KClass<*>?): Set<KProperty1<*, *>> {
        val fieldSet: MutableSet<KProperty1<*, *>> = HashSet()
        if (null == cls) {
            return fieldSet
        }
        fieldSet.addAll(cls.declaredMemberExtensionProperties as Collection<KProperty1<*, *>>)
        fieldSet.addAll(cls.declaredMemberProperties as Collection<KProperty1<*, *>>)
        fieldSet.addAll(cls.memberExtensionProperties as Collection<KProperty1<*, *>>)
        fieldSet.addAll(cls.memberProperties as Collection<KProperty1<*, *>>)
        return fieldSet
    }

    fun isCheckedType(cls: KClass<*>?): Boolean {
        val baseFlag = cls?.javaPrimitiveType?.isPrimitive
        return if (null == baseFlag || baseFlag) {
            true
        } else {
            if (cls.isAbstract || cls.isCompanion || cls.isFinal || cls.isFun || cls.isOpen || cls.isInner || cls.isSealed) {
                return false
            }

            if (Number::class == cls) {
                return true
            }
            if (String::class == cls) {
                return true
            }
            if (Date::class == cls) {
                return true
            }
            true
        }
    }

    /**
     * 解析对象包括通配符部分的结构
     *
     * 将对象集合或者Map对象（只关心value）拆解开，获取对应的值的类 例如：`Map<String, AEntity>` 到 `Class<AEntity>`，`List<BEntity>` 到 `Class<BEntity>`
     *
     * 逻辑同[ObjectUtil.parseObject]，但是 parseObject 会将对象削减
     *
     * @param value 待解析对象
     * @return 解析后的对象和对象的类型：key为解析后的对象值，value为key对应的类型
     */
    fun peel(value: Any?): KClass<*>? {
        if (null == value) {
            return null
        }
        return if (value is Collection<*>) {
            if (!value.isEmpty()) {
                val iterator = value.iterator()
                if (iterator.hasNext()) {
                    return peel(iterator.next())
                }
            }
            null
        } else if (value is Map<*, *>) {
            peel(value.values)
        } else {
            if (isCheckedType(value::class)) {
                null
            } else value::class
        }
    }
}
