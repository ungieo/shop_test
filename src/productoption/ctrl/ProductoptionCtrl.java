package productoption.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productoption.svc.ProductoptionAdd;
import productoption.svc.ProductoptionAddBo;
import productoption.svc.ProductoptionDel;
import productoption.svc.ProductoptionDelBo;
import productoption.svc.ProductoptionEdit;
import productoption.svc.ProductoptionEditBo;
import productoption.svc.ProductoptionIn;
import productoption.svc.ProductoptionInBo;
import productoption.svc.ProductoptionIndex;
import productoption.svc.ProductoptionIndexBo;
import productoption.svc.ProductoptionList;
import productoption.svc.ProductoptionListAjax;
import productoption.svc.ProductoptionListBo;
import productoption.svc.ProductoptionListDelBo;
import productoption.svc.ProductoptionListUpBo;
import productoption.svc.ProductoptionUp;
import productoption.svc.ProductoptionUpBo;
import productoption.svc.ProductoptionView;
import productoption.svc.ProductoptionViewBo;
import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;

@WebServlet("/productoption/*")
public class ProductoptionCtrl extends HttpServlet{
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


			if( "/productoption".equals( cmd ) ){

				svc = new ProductoptionIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new ProductoptionIndexBo();
				svc.handling( req, res, model );

			}
			else if( "productoptionadd".equals( cmd ) ){

				svc = new ProductoptionAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/productoptionadd".equals( cmd ) ){

				svc = new ProductoptionAddBo();
				svc.handling( req, res, model );

			}
			else if( "productoptiondel".equals( cmd ) ){

				svc = new ProductoptionDel();
				svc.handling( req, res, model );

			}
			else if( "bo/productoptiondel".equals( cmd ) ){

				svc = new ProductoptionDelBo();
				svc.handling( req, res, model );

			}
			else if( "productoptionedit".equals( cmd ) ){

				svc = new ProductoptionEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/productoptionedit".equals( cmd ) ){

				svc = new ProductoptionEditBo();
				svc.handling( req, res, model );

			}
			else if( "productoptionin".equals( cmd ) ){

				svc = new ProductoptionIn();
				svc.handling( req, res, model );

			}
			else if( "bo/productoptionin".equals( cmd ) ){

				svc = new ProductoptionInBo();
				svc.handling( req, res, model );

			}
			else if( "productoptionlist".equals( cmd ) ){

				svc = new ProductoptionList();
				svc.handling( req, res, model );

			}
			else if( "bo/productoptionlist".equals( cmd ) ){

				svc = new ProductoptionListBo();
				svc.handling( req, res, model );

			}
			else if( "productoptionlistajax".equals( cmd ) ){
				svc = new ProductoptionListAjax();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;
			}
			else if( "bo/productoptionlistdel".equals( cmd ) ){

				svc = new ProductoptionListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productoptionlistup".equals( cmd ) ){

				svc = new ProductoptionListUpBo();
				svc.handling( req, res, model );

			}
			else if( "productoptionview".equals( cmd ) ){

				svc = new ProductoptionView();
				svc.handling( req, res, model );

			}
			else if( "bo/productoptionview".equals( cmd ) ){

				svc = new ProductoptionViewBo();
				svc.handling( req, res, model );

			}
			else if( "productoptionup".equals( cmd ) ){

				svc = new ProductoptionUp();
				svc.handling( req, res, model );

			}
			else if( "bo/productoptionup".equals( cmd ) ){

				svc = new ProductoptionUpBo();
				svc.handling( req, res, model );

			}
			else if( "productoptionview".equals( cmd ) ){

				svc = new ProductoptionView();
				svc.handling( req, res, model );

			}
			else if( "bo/productoptionview".equals( cmd ) ){

				svc = new ProductoptionViewBo();
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