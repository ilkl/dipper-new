package com.yundasys.beidou.dipper.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.io.IOException;
import java.lang.reflect.Type;

public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * 序列化
     *
     * @param
     * @return
     */
    public static String serializeJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.error("serializeJson catch Exception " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * 字符串转json
     * @param json
     * @return
     */
    public static JsonNode strToJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("strToJson catch Exception " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * 反序列化简单对象
     *
     * @param json
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T deserializeJson(String json, Class<T> clz) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, clz);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("deserializeJson catch Exception " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * 反序列化复杂对象
     *
     * @param json
     * @param clz
     * @param clzType
     * @param <T>
     * @return
     */
    public static <T> T deserializeJson(String json, Class<T> clz, Type clzType) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            TypeReference typeReference = getReference(clz, clzType);
            return (T) mapper.readValue(json, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("deserializeJson catch Exception " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * 获取TypeReference对象(反序列化泛型用)
     *
     * @param clz
     * @param clzType
     * @param <T>
     * @return
     */
    private static <T> TypeReference<T> getReference(Class clz, Type clzType) {
        Type[] types = new Type[1];
        types[0] = clzType;
        final ParameterizedTypeImpl type = ParameterizedTypeImpl.make(clz, types, clz.getDeclaringClass());
        return new TypeReference<T>() {
            @Override
            public Type getType() {
                return type;
            }
        };
    }

}
