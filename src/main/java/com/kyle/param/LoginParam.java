package com.kyle.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginParam {

    @ApiModelProperty(value = "用户名", name = "username", example = "admin")
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "admin")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
