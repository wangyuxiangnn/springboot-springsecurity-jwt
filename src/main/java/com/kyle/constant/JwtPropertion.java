package com.kyle.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "jwt")
public class JwtPropertion {

    private String header;

    /**
     * 签名key
     */
    private String secret;

    private String prefix;

    private Long expiration;

}
