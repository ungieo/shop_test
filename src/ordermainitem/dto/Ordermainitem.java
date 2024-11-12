package ordermainitem.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Ordermainitem implements Serializable{
	private static final long serialVersionUID = 1L;

	private int OMI_SEQ;
	private int OMI_OMSEQ;
	private int OMI_PRSEQ;
	private int OMI_PROSEQ;
	private String OMI_PSWD;
	private String OMI_MBID;
	private String OMI_MBNAME;
	private String OMI_PAYTYPE;
	private int OMI_ACCOUNTMONEY;
	private int OMI_CARDMONEY;
	private int OMI_COUPONMONEY;
	private int OMI_LATERMONEY;
	private int OMI_POINTMONEY;
	private int OMI_SAVEMONEY;
	private int OMI_VIRTUALACCOUNTMONEY;
	private int OMI_RACCOUNTMONEY;
	private int OMI_RCARDMONEY;
	private int OMI_RCOUPONMONEY;
	private int OMI_RLATERMONEY;
	private int OMI_RPOINTMONEY;
	private int OMI_RSAVEMONEY;
	private int OMI_RVIRTUALACCOUNTMONEY;
	private int OMI_NEWSAVEMONEY;
	private int OMI_ORIGNALMONEY;
	private int OMI_TOTORIGNALMONEY;
	private int OMI_SALEMONEY;
	private int OMI_TOTSALEMONEY;
	private String OMI_DELITYPE;
	private String OMI_DELIMEMO;
	private int OMI_DELIMONEY;
	private String OMI_DELINUM;
	private String OMI_MEMO;
	private int OMI_PCCSEQ;
	private String OMI_ESCROWYN;
	private String OMI_PARTCANCELYN;
	private int OMI_EA;
	private int OMI_OUTEA;
	private int OMI_INEA;
	private String OMI_STATUS;
	private String OMI_STEP;
	private String OMI_TYPE;
	private String OMI_MOID;
	private String OMI_INID;
	private Timestamp OMI_MODATE;
	private Timestamp OMI_INDATE;


	public int getOMI_SEQ(){	return OMI_SEQ;	}
	public void setOMI_SEQ(int omi_seq){	OMI_SEQ = omi_seq;	}

	public int getOMI_OMSEQ(){	return OMI_OMSEQ;	}
	public void setOMI_OMSEQ(int omi_omseq){	OMI_OMSEQ = omi_omseq;	}

	public int getOMI_PRSEQ(){	return OMI_PRSEQ;	}
	public void setOMI_PRSEQ(int omi_prseq){	OMI_PRSEQ = omi_prseq;	}

	public int getOMI_PROSEQ(){	return OMI_PROSEQ;	}
	public void setOMI_PROSEQ(int omi_proseq){	OMI_PROSEQ = omi_proseq;	}

	public String getOMI_PSWD(){	return OMI_PSWD;	}
	public void setOMI_PSWD(String omi_pswd){	OMI_PSWD = omi_pswd;	}

	public String getOMI_MBID(){	return OMI_MBID;	}
	public void setOMI_MBID(String omi_mbid){	OMI_MBID = omi_mbid;	}

	public String getOMI_MBNAME(){	return OMI_MBNAME;	}
	public void setOMI_MBNAME(String omi_mbname){	OMI_MBNAME = omi_mbname;	}

	public String getOMI_PAYTYPE(){	return OMI_PAYTYPE;	}
	public void setOMI_PAYTYPE(String omi_paytype){	OMI_PAYTYPE = omi_paytype;	}

	public int getOMI_ACCOUNTMONEY(){	return OMI_ACCOUNTMONEY;	}
	public void setOMI_ACCOUNTMONEY(int omi_accountmoney){	OMI_ACCOUNTMONEY = omi_accountmoney;	}

	public int getOMI_CARDMONEY(){	return OMI_CARDMONEY;	}
	public void setOMI_CARDMONEY(int omi_cardmoney){	OMI_CARDMONEY = omi_cardmoney;	}

	public int getOMI_COUPONMONEY(){	return OMI_COUPONMONEY;	}
	public void setOMI_COUPONMONEY(int omi_couponmoney){	OMI_COUPONMONEY = omi_couponmoney;	}

	public int getOMI_LATERMONEY(){	return OMI_LATERMONEY;	}
	public void setOMI_LATERMONEY(int omi_latermoney){	OMI_LATERMONEY = omi_latermoney;	}

	public int getOMI_POINTMONEY(){	return OMI_POINTMONEY;	}
	public void setOMI_POINTMONEY(int omi_pointmoney){	OMI_POINTMONEY = omi_pointmoney;	}

	public int getOMI_SAVEMONEY(){	return OMI_SAVEMONEY;	}
	public void setOMI_SAVEMONEY(int omi_savemoney){	OMI_SAVEMONEY = omi_savemoney;	}

	public int getOMI_VIRTUALACCOUNTMONEY(){	return OMI_VIRTUALACCOUNTMONEY;	}
	public void setOMI_VIRTUALACCOUNTMONEY(int omi_virtualaccountmoney){	OMI_VIRTUALACCOUNTMONEY = omi_virtualaccountmoney;	}

	public int getOMI_RACCOUNTMONEY(){	return OMI_RACCOUNTMONEY;	}
	public void setOMI_RACCOUNTMONEY(int omi_raccountmoney){	OMI_RACCOUNTMONEY = omi_raccountmoney;	}

	public int getOMI_RCARDMONEY(){	return OMI_RCARDMONEY;	}
	public void setOMI_RCARDMONEY(int omi_rcardmoney){	OMI_RCARDMONEY = omi_rcardmoney;	}

	public int getOMI_RCOUPONMONEY(){	return OMI_RCOUPONMONEY;	}
	public void setOMI_RCOUPONMONEY(int omi_rcouponmoney){	OMI_RCOUPONMONEY = omi_rcouponmoney;	}

	public int getOMI_RLATERMONEY(){	return OMI_RLATERMONEY;	}
	public void setOMI_RLATERMONEY(int omi_rlatermoney){	OMI_RLATERMONEY = omi_rlatermoney;	}

	public int getOMI_RPOINTMONEY(){	return OMI_RPOINTMONEY;	}
	public void setOMI_RPOINTMONEY(int omi_rpointmoney){	OMI_RPOINTMONEY = omi_rpointmoney;	}

	public int getOMI_RSAVEMONEY(){	return OMI_RSAVEMONEY;	}
	public void setOMI_RSAVEMONEY(int omi_rsavemoney){	OMI_RSAVEMONEY = omi_rsavemoney;	}

	public int getOMI_RVIRTUALACCOUNTMONEY(){	return OMI_RVIRTUALACCOUNTMONEY;	}
	public void setOMI_RVIRTUALACCOUNTMONEY(int omi_rvirtualaccountmoney){	OMI_RVIRTUALACCOUNTMONEY = omi_rvirtualaccountmoney;	}

	public int getOMI_NEWSAVEMONEY(){	return OMI_NEWSAVEMONEY;	}
	public void setOMI_NEWSAVEMONEY(int omi_newsavemoney){	OMI_NEWSAVEMONEY = omi_newsavemoney;	}

	public int getOMI_ORIGNALMONEY(){	return OMI_ORIGNALMONEY;	}
	public void setOMI_ORIGNALMONEY(int omi_orignalmoney){	OMI_ORIGNALMONEY = omi_orignalmoney;	}

	public int getOMI_TOTORIGNALMONEY(){	return OMI_TOTORIGNALMONEY;	}
	public void setOMI_TOTORIGNALMONEY(int omi_totorignalmoney){	OMI_TOTORIGNALMONEY = omi_totorignalmoney;	}

	public int getOMI_SALEMONEY(){	return OMI_SALEMONEY;	}
	public void setOMI_SALEMONEY(int omi_salemoney){	OMI_SALEMONEY = omi_salemoney;	}

	public int getOMI_TOTSALEMONEY(){	return OMI_TOTSALEMONEY;	}
	public void setOMI_TOTSALEMONEY(int omi_totsalemoney){	OMI_TOTSALEMONEY = omi_totsalemoney;	}

	public String getOMI_DELITYPE(){	return OMI_DELITYPE;	}
	public void setOMI_DELITYPE(String omi_delitype){	OMI_DELITYPE = omi_delitype;	}

	public String getOMI_DELIMEMO(){	return OMI_DELIMEMO;	}
	public void setOMI_DELIMEMO(String omi_delimemo){	OMI_DELIMEMO = omi_delimemo;	}

	public int getOMI_DELIMONEY(){	return OMI_DELIMONEY;	}
	public void setOMI_DELIMONEY(int omi_delimoney){	OMI_DELIMONEY = omi_delimoney;	}

	public String getOMI_DELINUM(){	return OMI_DELINUM;	}
	public void setOMI_DELINUM(String omi_delinum){	OMI_DELINUM = omi_delinum;	}

	public String getOMI_MEMO(){	return OMI_MEMO;	}
	public void setOMI_MEMO(String omi_memo){	OMI_MEMO = omi_memo;	}

	public int getOMI_PCCSEQ(){	return OMI_PCCSEQ;	}
	public void setOMI_PCCSEQ(int omi_pccseq){	OMI_PCCSEQ = omi_pccseq;	}

	public String getOMI_ESCROWYN(){	return OMI_ESCROWYN;	}
	public void setOMI_ESCROWYN(String omi_escrowyn){	OMI_ESCROWYN = omi_escrowyn;	}

	public String getOMI_PARTCANCELYN(){	return OMI_PARTCANCELYN;	}
	public void setOMI_PARTCANCELYN(String omi_partcancelyn){	OMI_PARTCANCELYN = omi_partcancelyn;	}

	public int getOMI_EA(){	return OMI_EA;	}
	public void setOMI_EA(int omi_ea){	OMI_EA = omi_ea;	}

	public int getOMI_OUTEA(){	return OMI_OUTEA;	}
	public void setOMI_OUTEA(int omi_outea){	OMI_OUTEA = omi_outea;	}

	public int getOMI_INEA(){	return OMI_INEA;	}
	public void setOMI_INEA(int omi_inea){	OMI_INEA = omi_inea;	}

	public String getOMI_STATUS(){	return OMI_STATUS;	}
	public void setOMI_STATUS(String omi_status){	OMI_STATUS = omi_status;	}

	public String getOMI_STEP(){	return OMI_STEP;	}
	public void setOMI_STEP(String omi_step){	OMI_STEP = omi_step;	}

	public String getOMI_TYPE(){	return OMI_TYPE;	}
	public void setOMI_TYPE(String omi_type){	OMI_TYPE = omi_type;	}

	public String getOMI_MOID(){	return OMI_MOID;	}
	public void setOMI_MOID(String omi_moid){	OMI_MOID = omi_moid;	}

	public String getOMI_INID(){	return OMI_INID;	}
	public void setOMI_INID(String omi_inid){	OMI_INID = omi_inid;	}

	public Timestamp getOMI_MODATE(){	return OMI_MODATE;	}
	public void setOMI_MODATE(Timestamp omi_modate){	OMI_MODATE = omi_modate;	}

	public Timestamp getOMI_INDATE(){	return OMI_INDATE;	}
	public void setOMI_INDATE(Timestamp omi_indate){	OMI_INDATE = omi_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="OMI_SEQ : "+OMI_SEQ+", "+"OMI_OMSEQ : "+OMI_OMSEQ+", "+"OMI_PRSEQ : "+OMI_PRSEQ+", "+"OMI_PROSEQ : "+OMI_PROSEQ+", "+"OMI_PSWD : "+OMI_PSWD+", "+"OMI_MBID : "+OMI_MBID+", "+"OMI_MBNAME : "+OMI_MBNAME+", "+"OMI_PAYTYPE : "+OMI_PAYTYPE+", "+"OMI_ACCOUNTMONEY : "+OMI_ACCOUNTMONEY+", "+"OMI_CARDMONEY : "+OMI_CARDMONEY+", "+"OMI_COUPONMONEY : "+OMI_COUPONMONEY+", "+"OMI_LATERMONEY : "+OMI_LATERMONEY+", "+"OMI_POINTMONEY : "+OMI_POINTMONEY+", "+"OMI_SAVEMONEY : "+OMI_SAVEMONEY+", "+"OMI_VIRTUALACCOUNTMONEY : "+OMI_VIRTUALACCOUNTMONEY+", "+"OMI_RACCOUNTMONEY : "+OMI_RACCOUNTMONEY+", "+"OMI_RCARDMONEY : "+OMI_RCARDMONEY+", "+"OMI_RCOUPONMONEY : "+OMI_RCOUPONMONEY+", "+"OMI_RLATERMONEY : "+OMI_RLATERMONEY+", "+"OMI_RPOINTMONEY : "+OMI_RPOINTMONEY+", "+"OMI_RSAVEMONEY : "+OMI_RSAVEMONEY+", "+"OMI_RVIRTUALACCOUNTMONEY : "+OMI_RVIRTUALACCOUNTMONEY+", "+"OMI_NEWSAVEMONEY : "+OMI_NEWSAVEMONEY+", "+"OMI_ORIGNALMONEY : "+OMI_ORIGNALMONEY+", "+"OMI_TOTORIGNALMONEY : "+OMI_TOTORIGNALMONEY+", "+"OMI_SALEMONEY : "+OMI_SALEMONEY+", "+"OMI_TOTSALEMONEY : "+OMI_TOTSALEMONEY+", "+"OMI_DELITYPE : "+OMI_DELITYPE+", "+"OMI_DELIMEMO : "+OMI_DELIMEMO+", "+"OMI_DELIMONEY : "+OMI_DELIMONEY+", "+"OMI_DELINUM : "+OMI_DELINUM+", "+"OMI_MEMO : "+OMI_MEMO+", "+"OMI_PCCSEQ : "+OMI_PCCSEQ+", "+"OMI_ESCROWYN : "+OMI_ESCROWYN+", "+"OMI_PARTCANCELYN : "+OMI_PARTCANCELYN+", "+"OMI_EA : "+OMI_EA+", "+"OMI_OUTEA : "+OMI_OUTEA+", "+"OMI_INEA : "+OMI_INEA+", "+"OMI_STATUS : "+OMI_STATUS+", "+"OMI_STEP : "+OMI_STEP+", "+"OMI_TYPE : "+OMI_TYPE+", "+"OMI_MOID : "+OMI_MOID+", "+"OMI_INID : "+OMI_INID+", "+"OMI_MODATE : "+OMI_MODATE+", "+"OMI_INDATE : "+OMI_INDATE;
		return toStr;
	}

}