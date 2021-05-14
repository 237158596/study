package com.example.mybatisplus.t2.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.mybatisplus.t2.entity.Params;
import com.example.mybatisplus.t2.mapper.ParamsMapper;
import com.example.mybatisplus.t2.service.IParamsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 参数 服务实现类
 * </p>
 *
 * @author sailer
 * @since 2021-05-13
 */
@Service
public class ParamsServiceImpl extends ServiceImpl<ParamsMapper, Params> implements IParamsService {

    @Override
    public Params getData() {

//        Params params=   baseMapper.selectOne(new LambdaQueryWrapper<Params>().eq(Params::getPdsn,"P007002630000103111")
//
//                );
//
//        params.setPhone("1111111");
//        baseMapper.update(params,new QueryWrapper<Params>().lambda().eq(Params::getPdsn,"P007002630000103111"));



//
//
//        Params params = new Params();
//        params.setPdsn("p1");
//        params.setSessionId("id1");
//        params.setParam("pram1");
//        baseMapper.insert(params);




        LambdaUpdateWrapper<Params> updateWrapper = new LambdaUpdateWrapper<>();

        updateWrapper.eq(Params::getPdsn,"P007002630000103111").set(Params::getPhone, System.currentTimeMillis());
        baseMapper.update(null, updateWrapper);




        return null;
    }
}
