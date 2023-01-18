package my.mini.project.product.model.service;

import my.mini.project.product.model.vo.Order;
import my.mini.project.product.model.vo.orderCancel;

public interface OrderService {

	//step4 ORDER_TEST(임시테이블)에  orderNo, tid 를 저장한다
	int insertOrderTemp(Order o);
	
	//step5 DB에서 tid 를 꺼내와야 한다(select)
	String selectTid(String partner_order_id);

	//취소
	int cancelOrder(orderCancel c);
	
	//취소(Y)로 update
	int cancelUpdate();
	

	
	
}
