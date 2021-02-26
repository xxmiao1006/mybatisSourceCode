package com.xuemiao.mybatis_myself.reflection;

import java.lang.reflect.Field;

/**
 * @author xxm
 * @date 2021/2/26 10:29
 */
public class ReflectionUtils {
    public static void setBeanProp(Object bean, String propName, Object propValue) {
        Field field = null;
        try {
            field = bean.getClass().getDeclaredField(propName);
            field.setAccessible(true);
            field.set(bean, propValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
