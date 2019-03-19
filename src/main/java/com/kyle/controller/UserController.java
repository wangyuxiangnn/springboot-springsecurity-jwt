package com.kyle.controller;

import com.kyle.entity.User;
import com.kyle.param.PageParam;
import com.kyle.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "用户管理", description = "用户管理")
public class UserController extends BaseController {

    /**
     * 获取用户列表
     * @return
     */
    @ApiOperation(value = "查询用户列表")
    @PostMapping("/userList")
    public R userList(@RequestBody PageParam pageParam){
        Page<User> userPage = userRepository.findAll(pageParam.getPageable());
        logger.info("users: {}", userPage.getContent());
        return new R(userPage);
    }

    @ApiOperation(value = "查询用户权限")
    @PostMapping("/authorityList")
    public List<String> authorityList(){
        List<String> authentication = getAuthentication();
        return authentication;
    }

}
