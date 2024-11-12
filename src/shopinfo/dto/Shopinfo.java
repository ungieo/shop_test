package shopinfo.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Shopinfo implements Serializable{
	private static final long serialVersionUID = 1L;

	private String SHOP_ID;
	private String SHOP_NAME;
	private String SHOP_IP;
	private String SHOP_BIZNUM;
	private String SHOP_CEONAME;
	private String SHOP_UPTAI;
	private String SHOP_JONGMOK;
	private String SHOP_ZIPCODE;
	private String SHOP_ADDR1;
	private String SHOP_ADDR2;
	private String SHOP_TEL;
	private String SHOP_FAX;
	private String SHOP_EMAIL;
	private String SHOP_DOMAIN;
	private String SHOP_TONGSINNUM;
	private String SHOP_CSTEL;
	private String SHOP_CSEMAIL;
	private String SHOP_CSFAX;
	private String SHOP_CSTIME;
	private String SHOP_SCRNAME;
	private String SHOP_SCRDEPART;
	private String SHOP_SCRPHONE;
	private String SHOP_SCREMAIL;
	private String SHOP_AGREEMENT;
	private String SHOP_PRIVACY;
	private String SHOP_LEVEL;
	private String SHOP_TYPE;
	private String SHOP_USE;
	private String SHOP_MOID;
	private String SHOP_INID;
	private Timestamp SHOP_MODATE;
	private Timestamp SHOP_INDATE;


	public String getSHOP_ID(){	return SHOP_ID;	}
	public void setSHOP_ID(String shop_id){	SHOP_ID = shop_id;	}

	public String getSHOP_NAME(){	return SHOP_NAME;	}
	public void setSHOP_NAME(String shop_name){	SHOP_NAME = shop_name;	}

	public String getSHOP_IP(){	return SHOP_IP;	}
	public void setSHOP_IP(String shop_ip){	SHOP_IP = shop_ip;	}

	public String getSHOP_BIZNUM(){	return SHOP_BIZNUM;	}
	public void setSHOP_BIZNUM(String shop_biznum){	SHOP_BIZNUM = shop_biznum;	}

	public String getSHOP_CEONAME(){	return SHOP_CEONAME;	}
	public void setSHOP_CEONAME(String shop_ceoname){	SHOP_CEONAME = shop_ceoname;	}

	public String getSHOP_UPTAI(){	return SHOP_UPTAI;	}
	public void setSHOP_UPTAI(String shop_uptai){	SHOP_UPTAI = shop_uptai;	}

	public String getSHOP_JONGMOK(){	return SHOP_JONGMOK;	}
	public void setSHOP_JONGMOK(String shop_jongmok){	SHOP_JONGMOK = shop_jongmok;	}

	public String getSHOP_ZIPCODE(){	return SHOP_ZIPCODE;	}
	public void setSHOP_ZIPCODE(String shop_zipcode){	SHOP_ZIPCODE = shop_zipcode;	}

	public String getSHOP_ADDR1(){	return SHOP_ADDR1;	}
	public void setSHOP_ADDR1(String shop_addr1){	SHOP_ADDR1 = shop_addr1;	}

	public String getSHOP_ADDR2(){	return SHOP_ADDR2;	}
	public void setSHOP_ADDR2(String shop_addr2){	SHOP_ADDR2 = shop_addr2;	}

	public String getSHOP_TEL(){	return SHOP_TEL;	}
	public void setSHOP_TEL(String shop_tel){	SHOP_TEL = shop_tel;	}

	public String getSHOP_FAX(){	return SHOP_FAX;	}
	public void setSHOP_FAX(String shop_fax){	SHOP_FAX = shop_fax;	}

	public String getSHOP_EMAIL(){	return SHOP_EMAIL;	}
	public void setSHOP_EMAIL(String shop_email){	SHOP_EMAIL = shop_email;	}

	public String getSHOP_DOMAIN(){	return SHOP_DOMAIN;	}
	public void setSHOP_DOMAIN(String shop_domain){	SHOP_DOMAIN = shop_domain;	}

	public String getSHOP_TONGSINNUM(){	return SHOP_TONGSINNUM;	}
	public void setSHOP_TONGSINNUM(String shop_tongsinnum){	SHOP_TONGSINNUM = shop_tongsinnum;	}

	public String getSHOP_CSTEL(){	return SHOP_CSTEL;	}
	public void setSHOP_CSTEL(String shop_cstel){	SHOP_CSTEL = shop_cstel;	}

	public String getSHOP_CSEMAIL(){	return SHOP_CSEMAIL;	}
	public void setSHOP_CSEMAIL(String shop_csemail){	SHOP_CSEMAIL = shop_csemail;	}

	public String getSHOP_CSFAX(){	return SHOP_CSFAX;	}
	public void setSHOP_CSFAX(String shop_csfax){	SHOP_CSFAX = shop_csfax;	}

	public String getSHOP_CSTIME(){	return SHOP_CSTIME;	}
	public void setSHOP_CSTIME(String shop_cstime){	SHOP_CSTIME = shop_cstime;	}

	public String getSHOP_SCRNAME(){	return SHOP_SCRNAME;	}
	public void setSHOP_SCRNAME(String shop_scrname){	SHOP_SCRNAME = shop_scrname;	}

	public String getSHOP_SCRDEPART(){	return SHOP_SCRDEPART;	}
	public void setSHOP_SCRDEPART(String shop_scrdepart){	SHOP_SCRDEPART = shop_scrdepart;	}

	public String getSHOP_SCRPHONE(){	return SHOP_SCRPHONE;	}
	public void setSHOP_SCRPHONE(String shop_scrphone){	SHOP_SCRPHONE = shop_scrphone;	}

	public String getSHOP_SCREMAIL(){	return SHOP_SCREMAIL;	}
	public void setSHOP_SCREMAIL(String shop_scremail){	SHOP_SCREMAIL = shop_scremail;	}

	public String getSHOP_AGREEMENT(){	return SHOP_AGREEMENT;	}
	public void setSHOP_AGREEMENT(String shop_agreement){	SHOP_AGREEMENT = shop_agreement;	}

	public String getSHOP_PRIVACY(){	return SHOP_PRIVACY;	}
	public void setSHOP_PRIVACY(String shop_privacy){	SHOP_PRIVACY = shop_privacy;	}

	public String getSHOP_LEVEL(){	return SHOP_LEVEL;	}
	public void setSHOP_LEVEL(String shop_level){	SHOP_LEVEL = shop_level;	}

	public String getSHOP_TYPE(){	return SHOP_TYPE;	}
	public void setSHOP_TYPE(String shop_type){	SHOP_TYPE = shop_type;	}

	public String getSHOP_USE(){	return SHOP_USE;	}
	public void setSHOP_USE(String shop_use){	SHOP_USE = shop_use;	}

	public String getSHOP_MOID(){	return SHOP_MOID;	}
	public void setSHOP_MOID(String shop_moid){	SHOP_MOID = shop_moid;	}

	public String getSHOP_INID(){	return SHOP_INID;	}
	public void setSHOP_INID(String shop_inid){	SHOP_INID = shop_inid;	}

	public Timestamp getSHOP_MODATE(){	return SHOP_MODATE;	}
	public void setSHOP_MODATE(Timestamp shop_modate){	SHOP_MODATE = shop_modate;	}

	public Timestamp getSHOP_INDATE(){	return SHOP_INDATE;	}
	public void setSHOP_INDATE(Timestamp shop_indate){	SHOP_INDATE = shop_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="SHOP_ID : "+SHOP_ID+", "+"SHOP_NAME : "+SHOP_NAME+", "+"SHOP_IP : "+SHOP_IP+", "+"SHOP_BIZNUM : "+SHOP_BIZNUM+", "+"SHOP_CEONAME : "+SHOP_CEONAME+", "+"SHOP_UPTAI : "+SHOP_UPTAI+", "+"SHOP_JONGMOK : "+SHOP_JONGMOK+", "+"SHOP_ZIPCODE : "+SHOP_ZIPCODE+", "+"SHOP_ADDR1 : "+SHOP_ADDR1+", "+"SHOP_ADDR2 : "+SHOP_ADDR2+", "+"SHOP_TEL : "+SHOP_TEL+", "+"SHOP_FAX : "+SHOP_FAX+", "+"SHOP_EMAIL : "+SHOP_EMAIL+", "+"SHOP_DOMAIN : "+SHOP_DOMAIN+", "+"SHOP_TONGSINNUM : "+SHOP_TONGSINNUM+", "+"SHOP_CSTEL : "+SHOP_CSTEL+", "+"SHOP_CSEMAIL : "+SHOP_CSEMAIL+", "+"SHOP_CSFAX : "+SHOP_CSFAX+", "+"SHOP_CSTIME : "+SHOP_CSTIME+", "+"SHOP_SCRNAME : "+SHOP_SCRNAME+", "+"SHOP_SCRDEPART : "+SHOP_SCRDEPART+", "+"SHOP_SCRPHONE : "+SHOP_SCRPHONE+", "+"SHOP_SCREMAIL : "+SHOP_SCREMAIL+", "+"SHOP_AGREEMENT : "+SHOP_AGREEMENT+", "+"SHOP_PRIVACY : "+SHOP_PRIVACY+", "+"SHOP_LEVEL : "+SHOP_LEVEL+", "+"SHOP_TYPE : "+SHOP_TYPE+", "+"SHOP_USE : "+SHOP_USE+", "+"SHOP_MOID : "+SHOP_MOID+", "+"SHOP_INID : "+SHOP_INID+", "+"SHOP_MODATE : "+SHOP_MODATE+", "+"SHOP_INDATE : "+SHOP_INDATE;
		return toStr;
	}

}