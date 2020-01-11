package top.estech.core.convert.impl;

import top.estech.core.convert.AbstractNumberConverter;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class ShortConverter extends AbstractNumberConverter<Short> {

    @Override
    protected Short cast(Number number) {
        return number.shortValue();
    }
}
