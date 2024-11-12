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
				"/home/bo/*",
				"/board/bo/*",
				"/boardarticle/bo/*",
				"/company/bo/*",
				"/companydepartment/bo/*",
				"/config/bo/*",
				"/member/bo/*",
				"/ordermain/bo/*",
				"/ordermainaddress/bo/*",
				"/ordermainhistory/bo/*",
				"/ordermainitem/bo/*",
				"/ordermainitemaddress/bo/*",
				"/ordermainitemhistory/bo/*",
				"/parcelcompany/bo/*",
				"/product/bo/*",
				"/productbasket/bo/*",
				"/productbrand/bo/*",
				"/productcategory/bo/*",
				"/productdisplay/bo/*",
				"/productoption/bo/*",
				"/productprice/bo/*",
				"/productstock/bo/*",
				"/productunit/bo/*",
				"/productwish/bo/*",
		},
		initParams={
				@WebInitParam(name="login", value="/login/bo/login")
		}
)

public class LoginFilterBo implements Filter {

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
		
		String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
		String ss_mbtype = Cvt.toStr( session.getAttribute( "ss_mbtype" ) );
//		System.out.println(ss_mbid);
//		System.out.println(ss_mbtype);
		if( ss_mbid.isEmpty() || !"M".equals( ss_mbtype ) ){
			sContext = fConfig.getServletContext();
			hRes = (HttpServletResponse)res;
			hRes.sendRedirect( sContext.getContextPath() + login );				//redirect
		}else{
			fc.doFilter( req, res);
		}
	}
	
	@Override
	public void destroy() {}
}
