package company.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;
import company.svc.CompanyAdd;
import company.svc.CompanyDel;
import company.svc.CompanyEdit;
import company.svc.CompanyIndex;
import company.svc.CompanyIn;
import company.svc.CompanyList;
import company.svc.CompanyUp;
import company.svc.CompanyView;
import company.svc.CompanyAddBo;
import company.svc.CompanyDelBo;
import company.svc.CompanyEditBo;
import company.svc.CompanyIndexBo;
import company.svc.CompanyInBo;
import company.svc.CompanyListBo;
import company.svc.CompanyListDelBo;
import company.svc.CompanyListUpBo;
import company.svc.CompanyUpBo;
import company.svc.CompanyViewBo;

@WebServlet("/company/*")
public class CompanyCtrl extends HttpServlet{
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


			if( "/company".equals( cmd ) ){

				svc = new CompanyIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new CompanyIndexBo();
				svc.handling( req, res, model );

			}
			else if( "companyadd".equals( cmd ) ){

				svc = new CompanyAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/companyadd".equals( cmd ) ){

				svc = new CompanyAddBo();
				svc.handling( req, res, model );

			}
			else if( "companydel".equals( cmd ) ){

				svc = new CompanyDel();
				svc.handling( req, res, model );

			}
			else if( "bo/companydel".equals( cmd ) ){

				svc = new CompanyDelBo();
				svc.handling( req, res, model );

			}
			else if( "companyedit".equals( cmd ) ){

				svc = new CompanyEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/companyedit".equals( cmd ) ){

				svc = new CompanyEditBo();
				svc.handling( req, res, model );

			}
			else if( "companyin".equals( cmd ) ){

				svc = new CompanyIn();
				svc.handling( req, res, model );

			}
			else if( "bo/companyin".equals( cmd ) ){

				svc = new CompanyInBo();
				svc.handling( req, res, model );

			}
			else if( "companylist".equals( cmd ) ){

				svc = new CompanyList();
				svc.handling( req, res, model );

			}
			else if( "bo/companylist".equals( cmd ) ){

				svc = new CompanyListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/companylistdel".equals( cmd ) ){

				svc = new CompanyListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/companylistup".equals( cmd ) ){

				svc = new CompanyListUpBo();
				svc.handling( req, res, model );

			}			
			else if( "companyview".equals( cmd ) ){

				svc = new CompanyView();
				svc.handling( req, res, model );

			}
			else if( "bo/companyview".equals( cmd ) ){

				svc = new CompanyViewBo();
				svc.handling( req, res, model );

			}
			else if( "companyup".equals( cmd ) ){

				svc = new CompanyUp();
				svc.handling( req, res, model );

			}
			else if( "bo/companyup".equals( cmd ) ){

				svc = new CompanyUpBo();
				svc.handling( req, res, model );

			}
			else if( "companyview".equals( cmd ) ){

				svc = new CompanyView();
				svc.handling( req, res, model );

			}
			else if( "bo/companyview".equals( cmd ) ){

				svc = new CompanyViewBo();
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