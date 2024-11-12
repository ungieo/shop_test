package commoncode.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Commoncode implements Serializable{
	private static final long serialVersionUID = 1L;

	private int CMC_SEQ;
	private String CMC_GROUPCODE;
	private String CMC_CODE;
	private String CMC_NAME;
	private String CMC_VALUE;
	private String CMC_USE;
	private String CMC_INID;
	private Timestamp CMC_INDATE;


	public int getCMC_SEQ(){	return CMC_SEQ;	}
	public void setCMC_SEQ(int cmc_seq){	CMC_SEQ = cmc_seq;	}

	public String getCMC_GROUPCODE(){	return CMC_GROUPCODE;	}
	public void setCMC_GROUPCODE(String cmc_groupcode){	CMC_GROUPCODE = cmc_groupcode;	}

	public String getCMC_CODE(){	return CMC_CODE;	}
	public void setCMC_CODE(String cmc_code){	CMC_CODE = cmc_code;	}

	public String getCMC_NAME(){	return CMC_NAME;	}
	public void setCMC_NAME(String cmc_name){	CMC_NAME = cmc_name;	}

	public String getCMC_VALUE(){	return CMC_VALUE;	}
	public void setCMC_VALUE(String cmc_value){	CMC_VALUE = cmc_value;	}

	public String getCMC_USE(){	return CMC_USE;	}
	public void setCMC_USE(String cmc_use){	CMC_USE = cmc_use;	}

	public String getCMC_INID(){	return CMC_INID;	}
	public void setCMC_INID(String cmc_inid){	CMC_INID = cmc_inid;	}

	public Timestamp getCMC_INDATE(){	return CMC_INDATE;	}
	public void setCMC_INDATE(Timestamp cmc_indate){	CMC_INDATE = cmc_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="CMC_SEQ : "+CMC_SEQ+", "+"CMC_GROUPCODE : "+CMC_GROUPCODE+", "+"CMC_CODE : "+CMC_CODE+", "+"CMC_NAME : "+CMC_NAME+", "+"CMC_VALUE : "+CMC_VALUE+", "+"CMC_USE : "+CMC_USE+", "+"CMC_INID : "+CMC_INID+", "+"CMC_INDATE : "+CMC_INDATE;
		return toStr;
	}

}