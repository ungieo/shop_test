package ordermainitemhistory.ctrl;

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
import ordermainitemhistory.svc.OrdermainitemhistoryAdd;
import ordermainitemhistory.svc.OrdermainitemhistoryDel;
import ordermainitemhistory.svc.OrdermainitemhistoryEdit;
import ordermainitemhistory.svc.OrdermainitemhistoryIndex;
import ordermainitemhistory.svc.OrdermainitemhistoryIn;
import ordermainitemhistory.svc.OrdermainitemhistoryList;
import ordermainitemhistory.svc.OrdermainitemhistoryUp;
import ordermainitemhistory.svc.OrdermainitemhistoryView;
import ordermainitemhistory.svc.OrdermainitemhistoryAddBo;
import ordermainitemhistory.svc.OrdermainitemhistoryDelBo;
import ordermainitemhistory.svc.OrdermainitemhistoryEditBo;
import ordermainitemhistory.svc.OrdermainitemhistoryIndexBo;
import ordermainitemhistory.svc.OrdermainitemhistoryInBo;
import ordermainitemhistory.svc.OrdermainitemhistoryListBo;
import ordermainitemhistory.svc.OrdermainitemhistoryListDelBo;
import ordermainitemhistory.svc.OrdermainitemhistoryListUpBo;
import ordermainitemhistory.svc.OrdermainitemhistoryUpBo;
import ordermainitemhistory.svc.OrdermainitemhistoryViewBo;

@WebServlet("/ordermainitemhistory/*")
public class OrdermainitemhistoryCtrl extends HttpServlet{
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

			if( "/ordermainitemhistory".equals( cmd ) ){

				svc = new OrdermainitemhistoryIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new OrdermainitemhistoryIndexBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemhistoryadd".equals( cmd ) ){

				svc = new OrdermainitemhistoryAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemhistoryadd".equals( cmd ) ){

				svc = new OrdermainitemhistoryAddBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemhistorydel".equals( cmd ) ){

				svc = new OrdermainitemhistoryDel();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemhistorydel".equals( cmd ) ){

				svc = new OrdermainitemhistoryDelBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemhistoryedit".equals( cmd ) ){

				svc = new OrdermainitemhistoryEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemhistoryedit".equals( cmd ) ){

				svc = new OrdermainitemhistoryEditBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemhistoryin".equals( cmd ) ){

				svc = new OrdermainitemhistoryIn();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemhistoryin".equals( cmd ) ){

				svc = new OrdermainitemhistoryInBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemhistorylist".equals( cmd ) ){

				svc = new OrdermainitemhistoryList();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemhistorylist".equals( cmd ) ){

				svc = new OrdermainitemhistoryListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemhistorylistdel".equals( cmd ) ){

				svc = new OrdermainitemhistoryListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemhistorylistup".equals( cmd ) ){

				svc = new OrdermainitemhistoryListUpBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemhistoryview".equals( cmd ) ){

				svc = new OrdermainitemhistoryView();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemhistoryview".equals( cmd ) ){

				svc = new OrdermainitemhistoryViewBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemhistoryup".equals( cmd ) ){

				svc = new OrdermainitemhistoryUp();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemhistoryup".equals( cmd ) ){

				svc = new OrdermainitemhistoryUpBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemhistoryview".equals( cmd ) ){

				svc = new OrdermainitemhistoryView();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemhistoryview".equals( cmd ) ){

				svc = new OrdermainitemhistoryViewBo();
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