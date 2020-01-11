package top.estech.core.util;

/**
 * @author taoml
 * @date 2019-09-02
 */
public class ObjectUtil {

    /**
     * 比较两个对象是否相等。
     *
     * @param obj1 对象1
     * @param obj2 对象2
     * @return 是否相等
     */
    public static boolean equal(Object obj1, Object obj2) {
        return (obj1 == obj2) || (obj1 != null && obj1.equals(obj2));
    }
}
