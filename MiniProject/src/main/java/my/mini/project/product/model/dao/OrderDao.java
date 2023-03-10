package my.mini.project.product.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import my.mini.project.product.model.vo.Order;
import my.mini.project.product.model.vo.orderCancel;

@Repository
public class OrderDao {

//	public int orderTest(SqlSessionTemplate sqlSession, Order o) {
//		
//		return sqlSession.insert("orderMapper.orderTest",o);
//	}

	public int insertOrderTemp(Order o, SqlSessionTemplate sqlSession) {
		
		return sqlSession.insert("orderMapper.insertOrderTemp", o);
	}

	public String selectTid(String partner_order_id, SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("orderMapper.selectTid", partner_order_id);
	}

	public int cancelOrder(orderCancel c, SqlSessionTemplate sqlSession) {
		
		return sqlSession.insert("cancelMapper.cancelOrder", c);
	}

	public int cancelUpdate(SqlSessionTemplate sqlSession) {

		return sqlSession.update("cancelMapper.cancelUpdate");
	}

}
