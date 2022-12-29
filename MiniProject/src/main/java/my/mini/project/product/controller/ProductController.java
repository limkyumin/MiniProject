package my.mini.project.product.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.mini.project.common.model.vo.PageInfo;
import my.mini.project.common.template.Pagination;
import my.mini.project.product.model.service.ProductService;
import my.mini.project.product.model.vo.Product;


@Controller
public class ProductController {
	
	@Autowired
	ProductService Productservice;
	
	//상품 판매 페이지 메인
	@RequestMapping("productMain.ui")
	public String productMain(@RequestParam(value="ppage",defaultValue="1") int currentPage, Model model) {
			
		int pageLimit = 5;
		int productLimit = 9;
		
		int listCount = Productservice.selectListCount();
		
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, productLimit);
		
		ArrayList<Product> list = Productservice.selectAll(pi);
		System.out.println("넘어옵니까");
		return "product/productMain";
		
		
	}
	
	
}
