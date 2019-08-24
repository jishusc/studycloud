package com.test.product.utils;

import com.test.product.vo.ResultVO;

public class ResultVOUtil {

	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(0);
		resultVO.setMsg("success");
		resultVO.setData(object);
		return resultVO;
	}
}
