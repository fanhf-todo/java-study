package com.fanhf.javastudy.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-12-28 11:03
 */

public class ObjectMapperUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public ObjectMapperUtils() {
    }

    public static <T> JSONObject object2json(T t) throws Exception {
        return JSONObject.parseObject(objectMapper.writeValueAsString(t));
    }

    public static <T> T json2object(JSONObject json, Class<T> t) throws Exception {
        return objectMapper.readValue(JSONObject.toJSONString(json, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect}), t);
    }

    public static <T> List<T> json2objects(List<JSONObject> json, Class<T> t) throws Exception {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, new Class[]{t});
        return (List) objectMapper.readValue(JSONObject.toJSONString(json, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect}), javaType);
    }

    public static <T> List<JSONObject> objects2json(List<T> t) throws Exception {
        return JSONArray.parseArray(objectMapper.writeValueAsString(t), JSONObject.class);
    }

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(Include.NON_NULL);
    }
}

