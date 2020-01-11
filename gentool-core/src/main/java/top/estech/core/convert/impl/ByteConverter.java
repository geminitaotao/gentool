package top.estech.core.convert.impl;

import top.estech.core.convert.AbstractNumberConverter;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class ByteConverter extends AbstractNumberConverter<Byte> {

    @Override
    protected Byte cast(Number number) {
        return number.byteValue();
    }
}
