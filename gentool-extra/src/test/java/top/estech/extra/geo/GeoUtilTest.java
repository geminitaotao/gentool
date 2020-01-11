package top.estech.extra.geo;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author taoml
 * @date 2019-06-21
 */
public class GeoUtilTest {

    @Test
    public void testParseByGeoLiteWithLocalCache() {
        String ip = "183.129.218.236";
        GeoInfo geoInfo = GeoUtil.parseByGeoLiteWithLocalCache(ip);
        Assert.assertEquals("中国", geoInfo.getCountry());
        Assert.assertEquals("浙江省", geoInfo.getProvince());
        System.out.println(JSON.toJSONString(geoInfo));
    }
}
