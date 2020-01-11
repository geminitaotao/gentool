package top.estech.core.convert.impl;

import top.estech.core.convert.AbstractNumberConverter;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class LongConverter extends AbstractNumberConverter<Long> {

    @Override
    protected Long cast(Number number) {
        return number.longValue();
    }
}
