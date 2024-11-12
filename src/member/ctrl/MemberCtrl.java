package member.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.svc.AdminMemberAddBo;
import member.svc.AdminMemberDelBo;
import member.svc.AdminMemberEditBo;
import member.svc.AdminMemberInBo;
import member.svc.AdminMemberListBo;
import member.svc.AdminMemberListBoJson;
import member.svc.AdminMemberViewBo;
import member.svc.IdConfirmSvc;
import member.svc.MemberAdd1;
import member.svc.MemberAdd2;
import member.svc.MemberAddBo;
import member.svc.MemberAddComple;
import member.svc.MemberDel;
import member.svc.MemberDelBo;
import member.svc.MemberEdit;
import member.svc.MemberEditBo;
import member.svc.MemberIn;
import member.svc.MemberInBo;
import member.svc.MemberIndex;
import member.svc.MemberIndexBo;
import member.svc.MemberListBo;
import member.svc.MemberListBoJson;
import member.svc.MemberListDelBo;
import member.svc.MemberListUpBo;
import member.svc.MemberLoginAjax;
import member.svc.MemberLogout;
import member.svc.MemberUp;
import member.svc.MemberUpBo;
import member.svc.MemberView;
import member.svc.MemberViewBo;
import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;

@WebServlet("/member/*")
public class MemberCtrl extends HttpServlet{
	private static final long serialVersionUID = 1L;

	Ctrl ctrl;
	Svc svc;

	protected void doCtrl(HttpServletRequest req, HttpServletResponse res, String method) throws ServletException, IOException{

			Map<String, Object> model = new HashMap<String, Object>();

			String url = Cvt.toStr( req.getRequestURL() );
			String ctxt = req.getContextPath();
			String uri = req.getRequestURI();
			String cmd = uri.replaceAll("^/.+?/.+?/", "");
			if( "".equals( ctxt ) ){
				cmd = uri.replaceAll("^/.+?/", "");
			}
			model.put( "cmd", cmd );

//System.out.println(cmd);
			if( "/member".equals( cmd ) ){

				svc = new MemberIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new MemberIndexBo();
				svc.handling( req, res, model );

			}
			else if( "memberadd1".equals( cmd ) ){

				svc = new MemberAdd1();
				svc.handling( req, res, model );

			}
			else if( "memberadd2".equals( cmd ) ){

				svc = new MemberAdd2();
				svc.handling( req, res, model );

			}
			else if( "memberaddcomple".equals( cmd ) ){

				svc = new MemberAddComple();
				svc.handling( req, res, model );

			}
			else if( "bo/memberadd".equals( cmd ) ){

				svc = new MemberAddBo();
				svc.handling( req, res, model );

			}
			else if( "memberdel".equals( cmd ) ){

				svc = new MemberDel();
				svc.handling( req, res, model );

			}
			else if( "bo/memberdel".equals( cmd ) ){

				svc = new MemberDelBo();
				svc.handling( req, res, model );

			}
			else if( "memberedit".equals( cmd ) ){

				svc = new MemberEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/memberedit".equals( cmd ) ){

				svc = new MemberEditBo();
				svc.handling( req, res, model );

			}
			else if( "memberin".equals( cmd ) ){

				svc = new MemberIn();
				svc.handling( req, res, model );

			}
			else if( "bo/memberin".equals( cmd ) ){

				svc = new MemberInBo();
				svc.handling( req, res, model );

			}
//			else if( "memberlist".equals( cmd ) ){
//
//				svc = new MemberList();
//				svc.handling( req, res, model );
//
//			}
			else if( "bo/memberlist".equals( cmd ) ){

				svc = new MemberListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/memberlistjson".equals( cmd ) ){
				svc = new MemberListBoJson();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;
			}
			else if( "bo/memberlistdel".equals( cmd ) ){

				svc = new MemberListDelBo();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;
			}
			else if( "bo/memberlistup".equals( cmd ) ){

				svc = new MemberListUpBo();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;
			}
			else if( "memberview".equals( cmd ) ){

				svc = new MemberView();
				svc.handling( req, res, model );

			}
			else if( "bo/memberview".equals( cmd ) ){

				svc = new MemberViewBo();
				svc.handling( req, res, model );

			}
			else if( "memberup".equals( cmd ) ){

				svc = new MemberUp();
				svc.handling( req, res, model );

			}
			else if( "bo/memberup".equals( cmd ) ){

				svc = new MemberUpBo();
				svc.handling( req, res, model );

			}
			else if( "memberview".equals( cmd ) ){

				svc = new MemberView();
				svc.handling( req, res, model );

			}
			else if( "bo/memberview".equals( cmd ) ){

				svc = new MemberViewBo();
				svc.handling( req, res, model );

			}
			else if( "idconfirm".equals( cmd ) || "bo/idconfirm".equals( cmd ) ){
				svc = new IdConfirmSvc();
				svc.handling( req, res, model );
				return;
			}
	    	else if( "memberloginajax".equals( cmd ) ){
				svc = new MemberLoginAjax();
	    		svc.handling(req, res, model);
	    		Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;
	    	}
	    	else if( "memberlogout".equals( cmd ) ){
	    		svc = new MemberLogout();
				svc.handling( req, res, model );
	    	}
	    	else if( "bo/adminmemberadd".equals( cmd ) ){

				svc = new AdminMemberAddBo();
				svc.handling( req, res, model );

			}
	    	else if( "bo/adminmemberdel".equals( cmd ) ){

				svc = new AdminMemberDelBo();
				svc.handling( req, res, model );

			}
	    	else if( "bo/adminmemberedit".equals( cmd ) ){

				svc = new AdminMemberEditBo();
				svc.handling( req, res, model );

			}
	    	else if( "bo/adminmemberin".equals( cmd ) ){

				svc = new AdminMemberInBo();
				svc.handling( req, res, model );

			}
	    	else if( "bo/adminmemberview".equals( cmd ) ){

				svc = new AdminMemberViewBo();
				svc.handling( req, res, model );

			}
	    	else if( "bo/adminmemberlist".equals( cmd ) ){

				svc = new AdminMemberListBo();
				svc.handling( req, res, model );

			}
	    	else if( "bo/adminmemberlistjson".equals( cmd ) ){
				svc = new AdminMemberListBoJson();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;
			}
//			else if( "getcaptcha".equals( cmd ) || "bo/getcaptcha".equals( cmd ) ){
//				svc = new CaptchaSvc();
//				svc.handling( req, res, model );
//				return;
//			}


			//---* 결과페이지처리
			if( "".equals( Cvt.toStr( model.get( "returnPage" ) ) ) ){
				res.sendRedirect( ctxt + "/404.jsp?url=" + url );
			}
			else{
				if( "F".equals( model.get( "returnType" ) ) ){
					req.setAttribute( "model", model );
					RequestDispatcher dispatcher = req.getRequestDispatcher( "/WEB-INF/"+model.get( "returnPage" )+".jsp" );
					dispatcher.forward( req, res );
				}
				else if( "R".equals( model.get( "returnType" ) ) ){
					res.sendRedirect( ctxt + model.get( "returnPage" ) );
				}
			//--- 결과페이지처리
			}


	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doCtrl( req, res, "get" );
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doCtrl( req, res, "post" );
	}

}