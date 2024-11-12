package boardarticle.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Boardarticle implements Serializable{
	private static final long serialVersionUID = 1L;

	private int BDA_SEQ;
	private String BDA_BDID;
	private int BDA_BDCSEQ;
	private String BDA_CONTENT;
	private int BDA_FILENUM;
	private int BDA_GROUPNUM;
	private int BDA_LEVELNUM;
	private int BDA_STEPNUM;
	private String BDA_MBID;
	private String BDA_NAME;
	private String BDA_OWNERNAME;
	private String BDA_PSWD;
	private int BDA_READCNT;
	private int BDA_RECOMMENDCNT;
	private String BDA_IP;
	private int BDA_STATUS;
	private String BDA_SECRETUSE;
	private String BDA_LEVEL;
	private String BDA_TYPE;
	private String BDA_USE;
	private String BDA_MOID;
	private String BDA_INID;
	private Timestamp BDA_MODATE;
	private Timestamp BDA_INDATE;


	public int getBDA_SEQ(){	return BDA_SEQ;	}
	public void setBDA_SEQ(int bda_seq){	BDA_SEQ = bda_seq;	}

	public String getBDA_BDID(){	return BDA_BDID;	}
	public void setBDA_BDID(String bda_bdid){	BDA_BDID = bda_bdid;	}

	public int getBDA_BDCSEQ(){	return BDA_BDCSEQ;	}
	public void setBDA_BDCSEQ(int bda_bdcseq){	BDA_BDCSEQ = bda_bdcseq;	}

	public String getBDA_CONTENT(){	return BDA_CONTENT;	}
	public void setBDA_CONTENT(String bda_content){	BDA_CONTENT = bda_content;	}

	public int getBDA_FILENUM(){	return BDA_FILENUM;	}
	public void setBDA_FILENUM(int bda_filenum){	BDA_FILENUM = bda_filenum;	}

	public int getBDA_GROUPNUM(){	return BDA_GROUPNUM;	}
	public void setBDA_GROUPNUM(int bda_groupnum){	BDA_GROUPNUM = bda_groupnum;	}

	public int getBDA_LEVELNUM(){	return BDA_LEVELNUM;	}
	public void setBDA_LEVELNUM(int bda_levelnum){	BDA_LEVELNUM = bda_levelnum;	}

	public int getBDA_STEPNUM(){	return BDA_STEPNUM;	}
	public void setBDA_STEPNUM(int bda_stepnum){	BDA_STEPNUM = bda_stepnum;	}

	public String getBDA_MBID(){	return BDA_MBID;	}
	public void setBDA_MBID(String bda_mbid){	BDA_MBID = bda_mbid;	}

	public String getBDA_NAME(){	return BDA_NAME;	}
	public void setBDA_NAME(String bda_name){	BDA_NAME = bda_name;	}

	public String getBDA_OWNERNAME(){	return BDA_OWNERNAME;	}
	public void setBDA_OWNERNAME(String bda_ownername){	BDA_OWNERNAME = bda_ownername;	}

	public String getBDA_PSWD(){	return BDA_PSWD;	}
	public void setBDA_PSWD(String bda_pswd){	BDA_PSWD = bda_pswd;	}

	public int getBDA_READCNT(){	return BDA_READCNT;	}
	public void setBDA_READCNT(int bda_readcnt){	BDA_READCNT = bda_readcnt;	}

	public int getBDA_RECOMMENDCNT(){	return BDA_RECOMMENDCNT;	}
	public void setBDA_RECOMMENDCNT(int bda_recommendcnt){	BDA_RECOMMENDCNT = bda_recommendcnt;	}

	public String getBDA_IP(){	return BDA_IP;	}
	public void setBDA_IP(String bda_ip){	BDA_IP = bda_ip;	}

	public int getBDA_STATUS(){	return BDA_STATUS;	}
	public void setBDA_STATUS(int bda_status){	BDA_STATUS = bda_status;	}

	public String getBDA_SECRETUSE(){	return BDA_SECRETUSE;	}
	public void setBDA_SECRETUSE(String bda_secretuse){	BDA_SECRETUSE = bda_secretuse;	}

	public String getBDA_LEVEL(){	return BDA_LEVEL;	}
	public void setBDA_LEVEL(String bda_level){	BDA_LEVEL = bda_level;	}

	public String getBDA_TYPE(){	return BDA_TYPE;	}
	public void setBDA_TYPE(String bda_type){	BDA_TYPE = bda_type;	}

	public String getBDA_USE(){	return BDA_USE;	}
	public void setBDA_USE(String bda_use){	BDA_USE = bda_use;	}

	public String getBDA_MOID(){	return BDA_MOID;	}
	public void setBDA_MOID(String bda_moid){	BDA_MOID = bda_moid;	}

	public String getBDA_INID(){	return BDA_INID;	}
	public void setBDA_INID(String bda_inid){	BDA_INID = bda_inid;	}

	public Timestamp getBDA_MODATE(){	return BDA_MODATE;	}
	public void setBDA_MODATE(Timestamp bda_modate){	BDA_MODATE = bda_modate;	}

	public Timestamp getBDA_INDATE(){	return BDA_INDATE;	}
	public void setBDA_INDATE(Timestamp bda_indate){	BDA_INDATE = bda_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="BDA_SEQ : "+BDA_SEQ+", "+"BDA_BDID : "+BDA_BDID+", "+"BDA_BDCSEQ : "+BDA_BDCSEQ+", "+"BDA_CONTENT : "+BDA_CONTENT+", "+"BDA_FILENUM : "+BDA_FILENUM+", "+"BDA_GROUPNUM : "+BDA_GROUPNUM+", "+"BDA_LEVELNUM : "+BDA_LEVELNUM+", "+"BDA_STEPNUM : "+BDA_STEPNUM+", "+"BDA_MBID : "+BDA_MBID+", "+"BDA_NAME : "+BDA_NAME+", "+"BDA_OWNERNAME : "+BDA_OWNERNAME+", "+"BDA_PSWD : "+BDA_PSWD+", "+"BDA_READCNT : "+BDA_READCNT+", "+"BDA_RECOMMENDCNT : "+BDA_RECOMMENDCNT+", "+"BDA_IP : "+BDA_IP+", "+"BDA_STATUS : "+BDA_STATUS+", "+"BDA_SECRETUSE : "+BDA_SECRETUSE+", "+"BDA_LEVEL : "+BDA_LEVEL+", "+"BDA_TYPE : "+BDA_TYPE+", "+"BDA_USE : "+BDA_USE+", "+"BDA_MOID : "+BDA_MOID+", "+"BDA_INID : "+BDA_INID+", "+"BDA_MODATE : "+BDA_MODATE+", "+"BDA_INDATE : "+BDA_INDATE;
		return toStr;
	}

}