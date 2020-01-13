package top.estech.core.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author taoml
 * @date 2020-01-13
 */
public class DateUtil {

    /**
     * 获取时间戳。
     *
     * @return 时间戳
     */
    public static long timestamp() {
        return timestamp(LocalDateTime.now());
    }

    /**
     * 获取时间戳。
     *
     * @param dateTime 指定时间
     * @return 时间戳
     */
    public static long timestamp(LocalDateTime dateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = dateTime.atZone(zoneId).toInstant();
        return instant.toEpochMilli();
    }
}
