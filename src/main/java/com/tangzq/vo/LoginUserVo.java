package com.tangzq.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author tangzhiqiang
 */
@Getter
@Setter
public class LoginUserVo {

    @NotEmpty(message = "用戶名不能為空")
    private String username;

    @NotEmpty(message = "密碼不能為空")
    private String password;

    @NotEmpty(message = "驗證碼不能為空")
    private String validateCode;
}
