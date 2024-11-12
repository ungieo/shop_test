package system.svc;

public class PgInfo {

	private String g_conf_log_dir = "d:/kcp/log";
	private String g_conf_gw_url = "testpaygw.kcp.co.kr";
	private String g_conf_js_url = "https://pay.kcp.co.kr/plugin/payplus_test.js";
	private boolean g_conf_server = false;
	private String g_conf_site_cd   = "T0000";
	private String g_conf_site_key  = "3grptw1.zW0GSo4PQdaGvsF__";
	private String g_conf_site_name = "솔닷 쇼핑몰 솔루션";
	private String g_conf_log_level = "3";
	private String g_conf_gw_port   = "8090";        // 포트번호(변경불가)
	private String module_type      = "01";          // 변경불가
	private int g_conf_tx_mode   = 0;             // 변경불가
	
//	private String g_conf_log_dir = "d:/kcp/log";
//	private String g_conf_gw_url = "testpaygw.kcp.co.kr";
//	private String g_conf_js_url = "";
//	private boolean g_conf_server = false;
//	private String g_conf_site_cd   = "T0000";
//	private String g_conf_site_key  = "3grptw1.zW0GSo4PQdaGvsF__";
//	private String g_conf_site_name = "KCP TEST SHOP";
//	private String g_conf_log_level = "3";
//	private String g_conf_gw_port   = "8090";        // 포트번호(변경불가)
//	private String module_type      = "01";          // 변경불가
//	private int g_conf_tx_mode   = 0;             // 변경불가
	
	
	public String getG_conf_log_dir() {
		return g_conf_log_dir;
	}
	public String getG_conf_gw_url() {
		return g_conf_gw_url;
	}
	public String getG_conf_js_url() {
		return g_conf_js_url;
	}
	public boolean isG_conf_server() {
		return g_conf_server;
	}
	public String getG_conf_site_cd() {
		return g_conf_site_cd;
	}
	public String getG_conf_site_key() {
		return g_conf_site_key;
	}
	public String getG_conf_site_name() {
		return g_conf_site_name;
	}
	public String getG_conf_log_level() {
		return g_conf_log_level;
	}
	public String getG_conf_gw_port() {
		return g_conf_gw_port;
	}
	public String getModule_type() {
		return module_type;
	}
	public int getG_conf_tx_mode() {
		return g_conf_tx_mode;
	}
	
}
