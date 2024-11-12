package ordermainaddress.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Ordermainaddress implements Serializable{
	private static final long serialVersionUID = 1L;

	private int OMA_SEQ;
	private int OMA_OMSEQ;
	private String OMA_NAME;
	private String OMA_TEL;
	private String OMA_PHONE;
	private String OMA_EMAIL;
	private String OMA_ZIPCODE;
	private String OMA_ADDR1;
	private String OMA_ADDR2;
	private String OMA_TYPE;
	private String OMA_MOID;
	private String OMA_INID;
	private Timestamp OMA_MODATE;
	private Timestamp OMA_INDATE;


	public int getOMA_SEQ(){	return OMA_SEQ;	}
	public void setOMA_SEQ(int oma_seq){	OMA_SEQ = oma_seq;	}

	public int getOMA_OMSEQ(){	return OMA_OMSEQ;	}
	public void setOMA_OMSEQ(int oma_omseq){	OMA_OMSEQ = oma_omseq;	}

	public String getOMA_NAME(){	return OMA_NAME;	}
	public void setOMA_NAME(String oma_name){	OMA_NAME = oma_name;	}

	public String getOMA_TEL(){	return OMA_TEL;	}
	public void setOMA_TEL(String oma_tel){	OMA_TEL = oma_tel;	}

	public String getOMA_PHONE(){	return OMA_PHONE;	}
	public void setOMA_PHONE(String oma_phone){	OMA_PHONE = oma_phone;	}

	public String getOMA_EMAIL(){	return OMA_EMAIL;	}
	public void setOMA_EMAIL(String oma_email){	OMA_EMAIL = oma_email;	}

	public String getOMA_ZIPCODE(){	return OMA_ZIPCODE;	}
	public void setOMA_ZIPCODE(String oma_zipcode){	OMA_ZIPCODE = oma_zipcode;	}

	public String getOMA_ADDR1(){	return OMA_ADDR1;	}
	public void setOMA_ADDR1(String oma_addr1){	OMA_ADDR1 = oma_addr1;	}

	public String getOMA_ADDR2(){	return OMA_ADDR2;	}
	public void setOMA_ADDR2(String oma_addr2){	OMA_ADDR2 = oma_addr2;	}

	public String getOMA_TYPE(){	return OMA_TYPE;	}
	public void setOMA_TYPE(String oma_type){	OMA_TYPE = oma_type;	}

	public String getOMA_MOID(){	return OMA_MOID;	}
	public void setOMA_MOID(String oma_moid){	OMA_MOID = oma_moid;	}

	public String getOMA_INID(){	return OMA_INID;	}
	public void setOMA_INID(String oma_inid){	OMA_INID = oma_inid;	}

	public Timestamp getOMA_MODATE(){	return OMA_MODATE;	}
	public void setOMA_MODATE(Timestamp oma_modate){	OMA_MODATE = oma_modate;	}

	public Timestamp getOMA_INDATE(){	return OMA_INDATE;	}
	public void setOMA_INDATE(Timestamp oma_indate){	OMA_INDATE = oma_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="OMA_SEQ : "+OMA_SEQ+", "+"OMA_OMSEQ : "+OMA_OMSEQ+", "+"OMA_NAME : "+OMA_NAME+", "+"OMA_TEL : "+OMA_TEL+", "+"OMA_PHONE : "+OMA_PHONE+", "+"OMA_EMAIL : "+OMA_EMAIL+", "+"OMA_ZIPCODE : "+OMA_ZIPCODE+", "+"OMA_ADDR1 : "+OMA_ADDR1+", "+"OMA_ADDR2 : "+OMA_ADDR2+", "+"OMA_TYPE : "+OMA_TYPE+", "+"OMA_MOID : "+OMA_MOID+", "+"OMA_INID : "+OMA_INID+", "+"OMA_MODATE : "+OMA_MODATE+", "+"OMA_INDATE : "+OMA_INDATE;
		return toStr;
	}

}