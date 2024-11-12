package productdisplay.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Productdisplay implements Serializable{
	private static final long serialVersionUID = 1L;

	private int PRD_SEQ;
	private int PRD_PRSEQ;
	private String PRD_TYPE;
	private String PRD_USE;
	private String PRD_INID;
	private Timestamp PRD_INDATE;


	public int getPRD_SEQ(){	return PRD_SEQ;	}
	public void setPRD_SEQ(int prd_seq){	PRD_SEQ = prd_seq;	}

	public int getPRD_PRSEQ(){	return PRD_PRSEQ;	}
	public void setPRD_PRSEQ(int prd_prseq){	PRD_PRSEQ = prd_prseq;	}

	public String getPRD_TYPE(){	return PRD_TYPE;	}
	public void setPRD_TYPE(String prd_type){	PRD_TYPE = prd_type;	}

	public String getPRD_USE(){	return PRD_USE;	}
	public void setPRD_USE(String prd_use){	PRD_USE = prd_use;	}

	public String getPRD_INID(){	return PRD_INID;	}
	public void setPRD_INID(String prd_inid){	PRD_INID = prd_inid;	}

	public Timestamp getPRD_INDATE(){	return PRD_INDATE;	}
	public void setPRD_INDATE(Timestamp prd_indate){	PRD_INDATE = prd_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="PRD_SEQ : "+PRD_SEQ+", "+"PRD_PRSEQ : "+PRD_PRSEQ+", "+"PRD_TYPE : "+PRD_TYPE+", "+"PRD_USE : "+PRD_USE+", "+"PRD_INID : "+PRD_INID+", "+"PRD_INDATE : "+PRD_INDATE;
		return toStr;
	}

}