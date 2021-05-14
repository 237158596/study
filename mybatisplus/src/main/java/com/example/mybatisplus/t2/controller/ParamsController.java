package com.example.mybatisplus.t2.controller;


import com.example.mybatisplus.t2.service.IParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 参数 前端控制器
 * </p>
 *
 * @author sailer
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/t2/params")
public class ParamsController   implements ApplicationRunner {

    @Autowired
    private IParamsService paramsService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        paramsService.getData();

    }
}
