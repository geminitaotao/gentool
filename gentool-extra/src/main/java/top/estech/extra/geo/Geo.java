package top.estech.extra.geo;

import java.util.ArrayList;
import java.util.List;

/**
 * geo类，通过设置相关属性解析ip。
 *
 * @author taoml
 * @date 2019-06-20
 */
public final class Geo {

    private Cache cache;
    private List<ParserFactory> factories;

    private Geo() {

    }

    public GeoInfo parse(String ip) {
        GeoInfo geoInfo;
        if (cache != null) {
            geoInfo = cache.get(ip);
            if (geoInfo == null) {
                geoInfo = geoInfo(ip, factories);
                cache.set(geoInfo);
            }
        } else {
            geoInfo = geoInfo(ip, factories);
        }

        return geoInfo;
    }

    public Cache getCache() {
        return cache;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private Cache cache;
        private List<ParserFactory> factories = new ArrayList<>();

        public Builder withCache(Cache cache) {
            this.cache = cache;
            return this;
        }

        public Builder addParserFactory(ParserFactory factory) {
            factories.add(factory);
            return this;
        }

        public Geo build() {
            Geo context = new Geo();
            context.cache = this.cache;
            context.factories = this.factories;
            if (factories.isEmpty()) {
                factories.add(GeoLiteParserFactory.create());
            }
            return context;
        }
    }

    private static GeoInfo geoInfo(String ip, List<ParserFactory> factories) {
        GeoInfo geoInfo = null;
        for (ParserFactory factory : factories) {
            Parser parser = factory.getParser();
            geoInfo = parser.parse(ip);
            if (!parser.parsable(geoInfo)) {
                continue;
            }
        }
        return geoInfo;
    }
}
