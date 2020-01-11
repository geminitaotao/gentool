package top.estech.extra.geo;

import com.maxmind.db.CHMCache;
import com.maxmind.geoip2.DatabaseReader;

import java.io.IOException;
import java.io.InputStream;

/**
 * GeoLite脱机数据库解析。
 * 因为脱机库文件较大，所以解析器以singleton
 *
 * @author taoml
 * @date 2019-06-20
 */
public class GeoLiteParserFactory implements ParserFactory {

    GeoLiteParserFactory() {

    }

    public static GeoLiteParserFactory create() {
        return new GeoLiteParserFactory();
    }

    @Override
    public Parser getParser() {
        return GeoLiteParserEnum.INSTANCE.parser();
    }

    private enum GeoLiteParserEnum {
        INSTANCE;

        private Parser parser;

        GeoLiteParserEnum() {
            try {
                InputStream inputStream = GeoLiteParserFactory.class.getClassLoader().getResourceAsStream("GeoLite2-City.mmdb");
                DatabaseReader reader = new DatabaseReader.Builder(inputStream).withCache(new CHMCache()).build();
                parser = new GeoLiteParser(reader);
            } catch (IOException e) {
                throw new GeoException(e);
            }
        }

        public Parser parser() {
            return parser;
        }
    }
}
