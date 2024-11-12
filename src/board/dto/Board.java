package board.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Board implements Serializable{
	private static final long serialVersionUID = 1L;

	private String BD_ID;
	private String BD_NAME;
	private String BD_DESCRIPTION;
	private int BD_FILEMAXSIZE;
	private String BD_IMAGE;
	private String BD_IP;
	private String BD_FILEUSE;
	private String BD_ADDUSE;
	private String BD_DELUSE;
	private String BD_EDITUSE;
	private String BD_COMMENTUSE;
	private String BD_SECRETUSE;
	private String BD_IPUSE;
	private String BD_SELFVIEWUSE;
	private String BD_PSWDUSE;
	private String BD_REPLYUSE;
	private String BD_SORTTYPE;
	private String BD_VIEWTYPE;
	private String BD_LEVEL;
	private String BD_TYPE;
	private String BD_USE;
	private String BD_MOID;
	private String BD_INID;
	private Timestamp BD_MODATE;
	private Timestamp BD_INDATE;


	public String getBD_ID(){	return BD_ID;	}
	public void setBD_ID(String bd_id){	BD_ID = bd_id;	}

	public String getBD_NAME(){	return BD_NAME;	}
	public void setBD_NAME(String bd_name){	BD_NAME = bd_name;	}

	public String getBD_DESCRIPTION(){	return BD_DESCRIPTION;	}
	public void setBD_DESCRIPTION(String bd_description){	BD_DESCRIPTION = bd_description;	}

	public int getBD_FILEMAXSIZE(){	return BD_FILEMAXSIZE;	}
	public void setBD_FILEMAXSIZE(int bd_filemaxsize){	BD_FILEMAXSIZE = bd_filemaxsize;	}

	public String getBD_IMAGE(){	return BD_IMAGE;	}
	public void setBD_IMAGE(String bd_image){	BD_IMAGE = bd_image;	}

	public String getBD_IP(){	return BD_IP;	}
	public void setBD_IP(String bd_ip){	BD_IP = bd_ip;	}

	public String getBD_FILEUSE(){	return BD_FILEUSE;	}
	public void setBD_FILEUSE(String bd_fileuse){	BD_FILEUSE = bd_fileuse;	}

	public String getBD_ADDUSE(){	return BD_ADDUSE;	}
	public void setBD_ADDUSE(String bd_adduse){	BD_ADDUSE = bd_adduse;	}

	public String getBD_DELUSE(){	return BD_DELUSE;	}
	public void setBD_DELUSE(String bd_deluse){	BD_DELUSE = bd_deluse;	}

	public String getBD_EDITUSE(){	return BD_EDITUSE;	}
	public void setBD_EDITUSE(String bd_edituse){	BD_EDITUSE = bd_edituse;	}

	public String getBD_COMMENTUSE(){	return BD_COMMENTUSE;	}
	public void setBD_COMMENTUSE(String bd_commentuse){	BD_COMMENTUSE = bd_commentuse;	}

	public String getBD_SECRETUSE(){	return BD_SECRETUSE;	}
	public void setBD_SECRETUSE(String bd_secretuse){	BD_SECRETUSE = bd_secretuse;	}

	public String getBD_IPUSE(){	return BD_IPUSE;	}
	public void setBD_IPUSE(String bd_ipuse){	BD_IPUSE = bd_ipuse;	}

	public String getBD_SELFVIEWUSE(){	return BD_SELFVIEWUSE;	}
	public void setBD_SELFVIEWUSE(String bd_selfviewuse){	BD_SELFVIEWUSE = bd_selfviewuse;	}

	public String getBD_PSWDUSE(){	return BD_PSWDUSE;	}
	public void setBD_PSWDUSE(String bd_pswduse){	BD_PSWDUSE = bd_pswduse;	}

	public String getBD_REPLYUSE(){	return BD_REPLYUSE;	}
	public void setBD_REPLYUSE(String bd_replyuse){	BD_REPLYUSE = bd_replyuse;	}

	public String getBD_SORTTYPE(){	return BD_SORTTYPE;	}
	public void setBD_SORTTYPE(String bd_sorttype){	BD_SORTTYPE = bd_sorttype;	}

	public String getBD_VIEWTYPE(){	return BD_VIEWTYPE;	}
	public void setBD_VIEWTYPE(String bd_viewtype){	BD_VIEWTYPE = bd_viewtype;	}

	public String getBD_LEVEL(){	return BD_LEVEL;	}
	public void setBD_LEVEL(String bd_level){	BD_LEVEL = bd_level;	}

	public String getBD_TYPE(){	return BD_TYPE;	}
	public void setBD_TYPE(String bd_type){	BD_TYPE = bd_type;	}

	public String getBD_USE(){	return BD_USE;	}
	public void setBD_USE(String bd_use){	BD_USE = bd_use;	}

	public String getBD_MOID(){	return BD_MOID;	}
	public void setBD_MOID(String bd_moid){	BD_MOID = bd_moid;	}

	public String getBD_INID(){	return BD_INID;	}
	public void setBD_INID(String bd_inid){	BD_INID = bd_inid;	}

	public Timestamp getBD_MODATE(){	return BD_MODATE;	}
	public void setBD_MODATE(Timestamp bd_modate){	BD_MODATE = bd_modate;	}

	public Timestamp getBD_INDATE(){	return BD_INDATE;	}
	public void setBD_INDATE(Timestamp bd_indate){	BD_INDATE = bd_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="BD_ID : "+BD_ID+", "+"BD_NAME : "+BD_NAME+", "+"BD_DESCRIPTION : "+BD_DESCRIPTION+", "+"BD_FILEMAXSIZE : "+BD_FILEMAXSIZE+", "+"BD_IMAGE : "+BD_IMAGE+", "+"BD_IP : "+BD_IP+", "+"BD_FILEUSE : "+BD_FILEUSE+", "+"BD_ADDUSE : "+BD_ADDUSE+", "+"BD_DELUSE : "+BD_DELUSE+", "+"BD_EDITUSE : "+BD_EDITUSE+", "+"BD_COMMENTUSE : "+BD_COMMENTUSE+", "+"BD_SECRETUSE : "+BD_SECRETUSE+", "+"BD_IPUSE : "+BD_IPUSE+", "+"BD_SELFVIEWUSE : "+BD_SELFVIEWUSE+", "+"BD_PSWDUSE : "+BD_PSWDUSE+", "+"BD_REPLYUSE : "+BD_REPLYUSE+", "+"BD_SORTTYPE : "+BD_SORTTYPE+", "+"BD_VIEWTYPE : "+BD_VIEWTYPE+", "+"BD_LEVEL : "+BD_LEVEL+", "+"BD_TYPE : "+BD_TYPE+", "+"BD_USE : "+BD_USE+", "+"BD_MOID : "+BD_MOID+", "+"BD_INID : "+BD_INID+", "+"BD_MODATE : "+BD_MODATE+", "+"BD_INDATE : "+BD_INDATE;
		return toStr;
	}

}