package com.sanwei.framework.common.util.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * JsonUtils
 *
 * @author caiyang
 * @date 2026/4/17
 */
@Slf4j
public class JsonUtils {

    @Getter
    private static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows // “偷偷抛出”受检异常（Checked Exception），从而绕过 Java 编译器的强制 try-catch 或 throws 声明要求
    public static String toJsonString(Object object) {
        return objectMapper.writeValueAsString(object);
    }
}
