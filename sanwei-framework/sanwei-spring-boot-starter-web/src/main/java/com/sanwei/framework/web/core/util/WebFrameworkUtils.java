package com.sanwei.framework.web.core.util;

import cn.hutool.core.util.NumberUtil;
import jakarta.servlet.http.HttpServletRequest;

/**
 * WebFrameworkUtil
 *
 * @author caiyang
 * @date 2026/4/17
 */
public class WebFrameworkUtils {

    private static final String REQUEST_ATTRIBUTE_LOGIN_USER_TYPE = "login_user_type";

    private static final String HEADER_TENANT_ID = "tenant_id";

    /**
     * 获取当前用户的类型
     * @param request 请求
     * @return 用户编号
     */
    public static Integer getLoginUserType(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        // 从 Attribute 中获取
        Integer userType = (Integer) request.getAttribute(REQUEST_ATTRIBUTE_LOGIN_USER_TYPE);
        if (userType != null) {
            return userType;
        }
        return null;
    }

    /**
     * 获取租户编号
     * @param request 请求
     * @return 租户编号
     */
    public static Long getTenantId(HttpServletRequest request) {
        String tenantId = request.getHeader(HEADER_TENANT_ID);
        return NumberUtil.isNumber(tenantId) ? Long.getLong(tenantId) : null;
    }
}
