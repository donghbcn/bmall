package com.bmall.service;

import com.bmall.domain.entity.Goods;
import com.bmall.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BMallApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private GoodsMapper goodsMapper;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<Goods> userList = goodsMapper.selectList(null);
		for(Goods goods:userList) {
			System.out.println(goods);
		}
	}
}
