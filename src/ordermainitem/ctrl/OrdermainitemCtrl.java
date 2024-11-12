package ordermainitem.ctrl;

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
import ordermainitem.svc.OrdermainitemAdd;
import ordermainitem.svc.OrdermainitemDel;
import ordermainitem.svc.OrdermainitemEdit;
import ordermainitem.svc.OrdermainitemIndex;
import ordermainitem.svc.OrdermainitemIn;
import ordermainitem.svc.OrdermainitemList;
import ordermainitem.svc.OrdermainitemUp;
import ordermainitem.svc.OrdermainitemView;
import ordermainitem.svc.OrdermainitemAddBo;
import ordermainitem.svc.OrdermainitemDelBo;
import ordermainitem.svc.OrdermainitemEditBo;
import ordermainitem.svc.OrdermainitemIndexBo;
import ordermainitem.svc.OrdermainitemInBo;
import ordermainitem.svc.OrdermainitemListBo;
import ordermainitem.svc.OrdermainitemListDelBo;
import ordermainitem.svc.OrdermainitemListUpBo;
import ordermainitem.svc.OrdermainitemUpBo;
import ordermainitem.svc.OrdermainitemViewBo;

@WebServlet("/ordermainitem/*")
public class OrdermainitemCtrl extends HttpServlet{
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


			if( "/ordermainitem".equals( cmd ) ){

				svc = new OrdermainitemIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new OrdermainitemIndexBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemadd".equals( cmd ) ){

				svc = new OrdermainitemAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemadd".equals( cmd ) ){

				svc = new OrdermainitemAddBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemdel".equals( cmd ) ){

				svc = new OrdermainitemDel();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemdel".equals( cmd ) ){

				svc = new OrdermainitemDelBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemedit".equals( cmd ) ){

				svc = new OrdermainitemEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemedit".equals( cmd ) ){

				svc = new OrdermainitemEditBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemin".equals( cmd ) ){

				svc = new OrdermainitemIn();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemin".equals( cmd ) ){

				svc = new OrdermainitemInBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemlist".equals( cmd ) ){

				svc = new OrdermainitemList();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemlist".equals( cmd ) ){

				svc = new OrdermainitemListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemlistdel".equals( cmd ) ){

				svc = new OrdermainitemListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemlistup".equals( cmd ) ){

				svc = new OrdermainitemListUpBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemview".equals( cmd ) ){

				svc = new OrdermainitemView();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemview".equals( cmd ) ){

				svc = new OrdermainitemViewBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemup".equals( cmd ) ){

				svc = new OrdermainitemUp();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemup".equals( cmd ) ){

				svc = new OrdermainitemUpBo();
				svc.handling( req, res, model );

			}
			else if( "ordermainitemview".equals( cmd ) ){

				svc = new OrdermainitemView();
				svc.handling( req, res, model );

			}
			else if( "bo/ordermainitemview".equals( cmd ) ){

				svc = new OrdermainitemViewBo();
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