package exception.enums;

import exception.ErrorCode;

/**
 * GlobalErrorCodeConstants
 *
 * @author caiyang
 * @date 2026/4/14
 */
public interface GlobalErrorCodeConstants {

    ErrorCode SUCCESS = new ErrorCode(0, "成功");

    // 客户端错误
    ErrorCode BAD_REQUEST = new ErrorCode(400, "请求参数不正确");
}
