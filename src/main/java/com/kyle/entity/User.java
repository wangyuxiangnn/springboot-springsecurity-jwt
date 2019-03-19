package com.kyle.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value = {"password","age","salt","createTime","updateTime","delFlag","accountNonExpired","accountNonLocked","credentialsNonExpired","enabled"}, allowSetters = true)
public class User implements UserDetails {

    @Id
//    @GeneratedValue
    private Long id;

    @Column(columnDefinition="varchar(50)",nullable = false)
    private String username;

    @Column
    private Integer age;

    @Column(columnDefinition="varchar(50)",nullable = false)
    private String salt;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date updateTime = new Date();

    @Column(columnDefinition = "tinyint default 0 comment '0:未删除 1:已删除'")
    private Byte delFlag = 0;

    public User(String username, Integer age,String salt,String password) {
        this.username = username;
        this.age = age;
        this.salt = salt;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}