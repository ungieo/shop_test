package productoption.dto;

import java.io.*;

import java.sql.Date;
import java.sql.Timestamp;

public class Productoption implements Serializable{
	private static final long serialVersionUID = 1L;

	private int PRO_SEQ;
	private int PRO_PRSEQ;
	private String PRO_GNAME;
	private String PRO_NAME;
	private String PRO_VALUE;
	private int PRO_PRICE;
	private int PRO_STOCK;
	private String PRO_LEVEL;
	private String PRO_TYPE;
	private String PRO_USE;
	private String PRO_MOID;
	private String PRO_INID;
	private Timestamp PRO_MODATE;
	private Timestamp PRO_INDATE;


	public int getPRO_SEQ(){	return PRO_SEQ;	}
	public void setPRO_SEQ(int pro_seq){	PRO_SEQ = pro_seq;	}

	public int getPRO_PRSEQ(){	return PRO_PRSEQ;	}
	public void setPRO_PRSEQ(int pro_prseq){	PRO_PRSEQ = pro_prseq;	}

	public String getPRO_GNAME(){	return PRO_GNAME;	}
	public void setPRO_GNAME(String pro_gname){	PRO_GNAME = pro_gname;	}

	public String getPRO_NAME(){	return PRO_NAME;	}
	public void setPRO_NAME(String pro_name){	PRO_NAME = pro_name;	}

	public String getPRO_VALUE(){	return PRO_VALUE;	}
	public void setPRO_VALUE(String pro_value){	PRO_VALUE = pro_value;	}

	public int getPRO_PRICE(){	return PRO_PRICE;	}
	public void setPRO_PRICE(int pro_price){	PRO_PRICE = pro_price;	}

	public int getPRO_STOCK(){	return PRO_STOCK;	}
	public void setPRO_STOCK(int pro_stock){	PRO_STOCK = pro_stock;	}

	public String getPRO_LEVEL(){	return PRO_LEVEL;	}
	public void setPRO_LEVEL(String pro_level){	PRO_LEVEL = pro_level;	}

	public String getPRO_TYPE(){	return PRO_TYPE;	}
	public void setPRO_TYPE(String pro_type){	PRO_TYPE = pro_type;	}

	public String getPRO_USE(){	return PRO_USE;	}
	public void setPRO_USE(String pro_use){	PRO_USE = pro_use;	}

	public String getPRO_MOID(){	return PRO_MOID;	}
	public void setPRO_MOID(String pro_moid){	PRO_MOID = pro_moid;	}

	public String getPRO_INID(){	return PRO_INID;	}
	public void setPRO_INID(String pro_inid){	PRO_INID = pro_inid;	}

	public Timestamp getPRO_MODATE(){	return PRO_MODATE;	}
	public void setPRO_MODATE(Timestamp pro_modate){	PRO_MODATE = pro_modate;	}

	public Timestamp getPRO_INDATE(){	return PRO_INDATE;	}
	public void setPRO_INDATE(Timestamp pro_indate){	PRO_INDATE = pro_indate;	}


	// 추가는 아래 작성!!!!!

	public String toStr(){
		String toStr ="PRO_SEQ : "+PRO_SEQ+", "+"PRO_PRSEQ : "+PRO_PRSEQ+", "+"PRO_GNAME : "+PRO_GNAME+", "+"PRO_NAME : "+PRO_NAME+", "+"PRO_VALUE : "+PRO_VALUE+", "+"PRO_PRICE : "+PRO_PRICE+", "+"PRO_STOCK : "+PRO_STOCK+", "+"PRO_LEVEL : "+PRO_LEVEL+", "+"PRO_TYPE : "+PRO_TYPE+", "+"PRO_USE : "+PRO_USE+", "+"PRO_MOID : "+PRO_MOID+", "+"PRO_INID : "+PRO_INID+", "+"PRO_MODATE : "+PRO_MODATE+", "+"PRO_INDATE : "+PRO_INDATE;
		return toStr;
	}

}