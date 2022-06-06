package com.bmall.controller;

import com.bmall.domain.entity.Goods;
import com.bmall.domain.repository.GoodsRepository;
import com.bmall.mapper.GoodsMapper;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    SimpleMeterRegistry meterRegistry;


    @RequestMapping("/{id}")
    public Goods getGoodsDetail(@PathVariable("id") Long id){
        Goods goods = goodsRepository.findGoodsById(id);
        //log.info("goods with id {}: {}", id, goods);
        // 创建一个 meter 注册中心
        Counter counter = meterRegistry.counter("goods.detail.requests");
        counter.increment();
        return goods;
    }
}
