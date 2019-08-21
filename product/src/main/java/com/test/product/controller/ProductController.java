package com.test.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.product.VO.ProductInfoVo;
import com.test.product.VO.ProductVo;
import com.test.product.VO.ResultVO;
import com.test.product.dataobject.ProductCategory;
import com.test.product.dataobject.ProductInfo;
import com.test.product.service.CategoryService;
import com.test.product.service.ProductService;
import com.test.product.utils.ResultVOUtil;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	/**
	 * 1.查询所有在架的商品 2.获取类目type列表 3.查询类目 4.构造数据
	 */
	@GetMapping("/list")
	public ResultVO<ProductVo> list() {
		// 1.查询所有在架的商品
		List<ProductInfo> productInfoList = productService.findUpAll();
		// 2.获取类目type列表
		List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType)
				.collect(Collectors.toList());
		// 3.从数据库查询类目
		List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

		// 4.构造数据
		List<ProductVo> productVoList = new ArrayList<>();
		for (ProductCategory productCategory : categoryList) {
			ProductVo productVo = new ProductVo();
			productVo.setCategoryName(productCategory.getCategoryName());
			productVo.setCategoryType(productCategory.getCategoryType());

			List<ProductInfoVo> productInfoVoList = new ArrayList<>();
			for (ProductInfo productInfo : productInfoList) {
				if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
					ProductInfoVo productInfoVo = new ProductInfoVo();
					BeanUtils.copyProperties(productInfo, productInfoVo);
					productInfoVoList.add(productInfoVo);
				}
			}
			productVo.setProductInfoVoList(productInfoVoList);
			productVoList.add(productVo);
		}

		return ResultVOUtil.success(productVoList);
	}

}
