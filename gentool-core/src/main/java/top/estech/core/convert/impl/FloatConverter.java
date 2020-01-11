package top.estech.core.convert.impl;

import top.estech.core.convert.AbstractNumberConverter;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class FloatConverter extends AbstractNumberConverter<Float> {

    @Override
    protected Float cast(Number number) {
        return number.floatValue();
    }
}
