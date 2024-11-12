package parcelcompany.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Parcelcompany implements Serializable{
	private static final long serialVersionUID = 1L;

	private int PC_SEQ;
	private String PC_NAME;
	private String PC_CPID;
	private String PC_URL;
	private String PC_LEVEL;
	private String PC_TYPE;
	private String PC_USE;
	private String PC_INID;
	private Timestamp PC_INDATE;


	public int getPC_SEQ(){	return PC_SEQ;	}
	public void setPC_SEQ(int pc_seq){	PC_SEQ = pc_seq;	}

	public String getPC_NAME(){	return PC_NAME;	}
	public void setPC_NAME(String pc_name){	PC_NAME = pc_name;	}

	public String getPC_CPID(){	return PC_CPID;	}
	public void setPC_CPID(String pc_cpid){	PC_CPID = pc_cpid;	}

	public String getPC_URL(){	return PC_URL;	}
	public void setPC_URL(String pc_url){	PC_URL = pc_url;	}

	public String getPC_LEVEL(){	return PC_LEVEL;	}
	public void setPC_LEVEL(String pc_level){	PC_LEVEL = pc_level;	}

	public String getPC_TYPE(){	return PC_TYPE;	}
	public void setPC_TYPE(String pc_type){	PC_TYPE = pc_type;	}

	public String getPC_USE(){	return PC_USE;	}
	public void setPC_USE(String pc_use){	PC_USE = pc_use;	}

	public String getPC_INID(){	return PC_INID;	}
	public void setPC_INID(String pc_inid){	PC_INID = pc_inid;	}

	public Timestamp getPC_INDATE(){	return PC_INDATE;	}
	public void setPC_INDATE(Timestamp pc_indate){	PC_INDATE = pc_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="PC_SEQ : "+PC_SEQ+", "+"PC_NAME : "+PC_NAME+", "+"PC_CPID : "+PC_CPID+", "+"PC_URL : "+PC_URL+", "+"PC_LEVEL : "+PC_LEVEL+", "+"PC_TYPE : "+PC_TYPE+", "+"PC_USE : "+PC_USE+", "+"PC_INID : "+PC_INID+", "+"PC_INDATE : "+PC_INDATE;
		return toStr;
	}

}