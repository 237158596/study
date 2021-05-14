package com.example.mybatisplus.t2.service;

import com.example.mybatisplus.t2.entity.Params;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 参数 服务类
 * </p>
 *
 * @author sailer
 * @since 2021-05-13
 */
public interface IParamsService extends IService<Params> {


   Params getData();

}
