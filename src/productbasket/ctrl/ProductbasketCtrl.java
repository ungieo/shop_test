package productbasket.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productbasket.svc.ProductbasketAdd;
import productbasket.svc.ProductbasketAddBo;
import productbasket.svc.ProductbasketDel;
import productbasket.svc.ProductbasketDelAjax;
import productbasket.svc.ProductbasketDelBo;
import productbasket.svc.ProductbasketEdit;
import productbasket.svc.ProductbasketEditBo;
import productbasket.svc.ProductbasketIn;
import productbasket.svc.ProductbasketInAjax;
import productbasket.svc.ProductbasketInBo;
import productbasket.svc.ProductbasketIndex;
import productbasket.svc.ProductbasketIndexBo;
import productbasket.svc.ProductbasketList;
import productbasket.svc.ProductbasketListBo;
import productbasket.svc.ProductbasketListDelAjax;
import productbasket.svc.ProductbasketListDelBo;
import productbasket.svc.ProductbasketListUpBo;
import productbasket.svc.ProductbasketUp;
import productbasket.svc.ProductbasketUpAjax;
import productbasket.svc.ProductbasketUpBo;
import productbasket.svc.ProductbasketView;
import productbasket.svc.ProductbasketViewBo;
import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;

@WebServlet("/productbasket/*")
public class ProductbasketCtrl extends HttpServlet{
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


			if( "/productbasket".equals( cmd ) ){

				svc = new ProductbasketIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new ProductbasketIndexBo();
				svc.handling( req, res, model );

			}
			else if( "productbasketadd".equals( cmd ) ){

				svc = new ProductbasketAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/productbasketadd".equals( cmd ) ){

				svc = new ProductbasketAddBo();
				svc.handling( req, res, model );

			}
			else if( "productbasketdel".equals( cmd ) ){

				svc = new ProductbasketDel();
				svc.handling( req, res, model );

			}
			else if( "productbasketdelajax".equals( cmd ) ){

				svc = new ProductbasketDelAjax();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "bo/productbasketdel".equals( cmd ) ){

				svc = new ProductbasketDelBo();
				svc.handling( req, res, model );

			}
			else if( "productbasketedit".equals( cmd ) ){

				svc = new ProductbasketEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/productbasketedit".equals( cmd ) ){

				svc = new ProductbasketEditBo();
				svc.handling( req, res, model );

			}
			else if( "productbasketin".equals( cmd ) ){

				svc = new ProductbasketIn();
				svc.handling( req, res, model );

			}
			else if( "productbasketinajax".equals( cmd ) ){

				svc = new ProductbasketInAjax();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "bo/productbasketin".equals( cmd ) ){

				svc = new ProductbasketInBo();
				svc.handling( req, res, model );

			}
			else if( "productbasketlist".equals( cmd ) ){

				svc = new ProductbasketList();
				svc.handling( req, res, model );

			}
			else if( "productbasketlistdelajax".equals( cmd ) ){

				svc = new ProductbasketListDelAjax();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "bo/productbasketlist".equals( cmd ) ){

				svc = new ProductbasketListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productbasketlistdel".equals( cmd ) ){

				svc = new ProductbasketListDelBo();
				svc.handling( req, res, model );

			}
			
			else if( "bo/productbasketlistup".equals( cmd ) ){

				svc = new ProductbasketListUpBo();
				svc.handling( req, res, model );

			}
			else if( "productbasketview".equals( cmd ) ){

				svc = new ProductbasketView();
				svc.handling( req, res, model );

			}
			else if( "bo/productbasketview".equals( cmd ) ){

				svc = new ProductbasketViewBo();
				svc.handling( req, res, model );

			}
			else if( "productbasketup".equals( cmd ) ){

				svc = new ProductbasketUp();
				svc.handling( req, res, model );

			}
			else if( "productbasketupajax".equals( cmd ) ){

				svc = new ProductbasketUpAjax();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "bo/productbasketup".equals( cmd ) ){

				svc = new ProductbasketUpBo();
				svc.handling( req, res, model );

			}
			else if( "productbasketview".equals( cmd ) ){

				svc = new ProductbasketView();
				svc.handling( req, res, model );

			}
			else if( "bo/productbasketview".equals( cmd ) ){

				svc = new ProductbasketViewBo();
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