package ordermain.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ordermain.svc.OrdermainAdd;
import ordermain.svc.OrdermainAddBo;
import ordermain.svc.OrdermainDel;
import ordermain.svc.OrdermainDelBo;
import ordermain.svc.OrdermainEdit;
import ordermain.svc.OrdermainEditBo;
import ordermain.svc.OrdermainIn;
import ordermain.svc.OrdermainInBo;
import ordermain.svc.OrdermainIndex;
import ordermain.svc.OrdermainIndexBo;
import ordermain.svc.OrdermainList;
import ordermain.svc.OrdermainListBo;
import ordermain.svc.OrdermainListDelBo;
import ordermain.svc.OrdermainListUpBo;
import ordermain.svc.OrdermainListUpBoAjax;
import ordermain.svc.OrdermainUp;
import ordermain.svc.OrdermainUpBo;
import ordermain.svc.OrdermainView;
import ordermain.svc.OrdermainViewBo;
import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;

@WebServlet("/ordermain/*")
public class OrdermainCtrl extends HttpServlet{
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


			if( "/ordermain".equals( cmd ) ){

				svc = new OrdermainIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new OrdermainIndexBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainadd".equals( cmd ) ){

				svc = new OrdermainAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainadd".equals( cmd ) ){

				svc = new OrdermainAddBo();
				svc.handling( req, res, model );

			}
			else if( "ordermaindel".equals( cmd ) ){

				svc = new OrdermainDel();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermaindel".equals( cmd ) ){

				svc = new OrdermainDelBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainedit".equals( cmd ) ){

				svc = new OrdermainEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainedit".equals( cmd ) ){

				svc = new OrdermainEditBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainin".equals( cmd ) ){
				if( "post".equals( method ) ){
					svc = new OrdermainIn();
					svc.handling( req, res, model );
				}

			}
			else if( "bo/ordermainin".equals( cmd ) ){

				svc = new OrdermainInBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainlist".equals( cmd ) ){

				svc = new OrdermainList();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainlist".equals( cmd ) ){

				svc = new OrdermainListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainlistdel".equals( cmd ) ){

				svc = new OrdermainListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainlistup".equals( cmd ) ){

				svc = new OrdermainListUpBo();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainlistupajax".equals( cmd ) ){

				svc = new OrdermainListUpBoAjax();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "ordermainview".equals( cmd ) ){

				svc = new OrdermainView();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainview".equals( cmd ) ){

				svc = new OrdermainViewBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainup".equals( cmd ) ){

				svc = new OrdermainUp();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainup".equals( cmd ) ){

				svc = new OrdermainUpBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainview".equals( cmd ) ){

				svc = new OrdermainView();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainview".equals( cmd ) ){

				svc = new OrdermainViewBo();
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