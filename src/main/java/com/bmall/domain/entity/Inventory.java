package com.bmall.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Inventory {
    @TableId
    private Long goodsId;
    private Long balance;
}
