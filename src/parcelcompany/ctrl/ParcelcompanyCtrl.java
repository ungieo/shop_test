package parcelcompany.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parcelcompany.svc.ParcelcompanyAdd;
import parcelcompany.svc.ParcelcompanyAddBo;
import parcelcompany.svc.ParcelcompanyDel;
import parcelcompany.svc.ParcelcompanyDelBo;
import parcelcompany.svc.ParcelcompanyEdit;
import parcelcompany.svc.ParcelcompanyEditBo;
import parcelcompany.svc.ParcelcompanyIn;
import parcelcompany.svc.ParcelcompanyInBo;
import parcelcompany.svc.ParcelcompanyInBoAjax;
import parcelcompany.svc.ParcelcompanyIndex;
import parcelcompany.svc.ParcelcompanyIndexBo;
import parcelcompany.svc.ParcelcompanyList;
import parcelcompany.svc.ParcelcompanyListBo;
import parcelcompany.svc.ParcelcompanyListDelBo;
import parcelcompany.svc.ParcelcompanyListUpBo;
import parcelcompany.svc.ParcelcompanyUp;
import parcelcompany.svc.ParcelcompanyUpBo;
import parcelcompany.svc.ParcelcompanyView;
import parcelcompany.svc.ParcelcompanyViewBo;
import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;

@WebServlet("/parcelcompany/*")
public class ParcelcompanyCtrl extends HttpServlet{
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


			if( "/parcelcompany".equals( cmd ) ){

				svc = new ParcelcompanyIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new ParcelcompanyIndexBo();
				svc.handling( req, res, model );

			}
			else if( "parcelcompanyadd".equals( cmd ) ){

				svc = new ParcelcompanyAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/parcelcompanyadd".equals( cmd ) ){

				svc = new ParcelcompanyAddBo();
				svc.handling( req, res, model );

			}
			else if( "parcelcompanydel".equals( cmd ) ){

				svc = new ParcelcompanyDel();
				svc.handling( req, res, model );

			}
			else if( "bo/parcelcompanydel".equals( cmd ) ){

				svc = new ParcelcompanyDelBo();
				svc.handling( req, res, model );

			}
			else if( "parcelcompanyedit".equals( cmd ) ){

				svc = new ParcelcompanyEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/parcelcompanyedit".equals( cmd ) ){

				svc = new ParcelcompanyEditBo();
				svc.handling( req, res, model );

			}
			else if( "parcelcompanyin".equals( cmd ) ){

				svc = new ParcelcompanyIn();
				svc.handling( req, res, model );

			}
			else if( "bo/parcelcompanyin".equals( cmd ) ){

				svc = new ParcelcompanyInBo();
				svc.handling( req, res, model );

			}
			else if( "bo/parcelcompanyinajax".equals( cmd ) ){

				svc = new ParcelcompanyInBoAjax();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "parcelcompanylist".equals( cmd ) ){

				svc = new ParcelcompanyList();
				svc.handling( req, res, model );

			}
			else if( "bo/parcelcompanylist".equals( cmd ) ){

				svc = new ParcelcompanyListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/parcelcompanylistdel".equals( cmd ) ){

				svc = new ParcelcompanyListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/parcelcompanylistup".equals( cmd ) ){

				svc = new ParcelcompanyListUpBo();
				svc.handling( req, res, model );

			}
			else if( "parcelcompanyview".equals( cmd ) ){

				svc = new ParcelcompanyView();
				svc.handling( req, res, model );

			}
			else if( "bo/parcelcompanyview".equals( cmd ) ){

				svc = new ParcelcompanyViewBo();
				svc.handling( req, res, model );

			}
			else if( "parcelcompanyup".equals( cmd ) ){

				svc = new ParcelcompanyUp();
				svc.handling( req, res, model );

			}
			else if( "bo/parcelcompanyup".equals( cmd ) ){

				svc = new ParcelcompanyUpBo();
				svc.handling( req, res, model );

			}
			else if( "parcelcompanyview".equals( cmd ) ){

				svc = new ParcelcompanyView();
				svc.handling( req, res, model );

			}
			else if( "bo/parcelcompanyview".equals( cmd ) ){

				svc = new ParcelcompanyViewBo();
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