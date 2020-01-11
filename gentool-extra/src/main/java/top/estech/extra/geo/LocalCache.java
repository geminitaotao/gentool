package top.estech.extra.geo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author taoml
 * @date 2019-06-21
 */
public class LocalCache implements Cache {

    private static final Map<String, GeoInfo> CACHE = new ConcurrentHashMap<>();

    public LocalCache() {

    }

    @Override
    public GeoInfo get(String ip) {
        return CACHE.get(ip);
    }

    @Override
    public void set(GeoInfo geoInfo) {
        if (geoInfo == null) {
            return;
        }
        CACHE.put(geoInfo.getIp(), geoInfo);
    }
}
