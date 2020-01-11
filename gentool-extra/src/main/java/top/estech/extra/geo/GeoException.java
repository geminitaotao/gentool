package top.estech.extra.geo;

import top.estech.core.util.ExceptionUtil;
import top.estech.core.util.StringUtil;

/**
 * @author taoml
 * @date 2019-06-20
 */
public class GeoException extends RuntimeException {
    public GeoException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public GeoException(String message) {
        super(message);
    }

    public GeoException(String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params));
    }

    public GeoException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public GeoException(Throwable throwable, String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params), throwable);
    }
}
