package company.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Company implements Serializable{
	private static final long serialVersionUID = 1L;

	private int CP_SEQ;
	private String CP_ID;
	private String CP_NAME;
	private String CP_BIZNUM;
	private String CP_UPTAI;
	private String CP_UPJONG;
	private String CP_CEONAME;
	private String CP_ZIPCODE;
	private String CP_ADDR1;
	private String CP_ADDR2;
	private String CP_FILE;
	private int CP_DELIVERYMONEY;
	private String CP_PAYTYPE;
	private String CP_BIZTYPE;
	private String CP_TONGSINBIZNUM;
	private String CP_EMAIL;
	private String CP_TEL;
	private String CP_PHONE;
	private String CP_FAX;
	private String CP_LEVEL;
	private String CP_TYPE;
	private String CP_USE;
	private String CP_MOID;
	private String CP_INID;
	private Timestamp CP_MODATE;
	private Timestamp CP_INDATE;


	public int getCP_SEQ(){	return CP_SEQ;	}
	public void setCP_SEQ(int cp_seq){	CP_SEQ = cp_seq;	}

	public String getCP_ID(){	return CP_ID;	}
	public void setCP_ID(String cp_id){	CP_ID = cp_id;	}

	public String getCP_NAME(){	return CP_NAME;	}
	public void setCP_NAME(String cp_name){	CP_NAME = cp_name;	}

	public String getCP_BIZNUM(){	return CP_BIZNUM;	}
	public void setCP_BIZNUM(String cp_biznum){	CP_BIZNUM = cp_biznum;	}

	public String getCP_UPTAI(){	return CP_UPTAI;	}
	public void setCP_UPTAI(String cp_uptai){	CP_UPTAI = cp_uptai;	}

	public String getCP_UPJONG(){	return CP_UPJONG;	}
	public void setCP_UPJONG(String cp_upjong){	CP_UPJONG = cp_upjong;	}

	public String getCP_CEONAME(){	return CP_CEONAME;	}
	public void setCP_CEONAME(String cp_ceoname){	CP_CEONAME = cp_ceoname;	}

	public String getCP_ZIPCODE(){	return CP_ZIPCODE;	}
	public void setCP_ZIPCODE(String cp_zipcode){	CP_ZIPCODE = cp_zipcode;	}

	public String getCP_ADDR1(){	return CP_ADDR1;	}
	public void setCP_ADDR1(String cp_addr1){	CP_ADDR1 = cp_addr1;	}

	public String getCP_ADDR2(){	return CP_ADDR2;	}
	public void setCP_ADDR2(String cp_addr2){	CP_ADDR2 = cp_addr2;	}

	public String getCP_FILE(){	return CP_FILE;	}
	public void setCP_FILE(String cp_file){	CP_FILE = cp_file;	}

	public int getCP_DELIVERYMONEY(){	return CP_DELIVERYMONEY;	}
	public void setCP_DELIVERYMONEY(int cp_deliverymoney){	CP_DELIVERYMONEY = cp_deliverymoney;	}

	public String getCP_PAYTYPE(){	return CP_PAYTYPE;	}
	public void setCP_PAYTYPE(String cp_paytype){	CP_PAYTYPE = cp_paytype;	}

	public String getCP_BIZTYPE(){	return CP_BIZTYPE;	}
	public void setCP_BIZTYPE(String cp_biztype){	CP_BIZTYPE = cp_biztype;	}

	public String getCP_TONGSINBIZNUM(){	return CP_TONGSINBIZNUM;	}
	public void setCP_TONGSINBIZNUM(String cp_tongsinbiznum){	CP_TONGSINBIZNUM = cp_tongsinbiznum;	}

	public String getCP_EMAIL(){	return CP_EMAIL;	}
	public void setCP_EMAIL(String cp_email){	CP_EMAIL = cp_email;	}

	public String getCP_TEL(){	return CP_TEL;	}
	public void setCP_TEL(String cp_tel){	CP_TEL = cp_tel;	}

	public String getCP_PHONE(){	return CP_PHONE;	}
	public void setCP_PHONE(String cp_phone){	CP_PHONE = cp_phone;	}

	public String getCP_FAX(){	return CP_FAX;	}
	public void setCP_FAX(String cp_fax){	CP_FAX = cp_fax;	}

	public String getCP_LEVEL(){	return CP_LEVEL;	}
	public void setCP_LEVEL(String cp_level){	CP_LEVEL = cp_level;	}

	public String getCP_TYPE(){	return CP_TYPE;	}
	public void setCP_TYPE(String cp_type){	CP_TYPE = cp_type;	}

	public String getCP_USE(){	return CP_USE;	}
	public void setCP_USE(String cp_use){	CP_USE = cp_use;	}

	public String getCP_MOID(){	return CP_MOID;	}
	public void setCP_MOID(String cp_moid){	CP_MOID = cp_moid;	}

	public String getCP_INID(){	return CP_INID;	}
	public void setCP_INID(String cp_inid){	CP_INID = cp_inid;	}

	public Timestamp getCP_MODATE(){	return CP_MODATE;	}
	public void setCP_MODATE(Timestamp cp_modate){	CP_MODATE = cp_modate;	}

	public Timestamp getCP_INDATE(){	return CP_INDATE;	}
	public void setCP_INDATE(Timestamp cp_indate){	CP_INDATE = cp_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="CP_SEQ : "+CP_SEQ+", "+"CP_ID : "+CP_ID+", "+"CP_NAME : "+CP_NAME+", "+"CP_BIZNUM : "+CP_BIZNUM+", "+"CP_UPTAI : "+CP_UPTAI+", "+"CP_UPJONG : "+CP_UPJONG+", "+"CP_CEONAME : "+CP_CEONAME+", "+"CP_ZIPCODE : "+CP_ZIPCODE+", "+"CP_ADDR1 : "+CP_ADDR1+", "+"CP_ADDR2 : "+CP_ADDR2+", "+"CP_FILE : "+CP_FILE+", "+"CP_DELIVERYMONEY : "+CP_DELIVERYMONEY+", "+"CP_PAYTYPE : "+CP_PAYTYPE+", "+"CP_BIZTYPE : "+CP_BIZTYPE+", "+"CP_TONGSINBIZNUM : "+CP_TONGSINBIZNUM+", "+"CP_EMAIL : "+CP_EMAIL+", "+"CP_TEL : "+CP_TEL+", "+"CP_PHONE : "+CP_PHONE+", "+"CP_FAX : "+CP_FAX+", "+"CP_LEVEL : "+CP_LEVEL+", "+"CP_TYPE : "+CP_TYPE+", "+"CP_USE : "+CP_USE+", "+"CP_MOID : "+CP_MOID+", "+"CP_INID : "+CP_INID+", "+"CP_MODATE : "+CP_MODATE+", "+"CP_INDATE : "+CP_INDATE;
		return toStr;
	}

}