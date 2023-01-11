package my.mini.project.product.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import my.mini.project.product.model.vo.Order;

@Repository
public class OrderDao {

//	public int orderTest(SqlSessionTemplate sqlSession, Order o) {
//		
//		return sqlSession.insert("orderMapper.orderTest",o);
//	}

	public int insertOrderTemp(Order o, SqlSessionTemplate sqlSession) {
		
		return sqlSession.insert("orderMapper.insertOrderTemp", o);
	}

}
