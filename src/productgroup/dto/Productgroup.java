package productgroup.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Productgroup implements Serializable{
	private static final long serialVersionUID = 1L;

	private int PRG_SEQ;
	private int PRG_PRGSEQ;
	private int PRG_PRSEQ;
	private String PRG_TYPE;
	private String PRG_USE;
	private String PRG_INID;
	private Timestamp PRG_INDATE;


	public int getPRG_SEQ(){	return PRG_SEQ;	}
	public void setPRG_SEQ(int prg_seq){	PRG_SEQ = prg_seq;	}

	public int getPRG_PRGSEQ(){	return PRG_PRGSEQ;	}
	public void setPRG_PRGSEQ(int prg_prgseq){	PRG_PRGSEQ = prg_prgseq;	}

	public int getPRG_PRSEQ(){	return PRG_PRSEQ;	}
	public void setPRG_PRSEQ(int prg_prseq){	PRG_PRSEQ = prg_prseq;	}

	public String getPRG_TYPE(){	return PRG_TYPE;	}
	public void setPRG_TYPE(String prg_type){	PRG_TYPE = prg_type;	}

	public String getPRG_USE(){	return PRG_USE;	}
	public void setPRG_USE(String prg_use){	PRG_USE = prg_use;	}

	public String getPRG_INID(){	return PRG_INID;	}
	public void setPRG_INID(String prg_inid){	PRG_INID = prg_inid;	}

	public Timestamp getPRG_INDATE(){	return PRG_INDATE;	}
	public void setPRG_INDATE(Timestamp prg_indate){	PRG_INDATE = prg_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="PRG_SEQ : "+PRG_SEQ+", "+"PRG_PRGSEQ : "+PRG_PRGSEQ+", "+"PRG_PRSEQ : "+PRG_PRSEQ+", "+"PRG_TYPE : "+PRG_TYPE+", "+"PRG_USE : "+PRG_USE+", "+"PRG_INID : "+PRG_INID+", "+"PRG_INDATE : "+PRG_INDATE;
		return toStr;
	}

}