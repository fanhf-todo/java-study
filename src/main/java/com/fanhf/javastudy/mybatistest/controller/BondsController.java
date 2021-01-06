package com.fanhf.javastudy.mybatistest.controller;

import com.fanhf.javastudy.mybatistest.bean.BondsBean;
import com.fanhf.javastudy.mybatistest.service.BondsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-20 11:46
 */
@RestController
@RequestMapping("/bonds")
@Api(tags = "基金管理类")
@Slf4j
public class BondsController {
    @Autowired
    private BondsService bondsService;

    @PostMapping(value = "/bondslist")
    @ApiOperation(value = "列表展示")
    public List<BondsBean> getBondsList(){
       List<BondsBean>  bondsList = bondsService.getBondsList();
       log.info("{}",bondsList.toString());
       return bondsList;
    }

    @PostMapping(value = "/bondslistById")
    @ApiOperation(value = "列表展示")
    public BondsBean getBondsListById(@RequestBody BondsBean bondsBean){
        return bondsService.getBondsListById(bondsBean);
    }
    @PostMapping(value = "/insert")
    @ApiOperation(value = "插入")
    public Integer insert(@RequestBody BondsBean bondsBean){
        return bondsService.insert(bondsBean);
    }
    @PostMapping(value = "/redisDemo")
    /**
     * redis类型
     * @param type
     */
//    @ApiOperation(value = "redis不同数据结构demo")
    //如果是在多线程的需求下，要实现线程安全，可以给他加上上面说的@Scope注解，如下：
//    @Scope(value = "prototype")//加上@Scope注解，他有2个取值：单例-singleton 多实例-prototype，但着也不能保证真的安全了
    //或者用 ThreadLocal<Integer> tl = new ThreadLocal<>(); // 用ThreadLocal来封装变量
    public void getBondsRedis(@RequestBody String  type){
        bondsService.getBondsRedis(type);
         bondsService.getBondsRedis(type);
    }
}   
