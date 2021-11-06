package com.simonalong.mikilin.value.str

import com.simonalong.mikilin.MkValidators
import org.junit.Assert
import spock.lang.Specification

/**
 * @author shizi
 * @since 2021-11-06 15:51:40
 */
class StringValueSpock extends Specification {

    def "number类型测试"(){
        given:
        BooleanEntity entity = new BooleanEntity()
        entity.setFlag(flag)

        expect:
        boolean actResult = MkValidators.check(entity)
        Assert.assertEquals(result, actResult)

        where:
        flag  | result
        true  | true
    }
}
