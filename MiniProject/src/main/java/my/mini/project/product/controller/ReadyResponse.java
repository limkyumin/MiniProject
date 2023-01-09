package my.mini.project.kakaopay.model.vo;

import lombok.Data;
					//결재요청 vo -> 결재요청할때 사용
@Data
public class ReadyResponse {

	private String tid;
	private String next_redirect_pc_url;
	private String partner_order_id;
	
	
}
