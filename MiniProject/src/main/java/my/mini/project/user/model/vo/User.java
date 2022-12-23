package my.mini.project.user.model.vo;

import java.sql.Date;

import lombok.Data;

/*
 * lombok
 * -자동 코드 생성 라이브러리
 * -반복되는 getter, setter , toString 등의 메소드 작성 코드를 줄여주는 코드 라이브러리
 * 
 * lombok 설치방법
 * 1. 라이브러리 다운 후 적용(Maven pom.xml)
 * 2. 다운로드 된 jar파일을 찾아서 설치(작업할 IDE 선택) 
 * 3. IDE재 실행
 * 
 * lombok 사용시 주의사항
 * -uName, bTitle과 같이 앞 글자가 소문자외자인 필드명은 만들면 안된다.
 * -필드명 작성시 소문자 두 글자 이상으로 시작해야함.
 * -이유) el표기법으로 사용시 내부적으로 getter메소드를 찾게되는데
 * 		 이 때 getuName(),getbTitle() 이라는 이름으로 메소드를 호출하기 때문.
 * 		기존 사용하는 방식이라면 getUName()이 되기때문에 호출할 수 없다.
 * 
 * */

@Data
public class User {
	
	private int userNo;				//	USER_NO	NUMBER	No		1	
	private String userId;			//	USER_ID	VARCHAR2(12 BYTE)	Yes		2	
	private String userPwd;			//	USER_PWD	VARCHAR2(15 BYTE)	No		3	
	private String userName;		//	USER_NAME	VARCHAR2(10 BYTE)	No		4	
	private String userBirth;			//	USER_BIRTH	NUMBER(8,0)	No		5	
	private String userEmail;		//	USER_EMAIL	VARCHAR2(30 BYTE)	No		6	
	private String userPhone;		//	USER_PHONE	VARCHAR2(13 BYTE)	No		7	
	private String userAddress;		//	USER_ADDRESS	VARCHAR2(100 BYTE)	No		8	
	private Date enrollDate; 		//	ENROLL_DATE	DATE	No	SYSDATE 	9	
	private Date modifyDate;		//	MODIFY_DATE	DATE	No	SYSDATE 	10	
	private Date stopDate;			//	STOP_DATE	DATE	No	SYSDATE 	11	
	private Date withdrawalDate;	//	WITHDRAWAL_DATE	DATE	No	SYSDATE 	12	
	private Date forceDate;			//	FORCE_DATE	DATE	No	SYSDATE 	13	
	private String userStatus;		//	USER_STATUS	VARCHAR2(1 BYTE)	Yes	'Y' 	14	

}
