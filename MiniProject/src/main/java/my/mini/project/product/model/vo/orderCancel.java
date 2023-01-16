package my.mini.project.product.model.vo;

import lombok.Data;

@Data
public class orderCancel {
	
	private String cid;
	private String tid;
	private String cancel_amount;
	private String cancel_tax_free_amount;
	private String cancel_yn;

}
