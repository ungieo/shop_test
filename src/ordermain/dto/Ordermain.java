package ordermain.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Ordermain implements Serializable{
	private static final long serialVersionUID = 1L;

	private int OM_SEQ;
	private String OM_ID;
	private String OM_PGID;
	private String OM_PSWD;
	private String OM_MBID;
	private String OM_CPIDP;
	private String OM_CPIDS;
	private String OM_MBNAME;
	private String OM_PRNAME;
	private String OM_PAYTYPE;
	private int OM_ACCOUNTMONEY;
	private int OM_BUDGETMONEY;
	private int OM_CARDMONEY;
	private int OM_COUPONMONEY;
	private int OM_LATERMONEY;
	private int OM_VIRTUALMONEY;
	private int OM_VIRTUALACCOUNTMONEY;
	private int OM_RACCOUNTMONEY;
	private int OM_RCARDMONEY;
	private int OM_RCOUPONMONEY;
	private int OM_RLATERMONEY;
	private int OM_RVIRTUALMONEY;
	private int OM_RVIRTUALACCOUNTMONEY;
	private int OM_NEWVIRTUALMONEY;
	private int OM_ORIGNALMONEY;
	private int OM_SALEMONEY;
	private String OM_DELITYPE;
	private String OM_DELIMEMO;
	private int OM_DELIMONEY;
	private String OM_DELINUM;
	private String OM_MEMO;
	private int OM_PCCSEQ;
	private String OM_ESCROWYN;
	private String OM_PARTCANCELYN;
	private String OM_STATUS;
	private String OM_TYPE;
	private String OM_INID;
	private Timestamp OM_INDATE;


	public int getOM_SEQ(){	return OM_SEQ;	}
	public void setOM_SEQ(int om_seq){	OM_SEQ = om_seq;	}

	public String getOM_ID(){	return OM_ID;	}
	public void setOM_ID(String om_id){	OM_ID = om_id;	}

	public String getOM_PGID(){	return OM_PGID;	}
	public void setOM_PGID(String om_pgid){	OM_PGID = om_pgid;	}

	public String getOM_PSWD(){	return OM_PSWD;	}
	public void setOM_PSWD(String om_pswd){	OM_PSWD = om_pswd;	}

	public String getOM_MBID(){	return OM_MBID;	}
	public void setOM_MBID(String om_mbid){	OM_MBID = om_mbid;	}

	public String getOM_CPIDP(){	return OM_CPIDP;	}
	public void setOM_CPIDP(String om_cpidp){	OM_CPIDP = om_cpidp;	}

	public String getOM_CPIDS(){	return OM_CPIDS;	}
	public void setOM_CPIDS(String om_cpids){	OM_CPIDS = om_cpids;	}

	public String getOM_MBNAME(){	return OM_MBNAME;	}
	public void setOM_MBNAME(String om_mbname){	OM_MBNAME = om_mbname;	}

	public String getOM_PRNAME(){	return OM_PRNAME;	}
	public void setOM_PRNAME(String om_prname){	OM_PRNAME = om_prname;	}

	public String getOM_PAYTYPE(){	return OM_PAYTYPE;	}
	public void setOM_PAYTYPE(String om_paytype){	OM_PAYTYPE = om_paytype;	}

	public int getOM_ACCOUNTMONEY(){	return OM_ACCOUNTMONEY;	}
	public void setOM_ACCOUNTMONEY(int om_accountmoney){	OM_ACCOUNTMONEY = om_accountmoney;	}

	public int getOM_BUDGETMONEY(){	return OM_BUDGETMONEY;	}
	public void setOM_BUDGETMONEY(int om_budgetmoney){	OM_BUDGETMONEY = om_budgetmoney;	}

	public int getOM_CARDMONEY(){	return OM_CARDMONEY;	}
	public void setOM_CARDMONEY(int om_cardmoney){	OM_CARDMONEY = om_cardmoney;	}

	public int getOM_COUPONMONEY(){	return OM_COUPONMONEY;	}
	public void setOM_COUPONMONEY(int om_couponmoney){	OM_COUPONMONEY = om_couponmoney;	}

	public int getOM_LATERMONEY(){	return OM_LATERMONEY;	}
	public void setOM_LATERMONEY(int om_latermoney){	OM_LATERMONEY = om_latermoney;	}

	public int getOM_VIRTUALMONEY(){	return OM_VIRTUALMONEY;	}
	public void setOM_VIRTUALMONEY(int om_virtualmoney){	OM_VIRTUALMONEY = om_virtualmoney;	}

	public int getOM_VIRTUALACCOUNTMONEY(){	return OM_VIRTUALACCOUNTMONEY;	}
	public void setOM_VIRTUALACCOUNTMONEY(int om_virtualaccountmoney){	OM_VIRTUALACCOUNTMONEY = om_virtualaccountmoney;	}

	public int getOM_RACCOUNTMONEY(){	return OM_RACCOUNTMONEY;	}
	public void setOM_RACCOUNTMONEY(int om_raccountmoney){	OM_RACCOUNTMONEY = om_raccountmoney;	}

	public int getOM_RCARDMONEY(){	return OM_RCARDMONEY;	}
	public void setOM_RCARDMONEY(int om_rcardmoney){	OM_RCARDMONEY = om_rcardmoney;	}

	public int getOM_RCOUPONMONEY(){	return OM_RCOUPONMONEY;	}
	public void setOM_RCOUPONMONEY(int om_rcouponmoney){	OM_RCOUPONMONEY = om_rcouponmoney;	}

	public int getOM_RLATERMONEY(){	return OM_RLATERMONEY;	}
	public void setOM_RLATERMONEY(int om_rlatermoney){	OM_RLATERMONEY = om_rlatermoney;	}

	public int getOM_RVIRTUALMONEY(){	return OM_RVIRTUALMONEY;	}
	public void setOM_RVIRTUALMONEY(int om_rvirtualmoney){	OM_RVIRTUALMONEY = om_rvirtualmoney;	}

	public int getOM_RVIRTUALACCOUNTMONEY(){	return OM_RVIRTUALACCOUNTMONEY;	}
	public void setOM_RVIRTUALACCOUNTMONEY(int om_rvirtualaccountmoney){	OM_RVIRTUALACCOUNTMONEY = om_rvirtualaccountmoney;	}

	public int getOM_NEWVIRTUALMONEY(){	return OM_NEWVIRTUALMONEY;	}
	public void setOM_NEWVIRTUALMONEY(int om_newvirtualmoney){	OM_NEWVIRTUALMONEY = om_newvirtualmoney;	}

	public int getOM_ORIGNALMONEY(){	return OM_ORIGNALMONEY;	}
	public void setOM_ORIGNALMONEY(int om_orignalmoney){	OM_ORIGNALMONEY = om_orignalmoney;	}

	public int getOM_SALEMONEY(){	return OM_SALEMONEY;	}
	public void setOM_SALEMONEY(int om_salemoney){	OM_SALEMONEY = om_salemoney;	}

	public String getOM_DELITYPE(){	return OM_DELITYPE;	}
	public void setOM_DELITYPE(String om_delitype){	OM_DELITYPE = om_delitype;	}

	public String getOM_DELIMEMO(){	return OM_DELIMEMO;	}
	public void setOM_DELIMEMO(String om_delimemo){	OM_DELIMEMO = om_delimemo;	}

	public int getOM_DELIMONEY(){	return OM_DELIMONEY;	}
	public void setOM_DELIMONEY(int om_delimoney){	OM_DELIMONEY = om_delimoney;	}

	public String getOM_DELINUM(){	return OM_DELINUM;	}
	public void setOM_DELINUM(String om_delinum){	OM_DELINUM = om_delinum;	}

	public String getOM_MEMO(){	return OM_MEMO;	}
	public void setOM_MEMO(String om_memo){	OM_MEMO = om_memo;	}

	public int getOM_PCCSEQ(){	return OM_PCCSEQ;	}
	public void setOM_PCCSEQ(int om_pccseq){	OM_PCCSEQ = om_pccseq;	}

	public String getOM_ESCROWYN(){	return OM_ESCROWYN;	}
	public void setOM_ESCROWYN(String om_escrowyn){	OM_ESCROWYN = om_escrowyn;	}

	public String getOM_PARTCANCELYN(){	return OM_PARTCANCELYN;	}
	public void setOM_PARTCANCELYN(String om_partcancelyn){	OM_PARTCANCELYN = om_partcancelyn;	}

	public String getOM_STATUS(){	return OM_STATUS;	}
	public void setOM_STATUS(String om_status){	OM_STATUS = om_status;	}

	public String getOM_TYPE(){	return OM_TYPE;	}
	public void setOM_TYPE(String om_type){	OM_TYPE = om_type;	}

	public String getOM_INID(){	return OM_INID;	}
	public void setOM_INID(String om_inid){	OM_INID = om_inid;	}

	public Timestamp getOM_INDATE(){	return OM_INDATE;	}
	public void setOM_INDATE(Timestamp om_indate){	OM_INDATE = om_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="OM_SEQ : "+OM_SEQ+", "+"OM_ID : "+OM_ID+", "+"OM_PGID : "+OM_PGID+", "+"OM_PSWD : "+OM_PSWD+", "+"OM_MBID : "+OM_MBID+", "+"OM_CPIDP : "+OM_CPIDP+", "+"OM_CPIDS : "+OM_CPIDS+", "+"OM_MBNAME : "+OM_MBNAME+", "+"OM_PRNAME : "+OM_PRNAME+", "+"OM_PAYTYPE : "+OM_PAYTYPE+", "+"OM_ACCOUNTMONEY : "+OM_ACCOUNTMONEY+", "+"OM_BUDGETMONEY : "+OM_BUDGETMONEY+", "+"OM_CARDMONEY : "+OM_CARDMONEY+", "+"OM_COUPONMONEY : "+OM_COUPONMONEY+", "+"OM_LATERMONEY : "+OM_LATERMONEY+", "+"OM_VIRTUALMONEY : "+OM_VIRTUALMONEY+", "+"OM_VIRTUALACCOUNTMONEY : "+OM_VIRTUALACCOUNTMONEY+", "+"OM_RACCOUNTMONEY : "+OM_RACCOUNTMONEY+", "+"OM_RCARDMONEY : "+OM_RCARDMONEY+", "+"OM_RCOUPONMONEY : "+OM_RCOUPONMONEY+", "+"OM_RLATERMONEY : "+OM_RLATERMONEY+", "+"OM_RVIRTUALMONEY : "+OM_RVIRTUALMONEY+", "+"OM_RVIRTUALACCOUNTMONEY : "+OM_RVIRTUALACCOUNTMONEY+", "+"OM_NEWVIRTUALMONEY : "+OM_NEWVIRTUALMONEY+", "+"OM_ORIGNALMONEY : "+OM_ORIGNALMONEY+", "+"OM_SALEMONEY : "+OM_SALEMONEY+", "+"OM_DELITYPE : "+OM_DELITYPE+", "+"OM_DELIMEMO : "+OM_DELIMEMO+", "+"OM_DELIMONEY : "+OM_DELIMONEY+", "+"OM_DELINUM : "+OM_DELINUM+", "+"OM_MEMO : "+OM_MEMO+", "+"OM_PCCSEQ : "+OM_PCCSEQ+", "+"OM_ESCROWYN : "+OM_ESCROWYN+", "+"OM_PARTCANCELYN : "+OM_PARTCANCELYN+", "+"OM_STATUS : "+OM_STATUS+", "+"OM_TYPE : "+OM_TYPE+", "+"OM_INID : "+OM_INID+", "+"OM_INDATE : "+OM_INDATE;
		return toStr;
	}

}