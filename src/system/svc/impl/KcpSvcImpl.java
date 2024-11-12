package system.svc.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kcp.J_PP_CLI_N;

import ordermain.dao.OrdermainDao;
import ordermain.dto.Ordermain;
import ordermainhistory.dao.OrdermainhistoryDao;
import ordermainhistory.dto.Ordermainhistory;
import sales.dao.SalesDao;
import sales.dto.Sales;
import system.svc.PgInfo;
import system.svc.PgSvc;
import system.util.Cvt;
import virtualmoney.dao.VirtualmoneyDao;
import virtualmoney.dto.Virtualmoney;

public class KcpSvcImpl implements PgSvc{

	Connection conn;
	HttpSession session;
	
	public KcpSvcImpl(Connection conn){ this.conn = conn; }

	@Override
	public boolean deliveryIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean escrowIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean escrowUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pgCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pgDel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pgIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		
		
		//---* session
		HttpSession session = req.getSession();
		String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
		//--- session
		
		
		PgInfo pginfo = new PgInfo();
		
		
	    String req_tx         = Cvt.toStr( req.getParameter( "req_tx"         ) ); // 요청 종류
	    String tran_cd        = Cvt.toStr( req.getParameter( "tran_cd"        ) ); // 처리 종류
	    /* = -------------------------------------------------------------------------- = */
	    String cust_ip        = Cvt.toStr( req.getRemoteAddr()                  ); // 요청 IP
	    String ordr_idxx      = Cvt.toStr( req.getParameter( "ordr_idxx"      ) ); // 쇼핑몰 주문번호
	    String good_name      = Cvt.toStr( req.getParameter( "good_name"      ) ); // 상품명
	    String good_mny       = Cvt.toStr( req.getParameter( "good_mny"       ) ); // 결제 총금액
	    /* = -------------------------------------------------------------------------- = */
	    String res_cd         = "";                                                     // 응답코드
	    String res_msg        = "";                                                     // 응답 메세지
	    String tno            = Cvt.toStr( req.getParameter( "tno"            ) ); // KCP 거래 고유 번호
	    /* = -------------------------------------------------------------------------- = */
	    String buyr_name      = Cvt.toStr( req.getParameter( "buyr_name"      ) ); // 주문자명
	    String buyr_tel1      = Cvt.toStr( req.getParameter( "buyr_tel1"      ) ); // 주문자 전화번호
	    String buyr_tel2      = Cvt.toStr( req.getParameter( "buyr_tel2"      ) ); // 주문자 핸드폰 번호
	    String buyr_mail      = Cvt.toStr( req.getParameter( "buyr_mail"      ) ); // 주문자 E-mail 주소
	    /* = -------------------------------------------------------------------------- = */
	    String use_pay_method = Cvt.toStr( req.getParameter( "use_pay_method" ) ); // 결제 방법
	    String bSucc          = "";                                                     // 업체 DB 처리 성공 여부
	    /* = -------------------------------------------------------------------------- = */
	    String app_time       = "";                                                     // 승인시간 (모든 결제 수단 공통)
	    String amount         = "";                                                     // KCP 실제 거래금액         
	    String total_amount   = "0";                                                    // 복합결제시 총 거래금액
	    String coupon_mny     = "";                                                     // 쿠폰금액
	    /* = -------------------------------------------------------------------------- = */
	    String card_cd        = "";                                                     // 신용카드 코드
	    String card_name      = "";                                                     // 신용카드 명
	    String app_no         = "";                                                     // 신용카드 승인번호
	    String noinf          = "";                                                     // 신용카드 무이자 여부
	    String quota          = "";                                                     // 신용카드 할부개월
	    String partcanc_yn    = "";                                                     // 부분취소 가능유무
	    String card_bin_type_01 = "";                                                   // 카드구분1
	    String card_bin_type_02 = "";                                                   // 카드구분2
	    String card_mny       = "";                                                     // 카드결제금액
	    /* = -------------------------------------------------------------------------- = */
	    String bank_name      = "";                                                     // 은행명
	    String bank_code      = "";                                                     // 은행코드
	    String bk_mny         = "";                                                     // 계좌이체결제금액
	    /* = -------------------------------------------------------------------------- = */
	    String bankname       = "";                                                     // 입금 은행명
	    String depositor      = "";                                                     // 입금 계좌 예금주 성명
	    String account        = "";                                                     // 입금 계좌 번호
	    String va_date        = "";                                                     // 가상계좌 입금마감시간
	    /* = -------------------------------------------------------------------------- = */
	    String pnt_issue      = "";                                                     // 결제 포인트사 코드
	    String pnt_amount     = "";                                                     // 적립금액 or 사용금액
	    String pnt_app_time   = "";                                                     // 승인시간
	    String pnt_app_no     = "";                                                     // 승인번호
	    String add_pnt        = "";                                                     // 발생 포인트
	    String use_pnt        = "";                                                     // 사용가능 포인트
	    String rsv_pnt        = "";                                                     // 총 누적 포인트
	    /* = -------------------------------------------------------------------------- = */
	    String commid         = "";                                                     // 통신사코드
	    String mobile_no      = "";                                                     // 휴대폰번호
	    /* = -------------------------------------------------------------------------- = */
	    String shop_user_id   = Cvt.toStr( req.getParameter( "shop_user_id"   ) ); // 가맹점 고객 아이디
	    String tk_van_code    = "";                                                     // 발급사코드
	    String tk_app_no      = "";                                                     // 승인번호
	    /* = -------------------------------------------------------------------------- = */
	    String cash_yn        = Cvt.toStr( req.getParameter( "cash_yn"        ) ); // 현금 영수증 등록 여부
	    String cash_authno    = "";                                                     // 현금 영수증 승인 번호
	    String cash_tr_code   = Cvt.toStr( req.getParameter( "cash_tr_code"   ) ); // 현금 영수증 발행 구분
	    String cash_id_info   = Cvt.toStr( req.getParameter( "cash_id_info"   ) ); // 현금 영수증 등록 번호
	    /* ============================================================================== */
	    /* =   02. 지불 요청 정보 설정 END
	    /* ============================================================================== */
	    /* ============================================================================== */
	    /* =   03. 인스턴스 생성 및 초기화(변경 불가)                                   = */
	    /* = -------------------------------------------------------------------------- = */
	    /* =       결제에 필요한 인스턴스를 생성하고 초기화 합니다.                     = */
	    /* = -------------------------------------------------------------------------- = */
	    J_PP_CLI_N c_PayPlus = new J_PP_CLI_N();

