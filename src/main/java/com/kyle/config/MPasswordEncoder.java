package com.kyle.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

public class MPasswordEncoder implements PasswordEncoder {

    /**
     * 对密码进行加密并返回
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
    }

    /**
     * 验证密码是否正确
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword != null && encodedPassword.length() != 0) {
            return encode(rawPassword).equals(encodedPassword);
        } else {
            return false;
        }
    }
}