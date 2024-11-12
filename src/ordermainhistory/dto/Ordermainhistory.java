package ordermainhistory.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Ordermainhistory implements Serializable{
	private static final long serialVersionUID = 1L;

	private int OMH_SEQ;
	private int OMH_OMSEQ;
	private String OMH_OMSTATUS;
	private String OMH_MEMO;
	private String OMH_TYPE;
	private String OMH_INID;
	private Timestamp OMH_INDATE;


	public int getOMH_SEQ(){	return OMH_SEQ;	}
	public void setOMH_SEQ(int omh_seq){	OMH_SEQ = omh_seq;	}

	public int getOMH_OMSEQ(){	return OMH_OMSEQ;	}
	public void setOMH_OMSEQ(int omh_omseq){	OMH_OMSEQ = omh_omseq;	}

	public String getOMH_OMSTATUS(){	return OMH_OMSTATUS;	}
	public void setOMH_OMSTATUS(String omh_omstatus){	OMH_OMSTATUS = omh_omstatus;	}

	public String getOMH_MEMO(){	return OMH_MEMO;	}
	public void setOMH_MEMO(String omh_memo){	OMH_MEMO = omh_memo;	}

	public String getOMH_TYPE(){	return OMH_TYPE;	}
	public void setOMH_TYPE(String omh_type){	OMH_TYPE = omh_type;	}

	public String getOMH_INID(){	return OMH_INID;	}
	public void setOMH_INID(String omh_inid){	OMH_INID = omh_inid;	}

	public Timestamp getOMH_INDATE(){	return OMH_INDATE;	}
	public void setOMH_INDATE(Timestamp omh_indate){	OMH_INDATE = omh_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="OMH_SEQ : "+OMH_SEQ+", "+"OMH_OMSEQ : "+OMH_OMSEQ+", "+"OMH_OMSTATUS : "+OMH_OMSTATUS+", "+"OMH_MEMO : "+OMH_MEMO+", "+"OMH_TYPE : "+OMH_TYPE+", "+"OMH_INID : "+OMH_INID+", "+"OMH_INDATE : "+OMH_INDATE;
		return toStr;
	}

}