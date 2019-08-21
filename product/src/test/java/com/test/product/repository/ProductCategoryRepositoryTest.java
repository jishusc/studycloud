package com.test.product.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.product.dataobject.ProductCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Test
	public void testFindByCategoryTypeIn() {
		List<ProductCategory> productCategoryList = productCategoryRepository
				.findByCategoryTypeIn(Arrays.asList(11, 22));
		Assert.assertTrue(productCategoryList.size() > 0);
		System.out.println(productCategoryList.get(0).getCategoryName());
	}

}
