package top.estech.extra.geo;

/**
 * ip解析后的实体结构。
 *
 * @author taoml
 * @date 2019-06-20
 */
public class GeoInfo {
    /**
     * IP地址
     */
    private String ip;
    /**
     * 数值IP
     */
    private Long longIp;
    /**
     * 国家
     */
    private String country;
    /**
     * 国家代码表
     */
    private String countryIsoCode;
    /**
     * 省份/州
     */
    private String province;
    /**
     * 省份/州代码表
     */
    private String provinceIsoCode;
    /**
     * 城市
     */
    private String city;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 时区
     */
    private String timeZone;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getProvinceIsoCode() {
        return provinceIsoCode;
    }

    public void setProvinceIsoCode(String provinceIsoCode) {
        this.provinceIsoCode = provinceIsoCode;
    }

    public Long getLongIp() {
        return longIp;
    }

    public void setLongIp(Long longIp) {
        this.longIp = longIp;
    }
}
