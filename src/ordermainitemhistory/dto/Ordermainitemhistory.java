package ordermainitemhistory.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Ordermainitemhistory implements Serializable{
	private static final long serialVersionUID = 1L;

	private int OMIH_SEQ;
	private String OMIH_OMISEQ;
	private String OMIH_OMISTATUS;
	private String OMIH_OMISTEP;
	private String OMIH_MEMO;
	private String OMIH_LEVEL;
	private String OMIH_TYPE;
	private String OMIH_MOID;
	private String OMIH_INID;
	private Timestamp OMIH_MODATE;
	private Timestamp OMIH_INDATE;


	public int getOMIH_SEQ(){	return OMIH_SEQ;	}
	public void setOMIH_SEQ(int omih_seq){	OMIH_SEQ = omih_seq;	}

	public String getOMIH_OMISEQ(){	return OMIH_OMISEQ;	}
	public void setOMIH_OMISEQ(String omih_omiseq){	OMIH_OMISEQ = omih_omiseq;	}

	public String getOMIH_OMISTATUS(){	return OMIH_OMISTATUS;	}
	public void setOMIH_OMISTATUS(String omih_omistatus){	OMIH_OMISTATUS = omih_omistatus;	}

	public String getOMIH_OMISTEP(){	return OMIH_OMISTEP;	}
	public void setOMIH_OMISTEP(String omih_omistep){	OMIH_OMISTEP = omih_omistep;	}

	public String getOMIH_MEMO(){	return OMIH_MEMO;	}
	public void setOMIH_MEMO(String omih_memo){	OMIH_MEMO = omih_memo;	}

	public String getOMIH_LEVEL(){	return OMIH_LEVEL;	}
	public void setOMIH_LEVEL(String omih_level){	OMIH_LEVEL = omih_level;	}

	public String getOMIH_TYPE(){	return OMIH_TYPE;	}
	public void setOMIH_TYPE(String omih_type){	OMIH_TYPE = omih_type;	}

	public String getOMIH_MOID(){	return OMIH_MOID;	}
	public void setOMIH_MOID(String omih_moid){	OMIH_MOID = omih_moid;	}

	public String getOMIH_INID(){	return OMIH_INID;	}
	public void setOMIH_INID(String omih_inid){	OMIH_INID = omih_inid;	}

	public Timestamp getOMIH_MODATE(){	return OMIH_MODATE;	}
	public void setOMIH_MODATE(Timestamp omih_modate){	OMIH_MODATE = omih_modate;	}

	public Timestamp getOMIH_INDATE(){	return OMIH_INDATE;	}
	public void setOMIH_INDATE(Timestamp omih_indate){	OMIH_INDATE = omih_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="OMIH_SEQ : "+OMIH_SEQ+", "+"OMIH_OMISEQ : "+OMIH_OMISEQ+", "+"OMIH_OMISTATUS : "+OMIH_OMISTATUS+", "+"OMIH_OMISTEP : "+OMIH_OMISTEP+", "+"OMIH_MEMO : "+OMIH_MEMO+", "+"OMIH_LEVEL : "+OMIH_LEVEL+", "+"OMIH_TYPE : "+OMIH_TYPE+", "+"OMIH_MOID : "+OMIH_MOID+", "+"OMIH_INID : "+OMIH_INID+", "+"OMIH_MODATE : "+OMIH_MODATE+", "+"OMIH_INDATE : "+OMIH_INDATE;
		return toStr;
	}

}