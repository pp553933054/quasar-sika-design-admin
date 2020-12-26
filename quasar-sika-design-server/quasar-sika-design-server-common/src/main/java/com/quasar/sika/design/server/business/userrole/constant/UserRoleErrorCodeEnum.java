package com.quasar.sika.design.server.business.userrole.constant;

import com.sika.code.basic.errorcode.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 用户角色表 错误枚举类
 * </p>
 *
 * @author daiqi
 * @since 2020-12-26 16:59:34
 */
@Getter
@AllArgsConstructor
public enum UserRoleErrorCodeEnum implements BaseErrorCode {
    /**
     * 错误枚举示例
     */
    USERROLE_ERROR_CODE_ENUM("USERROLE_000001", "错误枚举示例")
    ;

    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;
}
