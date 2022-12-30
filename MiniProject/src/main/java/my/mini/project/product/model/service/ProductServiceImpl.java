package my.mini.project.product.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.mini.project.common.model.vo.PageInfo;
import my.mini.project.product.model.dao.ProductDao;
import my.mini.project.product.model.vo.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao Productdao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Product> selectAll(PageInfo pi) {
		
		return Productdao.selectAll(sqlSession, pi);
	}

	@Override
	public int selectListCount() {
		
		return Productdao.selectListCount(sqlSession);
	}

	@Override
	public int productInsert(Product p) {
		
		return Productdao.productInsert(sqlSession, p);
	}

	@Override
	public Product productDetail(int productNo) {

		return Productdao.productDetail(sqlSession, productNo);
	}

	@Override
	public int update(Product p) {
		
		return Productdao.update(sqlSession, p);
	}

	@Override
	public int productDelete(int productNo) {
		
		return Productdao.productDelete(sqlSession, productNo);
	}

}
