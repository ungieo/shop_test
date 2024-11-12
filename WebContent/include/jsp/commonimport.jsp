<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- *java import -->
<%@ page import="java.util.*" %>
<%@ page import="system.util.Cvt" %>
<%@page import="java.io.*" %>
<%@page import="java.util.Properties" %>
<!-- java import -->

<!--* TagLib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>			<!-- 코어태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<%@ taglib prefix="cvt"  uri="Cvt" %>
<%@ taglib prefix="odc" uri="OrderCode" %>
<!-- TagLib -->

<!--* Var  -->
<c:set var="sname" value="${ pageContext.request.serverName }" />
<c:set var="cpath" scope="page" value="${ pageContext.request.contextPath }" />
<!-- Var -->  

<%
    InputStream stream = new FileInputStream( new File( request.getServletContext().getRealPath( "/WEB-INF/system/prop/siteinfo.properties" ) ) );
    Properties props = new Properties();
    props.load(stream);
    stream.close();
%>