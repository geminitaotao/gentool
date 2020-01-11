package top.estech.core.convert.impl;

import top.estech.core.convert.AbstractNumberConverter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class AtomicIntegeConverter extends AbstractNumberConverter<AtomicInteger> {

    @Override
    protected AtomicInteger cast(Number number) {
        return new AtomicInteger(number.intValue());
    }
}
