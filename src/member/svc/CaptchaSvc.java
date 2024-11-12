package member.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;
import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system.db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import member.dao.MemberDao;
import member.dto.Member;

public class CaptchaSvc implements Svc{

	Connection conn;

	@Override
	public void handling( HttpServletRequest req, HttpServletResponse res, Map<String, Object> model ){

		try{

			HttpSession session = req.getSession();
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			String answer = req.getParameter("answer");
			res.getWriter().print(captcha.isCorrect(answer));
			
			//---* model
			model.put( "returnType", "F" );
			model.put( "returnPage", "/member/bo/memberindex" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}