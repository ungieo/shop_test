package companydepartment.ctrl;

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
import companydepartment.svc.CompanydepartmentAdd;
import companydepartment.svc.CompanydepartmentAddBo;
import companydepartment.svc.CompanydepartmentDel;
import companydepartment.svc.CompanydepartmentDelBo;
import companydepartment.svc.CompanydepartmentEdit;
import companydepartment.svc.CompanydepartmentEditBo;
import companydepartment.svc.CompanydepartmentIn;
import companydepartment.svc.CompanydepartmentInBo;
import companydepartment.svc.CompanydepartmentIndex;
import companydepartment.svc.CompanydepartmentIndexBo;
import companydepartment.svc.CompanydepartmentList;
import companydepartment.svc.CompanydepartmentListBo;
import companydepartment.svc.CompanydepartmentListBoJson;
import companydepartment.svc.CompanydepartmentListDelBo;
import companydepartment.svc.CompanydepartmentListUpBo;
import companydepartment.svc.CompanydepartmentUp;
import companydepartment.svc.CompanydepartmentUpBo;
import companydepartment.svc.CompanydepartmentView;
import companydepartment.svc.CompanydepartmentViewBo;

@WebServlet("/companydepartment/*")
public class CompanydepartmentCtrl extends HttpServlet{
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

			if( "/companydepartment".equals( cmd ) ){

				svc = new CompanydepartmentIndex();
				svc.handling( req, res, model );

			}
			else if( "bo".equals( cmd ) ){

				svc = new CompanydepartmentIndexBo();
				svc.handling( req, res, model );

			}
			else if( "companydepartmentadd".equals( cmd ) ){

				svc = new CompanydepartmentAdd();
				svc.handling( req, res, model );

			}
			else if( "bo/companydepartmentadd".equals( cmd ) ){

				svc = new CompanydepartmentAddBo();
				svc.handling( req, res, model );

			}
			else if( "companydepartmentdel".equals( cmd ) ){

				svc = new CompanydepartmentDel();
				svc.handling( req, res, model );

			}
			else if( "bo/companydepartmentdel".equals( cmd ) ){

				svc = new CompanydepartmentDelBo();
				svc.handling( req, res, model );

			}
			else if( "companydepartmentedit".equals( cmd ) ){

				svc = new CompanydepartmentEdit();
				svc.handling( req, res, model );

			}
			else if( "bo/companydepartmentedit".equals( cmd ) ){

				svc = new CompanydepartmentEditBo();
				svc.handling( req, res, model );

			}
			else if( "companydepartmentin".equals( cmd ) ){

				svc = new CompanydepartmentIn();
				svc.handling( req, res, model );

			}
			else if( "bo/companydepartmentin".equals( cmd ) ){

				svc = new CompanydepartmentInBo();
				svc.handling( req, res, model );

			}
			else if( "companydepartmentlist".equals( cmd ) ){

				svc = new CompanydepartmentList();
				svc.handling( req, res, model );

			}
			else if( "bo/companydepartmentlist".equals( cmd ) ){

				svc = new CompanydepartmentListBo();
				svc.handling( req, res, model );

			}
			else if( "bo/companydepartmentlistjson".equals( cmd ) ){

				svc = new CompanydepartmentListBoJson();
				svc.handling( req, res, model );
				Exception e = (Exception)model.get("exc");
				if( null != e ){
					throw new ServletException();
				}
				return;

			}
			else if( "bo/companydepartmentlistdel".equals( cmd ) ){

				svc = new CompanydepartmentListDelBo();
				svc.handling( req, res, model );

			}
			else if( "bo/companydepartmentlistup".equals( cmd ) ){

				svc = new CompanydepartmentListUpBo();
				svc.handling( req, res, model );

			}
			else if( "companydepartmentview".equals( cmd ) ){

				svc = new CompanydepartmentView();
				svc.handling( req, res, model );

			}
			else if( "bo/companydepartmentview".equals( cmd ) ){

				svc = new CompanydepartmentViewBo();
				svc.handling( req, res, model );

			}
			else if( "companydepartmentup".equals( cmd ) ){

				svc = new CompanydepartmentUp();
				svc.handling( req, res, model );

			}
			else if( "bo/companydepartmentup".equals( cmd ) ){

				svc = new CompanydepartmentUpBo();
				svc.handling( req, res, model );

			}
			else if( "companydepartmentview".equals( cmd ) ){

				svc = new CompanydepartmentView();
				svc.handling( req, res, model );

			}
			else if( "bo/companydepartmentview".equals( cmd ) ){

				svc = new CompanydepartmentViewBo();
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