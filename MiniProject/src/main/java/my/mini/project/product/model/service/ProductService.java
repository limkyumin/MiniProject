package my.mini.project.product.model.service;

import java.util.ArrayList;

import my.mini.project.common.model.vo.PageInfo;
import my.mini.project.product.model.vo.Product;

public interface ProductService {

	
	int selectListCount();
	
	ArrayList<Product> selectAll(PageInfo pi);

	int productInsert(Product p);

	Product productDetail(int pno);

	int update(Product p);

	int productDelete(int productNo);

	

	

}
