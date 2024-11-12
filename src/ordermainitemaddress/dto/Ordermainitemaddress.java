package ordermainitemaddress.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Ordermainitemaddress implements Serializable{
	private static final long serialVersionUID = 1L;

	private int OMIA_SEQ;
	private String OMIA_OMISEQ;
	private String OMIA_NAME;
	private String OMIA_TEL;
	private String OMIA_PHONE;
	private String OMIA_EMAIL;
	private String OMIA_ZIPCODE;
	private String OMIA_ADDR1;
	private String OMIA_ADDR2;
	private String OMIA_TYPE;
	private String OMIA_MOID;
	private String OMIA_INID;
	private Timestamp OMIA_MODATE;
	private Timestamp OMIA_INDATE;


	public int getOMIA_SEQ(){	return OMIA_SEQ;	}
	public void setOMIA_SEQ(int omia_seq){	OMIA_SEQ = omia_seq;	}

	public String getOMIA_OMISEQ(){	return OMIA_OMISEQ;	}
	public void setOMIA_OMISEQ(String omia_omiseq){	OMIA_OMISEQ = omia_omiseq;	}

	public String getOMIA_NAME(){	return OMIA_NAME;	}
	public void setOMIA_NAME(String omia_name){	OMIA_NAME = omia_name;	}

	public String getOMIA_TEL(){	return OMIA_TEL;	}
	public void setOMIA_TEL(String omia_tel){	OMIA_TEL = omia_tel;	}

	public String getOMIA_PHONE(){	return OMIA_PHONE;	}
	public void setOMIA_PHONE(String omia_phone){	OMIA_PHONE = omia_phone;	}

	public String getOMIA_EMAIL(){	return OMIA_EMAIL;	}
	public void setOMIA_EMAIL(String omia_email){	OMIA_EMAIL = omia_email;	}

	public String getOMIA_ZIPCODE(){	return OMIA_ZIPCODE;	}
	public void setOMIA_ZIPCODE(String omia_zipcode){	OMIA_ZIPCODE = omia_zipcode;	}

	public String getOMIA_ADDR1(){	return OMIA_ADDR1;	}
	public void setOMIA_ADDR1(String omia_addr1){	OMIA_ADDR1 = omia_addr1;	}

	public String getOMIA_ADDR2(){	return OMIA_ADDR2;	}
	public void setOMIA_ADDR2(String omia_addr2){	OMIA_ADDR2 = omia_addr2;	}

	public String getOMIA_TYPE(){	return OMIA_TYPE;	}
	public void setOMIA_TYPE(String omia_type){	OMIA_TYPE = omia_type;	}

	public String getOMIA_MOID(){	return OMIA_MOID;	}
	public void setOMIA_MOID(String omia_moid){	OMIA_MOID = omia_moid;	}

	public String getOMIA_INID(){	return OMIA_INID;	}
	public void setOMIA_INID(String omia_inid){	OMIA_INID = omia_inid;	}

	public Timestamp getOMIA_MODATE(){	return OMIA_MODATE;	}
	public void setOMIA_MODATE(Timestamp omia_modate){	OMIA_MODATE = omia_modate;	}

	public Timestamp getOMIA_INDATE(){	return OMIA_INDATE;	}
	public void setOMIA_INDATE(Timestamp omia_indate){	OMIA_INDATE = omia_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="OMIA_SEQ : "+OMIA_SEQ+", "+"OMIA_OMISEQ : "+OMIA_OMISEQ+", "+"OMIA_NAME : "+OMIA_NAME+", "+"OMIA_TEL : "+OMIA_TEL+", "+"OMIA_PHONE : "+OMIA_PHONE+", "+"OMIA_EMAIL : "+OMIA_EMAIL+", "+"OMIA_ZIPCODE : "+OMIA_ZIPCODE+", "+"OMIA_ADDR1 : "+OMIA_ADDR1+", "+"OMIA_ADDR2 : "+OMIA_ADDR2+", "+"OMIA_TYPE : "+OMIA_TYPE+", "+"OMIA_MOID : "+OMIA_MOID+", "+"OMIA_INID : "+OMIA_INID+", "+"OMIA_MODATE : "+OMIA_MODATE+", "+"OMIA_INDATE : "+OMIA_INDATE;
		return toStr;
	}

}