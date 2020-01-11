package top.estech.extra.geo;

/**
 * @author taoml
 * @date 2019-06-20
 */
public final class GeoUtil {

    public static GeoInfo parseByGeoLite(String ip) {
        return GeoLiteCall.INSTANCE.geo.parse(ip);
    }

    public static GeoInfo parseByGeoLiteWithLocalCache(String ip) {
        return GeoLiteCallLocalCache.INSTANCE.geo.parse(ip);
    }

    private enum GeoLiteCall {
        INSTANCE;
        private Geo geo;

        GeoLiteCall() {
            geo = Geo.builder()
                    .addParserFactory(GeoLiteParserFactory.create())
                    .build();
        }
    }

    private enum GeoLiteCallLocalCache {
        INSTANCE;
        private Geo geo;

        GeoLiteCallLocalCache() {
            geo = Geo.builder()
                    .addParserFactory(GeoLiteParserFactory.create())
                    .withCache(new LocalCache())
                    .build();
        }
    }
}
