package login.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.svc.MemberCheck;
import login.svc.MemberCheckAjax;
import login.svc.MemberCheckBo;
import login.svc.MemberLogout;
import login.svc.MemberLogoutBo;
import system.itf.Ctrl;
import system.itf.Svc;
import system.util.Cvt;
//import board.create.dao.mysql.DaoCreate;


@WebServlet("/login/*")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	Ctrl ctrl;
	Svc svc;
	
    protected void doCtrl(HttpServletRequest req, HttpServletResponse res, String method) throws ServletException, IOException {
    	
    	Map<String, Object> model = new HashMap<String, Object>();
    	
    	HttpSession session = req.getSession();
    	
    	String url = Cvt.toStr( req.getRequestURL() );
    	String ctxt = req.getContextPath();
    	String uri = req.getRequestURI();
		String cmd = uri.replaceAll("^/.+?/.+?/", "");

		if( "".equals( ctxt ) ){
			cmd = uri.replaceAll("^/.+?/", "");
		}
		
//    	String[] cmdPath = uri.split( "/" );
    	
    	model.put( "cmd", cmd );
    	
//    	System.out.println(" LoginCtrl : " + cmd);
//    	System.out.println(cmd);
    	
    	
    	
    	if( "login".equals( cmd ) ){
    		
    		String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
    		if( "".equals( ss_mbid ) ){
    			model.put( "returnType", "F" );
    			model.put( "returnPage", "/login/login" );
    		}else{
    			model.put( "returnType", "R" );
    			model.put( "returnPage", "/index.jsp" );
    		}
    		
    	}
    	else if( "bo/login".equals( cmd ) ){
    		
    		String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
    		String ss_mbtype = Cvt.toStr( session.getAttribute( "ss_mbtype" ) );
    		
    		if( ss_mbid.isEmpty() || !"".equals( ss_mbtype ) ){
    			model.put( "returnType", "F" );
    			model.put( "returnPage", "/login/bo/login" );
    		}else{
    			model.put( "returnType", "R" );
    			model.put( "returnPage", "/bo/index.jsp" );
    		}
    		
    	}
    	else if( "membercheck".equals( cmd ) ){
    		
			svc = new MemberCheck();
			svc.handling(req, res, model);
			
		}
    	else if( "bo/membercheck".equals( cmd ) ){
    		svc = new MemberCheckBo();
    		svc.handling(req, res, model);
    	}
    	else if( "membercheckajax".equals( cmd ) ){
			svc = new MemberCheckAjax();
    		svc.handling(req, res, model);
    		Exception e = (Exception)model.get("exc");
			if( null != e ){
				throw new ServletException();
			}
			return;
    	}
    	else if( "logout".equals( cmd ) ){
    		svc = new MemberLogout();
    		svc.handling(req, res, model);
    	}
    	else if( "bo/logout".equals( cmd ) ){
    		svc = new MemberLogoutBo();
    		svc.handling(req, res, model);
    	}
    	
    	
    	
    	
    	//---* 결과페이지처리
    	if( "".equals( Cvt.toStr( model.get( "returnPage" ) ) ) )
    	{
    		res.sendRedirect( ctxt + "/404.jsp?url="+url );
    	}
    	else
    	{
    		if( "F".equals( model.get( "returnType" ) ) ){
    			req.setAttribute( "model", model );
        		RequestDispatcher dispatcher = req.getRequestDispatcher( "/WEB-INF"+model.get( "returnPage" )+".jsp" );
    			dispatcher.forward( req, res );
        	}
    		else if( "R".equals( model.get( "returnType" ) ) ){
        		res.sendRedirect( ctxt + model.get( "returnPage" ) );
        	}
    	}
    	//--- 결과페이지처리
    	

    	
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doCtrl(req,res,"get");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doCtrl(req,res,"post");
	}

}
