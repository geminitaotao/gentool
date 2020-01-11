package top.estech.core.convert.impl;

import top.estech.core.convert.AbstractNumberConverter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class BigIntegerConverter extends AbstractNumberConverter<BigInteger> {

    @Override
    protected BigInteger cast(Number number) {
        BigDecimal bigDecimal = toBigDecimal(number);
        return bigDecimal.toBigInteger();
    }
}
