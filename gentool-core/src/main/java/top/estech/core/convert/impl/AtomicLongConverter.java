package top.estech.core.convert.impl;

import top.estech.core.convert.AbstractNumberConverter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class AtomicLongConverter extends AbstractNumberConverter<AtomicLong> {

    @Override
    protected AtomicLong cast(Number number) {
        return new AtomicLong(number.longValue());
    }
}
