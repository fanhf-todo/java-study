package com.fanhf.javastudy.enumTest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author fanhf
 * @Description 统一枚举值
 * @date 2020-12-28 10:59
 */
@ApiModel(value = "静态数据")
@Data
@Builder
public class EnumInfo implements ResultBean {
    @ApiModelProperty(value = "key")
    private Integer code;
    @ApiModelProperty(value = "name")
    private String name;
}
