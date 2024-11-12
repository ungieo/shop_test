package productwish.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productwish.svc.ProductwishAdd;
import productwish.svc.ProductwishAddBo;
import productwish.svc.ProductwishDel;
import productwish.svc.ProductwishDelBo;
import productwish.svc.ProductwishEdit;
import productwish.svc.ProductwishEditBo;
import productwish.svc.ProductwishIn;
import productwish.svc.ProductwishInAjax;
import productwish.svc.ProductwishInBo;
import productwish.svc.ProductwishIndex;
import productwish.svc.ProductwishIndexBo;
import productwish.svc.ProductwishList;
import productwish.svc.ProductwishListBo;
import productwish.svc.ProductwishListDelBo;
import productwish.svc.ProductwishListUpBo;
import productwish.svc.ProductwishUp;
import productwish.svc.ProductwishUpBo;
import productwish.svc.ProductwishView;
import productwish.svc.ProductwishViewBo;
import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;

@WebServlet("/productwish/*")
public class ProductwishCtrl extends HttpServlet{
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


			if( "/productwish".equals( cmd ) ){

				svc = new ProductwishIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new ProductwishIndexBo();
				svc.handling( req, res, model );

			}
			else if( "productwishadd".equals( cmd ) ){

				svc = new ProductwishAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/productwishadd".equals( cmd ) ){

				svc = new ProductwishAddBo();
				svc.handling( req, res, model );

			}
			else if( "productwishdel".equals( cmd ) ){

				svc = new ProductwishDel();
				svc.handling( req, res, model );

			}
			else if( "bo/productwishdel".equals( cmd ) ){

				svc = new ProductwishDelBo();
				svc.handling( req, res, model );

			}
			else if( "productwishedit".equals( cmd ) ){

				svc = new ProductwishEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/productwishedit".equals( cmd ) ){

				svc = new ProductwishEditBo();
				svc.handling( req, res, model );

			}
			else if( "productwishin".equals( cmd ) ){

				svc = new ProductwishIn();
				svc.handling( req, res, model );

			}
			else if( "productwishinajax".equals( cmd ) ){

				svc = new ProductwishInAjax();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "bo/productwishin".equals( cmd ) ){

				svc = new ProductwishInBo();
				svc.handling( req, res, model );

			}
			else if( "productwishlist".equals( cmd ) ){

				svc = new ProductwishList();
				svc.handling( req, res, model );

			}
			else if( "bo/productwishlist".equals( cmd ) ){

				svc = new ProductwishListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productwishlistdel".equals( cmd ) ){

				svc = new ProductwishListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/productwishlistup".equals( cmd ) ){

				svc = new ProductwishListUpBo();
				svc.handling( req, res, model );

			}
			else if( "productwishview".equals( cmd ) ){

				svc = new ProductwishView();
				svc.handling( req, res, model );

			}
			else if( "bo/productwishview".equals( cmd ) ){

				svc = new ProductwishViewBo();
				svc.handling( req, res, model );

			}
			else if( "productwishup".equals( cmd ) ){

				svc = new ProductwishUp();
				svc.handling( req, res, model );

			}
			else if( "bo/productwishup".equals( cmd ) ){

				svc = new ProductwishUpBo();
				svc.handling( req, res, model );

			}
			else if( "productwishview".equals( cmd ) ){

				svc = new ProductwishView();
				svc.handling( req, res, model );

			}
			else if( "bo/productwishview".equals( cmd ) ){

				svc = new ProductwishViewBo();
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