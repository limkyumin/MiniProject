package my.mini.project.product.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import my.mini.project.common.model.vo.PageInfo;
import my.mini.project.product.model.vo.Product;

@Repository
public class ProductDao {

	public ArrayList<Product> selectAll(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage()-1)*pi.getPageLimit();
		int limit = pi.getPageLimit();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		return (ArrayList)sqlSession.selectList("productMapper.selectAll", null, rowBounds);
	}

	public int selectListCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("productMapper.selectListCount");
	}

}
