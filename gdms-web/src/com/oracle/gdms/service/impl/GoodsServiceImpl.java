package com.oracle.gdms.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.oracle.gdms.dao.GoodsDao;
import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.PageModel;
import com.oracle.gdms.service.GoodsService;
import com.oracle.gdms.util.GDMSUtil;

public class GoodsServiceImpl extends BaseService implements GoodsService {

	@Override
	public PageModel<GoodsModel> findByPage(int pageNumber, int rows) {
		PageModel<GoodsModel> obj = new PageModel<GoodsModel>();
		obj.setCurrent(pageNumber); // ��ǰҳ
		
		try {
			session = GDMSUtil.getSession();
			GoodsDao dao = session.getMapper(GoodsDao.class);
			
			int count = dao.findCount();	// ��ѯ�ܼ�¼����
			int total = count % rows == 0 ? count / rows : count / rows + 1;	// ������ҳ��
			obj.setTotal(total); // ��ҳ��
			
			int offset = (pageNumber - 1) * rows;
			
			Map<String, Integer> map = new HashMap<>();
			map.put("offset", offset);
			map.put("rows", rows);
			obj.setData( dao.findByPage(map) );  // ���ݼ�Ҳ�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			free();
		}
		 
		return obj;
	}
	
//	public static void main(String[] args) {
//		GoodsService ser = new GoodsServiceImpl();
//		PageModel<GoodsModel> p = ser.findByPage(1, 2);
//		System.out.println("��ҳ��=" + p.getTotal());
//		for ( GoodsModel m : p.getData() ) {
//			System.out.print("goodsid=" + m.getGoodsid() + "  name=" + m.getName() );
//			System.out.println("  ���=" + m.getType().getName());
//		}
//	}

}
