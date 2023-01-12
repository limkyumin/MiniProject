package my.mini.project.product.model.service;

import my.mini.project.product.model.vo.Order;

public interface OrderService {

	//step4 ORDER_TEST(임시테이블)에  orderNo, tid 를 저장한다
	int insertOrderTemp(Order o);
	
	//step5 DB에서 tid 를 꺼내와야 한다(select)
	int selectTid(Order o);
}
