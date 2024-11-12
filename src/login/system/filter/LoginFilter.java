package login.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.util.Cvt;

@WebFilter(
		urlPatterns={
//				"/board/*",				//board/bo/*과 겹침.
				"/boardarticle/boardarticleadd",
				"/boardarticle/boardarticleedit",
//				"/boardarticle/boardarticlelist",
//				"/boardarticle/boardarticleview",
				"/ordermain/ordermainlist",
				"/ordermain/ordermainview",
				"/ordermain/ordermainadd",
				"/member/memberedit",
				"/member/memberdel",
				"/member/memberlist",
				"/member/memeberview"
		},
		initParams={
				@WebInitParam(name="login", value="/login/login"),
		}
)

public class LoginFilter implements Filter {

	FilterConfig fConfig;
	ServletContext sContext;
	HttpServletRequest hReq;
	HttpServletResponse hRes;
	String login;
	String bologin;
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig; 
		this.login = fConfig.getInitParameter( "login" );
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
		
		hReq = (HttpServletRequest)req;
		HttpSession session = hReq.getSession();
//		HttpSession session = ((HttpServletRequest)req).getSession();
		
		String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
		String ss_mbtype = Cvt.toStr( session.getAttribute( "ss_mbtype" ) );
//		System.out.println( "session ss_mbid : " + ss_mbid);
//		if( null == ss_mbid || "".equals( ss_mbid ) ){
		if( ss_mbid.isEmpty() || !"N".equals( ss_mbtype ) ){
			sContext = fConfig.getServletContext();
			hRes = (HttpServletResponse)res;
			hRes.sendRedirect( sContext.getContextPath() + login );				//redirect
//			sctxt.getRequestDispatcher( sctxt.getContextPath() + login_page );		//forward
//			System.out.println("login : fail");
		}else{
			fc.doFilter( req, res);
//			System.out.println("login : success");
		}
//		System.out.println( "LoginBoFilter context : "+ sContext.getContextPath() );
	}
	
	@Override
	public void destroy() {}
}
