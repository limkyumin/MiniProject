package my.mini.project.product.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.mini.project.product.model.dao.OrderDao;
import my.mini.project.product.model.dao.ProductDao;
import my.mini.project.product.model.vo.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

//	@Override
//	public int orderTest(Order o) {
//		
//		int order = Orderdao.orderTest(sqlSession,o); 
//		
//		return order;
//	}

	@Override
	public int insertOrderTemp(Order o) {
		
		int order = orderDao.insertOrderTemp(o, sqlSession);
		
		return order;
	}
	
}
