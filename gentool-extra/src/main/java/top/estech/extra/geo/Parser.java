package top.estech.extra.geo;

/**
 * @author taoml
 * @date 2019-06-20
 */
public interface Parser {
    /**
     * 解析IP，转化成地理位置、经纬度
     *
     * @param ip IP
     * @return location对象
     */
    GeoInfo parse(String ip);

    /**
     * 判断解析器是否解析成功。
     * <p>
     * geo支持多个解析器对ip解析，
     * 调用此方法判断解析器解析是否成功，
     * 如果不成功调用下一个解析器。
     *
     * @param geoInfo
     * @return boolean
     */
    boolean parsable(GeoInfo geoInfo);
}
