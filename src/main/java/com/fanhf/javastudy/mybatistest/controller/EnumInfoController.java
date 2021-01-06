package com.fanhf.javastudy.mybatistest.controller;

import com.fanhf.javastudy.enumTest.AgeEnum;
import com.fanhf.javastudy.enumTest.EnumInfo;
import com.fanhf.javastudy.enumTest.ResultData;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author fanhf
 * @Description 枚举接口
 * @date 2020-12-28 10:58
 */

@RestController
@RequestMapping("/enums")
@Api(tags = "静态数据-枚举类")
@Slf4j
public class EnumInfoController {
    private static List<EnumInfo> ageList = Lists.newArrayList();

    static {
        ageList = ageEnumInit();
    }

    @ApiOperation("年龄")
    @PostMapping(value = "/getJobAgeList")
    public ResultData getJobAgeList() {
        return new ResultData().setList(ageList);
    }

    public static List<EnumInfo> ageEnumInit(){
        AgeEnum[] values = AgeEnum.values();
        Arrays.stream(values).forEach(ageEnum -> {
            EnumInfo enumInfo = EnumInfo.builder()
                    .code(ageEnum.getCode())
                    .name(ageEnum.getName())
                    .build();
            ageList.add(enumInfo);
        });
        return ageList;
    }
}   
