package my.mini.project.kakaopay.model.vo;

import lombok.Data;
					//결재승인요청vo -> 결재승인요청할 때 담아서 보냄.
@Data
public class ApproveResponse {

	private String aid;
	private String tid;
	private String cid;
	private String sid;
	private String partner_order_id;
	private String partner_user_id;
	private String payment_method_type;
	private String item_name;
	private String item_code;
	private int quantity;
	private String created_at;
	private String approved_at;
	private String payload;
	private Amount amount;
	
	
}
