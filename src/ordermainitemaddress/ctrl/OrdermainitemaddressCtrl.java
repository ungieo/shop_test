package ordermainitemaddress.ctrl;

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
import ordermainitemaddress.svc.OrdermainitemaddressAdd;
import ordermainitemaddress.svc.OrdermainitemaddressDel;
import ordermainitemaddress.svc.OrdermainitemaddressEdit;
import ordermainitemaddress.svc.OrdermainitemaddressIndex;
import ordermainitemaddress.svc.OrdermainitemaddressIn;
import ordermainitemaddress.svc.OrdermainitemaddressList;
import ordermainitemaddress.svc.OrdermainitemaddressUp;
import ordermainitemaddress.svc.OrdermainitemaddressView;
import ordermainitemaddress.svc.OrdermainitemaddressAddBo;
import ordermainitemaddress.svc.OrdermainitemaddressDelBo;
import ordermainitemaddress.svc.OrdermainitemaddressEditBo;
import ordermainitemaddress.svc.OrdermainitemaddressIndexBo;
import ordermainitemaddress.svc.OrdermainitemaddressInBo;
import ordermainitemaddress.svc.OrdermainitemaddressListBo;
import ordermainitemaddress.svc.OrdermainitemaddressListDelBo;
import ordermainitemaddress.svc.OrdermainitemaddressListUpBo;
import ordermainitemaddress.svc.OrdermainitemaddressUpBo;
import ordermainitemaddress.svc.OrdermainitemaddressViewBo;

@WebServlet("/ordermainitemaddress/*")
public class OrdermainitemaddressCtrl extends HttpServlet{
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


			if( "/ordermainitemaddress".equals( cmd ) ){

				svc = new OrdermainitemaddressIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new OrdermainitemaddressIndexBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemaddressadd".equals( cmd ) ){

				svc = new OrdermainitemaddressAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemaddressadd".equals( cmd ) ){

				svc = new OrdermainitemaddressAddBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemaddressdel".equals( cmd ) ){

				svc = new OrdermainitemaddressDel();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemaddressdel".equals( cmd ) ){

				svc = new OrdermainitemaddressDelBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemaddressedit".equals( cmd ) ){

				svc = new OrdermainitemaddressEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemaddressedit".equals( cmd ) ){

				svc = new OrdermainitemaddressEditBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemaddressin".equals( cmd ) ){

				svc = new OrdermainitemaddressIn();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemaddressin".equals( cmd ) ){

				svc = new OrdermainitemaddressInBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemaddresslist".equals( cmd ) ){

				svc = new OrdermainitemaddressList();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemaddresslist".equals( cmd ) ){

				svc = new OrdermainitemaddressListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemaddresslistdel".equals( cmd ) ){

				svc = new OrdermainitemaddressListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemaddresslistup".equals( cmd ) ){

				svc = new OrdermainitemaddressListUpBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemaddressview".equals( cmd ) ){

				svc = new OrdermainitemaddressView();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemaddressview".equals( cmd ) ){

				svc = new OrdermainitemaddressViewBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemaddressup".equals( cmd ) ){

				svc = new OrdermainitemaddressUp();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemaddressup".equals( cmd ) ){

				svc = new OrdermainitemaddressUpBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemaddressview".equals( cmd ) ){

				svc = new OrdermainitemaddressView();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemaddressview".equals( cmd ) ){

				svc = new OrdermainitemaddressViewBo();
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