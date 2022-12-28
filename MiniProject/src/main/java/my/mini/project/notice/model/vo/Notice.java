package my.mini.project.notice.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Notice {
	
	private int noticeNo; 	//	NOTICE_NO	NUMBER
	private String noticeTitle;	//	NOTICE_TITLE	VARCHAR2(40 BYTE)
	private String noticeContent;	//	NOTICE_CONTENT	VARCHAR2(4000 BYTE)
	private Date noticeDate;	//	NOTICE_DATE	DATE
	private int noticeWriter;	//	NOTICE_WRITER	NUMBER
	private int noticeView;	//	조회수 NOTICE_VIEW	 NUMBER
	private String noticeStatus;	//	NOTICE_STATUS	VARCHAR2(1 BYTE)

}
