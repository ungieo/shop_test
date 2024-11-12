package home.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.svc.AgreementEditBo;
import home.svc.AgreementUpBo;
import home.svc.Contact;
import home.svc.Index;
import home.svc.IndexBo;
import home.svc.MainSliderEditBo;
import home.svc.MainSliderUpBo;
import home.svc.MypageOrdermainList;
import home.svc.NonmbprivacyEditBo;
import home.svc.NonmbprivacyUpBo;
import home.svc.PrivacyEditBo;
import home.svc.PrivacyUpBo;
import home.svc.ShopinfoEditBo;
import home.svc.ShopinfoUpBo;
import home.svc.SiteinfoEditBo;
import home.svc.SiteinfoUpBo;
import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;

@WebServlet("/home/*")
public class HomeCtrl extends HttpServlet{
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
			if( "index".equals( cmd ) ){

				svc = new Index();
				svc.handling( req, res, model );

			}else if( "bo/index".equals( cmd ) ){

				svc = new IndexBo();
				svc.handling( req, res, model );

			}else if( "contact".equals( cmd ) ){

				svc = new Contact();
				svc.handling( req, res, model );

			}			
			else if( "bo/agreementedit".equals( cmd ) ){

				svc = new AgreementEditBo();
				svc.handling( req, res, model );

			}
			else if( "bo/agreementup".equals( cmd ) ){

				svc = new AgreementUpBo();
				svc.handling( req, res, model );

			}
			else if( "bo/privacyedit".equals( cmd ) ){

				svc = new PrivacyEditBo();
				svc.handling( req, res, model );

			}
			else if( "bo/privacyup".equals( cmd ) ){

				svc = new PrivacyUpBo();
				svc.handling( req, res, model );

			}
			else if( "bo/nonmbprivacyedit".equals( cmd ) ){

				svc = new NonmbprivacyEditBo();
				svc.handling( req, res, model );

			}
			else if( "bo/nonmbprivacyup".equals( cmd ) ){

				svc = new NonmbprivacyUpBo();
				svc.handling( req, res, model );

			}
			else if( "bo/mainslideredit".equals( cmd ) ){

				svc = new MainSliderEditBo();
				svc.handling( req, res, model );

			}
			else if( "bo/mainsliderup".equals( cmd ) ){

				svc = new MainSliderUpBo();
				svc.handling( req, res, model );

			}
			else if( "mypage/ordermainlist".equals( cmd ) ){
				svc = new MypageOrdermainList();
				svc.handling( req, res, model );
			}
			else if( "bo/siteinfoedit".equals( cmd ) ){

				svc = new SiteinfoEditBo();
				svc.handling( req, res, model );

			}
			else if( "bo/siteinfoup".equals( cmd ) ){

				svc = new SiteinfoUpBo();
				svc.handling( req, res, model );

			}


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