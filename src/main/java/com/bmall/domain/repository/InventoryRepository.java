package com.bmall.domain.repository;

import com.bmall.domain.entity.Inventory;
import com.bmall.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryRepository {
    @Autowired
    private InventoryMapper inventoryMapper;

    public Long getGoodsBalanceById(Long id){
        Inventory inventory = inventoryMapper.selectById(id);
        return inventory.getBalance();
    }

    public int deductBalance(Long id){
        Inventory inventory = inventoryMapper.selectById(id);
        inventory.setBalance(inventory.getBalance() - 1);
        return inventoryMapper.updateById(inventory);
    }
}
