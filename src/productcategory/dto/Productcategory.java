package productcategory.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Productcategory implements Serializable{
	private static final long serialVersionUID = 1L;

	private int PRC_SEQ;
	private String PRC_CODE;
	private int PRC_PID;
	private String PRC_NAME;
	private int PRC_STEP;
	private String PRC_TITLEIMAGE;
	private int PRC_GNUM1;
	private int PRC_GNUM2;
	private int PRC_GNUM3;
	private int PRC_GNUM4;
	private int PRC_LEVEL;
	private String PRC_TYPE;
	private String PRC_USE;
	private String PRC_MOID;
	private String PRC_INID;
	private Timestamp PRC_MODATE;
	private Timestamp PRC_INDATE;


	public int getPRC_SEQ(){	return PRC_SEQ;	}
	public void setPRC_SEQ(int prc_seq){	PRC_SEQ = prc_seq;	}

	public String getPRC_CODE(){	return PRC_CODE;	}
	public void setPRC_CODE(String prc_code){	PRC_CODE = prc_code;	}

	public int getPRC_PID(){	return PRC_PID;	}
	public void setPRC_PID(int prc_pid){	PRC_PID = prc_pid;	}

	public String getPRC_NAME(){	return PRC_NAME;	}
	public void setPRC_NAME(String prc_name){	PRC_NAME = prc_name;	}

	public int getPRC_STEP(){	return PRC_STEP;	}
	public void setPRC_STEP(int prc_step){	PRC_STEP = prc_step;	}

	public String getPRC_TITLEIMAGE(){	return PRC_TITLEIMAGE;	}
	public void setPRC_TITLEIMAGE(String prc_titleimage){	PRC_TITLEIMAGE = prc_titleimage;	}

	public int getPRC_GNUM1(){	return PRC_GNUM1;	}
	public void setPRC_GNUM1(int prc_gnum1){	PRC_GNUM1 = prc_gnum1;	}

	public int getPRC_GNUM2(){	return PRC_GNUM2;	}
	public void setPRC_GNUM2(int prc_gnum2){	PRC_GNUM2 = prc_gnum2;	}

	public int getPRC_GNUM3(){	return PRC_GNUM3;	}
	public void setPRC_GNUM3(int prc_gnum3){	PRC_GNUM3 = prc_gnum3;	}

	public int getPRC_GNUM4(){	return PRC_GNUM4;	}
	public void setPRC_GNUM4(int prc_gnum4){	PRC_GNUM4 = prc_gnum4;	}

	public int getPRC_LEVEL(){	return PRC_LEVEL;	}
	public void setPRC_LEVEL(int prc_level){	PRC_LEVEL = prc_level;	}

	public String getPRC_TYPE(){	return PRC_TYPE;	}
	public void setPRC_TYPE(String prc_type){	PRC_TYPE = prc_type;	}

	public String getPRC_USE(){	return PRC_USE;	}
	public void setPRC_USE(String prc_use){	PRC_USE = prc_use;	}

	public String getPRC_MOID(){	return PRC_MOID;	}
	public void setPRC_MOID(String prc_moid){	PRC_MOID = prc_moid;	}

	public String getPRC_INID(){	return PRC_INID;	}
	public void setPRC_INID(String prc_inid){	PRC_INID = prc_inid;	}

	public Timestamp getPRC_MODATE(){	return PRC_MODATE;	}
	public void setPRC_MODATE(Timestamp prc_modate){	PRC_MODATE = prc_modate;	}

	public Timestamp getPRC_INDATE(){	return PRC_INDATE;	}
	public void setPRC_INDATE(Timestamp prc_indate){	PRC_INDATE = prc_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="PRC_SEQ : "+PRC_SEQ+", "+"PRC_CODE : "+PRC_CODE+", "+"PRC_PID : "+PRC_PID+", "+"PRC_NAME : "+PRC_NAME+", "+"PRC_STEP : "+PRC_STEP+", "+"PRC_TITLEIMAGE : "+PRC_TITLEIMAGE+", "+"PRC_GNUM1 : "+PRC_GNUM1+", "+"PRC_GNUM2 : "+PRC_GNUM2+", "+"PRC_GNUM3 : "+PRC_GNUM3+", "+"PRC_GNUM4 : "+PRC_GNUM4+", "+"PRC_LEVEL : "+PRC_LEVEL+", "+"PRC_TYPE : "+PRC_TYPE+", "+"PRC_USE : "+PRC_USE+", "+"PRC_MOID : "+PRC_MOID+", "+"PRC_INID : "+PRC_INID+", "+"PRC_MODATE : "+PRC_MODATE+", "+"PRC_INDATE : "+PRC_INDATE;
		return toStr;
	}

}