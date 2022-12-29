package my.mini.project.product.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Product {
	
	private int productNo;	//	PRODUCT_NO	NUMBER
	private String productType;	//	PRODUCT_TYPE	VARCHAR2(30 BYTE)
	private String productName;	//	PRODUCT_NAME	VARCHAR2(30 BYTE)
	private String productDescript;	//	PRODUCT_DESCRIPT	VARCHAR2(4000 BYTE)
	private String productCount; //이건 int로 해야하나? 일단진행..	//	PRODUCT_COUNT	VARCHAR2(30 BYTE)
	private String productPrice; //이것도 int..?	//	PRODUCT_PRICE	VARCHAR2(30 BYTE)
	private Date productDate;	//	PRODUCT_DATE	DATE
	private String productStatus;	//	PRODUCT_STATUS	VARCHAR2(1 BYTE)
}
