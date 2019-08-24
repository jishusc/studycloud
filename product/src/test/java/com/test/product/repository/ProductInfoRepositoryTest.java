package com.test.product.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.product.dataobject.ProductInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Test
	public void testFindByProductStatus() {
		List<ProductInfo> lists = productInfoRepository.findByProductStatus(0);
		Assert.assertTrue(lists.size() > 0);
		System.out.println(lists.get(0).getProductName());

	}
	@Test
	public void testFindByProductIdIn() {
		List<ProductInfo> lists = productInfoRepository.findByProductIdIn(Arrays.asList(new String[] {"157875196366160022", "157875227953464068"}));
		Assert.assertTrue(lists.size() > 0);
	}

}
