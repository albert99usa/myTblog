package com.tangzq.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tangzhiqiang
 */
@Getter
@Setter
@ToString
public class AvatarVo {

    private String uid;

    @NotEmpty(message = "頭像檔不能為空")
    private MultipartFile file;

}