	    c_PayPlus.mf_init( "", pginfo.getG_conf_gw_url(), pginfo.getG_conf_gw_port(), pginfo.getG_conf_tx_mode(), pginfo.getG_conf_log_dir() );
	    c_PayPlus.mf_init_set();   

	    /* ============================================================================== */
	    /* =   03. 인스턴스 생성 및 초기화 END                                          = */
	    /* ============================================================================== */


	    /* ============================================================================== */
	    /* =   04. 처리 요청 정보 설정                                                  = */
	    /* = -------------------------------------------------------------------------- = */
	    /* = -------------------------------------------------------------------------- = */
	    /* =   04-1. 승인 요청 정보 설정                                                = */
	    /* = -------------------------------------------------------------------------- = */
	    if ( req_tx.equals( "pay" ) )
	    {
	            c_PayPlus.mf_set_enc_data( Cvt.toStr( req.getParameter( "enc_data" ) ),
	                                       Cvt.toStr( req.getParameter( "enc_info" ) ) );

	            /* 1 원은 실제로 업체에서 결제하셔야 될 원 금액을 넣어주셔야 합니다. 결제금액 유효성 검증 */
	            if(good_mny.trim().length() > 0)
	            {
	                int ordr_data_set_no;

	                ordr_data_set_no = c_PayPlus.mf_add_set( "ordr_data" );

//	                c_PayPlus.mf_set_us( ordr_data_set_no, "ordr_mony", "1" );
	                c_PayPlus.mf_set_us( ordr_data_set_no, "ordr_mony", good_mny );
	            }
	            
	    }
	    /* = -------------------------------------------------------------------------- = */
	    /* =   04. 처리 요청 정보 설정 END                                              = */
	    /* = ========================================================================== = */


