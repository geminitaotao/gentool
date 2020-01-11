package top.estech.core.convert.impl;

import top.estech.core.convert.AbstractNumberConverter;

import java.math.BigDecimal;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class BigDecimalConverter extends AbstractNumberConverter<BigDecimal> {

    @Override
    protected BigDecimal cast(Number number) {
        return toBigDecimal(number);
    }
}
