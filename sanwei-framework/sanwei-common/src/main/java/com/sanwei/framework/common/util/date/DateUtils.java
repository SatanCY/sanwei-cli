package com.sanwei.framework.common.util.date;

import java.time.LocalDateTime;

/**
 * DateUtils
 *
 * @author caiyang
 * @date 2026/4/17
 */
public class DateUtils {

    /**
     * 判断是否过期
     * @param time 过期时间
     * @return 判断结果
     */
    public static boolean isExpired(LocalDateTime time) {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(time);
    }
}
