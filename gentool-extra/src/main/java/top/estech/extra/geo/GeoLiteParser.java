package top.estech.extra.geo;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Subdivision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.estech.core.util.NetUtil;
import top.estech.core.util.StringUtil;

import java.net.InetAddress;

/**
 * @author taoml
 * @date 2019-06-20
 */
public class GeoLiteParser implements Parser {

    private DatabaseReader reader;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public GeoLiteParser(DatabaseReader reader) {
        this.reader = reader;
    }

    @Override
    public GeoInfo parse(String ip) {
        GeoInfo info = null;

        try {
            InetAddress address = InetAddress.getByName(ip);
            CityResponse response = reader.city(address);

            info = new GeoInfo();
            info.setIp(ip);
            info.setLongIp(NetUtil.ipv4ToLong(ip));

            Country country = response.getCountry();
            info.setCountry(country.getNames().get("zh-CN"));
            info.setCountryIsoCode(country.getIsoCode());

            Subdivision subdivision = response.getMostSpecificSubdivision();
            info.setProvince(subdivision.getNames().get("zh-CN"));
            info.setProvinceIsoCode(subdivision.getIsoCode());

            City city = response.getCity();
            info.setCity(city.getNames().get("zh-CN"));

            Location geoLocation = response.getLocation();
            info.setLatitude(geoLocation.getLatitude());
            info.setLongitude(geoLocation.getLongitude());
            info.setTimeZone(geoLocation.getTimeZone());
        } catch (Exception e) {
            logger.error("GeoLite2 parse exception. ip: {}", ip, e);
        }

        return info;
    }

    @Override
    public boolean parsable(GeoInfo geoInfo) {
        return geoInfo != null && StringUtil.isNotEmpty(geoInfo.getCountry());
    }
}
