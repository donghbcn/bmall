package com.bmall.controller;

import com.bmall.domain.entity.Goods;
import com.bmall.domain.entity.Inventory;
import com.bmall.domain.repository.InventoryRepository;
import com.bmall.mapper.InventoryMapper;
import com.bmall.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/{id}/{count}")
    public Long submitOrder(@RequestParam("user_id") Long userId, @PathVariable("id") Long goodsId, @PathVariable("count") Long count){
        long t1 = System.currentTimeMillis();
        long result = orderService.submitOrder(userId, goodsId, count);
        //log.info("time cost to submit order:{}", (System.currentTimeMillis() - t1));
        return result;
    }

    @RequestMapping("/submit")
    public Long submitOrder2(@RequestParam("user_id") Long userId, @RequestParam("goods_id") Long goodsId, @RequestParam("count") Long count){
        //log.info("submitOrder2, userId:{}, goodsId:{}, count:{}", userId, goodsId, count);
        long t1 = System.currentTimeMillis();
        long result = orderService.submitOrder(userId, goodsId, count);
        //log.info("time cost to submit order:{}", (System.currentTimeMillis() - t1));
        return result;
    }
}
