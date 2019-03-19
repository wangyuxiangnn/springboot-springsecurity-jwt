package com.kyle.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @Author wangyuxiang
 * @Date 2019-03-18 22:54
 * @Version 1.0
 **/
@Setter
@Getter
public class PageParam {
    /**
     * ApiModelProperty()用于方法，字段 表示对model属性的说明或者数据操作更改
     * value–字段说明
     * name–重写属性名字
     * dataType–重写属性类型
     * required–是否必填
     * example–举例说明
     * hidden–隐藏
     */
    @ApiModelProperty(value = "下一页", name = "page", example = "0")
    private int page = 0;

    @ApiModelProperty(value = "条数", name = "size", example = "10")
    private int size = 10;

    public Pageable getPageable() {
        return PageRequest.of(page, size);
    }
}
