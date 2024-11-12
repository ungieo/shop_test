<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<%@page import="system.file.svc.FileSvc" %>
<%@page import="system.file.svc.impl.FileSvcImpl"%>
<%@ page import="java.io.*"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%
// 	System.out.println( request.getParameter( "CKEditorFuncNum" ) );
// 	System.out.println( request.getParameter( "CKEditor" ) );
// 	System.out.println( request.getParameter( "langCode" ) );

	String funcNum = request.getParameter( "CKEditorFuncNum" );
	String r_filePath = request.getParameter( "r_filePath" );
	if( "".equals( r_filePath ) ){
		r_filePath = "img";
	}

	FileSvc fileSvc = new FileSvcImpl();
	Map<String, Object> svcMap = new HashMap<String, Object>();
	int fileSize = 1024*1024*10;
	svcMap.put( "filePath", "/up/img" );
	svcMap.put( "fileSize", fileSize );
	svcMap.put( "encoding", "UTF-8" );
	
	boolean result = fileSvc.fileUpload(request, svcMap );
	String filePath = Cvt.toStr( svcMap.get( "filePath" ) );
	List<String> fileNameList = (List<String>)svcMap.get( "fileNameList" );
	String fileName = fileNameList.get(0);
	String msg = "";
	
	if( result ){
		msg = "업로드 완료";
	}else{
		msg = "업로드 실패";
	}
	String fileExtention = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
	String[] extArr = {"gif","png","jpg","jpeg", "bmp", "tif" };
	boolean extBool = false;
	for( String ext : extArr ){
		if( ext.equals( fileExtention ) ){
			extBool = true;
			break;
		}
	}
	if( !extBool ){
		fileSvc.fileDel(request, "/up/"+r_filePath+"/"+fileName );
		msg = "이미지 파일만 업로드 가능합니다.";
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@include file="/include/jsp/commonhead.jsp"%>	

<%if( true == result ){	%>
	<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(<%=funcNum%>, '${cpath}/data/up/img/<%= fileName%>', '<%=msg%>');</script>
<%}else{%>
	<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(<%=funcNum%>, '', 'false', '<%=msg%>' );</script>
<%}%>

</head>
<body>

</body>
</html>