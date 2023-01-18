package my.mini.project.product.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.mini.project.product.model.dao.OrderDao;
import my.mini.project.product.model.dao.ProductDao;
import my.mini.project.product.model.vo.Order;
import my.mini.project.product.model.vo.orderCancel;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertOrderTemp(Order o) {
		
		int order = orderDao.insertOrderTemp(o, sqlSession);
		
		return order;
	}

	@Override
	public String selectTid(String partner_order_id) {
		
		String selectTid = orderDao.selectTid(partner_order_id, sqlSession);
		
		return selectTid;
	}
	
	//취소 
	@Override
	public int cancelOrder(orderCancel c) {
		
		int cancel = orderDao.cancelOrder(c, sqlSession);
		
		return cancel;
	}

	@Override
	public int cancelUpdate() {
		
		int cancelUpdate = orderDao.cancelUpdate(sqlSession);
		
		return cancelUpdate;
	}
	

	
	
}
