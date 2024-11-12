package board.ctrl;

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
import board.svc.BoardAdd;
import board.svc.BoardAddBo;
import board.svc.BoardDel;
import board.svc.BoardDelBo;
import board.svc.BoardEdit;
import board.svc.BoardEditBo;
import board.svc.BoardIn;
import board.svc.BoardInBo;
import board.svc.BoardIndex;
import board.svc.BoardIndexBo;
import board.svc.BoardList;
import board.svc.BoardListBo;
import board.svc.BoardListDelBo;
import board.svc.BoardListUpBo;
import board.svc.BoardUp;
import board.svc.BoardUpBo;
import board.svc.BoardView;
import board.svc.BoardViewBo;

@WebServlet("/board/*")
public class BoardCtrl extends HttpServlet{
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
			
			if( "/board".equals( cmd ) ){

				svc = new BoardIndex();
				svc.handling( req, res, model );

			}
			if( "bo".equals( cmd ) ){

				svc = new BoardIndexBo();
				svc.handling( req, res, model );

			}
			else if( "boardadd".equals( cmd ) ){

				svc = new BoardAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/boardadd".equals( cmd ) ){

				svc = new BoardAddBo();
				svc.handling( req, res, model );

			}
			else if( "boarddel".equals( cmd ) ){

				svc = new BoardDel();
				svc.handling( req, res, model );

			}
			else if( "bo/boarddel".equals( cmd ) ){

				svc = new BoardDelBo();
				svc.handling( req, res, model );

			}
			else if( "boardedit".equals( cmd ) ){

				svc = new BoardEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/boardedit".equals( cmd ) ){

				svc = new BoardEditBo();
				svc.handling( req, res, model );

			}
			else if( "boardin".equals( cmd ) ){

				svc = new BoardIn();
				svc.handling( req, res, model );

			}
			else if( "bo/boardin".equals( cmd ) ){

				svc = new BoardInBo();
				svc.handling( req, res, model );

			}
			else if( "bo/boardindex".equals( cmd ) ){
				
				svc = new BoardIndexBo();
				svc.handling( req, res, model );
			}
			else if( "boardlist".equals( cmd ) ){

				svc = new BoardList();
				svc.handling( req, res, model );

			}
			else if( "bo/boardlist".equals( cmd ) ){

				svc = new BoardListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/boardlistdel".equals( cmd ) ){

				svc = new BoardListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/boardlistup".equals( cmd ) ){

				svc = new BoardListUpBo();
				svc.handling( req, res, model );

			}
			else if( "boardview".equals( cmd ) ){

				svc = new BoardView();
				svc.handling( req, res, model );

			}
			else if( "bo/boardview".equals( cmd ) ){

				svc = new BoardViewBo();
				svc.handling( req, res, model );

			}
			else if( "boardup".equals( cmd ) ){

				svc = new BoardUp();
				svc.handling( req, res, model );

			}
			else if( "bo/boardup".equals( cmd ) ){

				svc = new BoardUpBo();
				svc.handling( req, res, model );

			}
			else if( "boardview".equals( cmd ) ){

				svc = new BoardView();
				svc.handling( req, res, model );

			}
			else if( "bo/boardview".equals( cmd ) ){

				svc = new BoardViewBo();
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