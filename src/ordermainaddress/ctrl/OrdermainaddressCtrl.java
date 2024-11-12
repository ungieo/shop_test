package ordermainaddress.ctrl;

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
import ordermainaddress.svc.OrdermainaddressAdd;
import ordermainaddress.svc.OrdermainaddressDel;
import ordermainaddress.svc.OrdermainaddressEdit;
import ordermainaddress.svc.OrdermainaddressIndex;
import ordermainaddress.svc.OrdermainaddressIn;
import ordermainaddress.svc.OrdermainaddressList;
import ordermainaddress.svc.OrdermainaddressUp;
import ordermainaddress.svc.OrdermainaddressView;
import ordermainaddress.svc.OrdermainaddressAddBo;
import ordermainaddress.svc.OrdermainaddressDelBo;
import ordermainaddress.svc.OrdermainaddressEditBo;
import ordermainaddress.svc.OrdermainaddressIndexBo;
import ordermainaddress.svc.OrdermainaddressInBo;
import ordermainaddress.svc.OrdermainaddressListBo;
import ordermainaddress.svc.OrdermainaddressListDelBo;
import ordermainaddress.svc.OrdermainaddressListUpBo;
import ordermainaddress.svc.OrdermainaddressUpBo;
import ordermainaddress.svc.OrdermainaddressViewBo;

@WebServlet("/ordermainaddress/*")
public class OrdermainaddressCtrl extends HttpServlet{
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


			if( "/ordermainaddress".equals( cmd ) ){

				svc = new OrdermainaddressIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new OrdermainaddressIndexBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainaddressadd".equals( cmd ) ){

				svc = new OrdermainaddressAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainaddressadd".equals( cmd ) ){

				svc = new OrdermainaddressAddBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainaddressdel".equals( cmd ) ){

				svc = new OrdermainaddressDel();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainaddressdel".equals( cmd ) ){

				svc = new OrdermainaddressDelBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainaddressedit".equals( cmd ) ){

				svc = new OrdermainaddressEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainaddressedit".equals( cmd ) ){

				svc = new OrdermainaddressEditBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainaddressin".equals( cmd ) ){

				svc = new OrdermainaddressIn();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainaddressin".equals( cmd ) ){

				svc = new OrdermainaddressInBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainaddresslist".equals( cmd ) ){

				svc = new OrdermainaddressList();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainaddresslist".equals( cmd ) ){

				svc = new OrdermainaddressListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainaddresslistdel".equals( cmd ) ){

				svc = new OrdermainaddressListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainaddresslistup".equals( cmd ) ){

				svc = new OrdermainaddressListUpBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainaddressview".equals( cmd ) ){

				svc = new OrdermainaddressView();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainaddressview".equals( cmd ) ){

				svc = new OrdermainaddressViewBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainaddressup".equals( cmd ) ){

				svc = new OrdermainaddressUp();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainaddressup".equals( cmd ) ){

				svc = new OrdermainaddressUpBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainaddressview".equals( cmd ) ){

				svc = new OrdermainaddressView();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainaddressview".equals( cmd ) ){

				svc = new OrdermainaddressViewBo();
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