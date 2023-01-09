package my.mini.project.kakaopay.model.vo;

import lombok.Data;
					//결재내역 vo -> 결재내역을 가져올 때 사용.
@Data
public class Amount {

	private int total;
	private int tax_free;
	private int vat;
	private int point;
	private int discount;
	
}
