package com.test.order.utils;

import com.test.order.vo.ResultVO;

public class ResultVOUtil {

	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(0);
		resultVO.setMsg("success");
		resultVO.setData(object);
		return resultVO;
	}
}
