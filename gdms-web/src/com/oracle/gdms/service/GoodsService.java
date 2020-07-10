package com.oracle.gdms.service;

import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.PageModel;

public interface GoodsService {

	/**
	 * 分页显示商品数据
	 * @param pageNumber 当前页码
	 * @param rows 每页多少条记录
	 * @return 
	 */
	PageModel<GoodsModel> findByPage(int pageNumber, int rows);
}
