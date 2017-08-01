package com.ll.demo.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 类说明   : map做缓存的实例
 * 作者      :LiLi
 * 日期      :2017/8/1 10:35
 * 版本号    : V1.0
 */
public class MapCache {

    private static Map<String,Object> cacheMap;

    /*
     *添加
     * */
    public static void putCache(String key, Object value) {
        getCacheMap().put(key, value);
    }

    /*
     *获取
     * */
    public static Object getCache(String key, Object defaultValue) {
        Object object = getCacheMap().get(key);
        return object==null?defaultValue:object;
    }

    /*
    *删除
    * */
    public static void removeCache(String key) {
        getCacheMap().remove(key);
    }

    public static Map<String,Object> getCacheMap () {
        if (cacheMap == null) {
            cacheMap = new HashMap<String, Object>();
        }
        return cacheMap;
    }

    public static void main(String[] args) {
        putCache("1","张三");
        putCache("2","李四");
        putCache("3","王五");
        System.out.println("调用putCache(1,张三).............");
        System.out.println((String) getCache("1","默认"));
        System.out.println((String) getCache("2","默认"));
        System.out.println((String) getCache("3","默认"));
        removeCache("1");
        System.out.println("调用removeCache(1)..........");
        System.out.println((String) getCache("1","默认"));
        putCache("1","修改");
        System.out.println("再次调用putCache(1)..........");
        System.out.println((String) getCache("1","默认"));
    }
}
