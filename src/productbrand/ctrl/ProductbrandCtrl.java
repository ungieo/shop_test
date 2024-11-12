package productbrand.ctrl;

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
import productbrand.svc.ProductbrandAdd;
import productbrand.svc.ProductbrandDel;
import productbrand.svc.ProductbrandEdit;
import productbrand.svc.ProductbrandIndex;
import productbrand.svc.ProductbrandIn;
import productbrand.svc.ProductbrandList;
import productbrand.svc.ProductbrandUp;
import productbrand.svc.ProductbrandView;
import productbrand.svc.ProductbrandAddBo;
import productbrand.svc.ProductbrandDelBo;
import productbrand.svc.ProductbrandEditBo;
import productbrand.svc.ProductbrandIndexBo;
import productbrand.svc.ProductbrandInBo;
import productbrand.svc.ProductbrandListBo;
import productbrand.svc.ProductbrandListDelBo;
import productbrand.svc.ProductbrandListUpBo;
import productbrand.svc.ProductbrandUpBo;
import productbrand.svc.ProductbrandViewBo;

@WebServlet("/productbrand/*")
public class ProductbrandCtrl extends HttpServlet{
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


			if( "/productbrand".equals( cmd ) ){

				svc = new ProductbrandIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new ProductbrandIndexBo();
				svc.handling( req, res, model );

			}
			else if( "productbrandadd".equals( cmd ) ){

				svc = new ProductbrandAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/productbrandadd".equals( cmd ) ){

				svc = new ProductbrandAddBo();
				svc.handling( req, res, model );

			}
			else if( "productbranddel".equals( cmd ) ){

				svc = new ProductbrandDel();
				svc.handling( req, res, model );

			}
			else if( "bo/productbranddel".equals( cmd ) ){

				svc = new ProductbrandDelBo();
				svc.handling( req, res, model );

			}
			else if( "productbrandedit".equals( cmd ) ){

				svc = new ProductbrandEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/productbrandedit".equals( cmd ) ){

				svc = new ProductbrandEditBo();
				svc.handling( req, res, model );

			}
			else if( "productbrandin".equals( cmd ) ){

				svc = new ProductbrandIn();
				svc.handling( req, res, model );

			}
			else if( "bo/productbrandin".equals( cmd ) ){

				svc = new ProductbrandInBo();
				svc.handling( req, res, model );

			}
			else if( "productbrandlist".equals( cmd ) ){

				svc = new ProductbrandList();
				svc.handling( req, res, model );

			}
			else if( "bo/productbrandlist".equals( cmd ) ){

				svc = new ProductbrandListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productbrandlistdel".equals( cmd ) ){

				svc = new ProductbrandListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productbrandlistup".equals( cmd ) ){

				svc = new ProductbrandListUpBo();
				svc.handling( req, res, model );

			}
			else if( "productbrandview".equals( cmd ) ){

				svc = new ProductbrandView();
				svc.handling( req, res, model );

			}
			else if( "bo/productbrandview".equals( cmd ) ){

				svc = new ProductbrandViewBo();
				svc.handling( req, res, model );

			}
			else if( "productbrandup".equals( cmd ) ){

				svc = new ProductbrandUp();
				svc.handling( req, res, model );

			}
			else if( "bo/productbrandup".equals( cmd ) ){

				svc = new ProductbrandUpBo();
				svc.handling( req, res, model );

			}
			else if( "productbrandview".equals( cmd ) ){

				svc = new ProductbrandView();
				svc.handling( req, res, model );

			}
			else if( "bo/productbrandview".equals( cmd ) ){

				svc = new ProductbrandViewBo();
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