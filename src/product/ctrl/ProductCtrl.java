package product.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.svc.FilestorageDelBoJson;
import product.svc.FilestorageUpBoJson;
import product.svc.ProductAdd;
import product.svc.ProductAddBo;
import product.svc.ProductDel;
import product.svc.ProductDelBo;
import product.svc.ProductEdit;
import product.svc.ProductEditBo;
import product.svc.ProductIn;
import product.svc.ProductInBo;
import product.svc.ProductIndex;
import product.svc.ProductIndexBo;
import product.svc.ProductList;
import product.svc.ProductListBo;
import product.svc.ProductListBoAjax;
import product.svc.ProductListDelBo;
import product.svc.ProductListUpBo;
import product.svc.ProductSearchList;
import product.svc.ProductUp;
import product.svc.ProductUpBo;
import product.svc.ProductView;
import product.svc.ProductViewAjax;
import product.svc.ProductViewBo;
import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;

@WebServlet("/product/*")
public class ProductCtrl extends HttpServlet{
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


			if( "/product".equals( cmd ) ){

				svc = new ProductIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new ProductIndexBo();
				svc.handling( req, res, model );

			}
			else if( "productadd".equals( cmd ) ){

				svc = new ProductAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/productadd".equals( cmd ) ){

				svc = new ProductAddBo();
				svc.handling( req, res, model );

			}
			else if( "productdel".equals( cmd ) ){

				svc = new ProductDel();
				svc.handling( req, res, model );

			}
			else if( "bo/productdel".equals( cmd ) ){

				svc = new ProductDelBo();
				svc.handling( req, res, model );

			}
			else if( "productedit".equals( cmd ) ){

				svc = new ProductEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/productedit".equals( cmd ) ){

				svc = new ProductEditBo();
				svc.handling( req, res, model );

			}
			else if( "productin".equals( cmd ) ){

				svc = new ProductIn();
				svc.handling( req, res, model );

			}
			else if( "bo/productin".equals( cmd ) ){

				svc = new ProductInBo();
				svc.handling( req, res, model );

			}
			else if( "productlist".equals( cmd ) ){

				svc = new ProductList();
				svc.handling( req, res, model );

			}
			else if( "productsearchlist".equals( cmd ) ){

				svc = new ProductSearchList();
				svc.handling( req, res, model );

			}
			else if( "bo/productlist".equals( cmd ) ){

				svc = new ProductListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productlistajax".equals( cmd ) ){
				svc = new ProductListBoAjax();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;
			}
			else if( "bo/productlistdel".equals( cmd ) ){

				svc = new ProductListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productlistup".equals( cmd ) ){

				svc = new ProductListUpBo();
				svc.handling( req, res, model );

			}
			else if( "productview".equals( cmd ) ){

				svc = new ProductView();
				svc.handling( req, res, model );

			}
			else if( "bo/productview".equals( cmd ) ){

				svc = new ProductViewBo();
				svc.handling( req, res, model );

			}
			else if( "productup".equals( cmd ) ){

				svc = new ProductUp();
				svc.handling( req, res, model );

			}
			else if( "bo/productup".equals( cmd ) ){

				svc = new ProductUpBo();
				svc.handling( req, res, model );

			}
			else if( "productview".equals( cmd ) ){

				svc = new ProductView();
				svc.handling( req, res, model );

			}
			else if( "bo/productview".equals( cmd ) ){

				svc = new ProductViewBo();
				svc.handling( req, res, model );

			}
			else if( "bo/filestoragedeljson".equals( cmd ) ){

				svc = new FilestorageDelBoJson();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "bo/filestorageupjson".equals( cmd ) ){

				svc = new FilestorageUpBoJson();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "productviewajax".equals( cmd ) ){
				svc = new ProductViewAjax();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;
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