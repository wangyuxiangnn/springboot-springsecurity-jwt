package com.kyle.controller;

import com.kyle.config.SnowflakeIdWorker;
import com.kyle.entity.User;
import com.kyle.exception.UsernameIsExitedException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.utility.RandomString;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
@Api(value = "注册管理", description = "注册管理")
public class RegisterController extends BaseController {

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    /**
     * 注册用户 默认开启白名单
     *
     * @param user
     */
    @ApiOperation(value = "注册用户")
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {

        User bizUser = userRepository.findByUsername(user.getUsername());
        if (null != bizUser) {
            throw new UsernameIsExitedException("用户已经存在");
        }
        user.setId(snowflakeIdWorker.nextId());
        user.setSalt(RandomString.make(6));
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().concat(user.getSalt()).getBytes()));
        return userRepository.save(user);
    }

}
