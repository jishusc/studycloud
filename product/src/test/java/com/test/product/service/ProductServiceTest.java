package com.test.product.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.product.ProductApplicationTest;
import com.test.product.dataobject.ProductInfo;

@Component
public class ProductServiceTest extends ProductApplicationTest {
	@Autowired
	private ProductService productService;

	@Test
	public void testFindUpAll() {
		List<ProductInfo> lists = productService.findUpAll();
		Assert.assertTrue(lists.size() > 0);
	}
	
	@Test
	public void testFindList() {
		List<ProductInfo> lists = productService.findList(Arrays.asList(new String[] {"157875196366160022"}));
		Assert.assertTrue(lists.size() > 0);
	}

}
