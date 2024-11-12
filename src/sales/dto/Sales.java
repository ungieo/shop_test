package sales.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Sales implements Serializable{
	private static final long serialVersionUID = 1L;

	private int SL_SEQ;
	private int SL_OMSEQ;
	private int SL_OMISEQ;
	private String SL_CPIDP;
	private String SL_CPIDS;
	private String SL_MBID;
	private int SL_ACCOUNTMONEY;
	private int SL_CARDMONEY;
	private int SL_COUPONMONEY;
	private int SL_LATERMONEY;
	private int SL_BUDGETMONEY;
	private int SL_VIRTUALMONEY;
	private int SL_VIRTUALACCOUNTMONEY;
	private int SL_ORIGNALMONEY;
	private int SL_SALEMONEY;
	private String SL_CCIDB;
	private String SL_CCIDS;
	private String SL_CCBHANDLINGYN;
	private String SL_CCSHANDLINGYN;
	private String SL_TYPE;
	private String SL_INID;
	private Timestamp SL_INDATE;


	public int getSL_SEQ(){	return SL_SEQ;	}
	public void setSL_SEQ(int sl_seq){	SL_SEQ = sl_seq;	}

	public int getSL_OMSEQ(){	return SL_OMSEQ;	}
	public void setSL_OMSEQ(int sl_omseq){	SL_OMSEQ = sl_omseq;	}

	public int getSL_OMISEQ(){	return SL_OMISEQ;	}
	public void setSL_OMISEQ(int sl_omiseq){	SL_OMISEQ = sl_omiseq;	}

	public String getSL_CPIDP(){	return SL_CPIDP;	}
	public void setSL_CPIDP(String sl_cpidp){	SL_CPIDP = sl_cpidp;	}

	public String getSL_CPIDS(){	return SL_CPIDS;	}
	public void setSL_CPIDS(String sl_cpids){	SL_CPIDS = sl_cpids;	}

	public String getSL_MBID(){	return SL_MBID;	}
	public void setSL_MBID(String sl_mbid){	SL_MBID = sl_mbid;	}

	public int getSL_ACCOUNTMONEY(){	return SL_ACCOUNTMONEY;	}
	public void setSL_ACCOUNTMONEY(int sl_accountmoney){	SL_ACCOUNTMONEY = sl_accountmoney;	}

	public int getSL_CARDMONEY(){	return SL_CARDMONEY;	}
	public void setSL_CARDMONEY(int sl_cardmoney){	SL_CARDMONEY = sl_cardmoney;	}

	public int getSL_COUPONMONEY(){	return SL_COUPONMONEY;	}
	public void setSL_COUPONMONEY(int sl_couponmoney){	SL_COUPONMONEY = sl_couponmoney;	}

	public int getSL_LATERMONEY(){	return SL_LATERMONEY;	}
	public void setSL_LATERMONEY(int sl_latermoney){	SL_LATERMONEY = sl_latermoney;	}

	public int getSL_BUDGETMONEY(){	return SL_BUDGETMONEY;	}
	public void setSL_BUDGETMONEY(int sl_budgetmoney){	SL_BUDGETMONEY = sl_budgetmoney;	}

	public int getSL_VIRTUALMONEY(){	return SL_VIRTUALMONEY;	}
	public void setSL_VIRTUALMONEY(int sl_virtualmoney){	SL_VIRTUALMONEY = sl_virtualmoney;	}

	public int getSL_VIRTUALACCOUNTMONEY(){	return SL_VIRTUALACCOUNTMONEY;	}
	public void setSL_VIRTUALACCOUNTMONEY(int sl_virtualaccountmoney){	SL_VIRTUALACCOUNTMONEY = sl_virtualaccountmoney;	}

	public int getSL_ORIGNALMONEY(){	return SL_ORIGNALMONEY;	}
	public void setSL_ORIGNALMONEY(int sl_orignalmoney){	SL_ORIGNALMONEY = sl_orignalmoney;	}

	public int getSL_SALEMONEY(){	return SL_SALEMONEY;	}
	public void setSL_SALEMONEY(int sl_salemoney){	SL_SALEMONEY = sl_salemoney;	}

	public String getSL_CCIDB(){	return SL_CCIDB;	}
	public void setSL_CCIDB(String sl_ccidb){	SL_CCIDB = sl_ccidb;	}

	public String getSL_CCIDS(){	return SL_CCIDS;	}
	public void setSL_CCIDS(String sl_ccids){	SL_CCIDS = sl_ccids;	}

	public String getSL_CCBHANDLINGYN(){	return SL_CCBHANDLINGYN;	}
	public void setSL_CCBHANDLINGYN(String sl_ccbhandlingyn){	SL_CCBHANDLINGYN = sl_ccbhandlingyn;	}

	public String getSL_CCSHANDLINGYN(){	return SL_CCSHANDLINGYN;	}
	public void setSL_CCSHANDLINGYN(String sl_ccshandlingyn){	SL_CCSHANDLINGYN = sl_ccshandlingyn;	}

	public String getSL_TYPE(){	return SL_TYPE;	}
	public void setSL_TYPE(String sl_type){	SL_TYPE = sl_type;	}

	public String getSL_INID(){	return SL_INID;	}
	public void setSL_INID(String sl_inid){	SL_INID = sl_inid;	}

	public Timestamp getSL_INDATE(){	return SL_INDATE;	}
	public void setSL_INDATE(Timestamp sl_indate){	SL_INDATE = sl_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="SL_SEQ : "+SL_SEQ+", "+"SL_OMSEQ : "+SL_OMSEQ+", "+"SL_OMISEQ : "+SL_OMISEQ+", "+"SL_CPIDP : "+SL_CPIDP+", "+"SL_CPIDS : "+SL_CPIDS+", "+"SL_MBID : "+SL_MBID+", "+"SL_ACCOUNTMONEY : "+SL_ACCOUNTMONEY+", "+"SL_CARDMONEY : "+SL_CARDMONEY+", "+"SL_COUPONMONEY : "+SL_COUPONMONEY+", "+"SL_LATERMONEY : "+SL_LATERMONEY+", "+"SL_BUDGETMONEY : "+SL_BUDGETMONEY+", "+"SL_VIRTUALMONEY : "+SL_VIRTUALMONEY+", "+"SL_VIRTUALACCOUNTMONEY : "+SL_VIRTUALACCOUNTMONEY+", "+"SL_ORIGNALMONEY : "+SL_ORIGNALMONEY+", "+"SL_SALEMONEY : "+SL_SALEMONEY+", "+"SL_CCIDB : "+SL_CCIDB+", "+"SL_CCIDS : "+SL_CCIDS+", "+"SL_CCBHANDLINGYN : "+SL_CCBHANDLINGYN+", "+"SL_CCSHANDLINGYN : "+SL_CCSHANDLINGYN+", "+"SL_TYPE : "+SL_TYPE+", "+"SL_INID : "+SL_INID+", "+"SL_INDATE : "+SL_INDATE;
		return toStr;
	}

}