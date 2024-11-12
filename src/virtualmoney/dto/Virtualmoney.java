package virtualmoney.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Virtualmoney implements Serializable{
	private static final long serialVersionUID = 1L;

	private int VTM_SEQ;
	private String VTM_MBID;
	private String VTM_DESCRIPTION;
	private int VTM_OMSEQ;
	private int VTM_OMISEQ;
	private int VTM_MONEY;
	private String VTN_USETYPE;
	private String VTM_TYPE;
	private String VTM_USE;
	private String VTM_INID;
	private Timestamp VTM_INDATE;


	public int getVTM_SEQ(){	return VTM_SEQ;	}
	public void setVTM_SEQ(int vtm_seq){	VTM_SEQ = vtm_seq;	}

	public String getVTM_MBID(){	return VTM_MBID;	}
	public void setVTM_MBID(String vtm_mbid){	VTM_MBID = vtm_mbid;	}

	public String getVTM_DESCRIPTION(){	return VTM_DESCRIPTION;	}
	public void setVTM_DESCRIPTION(String vtm_description){	VTM_DESCRIPTION = vtm_description;	}

	public int getVTM_OMSEQ(){	return VTM_OMSEQ;	}
	public void setVTM_OMSEQ(int vtm_omseq){	VTM_OMSEQ = vtm_omseq;	}

	public int getVTM_OMISEQ(){	return VTM_OMISEQ;	}
	public void setVTM_OMISEQ(int vtm_omiseq){	VTM_OMISEQ = vtm_omiseq;	}

	public int getVTM_MONEY(){	return VTM_MONEY;	}
	public void setVTM_MONEY(int vtm_money){	VTM_MONEY = vtm_money;	}

	public String getVTN_USETYPE(){	return VTN_USETYPE;	}
	public void setVTN_USETYPE(String vtn_usetype){	VTN_USETYPE = vtn_usetype;	}

	public String getVTM_TYPE(){	return VTM_TYPE;	}
	public void setVTM_TYPE(String vtm_type){	VTM_TYPE = vtm_type;	}

	public String getVTM_USE(){	return VTM_USE;	}
	public void setVTM_USE(String vtm_use){	VTM_USE = vtm_use;	}

	public String getVTM_INID(){	return VTM_INID;	}
	public void setVTM_INID(String vtm_inid){	VTM_INID = vtm_inid;	}

	public Timestamp getVTM_INDATE(){	return VTM_INDATE;	}
	public void setVTM_INDATE(Timestamp vtm_indate){	VTM_INDATE = vtm_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="VTM_SEQ : "+VTM_SEQ+", "+"VTM_MBID : "+VTM_MBID+", "+"VTM_DESCRIPTION : "+VTM_DESCRIPTION+", "+"VTM_OMSEQ : "+VTM_OMSEQ+", "+"VTM_OMISEQ : "+VTM_OMISEQ+", "+"VTM_MONEY : "+VTM_MONEY+", "+"VTN_USETYPE : "+VTN_USETYPE+", "+"VTM_TYPE : "+VTM_TYPE+", "+"VTM_USE : "+VTM_USE+", "+"VTM_INID : "+VTM_INID+", "+"VTM_INDATE : "+VTM_INDATE;
		return toStr;
	}

}