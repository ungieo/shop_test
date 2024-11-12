package member.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Member implements Serializable{
	private static final long serialVersionUID = 1L;

	private String MB_ID;
	private String MB_NAME;
	private String MB_PSWD;
	private Timestamp MB_PSWDCHDATE;
	private int MB_PSWDFAILCNT;
	private String MB_CPID;
	private String MB_DPID;
	private String MB_ZIPCODE;
	private String MB_ADDR1;
	private String MB_ADDR2;
	private String MB_EMAIL;
	private String MB_PHONE;
	private String MB_TEL;
	private String MB_BIRTH;
	private String MB_SEX;
	private String MB_EMAILUSE;
	private String MB_SMSUSE;
	private String MB_LEVEL;
	private String MB_TYPE;
	private String MB_USE;
	private String MB_MOID;
	private String MB_INID;
	private Timestamp MB_MODATE;
	private Timestamp MB_INDATE;


	public String getMB_ID(){	return MB_ID;	}
	public void setMB_ID(String mb_id){	MB_ID = mb_id;	}

	public String getMB_NAME(){	return MB_NAME;	}
	public void setMB_NAME(String mb_name){	MB_NAME = mb_name;	}

	public String getMB_PSWD(){	return MB_PSWD;	}
	public void setMB_PSWD(String mb_pswd){	MB_PSWD = mb_pswd;	}

	public Timestamp getMB_PSWDCHDATE(){	return MB_PSWDCHDATE;	}
	public void setMB_PSWDCHDATE(Timestamp mb_pswdchdate){	MB_PSWDCHDATE = mb_pswdchdate;	}

	public int getMB_PSWDFAILCNT(){	return MB_PSWDFAILCNT;	}
	public void setMB_PSWDFAILCNT(int mb_pswdfailcnt){	MB_PSWDFAILCNT = mb_pswdfailcnt;	}

	public String getMB_CPID(){	return MB_CPID;	}
	public void setMB_CPID(String mb_cpid){	MB_CPID = mb_cpid;	}

	public String getMB_DPID(){	return MB_DPID;	}
	public void setMB_DPID(String mb_dpid){	MB_DPID = mb_dpid;	}

	public String getMB_ZIPCODE(){	return MB_ZIPCODE;	}
	public void setMB_ZIPCODE(String mb_zipcode){	MB_ZIPCODE = mb_zipcode;	}

	public String getMB_ADDR1(){	return MB_ADDR1;	}
	public void setMB_ADDR1(String mb_addr1){	MB_ADDR1 = mb_addr1;	}

	public String getMB_ADDR2(){	return MB_ADDR2;	}
	public void setMB_ADDR2(String mb_addr2){	MB_ADDR2 = mb_addr2;	}

	public String getMB_EMAIL(){	return MB_EMAIL;	}
	public void setMB_EMAIL(String mb_email){	MB_EMAIL = mb_email;	}

	public String getMB_PHONE(){	return MB_PHONE;	}
	public void setMB_PHONE(String mb_phone){	MB_PHONE = mb_phone;	}

	public String getMB_TEL(){	return MB_TEL;	}
	public void setMB_TEL(String mb_tel){	MB_TEL = mb_tel;	}

	public String getMB_BIRTH(){	return MB_BIRTH;	}
	public void setMB_BIRTH(String mb_birth){	MB_BIRTH = mb_birth;	}

	public String getMB_SEX(){	return MB_SEX;	}
	public void setMB_SEX(String mb_sex){	MB_SEX = mb_sex;	}

	public String getMB_EMAILUSE(){	return MB_EMAILUSE;	}
	public void setMB_EMAILUSE(String mb_emailuse){	MB_EMAILUSE = mb_emailuse;	}

	public String getMB_SMSUSE(){	return MB_SMSUSE;	}
	public void setMB_SMSUSE(String mb_smsuse){	MB_SMSUSE = mb_smsuse;	}

	public String getMB_LEVEL(){	return MB_LEVEL;	}
	public void setMB_LEVEL(String mb_level){	MB_LEVEL = mb_level;	}

	public String getMB_TYPE(){	return MB_TYPE;	}
	public void setMB_TYPE(String mb_type){	MB_TYPE = mb_type;	}

	public String getMB_USE(){	return MB_USE;	}
	public void setMB_USE(String mb_use){	MB_USE = mb_use;	}

	public String getMB_MOID(){	return MB_MOID;	}
	public void setMB_MOID(String mb_moid){	MB_MOID = mb_moid;	}

	public String getMB_INID(){	return MB_INID;	}
	public void setMB_INID(String mb_inid){	MB_INID = mb_inid;	}

	public Timestamp getMB_MODATE(){	return MB_MODATE;	}
	public void setMB_MODATE(Timestamp mb_modate){	MB_MODATE = mb_modate;	}

	public Timestamp getMB_INDATE(){	return MB_INDATE;	}
	public void setMB_INDATE(Timestamp mb_indate){	MB_INDATE = mb_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="MB_ID : "+MB_ID+", "+"MB_NAME : "+MB_NAME+", "+"MB_PSWD : "+MB_PSWD+", "+"MB_PSWDCHDATE : "+MB_PSWDCHDATE+", "+"MB_PSWDFAILCNT : "+MB_PSWDFAILCNT+", "+"MB_CPID : "+MB_CPID+", "+"MB_DPID : "+MB_DPID+", "+"MB_ZIPCODE : "+MB_ZIPCODE+", "+"MB_ADDR1 : "+MB_ADDR1+", "+"MB_ADDR2 : "+MB_ADDR2+", "+"MB_EMAIL : "+MB_EMAIL+", "+"MB_PHONE : "+MB_PHONE+", "+"MB_TEL : "+MB_TEL+", "+"MB_BIRTH : "+MB_BIRTH+", "+"MB_SEX : "+MB_SEX+", "+"MB_EMAILUSE : "+MB_EMAILUSE+", "+"MB_SMSUSE : "+MB_SMSUSE+", "+"MB_LEVEL : "+MB_LEVEL+", "+"MB_TYPE : "+MB_TYPE+", "+"MB_USE : "+MB_USE+", "+"MB_MOID : "+MB_MOID+", "+"MB_INID : "+MB_INID+", "+"MB_MODATE : "+MB_MODATE+", "+"MB_INDATE : "+MB_INDATE;
		return toStr;
	}

}