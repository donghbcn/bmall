package com.bmall.service;

import com.bmall.domain.entity.Goods;
import com.bmall.domain.entity.Order;
import com.bmall.domain.repository.GoodsRepository;
import com.bmall.domain.repository.InventoryRepository;
import com.bmall.domain.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Service
public class OrderService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private GoodsRepository goodsRepository;
    
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Long submitOrder(Long userId, Long goodsId, Long count){
        Goods goods = goodsRepository.findGoodsById(goodsId);
        Long balance = inventoryRepository.getGoodsBalanceById(goodsId);
        inventoryRepository.deductBalance(goodsId);
        Order order = Order.of(userId, goods, count);
        int result = orderRepository.insert(order);
        //log.info("order is created, result:{}, id:{}", result, order.getId());
        return balance;
    }
}
