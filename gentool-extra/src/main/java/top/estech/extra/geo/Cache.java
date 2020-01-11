package top.estech.extra.geo;

/**
 * 支持从缓存中提取GeoInfo。
 *
 * @author taoml
 * @date 2019-06-21
 */
public interface Cache {
    /**
     * 获取GeoInfo缓存。
     *
     * @param ip ip地址
     * @return geoinfo
     */
    GeoInfo get(String ip);

    void set(GeoInfo geoInfo);
}
