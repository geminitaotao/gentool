package top.estech.core.convert.impl;

import top.estech.core.convert.AbstractNumberConverter;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class IntegerConverter extends AbstractNumberConverter<Integer> {

    @Override
    protected Integer cast(Number number) {
        return number.intValue();
    }
}
