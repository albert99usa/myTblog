package com.tangzq.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * @author tangzhiqiang
 */
@Getter
@Setter
@ToString
public class UserPwdVo {

    // private String uid;
    private int uid;
    private String username;

    @NotEmpty(message = "舊密碼不能為空")
    private String oldPwd;

    @NotEmpty(message = "新密碼不能為空")
    @Size(min = 6, max = 15, message = "新密碼必須在6到15個字元")
    private String newPwd;

    @NotEmpty(message = "新密碼不能為空")
    private String repeatNewPwd;
}
