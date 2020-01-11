package top.estech.core.convert.impl;

import top.estech.core.convert.AbstractNumberConverter;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class DoubleConverter extends AbstractNumberConverter<Double> {

    @Override
    protected Double cast(Number number) {
        return number.doubleValue();
    }
}
