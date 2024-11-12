package companydepartment.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Companydepartment implements Serializable{
	private static final long serialVersionUID = 1L;

	private int CPD_SEQ;
	private String CPD_CPID;
	private String CPD_ID;
	private String CPD_NAME;
	private String CPD_PAYTYPE;
	private String CPD_EMAIL;
	private String CPD_TEL;
	private String CPD_PHONE;
	private String CPD_FAX;
	private String CPD_LEVEL;
	private String CPD_TYPE;
	private String CPD_USE;
	private String CPD_MOID;
	private String CPD_INID;
	private Timestamp CPD_MODATE;
	private Timestamp CPD_INDATE;


	public int getCPD_SEQ(){	return CPD_SEQ;	}
	public void setCPD_SEQ(int cpd_seq){	CPD_SEQ = cpd_seq;	}

	public String getCPD_CPID(){	return CPD_CPID;	}
	public void setCPD_CPID(String cpd_cpid){	CPD_CPID = cpd_cpid;	}

	public String getCPD_ID(){	return CPD_ID;	}
	public void setCPD_ID(String cpd_id){	CPD_ID = cpd_id;	}

	public String getCPD_NAME(){	return CPD_NAME;	}
	public void setCPD_NAME(String cpd_name){	CPD_NAME = cpd_name;	}

	public String getCPD_PAYTYPE(){	return CPD_PAYTYPE;	}
	public void setCPD_PAYTYPE(String cpd_paytype){	CPD_PAYTYPE = cpd_paytype;	}

	public String getCPD_EMAIL(){	return CPD_EMAIL;	}
	public void setCPD_EMAIL(String cpd_email){	CPD_EMAIL = cpd_email;	}

	public String getCPD_TEL(){	return CPD_TEL;	}
	public void setCPD_TEL(String cpd_tel){	CPD_TEL = cpd_tel;	}

	public String getCPD_PHONE(){	return CPD_PHONE;	}
	public void setCPD_PHONE(String cpd_phone){	CPD_PHONE = cpd_phone;	}

	public String getCPD_FAX(){	return CPD_FAX;	}
	public void setCPD_FAX(String cpd_fax){	CPD_FAX = cpd_fax;	}

	public String getCPD_LEVEL(){	return CPD_LEVEL;	}
	public void setCPD_LEVEL(String cpd_level){	CPD_LEVEL = cpd_level;	}

	public String getCPD_TYPE(){	return CPD_TYPE;	}
	public void setCPD_TYPE(String cpd_type){	CPD_TYPE = cpd_type;	}

	public String getCPD_USE(){	return CPD_USE;	}
	public void setCPD_USE(String cpd_use){	CPD_USE = cpd_use;	}

	public String getCPD_MOID(){	return CPD_MOID;	}
	public void setCPD_MOID(String cpd_moid){	CPD_MOID = cpd_moid;	}

	public String getCPD_INID(){	return CPD_INID;	}
	public void setCPD_INID(String cpd_inid){	CPD_INID = cpd_inid;	}

	public Timestamp getCPD_MODATE(){	return CPD_MODATE;	}
	public void setCPD_MODATE(Timestamp cpd_modate){	CPD_MODATE = cpd_modate;	}

	public Timestamp getCPD_INDATE(){	return CPD_INDATE;	}
	public void setCPD_INDATE(Timestamp cpd_indate){	CPD_INDATE = cpd_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="CPD_SEQ : "+CPD_SEQ+", "+"CPD_CPID : "+CPD_CPID+", "+"CPD_ID : "+CPD_ID+", "+"CPD_NAME : "+CPD_NAME+", "+"CPD_PAYTYPE : "+CPD_PAYTYPE+", "+"CPD_EMAIL : "+CPD_EMAIL+", "+"CPD_TEL : "+CPD_TEL+", "+"CPD_PHONE : "+CPD_PHONE+", "+"CPD_FAX : "+CPD_FAX+", "+"CPD_LEVEL : "+CPD_LEVEL+", "+"CPD_TYPE : "+CPD_TYPE+", "+"CPD_USE : "+CPD_USE+", "+"CPD_MOID : "+CPD_MOID+", "+"CPD_INID : "+CPD_INID+", "+"CPD_MODATE : "+CPD_MODATE+", "+"CPD_INDATE : "+CPD_INDATE;
		return toStr;
	}

}