	    /* = ========================================================================== = */
	    /* =   05. 실행                                                                 = */
	    /* = -------------------------------------------------------------------------- = */
	    if ( tran_cd.length() > 0 )
	    {
	        c_PayPlus.mf_do_tx( pginfo.getG_conf_site_cd(), pginfo.getG_conf_site_key(), tran_cd, "", ordr_idxx, pginfo.getG_conf_log_level(), "0" );
	    }
	    else
	    {
	        c_PayPlus.m_res_cd  = "9562";
	        c_PayPlus.m_res_msg = "연동 오류|Payplus Plugin이 설치되지 않았거나 tran_cd값이 설정되지 않았습니다.";
	    }

	        res_cd  = c_PayPlus.m_res_cd;  // 결과 코드
	        res_msg = c_PayPlus.m_res_msg; // 결과 메시지
	    /* = -------------------------------------------------------------------------- = */
	    /* =   05. 실행 END                                                             = */
	    /* ============================================================================== */


	    /* ============================================================================== */
	    /* =   06. 승인 결과 값 추출                                                    = */
	    /* = -------------------------------------------------------------------------- = */
	        System.out.println(res_cd);
	        System.out.println(res_msg);
	    if ( req_tx.equals( "pay" ) )
	    {
	        if ( res_cd.equals( "0000" ) )
	        {
	            tno       = c_PayPlus.mf_get_res( "tno"       ); // KCP 거래 고유 번호
	            amount    = c_PayPlus.mf_get_res( "amount"    ); // KCP 실제 거래 금액
	            pnt_issue = c_PayPlus.mf_get_res( "pnt_issue" ); // 결제 포인트사 코드
	            coupon_mny = c_PayPlus.mf_get_res( "coupon_mny"	); // 쿠폰금액

	    /* = -------------------------------------------------------------------------- = */
	    /* =   06-1. 신용카드 승인 결과 처리                                            = */
	    /* = -------------------------------------------------------------------------- = */
	            if ( use_pay_method.equals( "100000000000" ) )
	            {
	                card_cd   = c_PayPlus.mf_get_res( "card_cd"   ); // 카드사 코드
	                card_name = c_PayPlus.mf_get_res( "card_name" ); // 카드사 명
	                app_time  = c_PayPlus.mf_get_res( "app_time"  ); // 승인시간
	                app_no    = c_PayPlus.mf_get_res( "app_no"    ); // 승인번호
	                noinf     = c_PayPlus.mf_get_res( "noinf"     ); // 무이자 여부
	                quota     = c_PayPlus.mf_get_res( "quota"     ); // 할부 개월 수
	                partcanc_yn = c_PayPlus.mf_get_res( "partcanc_yn"     ); // 부분취소 가능유무
	                card_bin_type_01 = c_PayPlus.mf_get_res( "card_bin_type_01" ); // 카드구분1
	                card_bin_type_02 = c_PayPlus.mf_get_res( "card_bin_type_02" ); // 카드구분2
	                card_mny = c_PayPlus.mf_get_res( "card_mny" ); // 카드결제금액

	                /* = -------------------------------------------------------------- = */
	                /* =   06-1.1. 복합결제(포인트+신용카드) 승인 결과 처리             = */
	                /* = -------------------------------------------------------------- = */
	                if ( pnt_issue.equals( "SCSK" ) || pnt_issue.equals( "SCWB" ) )
	                {
	                    pnt_amount   = c_PayPlus.mf_get_res( "pnt_amount"   ); // 적립금액 or 사용금액
	                    pnt_app_time = c_PayPlus.mf_get_res( "pnt_app_time" ); // 승인시간
	                    pnt_app_no   = c_PayPlus.mf_get_res( "pnt_app_no"   ); // 승인번호
	                    add_pnt      = c_PayPlus.mf_get_res( "add_pnt"      ); // 발생 포인트
	                    use_pnt      = c_PayPlus.mf_get_res( "use_pnt"      ); // 사용가능 포인트
	                    rsv_pnt      = c_PayPlus.mf_get_res( "rsv_pnt"      ); // 총 누적 포인트
	                    total_amount = amount + pnt_amount;                    // 복합결제시 총 거래금액
	                }
	                
	                
	            }

	    /* = -------------------------------------------------------------------------- = */
	    /* =   06-2. 계좌이체 승인 결과 처리                                            = */
	    /* = -------------------------------------------------------------------------- = */
	            if ( use_pay_method.equals("010000000000") )
	            {
	                app_time  = c_PayPlus.mf_get_res( "app_time"  ); // 승인시간
	                bank_name = c_PayPlus.mf_get_res( "bank_name" ); // 은행명
	                bank_code = c_PayPlus.mf_get_res( "bank_code" ); // 은행코드
	                bk_mny    = c_PayPlus.mf_get_res( "bk_mny"    ); // 계좌이체결제금액
	            }

	    /* = -------------------------------------------------------------------------- = */
	    /* =   06-3. 가상계좌 승인 결과 처리                                            = */
	    /* = -------------------------------------------------------------------------- = */
	            if ( use_pay_method.equals( "001000000000" ) )
	            {
	                bankname  = c_PayPlus.mf_get_res( "bankname"  ); // 입금할 은행 이름
	                depositor = c_PayPlus.mf_get_res( "depositor" ); // 입금할 계좌 예금주
	                account   = c_PayPlus.mf_get_res( "account"   ); // 입금할 계좌 번호
	                va_date   = c_PayPlus.mf_get_res( "va_date"   ); // 가상계좌 입금마감시간
	            }

	    /* = -------------------------------------------------------------------------- = */
	    /* =   06-4. 포인트 승인 결과 처리                                              = */
	    /* = -------------------------------------------------------------------------- = */
	            if ( use_pay_method.equals( "000100000000" ) )
	            {
	                pnt_amount   = c_PayPlus.mf_get_res( "pnt_amount"   ); // 적립금액 or 사용금액
	                pnt_app_time = c_PayPlus.mf_get_res( "pnt_app_time" ); // 승인시간
	                pnt_app_no   = c_PayPlus.mf_get_res( "pnt_app_no"   ); // 승인번호
	                add_pnt      = c_PayPlus.mf_get_res( "add_pnt"      ); // 발생 포인트
	                use_pnt      = c_PayPlus.mf_get_res( "use_pnt"      ); // 사용가능 포인트
	                rsv_pnt      = c_PayPlus.mf_get_res( "rsv_pnt"      ); // 총 누적 포인트
	            }

	    /* = -------------------------------------------------------------------------- = */
	    /* =   06-5. 휴대폰 승인 결과 처리                                              = */
	    /* = -------------------------------------------------------------------------- = */
	            if ( use_pay_method.equals( "000010000000" ) )
	            {
	                app_time = c_PayPlus.mf_get_res( "hp_app_time" ); // 승인 시간
	                commid	 = c_PayPlus.mf_get_res( "commid"	   ); // 통신사 코드
	                mobile_no= c_PayPlus.mf_get_res( "mobile_no"   ); // 휴대폰 번호
	            }

	    /* = -------------------------------------------------------------------------- = */
	    /* =   06-6. 상품권 승인 결과 처리                                              = */
	    /* = -------------------------------------------------------------------------- = */
	            if ( use_pay_method.equals( "000000001000" ) )
	            {
	                app_time    = c_PayPlus.mf_get_res( "tk_app_time" ); // 승인 시간
	                tk_van_code = c_PayPlus.mf_get_res( "tk_van_code" ); // 발급사 코드
	                tk_app_no   = c_PayPlus.mf_get_res( "tk_app_no"   ); // 승인 번호
	            }

	    /* = -------------------------------------------------------------------------- = */
	    /* =   06-7. 현금영수증 승인 결과 처리                                          = */
	    /* = -------------------------------------------------------------------------- = */
	            cash_authno = c_PayPlus.mf_get_res( "cash_authno" ); // 현금영수증 승인번호
	        }
	    }
	    /* = -------------------------------------------------------------------------- = */
	    /* =   06. 승인 결과 처리 END                                                   = */
	    /* ============================================================================== */


