package boardarticle.ctrl;

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
import boardarticle.svc.BoardarticleAdd;
import boardarticle.svc.BoardarticleAddBo;
import boardarticle.svc.BoardarticleDel;
import boardarticle.svc.BoardarticleDelBo;
import boardarticle.svc.BoardarticleEdit;
import boardarticle.svc.BoardarticleEditBo;
import boardarticle.svc.BoardarticleFaqList;
import boardarticle.svc.BoardarticleIn;
import boardarticle.svc.BoardarticleInBo;
import boardarticle.svc.BoardarticleIndex;
import boardarticle.svc.BoardarticleIndexBo;
import boardarticle.svc.BoardarticleList;
import boardarticle.svc.BoardarticleListBo;
import boardarticle.svc.BoardarticleListDelBo;
import boardarticle.svc.BoardarticleListUpBo;
import boardarticle.svc.BoardarticleReplyAdd;
import boardarticle.svc.BoardarticleReplyAddBo;
import boardarticle.svc.BoardarticleReplyIn;
import boardarticle.svc.BoardarticleReplyInBo;
import boardarticle.svc.BoardarticleUp;
import boardarticle.svc.BoardarticleUpBo;
import boardarticle.svc.BoardarticleView;
import boardarticle.svc.BoardarticleViewBo;
import boardarticle.svc.FileDown;

@WebServlet("/boardarticle/*")
public class BoardarticleCtrl extends HttpServlet{
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
//			System.out.println(cmd);
			
			if( "/boardarticle".equals( cmd ) ){

				svc = new BoardarticleIndex();
				svc.handling( req, res, model );

			}
			if( "bo".equals( cmd ) ){

				svc = new BoardarticleIndexBo();
				svc.handling( req, res, model );

			}
			else if( "boardarticleadd".equals( cmd ) ){

				svc = new BoardarticleAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/boardarticleadd".equals( cmd ) ){

				svc = new BoardarticleAddBo();
				svc.handling( req, res, model );

			}
			else if( "boardarticlereplyadd".equals( cmd ) ){
				svc = new BoardarticleReplyAdd();
				svc.handling( req, res, model );
			}
			else if( "bo/boardarticlereplyadd".equals( cmd ) ){
				svc = new BoardarticleReplyAddBo();
				svc.handling( req, res, model );
			}
			else if( "boardarticlereplyin".equals( cmd ) ){
				svc = new BoardarticleReplyIn();
				svc.handling( req, res, model );
			}
			else if( "bo/boardarticlereplyin".equals( cmd ) ){
				svc = new BoardarticleReplyInBo();
				svc.handling( req, res, model );
			}
			else if( "bo/boardarticlereplyin".equals( cmd ) ){
				svc = new BoardarticleReplyInBo();
				svc.handling( req, res, model );
			}
			else if( "boardarticledel".equals( cmd ) ){

				svc = new BoardarticleDel();
				svc.handling( req, res, model );

			}
			else if( "bo/boardarticledel".equals( cmd ) ){

				svc = new BoardarticleDelBo();
				svc.handling( req, res, model );

			}
			else if( "boardarticleedit".equals( cmd ) ){

				svc = new BoardarticleEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/boardarticleedit".equals( cmd ) ){

				svc = new BoardarticleEditBo();
				svc.handling( req, res, model );

			}
			else if( "boardarticlein".equals( cmd ) ){

				svc = new BoardarticleIn();
				svc.handling( req, res, model );

			}
			else if( "bo/boardarticlein".equals( cmd ) ){

				svc = new BoardarticleInBo();
				svc.handling( req, res, model );

			}
			else if( "boardarticlelist".equals( cmd ) ){

				svc = new BoardarticleList();
				svc.handling( req, res, model );

			}
			else if( "boardarticlefaqlist".equals( cmd ) ){

				svc = new BoardarticleFaqList();
				svc.handling( req, res, model );

			}
			else if( "bo/boardarticlelist".equals( cmd ) ){

				svc = new BoardarticleListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/boardarticlelistdel".equals( cmd ) ){

				svc = new BoardarticleListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/boardarticlelistup".equals( cmd ) ){

				svc = new BoardarticleListUpBo();
				svc.handling( req, res, model );

			}			
			else if( "boardarticleview".equals( cmd ) ){

				svc = new BoardarticleView();
				svc.handling( req, res, model );

			}
			else if( "bo/boardarticleview".equals( cmd ) ){

				svc = new BoardarticleViewBo();
				svc.handling( req, res, model );

			}
			else if( "boardarticleup".equals( cmd ) ){

				svc = new BoardarticleUp();
				svc.handling( req, res, model );

			}
			else if( "bo/boardarticleup".equals( cmd ) ){

				svc = new BoardarticleUpBo();
				svc.handling( req, res, model );

			}
			else if( "boardarticleview".equals( cmd ) ){

				svc = new BoardarticleView();
				svc.handling( req, res, model );

			}
			else if( "bo/boardarticleview".equals( cmd ) ){

				svc = new BoardarticleViewBo();
				svc.handling( req, res, model );

			}
			else if( "filedown".equals( cmd ) || "bo/filedown".equals( cmd ) ){
				svc = new FileDown();
				svc.handling(req, res, model );
				return;
			}


			//---* 결과페이지처리
			if( "".equals( Cvt.toStr( model.get( "returnPage" ) ) ) ){
//				res.sendRedirect( ctxt + "/404.jsp" );
				res.sendRedirect( ctxt + "/404.jsp?url=" + url );
			}
			else{
				if( "F".equals( model.get( "returnType" ) ) ){
					req.setAttribute( "model", model );
					RequestDispatcher dispatcher = req.getRequestDispatcher( "/WEB-INF"+model.get( "returnPage" )+".jsp" );
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