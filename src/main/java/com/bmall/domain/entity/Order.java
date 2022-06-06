package com.bmall.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.Data;

import static com.baomidou.mybatisplus.annotation.IdType.ID_WORKER;

@TableName("`order`")
@Data
public class Order {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private Long userId;
    private Long goodsId;
    private Long count;
    private Long amount;

    public static Order of(Long userId, Goods goods, Long count){
        Order order = new Order();
        //order.setId(IdWorker.getId());
        order.setUserId(userId);
        order.setGoodsId(goods.getId());
        order.setCount(count);
        order.setAmount(goods.getPrice() * count);
        return order;
    }
}
