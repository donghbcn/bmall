package com.bmall.domain.repository;

import com.bmall.domain.entity.Goods;
import com.bmall.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodsRepository {
    @Autowired
    private GoodsMapper goodsMapper;

    public Goods findGoodsById(Long id){
        return goodsMapper.selectById(id);
    }
}
