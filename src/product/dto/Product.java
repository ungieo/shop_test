package product.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;

	private int PR_SEQ;
	private int PR_PRCSEQ;
	private String PR_CODE;
	private String PR_CODEB;
	private String PR_CODES;
	private String PR_NAME;
	private int PR_PRICE;
	private int PR_FILENUM;
	private String PR_IMAGE1;
	private String PR_IMAGE2;
	private String PR_IMAGE3;
	private String PR_IMAGE4;
	private String PR_CPIDS;
	private String PR_CPIDB;
	private String PR_BARCODE;
	private String PR_VATUSE;
	private int PR_SAVEMONEY;
	private String PR_STANDARD;
	private int PR_BRSEQ;
	private String PR_MODEL;
	private String PR_UNIT;
	private String PR_MANUFACTURE;
	private String PR_COUNTRY;
	private int PR_MINBUYEA;
	private int PR_STOCK;
	private String PR_WEIGHT;
	private String PR_CONTENT;
	private String PR_DELITERM;
	private String PR_DELIPOLICY;
	private String PR_STATUS;
	private String PR_LEVEL;
	private String PR_TYPE;
	private String PR_USE;
	private String PR_MOID;
	private String PR_INID;
	private Timestamp PR_MODATE;
	private Timestamp PR_INDATE;


	public int getPR_SEQ(){	return PR_SEQ;	}
	public void setPR_SEQ(int pr_seq){	PR_SEQ = pr_seq;	}

	public int getPR_PRCSEQ(){	return PR_PRCSEQ;	}
	public void setPR_PRCSEQ(int pr_prcseq){	PR_PRCSEQ = pr_prcseq;	}

	public String getPR_CODE(){	return PR_CODE;	}
	public void setPR_CODE(String pr_code){	PR_CODE = pr_code;	}

	public String getPR_CODEB(){	return PR_CODEB;	}
	public void setPR_CODEB(String pr_codeb){	PR_CODEB = pr_codeb;	}

	public String getPR_CODES(){	return PR_CODES;	}
	public void setPR_CODES(String pr_codes){	PR_CODES = pr_codes;	}

	public String getPR_NAME(){	return PR_NAME;	}
	public void setPR_NAME(String pr_name){	PR_NAME = pr_name;	}

	public int getPR_PRICE(){	return PR_PRICE;	}
	public void setPR_PRICE(int pr_price){	PR_PRICE = pr_price;	}

	public int getPR_FILENUM(){	return PR_FILENUM;	}
	public void setPR_FILENUM(int pr_filenum){	PR_FILENUM = pr_filenum;	}

	public String getPR_IMAGE1(){	return PR_IMAGE1;	}
	public void setPR_IMAGE1(String pr_image1){	PR_IMAGE1 = pr_image1;	}

	public String getPR_IMAGE2(){	return PR_IMAGE2;	}
	public void setPR_IMAGE2(String pr_image2){	PR_IMAGE2 = pr_image2;	}

	public String getPR_IMAGE3(){	return PR_IMAGE3;	}
	public void setPR_IMAGE3(String pr_image3){	PR_IMAGE3 = pr_image3;	}

	public String getPR_IMAGE4(){	return PR_IMAGE4;	}
	public void setPR_IMAGE4(String pr_image4){	PR_IMAGE4 = pr_image4;	}
	
	public String getPR_CPIDS(){	return PR_CPIDS;	}
	public void setPR_CPIDS(String pr_cpids){	PR_CPIDS = pr_cpids;	}

	public String getPR_CPIDB(){	return PR_CPIDB;	}
	public void setPR_CPIDB(String pr_cpidb){	PR_CPIDB = pr_cpidb;	}

	public String getPR_BARCODE(){	return PR_BARCODE;	}
	public void setPR_BARCODE(String pr_barcode){	PR_BARCODE = pr_barcode;	}

	public String getPR_VATUSE(){	return PR_VATUSE;	}
	public void setPR_VATUSE(String pr_vatuse){	PR_VATUSE = pr_vatuse;	}

	public int getPR_SAVEMONEY(){	return PR_SAVEMONEY;	}
	public void setPR_SAVEMONEY(int pr_savemoney){	PR_SAVEMONEY = pr_savemoney;	}

	public String getPR_STANDARD(){	return PR_STANDARD;	}
	public void setPR_STANDARD(String pr_standard){	PR_STANDARD = pr_standard;	}

	public int getPR_BRSEQ(){	return PR_BRSEQ;	}
	public void setPR_BRSEQ(int pr_brseq){	PR_BRSEQ = pr_brseq;	}

	public String getPR_MODEL(){	return PR_MODEL;	}
	public void setPR_MODEL(String pr_model){	PR_MODEL = pr_model;	}

	public String getPR_UNIT(){	return PR_UNIT;	}
	public void setPR_UNIT(String pr_unit){	PR_UNIT = pr_unit;	}

	public String getPR_MANUFACTURE(){	return PR_MANUFACTURE;	}
	public void setPR_MANUFACTURE(String pr_manufacture){	PR_MANUFACTURE = pr_manufacture;	}

	public String getPR_COUNTRY(){	return PR_COUNTRY;	}
	public void setPR_COUNTRY(String pr_country){	PR_COUNTRY = pr_country;	}

	public int getPR_MINBUYEA(){	return PR_MINBUYEA;	}
	public void setPR_MINBUYEA(int pr_minbuyea){	PR_MINBUYEA = pr_minbuyea;	}

	public int getPR_STOCK(){	return PR_STOCK;	}
	public void setPR_STOCK(int pr_stock){	PR_STOCK = pr_stock;	}

	public String getPR_WEIGHT(){	return PR_WEIGHT;	}
	public void setPR_WEIGHT(String pr_weight){	PR_WEIGHT = pr_weight;	}

	public String getPR_CONTENT(){	return PR_CONTENT;	}
	public void setPR_CONTENT(String pr_content){	PR_CONTENT = pr_content;	}

	public String getPR_DELITERM(){	return PR_DELITERM;	}
	public void setPR_DELITERM(String pr_deliterm){	PR_DELITERM = pr_deliterm;	}

	public String getPR_DELIPOLICY(){	return PR_DELIPOLICY;	}
	public void setPR_DELIPOLICY(String pr_delipolicy){	PR_DELIPOLICY = pr_delipolicy;	}

	public String getPR_STATUS(){	return PR_STATUS;	}
	public void setPR_STATUS(String pr_status){	PR_STATUS = pr_status;	}

	public String getPR_LEVEL(){	return PR_LEVEL;	}
	public void setPR_LEVEL(String pr_level){	PR_LEVEL = pr_level;	}

	public String getPR_TYPE(){	return PR_TYPE;	}
	public void setPR_TYPE(String pr_type){	PR_TYPE = pr_type;	}

	public String getPR_USE(){	return PR_USE;	}
	public void setPR_USE(String pr_use){	PR_USE = pr_use;	}

	public String getPR_MOID(){	return PR_MOID;	}
	public void setPR_MOID(String pr_moid){	PR_MOID = pr_moid;	}

	public String getPR_INID(){	return PR_INID;	}
	public void setPR_INID(String pr_inid){	PR_INID = pr_inid;	}

	public Timestamp getPR_MODATE(){	return PR_MODATE;	}
	public void setPR_MODATE(Timestamp pr_modate){	PR_MODATE = pr_modate;	}

	public Timestamp getPR_INDATE(){	return PR_INDATE;	}
	public void setPR_INDATE(Timestamp pr_indate){	PR_INDATE = pr_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="PR_SEQ : "+PR_SEQ+", "+"PR_PRCSEQ : "+PR_PRCSEQ+", "+"PR_CODE : "+PR_CODE+", "+"PR_CODEB : "+PR_CODEB+", "+"PR_CODES : "+PR_CODES+", "+"PR_NAME : "+PR_NAME+", "+"PR_PRICE : "+PR_PRICE+", "+"PR_FILENUM : "+PR_FILENUM+", "+"PR_IMAGE1 : "+PR_IMAGE1+", "+"PR_IMAGE2 : "+PR_IMAGE2+", "+"PR_IMAGE3 : "+PR_IMAGE3+", "+"PR_IMAGE4 : "+PR_IMAGE4+", "+"PR_CPIDS : "+PR_CPIDS+", "+"PR_CPIDB : "+PR_CPIDB+", "+"PR_BARCODE : "+PR_BARCODE+", "+"PR_VATUSE : "+PR_VATUSE+", "+"PR_SAVEMONEY : "+PR_SAVEMONEY+", "+"PR_STANDARD : "+PR_STANDARD+", "+"PR_BRSEQ : "+PR_BRSEQ+", "+"PR_MODEL : "+PR_MODEL+", "+"PR_UNIT : "+PR_UNIT+", "+"PR_MANUFACTURE : "+PR_MANUFACTURE+", "+"PR_COUNTRY : "+PR_COUNTRY+", "+"PR_MINBUYEA : "+PR_MINBUYEA+", "+"PR_STOCK : "+PR_STOCK+", "+"PR_WEIGHT : "+PR_WEIGHT+", "+"PR_CONTENT : "+PR_CONTENT+", "+"PR_DELITERM : "+PR_DELITERM+", "+"PR_DELIPOLICY : "+PR_DELIPOLICY+", "+"PR_STATUS : "+PR_STATUS+", "+"PR_LEVEL : "+PR_LEVEL+", "+"PR_TYPE : "+PR_TYPE+", "+"PR_USE : "+PR_USE+", "+"PR_MOID : "+PR_MOID+", "+"PR_INID : "+PR_INID+", "+"PR_MODATE : "+PR_MODATE+", "+"PR_INDATE : "+PR_INDATE;
		return toStr;
	}

}