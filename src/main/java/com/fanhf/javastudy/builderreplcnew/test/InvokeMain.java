package com.fanhf.javastudy.builderreplcnew.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fanhf.javastudy.builderreplcnew.Builder;

/**
 * @author fanhf
 * @Description 测试主类
 * @date 2021-01-25 10:32
 */
public class InvokeMain {
    public static void main(String[] args) {
        Person person = Builder.of(Person::new)
                .with(Person::setBasicInfo,"fanhf",18,"Beijing China","BAT",2000.1)
                .with(Person::setSchool,"Peking University","Computer")
                .build();
        System.out.println(JSON.toJSONString(person, SerializerFeature.SortField,SerializerFeature.PrettyFormat));
    }
}   
