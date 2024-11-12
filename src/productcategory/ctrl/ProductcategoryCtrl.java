package productcategory.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productcategory.svc.ProductcategoryAdd;
import productcategory.svc.ProductcategoryAddBo;
import productcategory.svc.ProductcategoryDel;
import productcategory.svc.ProductcategoryDelBo;
import productcategory.svc.ProductcategoryEdit;
import productcategory.svc.ProductcategoryEditBo;
import productcategory.svc.ProductcategoryIn;
import productcategory.svc.ProductcategoryInBo;
import productcategory.svc.ProductcategoryIndex;
import productcategory.svc.ProductcategoryIndexBo;
import productcategory.svc.ProductcategoryList;
import productcategory.svc.ProductcategoryListBo;
import productcategory.svc.ProductcategoryListBoJson;
import productcategory.svc.ProductcategoryListBoTree;
import productcategory.svc.ProductcategoryUp;
import productcategory.svc.ProductcategoryUpBo;
import productcategory.svc.ProductcategoryView;
import productcategory.svc.ProductcategoryViewBo;
import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;

@WebServlet("/productcategory/*")
public class ProductcategoryCtrl extends HttpServlet{
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


			if( "/productcategory".equals( cmd ) ){

				svc = new ProductcategoryIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new ProductcategoryIndexBo();
				svc.handling( req, res, model );

			}
			else if( "productcategoryadd".equals( cmd ) ){

				svc = new ProductcategoryAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/productcategoryadd".equals( cmd ) ){

				svc = new ProductcategoryAddBo();
				svc.handling( req, res, model );

			}
			else if( "productcategorydel".equals( cmd ) ){

				svc = new ProductcategoryDel();
				svc.handling( req, res, model );

			}
			else if( "bo/productcategorydel".equals( cmd ) ){

				svc = new ProductcategoryDelBo();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "productcategoryedit".equals( cmd ) ){

				svc = new ProductcategoryEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/productcategoryedit".equals( cmd ) ){

				svc = new ProductcategoryEditBo();
				svc.handling( req, res, model );

			}
			else if( "productcategoryin".equals( cmd ) ){

				svc = new ProductcategoryIn();
				svc.handling( req, res, model );

			}
			else if( "bo/productcategoryin".equals( cmd ) ){

				svc = new ProductcategoryInBo();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "productcategorylist".equals( cmd ) ){

				svc = new ProductcategoryList();
				svc.handling( req, res, model );

			}
			else if( "bo/productcategorylist".equals( cmd ) ){

				svc = new ProductcategoryListBo();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}else if( "bo/productcategorylistjson".equals( cmd ) ){

				svc = new ProductcategoryListBoJson();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "bo/productcategorylisttree".equals( cmd ) ){

				svc = new ProductcategoryListBoTree();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "productcategoryview".equals( cmd ) ){

				svc = new ProductcategoryView();
				svc.handling( req, res, model );

			}
			else if( "bo/productcategoryview".equals( cmd ) ){

				svc = new ProductcategoryViewBo();
				svc.handling( req, res, model );

			}
			else if( "productcategoryup".equals( cmd ) ){

				svc = new ProductcategoryUp();
				svc.handling( req, res, model );

			}
			else if( "bo/productcategoryup".equals( cmd ) ){

				svc = new ProductcategoryUpBo();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "productcategoryview".equals( cmd ) ){

				svc = new ProductcategoryView();
				svc.handling( req, res, model );

			}
			else if( "bo/productcategoryview".equals( cmd ) ){

				svc = new ProductcategoryViewBo();
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