package productdisplay.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productdisplay.svc.ProductdisplayAdd;
import productdisplay.svc.ProductdisplayAddBo;
import productdisplay.svc.ProductdisplayDel;
import productdisplay.svc.ProductdisplayDelBo;
import productdisplay.svc.ProductdisplayEdit;
import productdisplay.svc.ProductdisplayEditBo;
import productdisplay.svc.ProductdisplayIn;
import productdisplay.svc.ProductdisplayInBo;
import productdisplay.svc.ProductdisplayIndex;
import productdisplay.svc.ProductdisplayIndexBo;
import productdisplay.svc.ProductdisplayList;
import productdisplay.svc.ProductdisplayListBo;
import productdisplay.svc.ProductdisplayListDelBo;
import productdisplay.svc.ProductdisplayListInBoAjax;
import productdisplay.svc.ProductdisplayListUpBo;
import productdisplay.svc.ProductdisplayUp;
import productdisplay.svc.ProductdisplayUpBo;
import productdisplay.svc.ProductdisplayView;
import productdisplay.svc.ProductdisplayViewBo;
import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;

@WebServlet("/productdisplay/*")
public class ProductdisplayCtrl extends HttpServlet{
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


			if( "/productdisplay".equals( cmd ) ){

				svc = new ProductdisplayIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new ProductdisplayIndexBo();
				svc.handling( req, res, model );

			}
			else if( "productdisplayadd".equals( cmd ) ){

				svc = new ProductdisplayAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/productdisplayadd".equals( cmd ) ){

				svc = new ProductdisplayAddBo();
				svc.handling( req, res, model );

			}
			else if( "productdisplaydel".equals( cmd ) ){

				svc = new ProductdisplayDel();
				svc.handling( req, res, model );

			}
			else if( "bo/productdisplaydel".equals( cmd ) ){

				svc = new ProductdisplayDelBo();
				svc.handling( req, res, model );

			}
			else if( "productdisplayedit".equals( cmd ) ){

				svc = new ProductdisplayEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/productdisplayedit".equals( cmd ) ){

				svc = new ProductdisplayEditBo();
				svc.handling( req, res, model );

			}
			else if( "productdisplayin".equals( cmd ) ){

				svc = new ProductdisplayIn();
				svc.handling( req, res, model );

			}
			else if( "bo/productdisplayin".equals( cmd ) ){

				svc = new ProductdisplayInBo();
				svc.handling( req, res, model );

			}
			else if( "productdisplaylist".equals( cmd ) ){

				svc = new ProductdisplayList();
				svc.handling( req, res, model );

			}
			else if( "bo/productdisplaylist".equals( cmd ) ){

				svc = new ProductdisplayListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productdisplaylistdel".equals( cmd ) ){

				svc = new ProductdisplayListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productdisplaylistinajax".equals( cmd ) ){

				svc = new ProductdisplayListInBoAjax();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "bo/productdisplaylistup".equals( cmd ) ){

				svc = new ProductdisplayListUpBo();
				svc.handling( req, res, model );

			}
			else if( "productdisplayview".equals( cmd ) ){

				svc = new ProductdisplayView();
				svc.handling( req, res, model );

			}
			else if( "bo/productdisplayview".equals( cmd ) ){

				svc = new ProductdisplayViewBo();
				svc.handling( req, res, model );

			}
			else if( "productdisplayup".equals( cmd ) ){

				svc = new ProductdisplayUp();
				svc.handling( req, res, model );

			}
			else if( "bo/productdisplayup".equals( cmd ) ){

				svc = new ProductdisplayUpBo();
				svc.handling( req, res, model );

			}
			else if( "productdisplayview".equals( cmd ) ){

				svc = new ProductdisplayView();
				svc.handling( req, res, model );

			}
			else if( "bo/productdisplayview".equals( cmd ) ){

				svc = new ProductdisplayViewBo();
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