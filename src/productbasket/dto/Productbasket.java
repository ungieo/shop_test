package productbasket.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Productbasket implements Serializable{
	private static final long serialVersionUID = 1L;

	private int PRB_SEQ;
	private int PRB_PRSEQ;
	private String PRB_MBID;
	private int PRB_PROSEQ;
	private int PRB_EA;
	private String PRB_TYPE;
	private String PRB_MOID;
	private String PRB_INID;
	private Timestamp PRB_INDATE;


	public int getPRB_SEQ(){	return PRB_SEQ;	}
	public void setPRB_SEQ(int prb_seq){	PRB_SEQ = prb_seq;	}

	public int getPRB_PRSEQ(){	return PRB_PRSEQ;	}
	public void setPRB_PRSEQ(int prb_prseq){	PRB_PRSEQ = prb_prseq;	}

	public String getPRB_MBID(){	return PRB_MBID;	}
	public void setPRB_MBID(String prb_mbid){	PRB_MBID = prb_mbid;	}

	public int getPRB_PROSEQ(){	return PRB_PROSEQ;	}
	public void setPRB_PROSEQ(int prb_proseq){	PRB_PROSEQ = prb_proseq;	}

	public int getPRB_EA(){	return PRB_EA;	}
	public void setPRB_EA(int prb_ea){	PRB_EA = prb_ea;	}

	public String getPRB_TYPE(){	return PRB_TYPE;	}
	public void setPRB_TYPE(String prb_type){	PRB_TYPE = prb_type;	}

	public String getPRB_MOID(){	return PRB_MOID;	}
	public void setPRB_MOID(String prb_moid){	PRB_MOID = prb_moid;	}

	public String getPRB_INID(){	return PRB_INID;	}
	public void setPRB_INID(String prb_inid){	PRB_INID = prb_inid;	}

	public Timestamp getPRB_INDATE(){	return PRB_INDATE;	}
	public void setPRB_INDATE(Timestamp prb_indate){	PRB_INDATE = prb_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="PRB_SEQ : "+PRB_SEQ+", "+"PRB_PRSEQ : "+PRB_PRSEQ+", "+"PRB_MBID : "+PRB_MBID+", "+"PRB_PROSEQ : "+PRB_PROSEQ+", "+"PRB_EA : "+PRB_EA+", "+"PRB_TYPE : "+PRB_TYPE+", "+"PRB_MOID : "+PRB_MOID+", "+"PRB_INID : "+PRB_INID+", "+"PRB_INDATE : "+PRB_INDATE;
		return toStr;
	}

}