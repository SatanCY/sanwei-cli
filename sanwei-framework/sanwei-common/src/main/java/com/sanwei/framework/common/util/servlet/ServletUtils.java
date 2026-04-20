package com.sanwei.framework.common.util.servlet;

import cn.hutool.extra.servlet.JakartaServletUtil;
import com.sanwei.framework.common.util.json.JsonUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;

/**
 * SecvletUtils
 *
 * @author caiyang
 * @date 2026/4/17
 */
public class ServletUtils {

    @SuppressWarnings("deprecation")
    public static void writeJSON(HttpServletResponse response, Object object) {
        String content = JsonUtils.toJsonString(object);
        JakartaServletUtil.write(response, content, MediaType.APPLICATION_JSON_UTF8_VALUE);
    }
}
