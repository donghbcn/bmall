package com.bmall.domain.repository;

import com.bmall.domain.entity.Order;
import com.bmall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository {

    @Autowired
    private OrderMapper orderMapper;

    public int insert(Order order){
        return orderMapper.insert(order);
    }
}