	    /* = ========================================================================== = */
	    /* =   07. 승인 및 실패 결과 DB 처리                                            = */
	    /* = -------------------------------------------------------------------------- = */
	    /* =      결과를 업체 자체적으로 DB 처리 작업하시는 부분입니다.                 = */
	    /* = -------------------------------------------------------------------------- = */

	    
		int r_omseq = Cvt.toInt( req.getParameter( "r_omseq") );
		String r_omid = Cvt.toStr( req.getParameter( "ordr_idxx") );
		String r_ompgid = Cvt.toStr( tno );
		String r_ompswd = Cvt.toStr( req.getParameter( "r_ompswd") );
		String r_ommbid = Cvt.toStr( ss_mbid );
		String r_omprname = Cvt.toStr( req.getParameter( "r_omprname") );
		String r_ompaytype = Cvt.toStr( req.getParameter( "r_ompaytype") );
		int r_omaccountmoney = Cvt.toInt( req.getParameter( "r_omaccountmoney") );
		int r_omcardmoney = Cvt.toInt( req.getParameter( "r_omcardmoney") );
		int r_omcouponmoney = Cvt.toInt( req.getParameter( "r_omcouponmoney") );
		int r_omlatermoney = Cvt.toInt( req.getParameter( "r_omlatermoney") );
		int r_ompointmoney = Cvt.toInt( req.getParameter( "r_ompointmoney") );
		int r_omsavemoney = Cvt.toInt( req.getParameter( "r_omsavemoney") );
		int r_omvirtualaccountmoney = Cvt.toInt( req.getParameter( "r_omvirtualaccountmoney") );
		int r_omraccountmoney = Cvt.toInt( req.getParameter( "r_omraccountmoney") );
		int r_omrcardmoney = Cvt.toInt( req.getParameter( "r_omrcardmoney") );
		int r_omrcouponmoney = Cvt.toInt( req.getParameter( "r_omrcouponmoney") );
		int r_omrlatermoney = Cvt.toInt( req.getParameter( "r_omrlatermoney") );
		int r_omrpointmoney = Cvt.toInt( req.getParameter( "r_omrpointmoney") );
		int r_omrsavemoney = Cvt.toInt( req.getParameter( "r_omrsavemoney") );
		int r_omrvirtualaccountmoney = Cvt.toInt( req.getParameter( "r_omrvirtualaccountmoney") );
		int r_omnewsavemoney = Cvt.toInt( req.getParameter( "r_omnewsavemoney") );
		int r_omorignalmoney = Cvt.toInt( req.getParameter( "r_omorignalmoney") );
		int r_omsalemoney = Cvt.toInt( req.getParameter( "r_omsalemoney") );
		String r_omdelitype = Cvt.toStr( req.getParameter( "r_omdelitype") );
		String r_omdelimemo = Cvt.toStr( req.getParameter( "r_omdelimemo") );
		int r_omdelimoney = Cvt.toInt( req.getParameter( "r_omdelimoney") );
		String r_omdelinum = Cvt.toStr( req.getParameter( "r_omdelinum") );
		String r_ommemo = Cvt.toStr( req.getParameter( "r_ommemo") );
		int r_ompccseq = Cvt.toInt( req.getParameter( "r_ompccseq") );
		String r_omescrowyn = Cvt.toStr( req.getParameter( "r_omescrowyn") );
		String r_ompartcancelyn = Cvt.toStr( req.getParameter( "r_ompartcancelyn") );
		String r_omstatus = Cvt.toStr( req.getParameter( "r_omstatus") );
		String r_omstep = Cvt.toStr( req.getParameter( "r_omstep") );
		String r_omtype = Cvt.toStr( req.getParameter( "r_omtype") );
		String r_ommoid = Cvt.toStr( req.getParameter( "r_ommoid") );
		String r_ominid = Cvt.toStr( req.getParameter( "r_ominid") );
	    
	    
	    
	    
	    if ( req_tx.equals( "pay" ) )
	    {

	    /* = -------------------------------------------------------------------------- = */
	    /* =   07-1. 승인 결과 DB 처리(res_cd == "0000")                                = */
	    /* = -------------------------------------------------------------------------- = */
	    /* =        각 결제수단을 구분하시어 DB 처리를 하시기 바랍니다.                 = */
	    /* = -------------------------------------------------------------------------- = */
	        if ( res_cd.equals( "0000" ) )
	        {
	            // 07-1-1. 신용카드
	            if ( use_pay_method.equals( "100000000000" ) )
	            {
	                // 07-1-1-1. 복합결제(신용카드+포인트)
	                if ( pnt_issue.equals( "SCSK" ) || pnt_issue.equals( "SCWB" ) )
	                {

	                }
	            }

	            // 07-1-2. 계좌이체
	            if ( use_pay_method.equals("010000000000") )
	            {

	            }
	            // 07-1-3. 가상계좌
	            if ( use_pay_method.equals("001000000000") )
	            {
	            
	            }
	            // 07-1-4. 포인트
	            if ( use_pay_method.equals("000100000000") )
	            {

	            }
	            // 07-1-5. 휴대폰
	            if ( use_pay_method.equals("000010000000") )
	            {

	            }
	            // 07-1-6. 상품권
	            if ( use_pay_method.equals("000000001000") )
	            {

	            }
	        }

	        /* = -------------------------------------------------------------------------- = */
	        /* =   07-2. 승인 실패 DB 처리(res_cd != "0000")                                = */
	        /* = -------------------------------------------------------------------------- = */
	        if( !"0000".equals ( res_cd ) )
	        {
	        }
	    }
	    /* = -------------------------------------------------------------------------- = */
	    /* =   07. 승인 및 실패 결과 DB 처리 END                                        = */
	    /* = ========================================================================== = */


