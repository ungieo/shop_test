package commontext.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Commontext implements Serializable{
	private static final long serialVersionUID = 1L;

	private int CMT_SEQ;
	private String CMT_GROUPCODE;
	private String CMT_CODE;
	private String CMT_NAME;
	private String CMT_VALUE;
	private String CMT_INID;
	private Timestamp CMT_INDATE;


	public int getCMT_SEQ(){	return CMT_SEQ;	}
	public void setCMT_SEQ(int cmt_seq){	CMT_SEQ = cmt_seq;	}

	public String getCMT_GROUPCODE(){	return CMT_GROUPCODE;	}
	public void setCMT_GROUPCODE(String cmt_groupcode){	CMT_GROUPCODE = cmt_groupcode;	}

	public String getCMT_CODE(){	return CMT_CODE;	}
	public void setCMT_CODE(String cmt_code){	CMT_CODE = cmt_code;	}

	public String getCMT_NAME(){	return CMT_NAME;	}
	public void setCMT_NAME(String cmt_name){	CMT_NAME = cmt_name;	}

	public String getCMT_VALUE(){	return CMT_VALUE;	}
	public void setCMT_VALUE(String cmt_value){	CMT_VALUE = cmt_value;	}

	public String getCMT_INID(){	return CMT_INID;	}
	public void setCMT_INID(String cmt_inid){	CMT_INID = cmt_inid;	}

	public Timestamp getCMT_INDATE(){	return CMT_INDATE;	}
	public void setCMT_INDATE(Timestamp cmt_indate){	CMT_INDATE = cmt_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="CMT_SEQ : "+CMT_SEQ+", "+"CMT_GROUPCODE : "+CMT_GROUPCODE+", "+"CMT_CODE : "+CMT_CODE+", "+"CMT_NAME : "+CMT_NAME+", "+"CMT_VALUE : "+CMT_VALUE+", "+"CMT_INID : "+CMT_INID+", "+"CMT_INDATE : "+CMT_INDATE;
		return toStr;
	}

}