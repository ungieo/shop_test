package productwish.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Productwish implements Serializable{
	private static final long serialVersionUID = 1L;

	private int PRW_SEQ;
	private int PRW_PRSEQ;
	private int PRW_PROSEQ;
	private String PRW_MBID;
	private String PRW_LEVEL;
	private String PRW_TYPE;
	private String PRW_USE;
	private String PRW_MOID;
	private String PRW_INID;
	private Timestamp PRW_MODATE;
	private Timestamp PRW_INDATE;


	public int getPRW_SEQ(){	return PRW_SEQ;	}
	public void setPRW_SEQ(int prw_seq){	PRW_SEQ = prw_seq;	}

	public int getPRW_PRSEQ(){	return PRW_PRSEQ;	}
	public void setPRW_PRSEQ(int prw_prseq){	PRW_PRSEQ = prw_prseq;	}

	public int getPRW_PROSEQ(){	return PRW_PROSEQ;	}
	public void setPRW_PROSEQ(int prw_proseq){	PRW_PROSEQ = prw_proseq;	}

	public String getPRW_MBID(){	return PRW_MBID;	}
	public void setPRW_MBID(String prw_mbid){	PRW_MBID = prw_mbid;	}

	public String getPRW_LEVEL(){	return PRW_LEVEL;	}
	public void setPRW_LEVEL(String prw_level){	PRW_LEVEL = prw_level;	}

	public String getPRW_TYPE(){	return PRW_TYPE;	}
	public void setPRW_TYPE(String prw_type){	PRW_TYPE = prw_type;	}

	public String getPRW_USE(){	return PRW_USE;	}
	public void setPRW_USE(String prw_use){	PRW_USE = prw_use;	}

	public String getPRW_MOID(){	return PRW_MOID;	}
	public void setPRW_MOID(String prw_moid){	PRW_MOID = prw_moid;	}

	public String getPRW_INID(){	return PRW_INID;	}
	public void setPRW_INID(String prw_inid){	PRW_INID = prw_inid;	}

	public Timestamp getPRW_MODATE(){	return PRW_MODATE;	}
	public void setPRW_MODATE(Timestamp prw_modate){	PRW_MODATE = prw_modate;	}

	public Timestamp getPRW_INDATE(){	return PRW_INDATE;	}
	public void setPRW_INDATE(Timestamp prw_indate){	PRW_INDATE = prw_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="PRW_SEQ : "+PRW_SEQ+", "+"PRW_PRSEQ : "+PRW_PRSEQ+", "+"PRW_PROSEQ : "+PRW_PROSEQ+", "+"PRW_MBID : "+PRW_MBID+", "+"PRW_LEVEL : "+PRW_LEVEL+", "+"PRW_TYPE : "+PRW_TYPE+", "+"PRW_USE : "+PRW_USE+", "+"PRW_MOID : "+PRW_MOID+", "+"PRW_INID : "+PRW_INID+", "+"PRW_MODATE : "+PRW_MODATE+", "+"PRW_INDATE : "+PRW_INDATE;
		return toStr;
	}

}