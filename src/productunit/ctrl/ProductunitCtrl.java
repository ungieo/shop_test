package productunit.ctrl;

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
import productunit.svc.ProductunitAdd;
import productunit.svc.ProductunitDel;
import productunit.svc.ProductunitEdit;
import productunit.svc.ProductunitIndex;
import productunit.svc.ProductunitIn;
import productunit.svc.ProductunitList;
import productunit.svc.ProductunitUp;
import productunit.svc.ProductunitView;
import productunit.svc.ProductunitAddBo;
import productunit.svc.ProductunitDelBo;
import productunit.svc.ProductunitEditBo;
import productunit.svc.ProductunitIndexBo;
import productunit.svc.ProductunitInBo;
import productunit.svc.ProductunitListBo;
import productunit.svc.ProductunitListDelBo;
import productunit.svc.ProductunitListUpBo;
import productunit.svc.ProductunitUpBo;
import productunit.svc.ProductunitViewBo;

@WebServlet("/productunit/*")
public class ProductunitCtrl extends HttpServlet{
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


			if( "/productunit".equals( cmd ) ){

				svc = new ProductunitIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new ProductunitIndexBo();
				svc.handling( req, res, model );

			}
			else if( "productunitadd".equals( cmd ) ){

				svc = new ProductunitAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/productunitadd".equals( cmd ) ){

				svc = new ProductunitAddBo();
				svc.handling( req, res, model );

			}
			else if( "productunitdel".equals( cmd ) ){

				svc = new ProductunitDel();
				svc.handling( req, res, model );

			}
			else if( "bo/productunitdel".equals( cmd ) ){

				svc = new ProductunitDelBo();
				svc.handling( req, res, model );

			}
			else if( "productunitedit".equals( cmd ) ){

				svc = new ProductunitEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/productunitedit".equals( cmd ) ){

				svc = new ProductunitEditBo();
				svc.handling( req, res, model );

			}
			else if( "productunitin".equals( cmd ) ){

				svc = new ProductunitIn();
				svc.handling( req, res, model );

			}
			else if( "bo/productunitin".equals( cmd ) ){

				svc = new ProductunitInBo();
				svc.handling( req, res, model );

			}
			else if( "productunitlist".equals( cmd ) ){

				svc = new ProductunitList();
				svc.handling( req, res, model );

			}
			else if( "bo/productunitlist".equals( cmd ) ){

				svc = new ProductunitListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productunitlistdel".equals( cmd ) ){

				svc = new ProductunitListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productunitlistup".equals( cmd ) ){

				svc = new ProductunitListUpBo();
				svc.handling( req, res, model );

			}
			else if( "productunitview".equals( cmd ) ){

				svc = new ProductunitView();
				svc.handling( req, res, model );

			}
			else if( "bo/productunitview".equals( cmd ) ){

				svc = new ProductunitViewBo();
				svc.handling( req, res, model );

			}
			else if( "productunitup".equals( cmd ) ){

				svc = new ProductunitUp();
				svc.handling( req, res, model );

			}
			else if( "bo/productunitup".equals( cmd ) ){

				svc = new ProductunitUpBo();
				svc.handling( req, res, model );

			}
			else if( "productunitview".equals( cmd ) ){

				svc = new ProductunitView();
				svc.handling( req, res, model );

			}
			else if( "bo/productunitview".equals( cmd ) ){

				svc = new ProductunitViewBo();
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