	    /* = ========================================================================== = */
	    /* =   08. 승인 결과 DB 처리 실패시 : 자동취소                                  = */
	    /* = -------------------------------------------------------------------------- = */
	    /* =      승인 결과를 DB 작업 하는 과정에서 정상적으로 승인된 건에 대해         = */
	    /* =      DB 작업을 실패하여 DB update 가 완료되지 않은 경우, 자동으로          = */
	    /* =      승인 취소 요청을 하는 프로세스가 구성되어 있습니다.                   = */
	    /* =                                                                            = */
	    /* =      DB 작업이 실패 한 경우, bSucc 라는 변수(String)의 값을 "false"        = */
	    /* =      로 설정해 주시기 바랍니다. (DB 작업 성공의 경우에는 "false" 이외의    = */
	    /* =      값을 설정하시면 됩니다.)                                              = */
	    /* = -------------------------------------------------------------------------- = */

	    // 승인 결과 DB 처리 에러시 bSucc값을 false로 설정하여 거래건을 취소 요청
	    bSucc = ""; 

	    if (req_tx.equals("pay") )
	    {
	        if (res_cd.equals("0000") )
	        {
	            if ( bSucc.equals("false") )
	            {
	                int mod_data_set_no;

	                c_PayPlus.mf_init_set();

	                tran_cd = "00200000";

	                mod_data_set_no = c_PayPlus.mf_add_set( "mod_data" );

	                c_PayPlus.mf_set_us( mod_data_set_no, "tno",      tno      ); // KCP 원거래 거래번호
	                c_PayPlus.mf_set_us( mod_data_set_no, "mod_type", "STSC"   ); // 원거래 변경 요청 종류
	                c_PayPlus.mf_set_us( mod_data_set_no, "mod_ip",   cust_ip  ); // 변경 요청자 IP
	                c_PayPlus.mf_set_us( mod_data_set_no, "mod_desc", "가맹점 결과 처리 오류 - 가맹점에서 취소 요청"  ); // 변경 사유

	                c_PayPlus.mf_do_tx( pginfo.getG_conf_site_cd(), pginfo.getG_conf_site_key(), tran_cd, "", ordr_idxx, pginfo.getG_conf_log_level(), "0" );

	                res_cd  = c_PayPlus.m_res_cd;                                 // 결과 코드
	                res_msg = c_PayPlus.m_res_msg;                                // 결과 메시지
	            }
	        }
	    }
	    
		return false;
	}

	@Override
	public boolean pgPartCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pgUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
