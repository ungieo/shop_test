<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    
<%@include file="/include/jsp/commonhead.jsp"%>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<script type="text/javascript">

	$(function(){
		jQuery.validator.addMethod("idcheck", function(value, element) {
			  return this.optional(element) || /^[A-Za-z0-9+]{4,20}$/.test(value);
			}, "아이디는 4~20자의 영문과 숫자만 입력가능합니다.");
		
		jQuery.validator.addMethod("mobile", function(value, element) {
			  return this.optional(element) || /^01[\d]{1}-[\d]{3,4}-[\d]{4}$/.test(value);
			}, "유효하지 않은 휴대전화번호 입니다.");
		
		jQuery.validator.addMethod("email", function(value, element) {
			  return this.optional(element) || /^[\w]([-_\.]?[\w])*@[\w]([-_\.]?[\w])*\.[\w]{2,3}$/i.test(value);
			}, "유효하지 않은 E-Mail주소입니다.");
		
		$( '#dialog' ).dialog({
			autoOpen : false
		});
		
		$('#frm').validate({
			submitHandler : function(form){
// 				$( form ).submit();			//재귀?
				form.submit();
			}
// 			rules : {
// 				r_mbphone : {
// 					required : true,
// 					rangelength : [4, 16],
// 					digits : true
// 				}
// 			}
		});
		
		$( 'input[name="r_mbbirth"]' ).datepicker({
			changeYear: true,
			yearRange : 'c-50:c+10',
			showButtonPanel: true,
		    dateFormat: "yy-mm-dd",
// 			showOn: 'button',
			maxDate : 0
// 			buttonImage : '',
// 			buttonImageOnly : true
		});
	});

	function dataAjax(){
		if( $( '#r_mbid' ).attr( 'readonly' ) != 'readonly' ){
			alert( '아이디 중복 체크가 되지 않았습니다.' );
			return;
		}
		
		var answerVal = $('input[name="answer"]').val();
		
		$.get( '${cpath}/system/captcha?answer='+answerVal, function(data){
			if( 'true' == data ){
				handling.submit( '', 'memberin' );
			}else{
				alert('보안문자가 일치하지 않습니다.');
				return;
			}
		} );

// 		$.get( 'getcaptcha', {answer : answer }).done(function(data){			//answer input을 가져오는 듯. 'answer' 형태로 안 써도 됨. done이 실행하고 리턴하는 메소드인듯.
// 			alert( data );
// 		} );
		
		
// 		$.ajax({
// 			async : false,
// 			data : param,
// 			error : function(){
// 				alert( '처리 중 오류가 발생되었습니다.' );
// 				errorCnt += 1;
// 				checkYn = 'N';
// 				return false;
// 			},
// 			success : function( data ){
// 				alert( data );
// 			},
// 			type : 'GET',
// 			url : 'getcaptcha'
// 		});
	}

	function dataAdd(){
		handling.submit( '', 'memberadd' );
	}

	function dataEdit(){
		handling.submit( '', 'memberedit' );
	}

	function dataDel(){
		handling.submit( '', 'memberdel' );
	}

	function dataDown(){
		handling.submit( '', 'memberdel' );
	}

	function dataIn(){
		dataAjax();
	}

	function dataView(){
		handling.submit( '', 'memberview' );
	}

	function dataList(){
		handling.submit( '', 'memberlist' );
	}

	function dataSort(){
		handling.submit( '', 'memberlist' );
	}

	function dataUp(){
		handling.submit( '', 'memberup' );
	}

	function formSubmit( fName, url ){
		handling.submit( fName, url );
	}

	function pager( fName, url ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( fName, url );
	}

	function pageMove( fName, url ){
		handling.pageMove(url,param);
	}
	
	
	function getZipcode(){
		daum.postcode.load(function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	            	document.getElementsByName( "r_mbzipcode" )[0].value = data.zonecode;
		        	document.getElementsByName( "r_mbaddr1" )[0].value = data.roadAddress;
	            }
	        }).open();
	    });
	}
	
	function captcharReload(){
		$('img[name="captcha"]').attr('src','${cpath}/simpleCaptcha.png');
	}

	
	function idconfirm(){
		var r_mbidVal = $('#r_mbid' ).val();
		if( r_mbidVal == '' ){
			alert( '아이디를 입력해주십시오' );
			return;
		}
		$.get( 'idconfirm', { r_mbid : r_mbidVal }).done(function(data){			//answer input을 가져오는 듯. 'answer' 형태로 안 써도 됨. done이 실행하고 리턴하는 메소드인듯.
			if( 'false' == data ){
				$( '#dialog' ).dialog( 'open' );
				$( '#dialog' ).dialog({
					buttons:[{
						text: '사용하기',
						click:function(){
							idreadonly( 'readonly="readonly"' );
							$( this ).dialog( 'close' );
						}
					}]
				});
				$( '#dialog' ).html( '사용가능한 아이디입니다.' );
			}else{
				$( '#dialog' ).dialog( 'open' );
				$( '#dialog' ).dialog({
					buttons:[{
						text: '닫기',
						click:function(){
							$( this ).dialog( 'close' );
						}
					}]
				});
				$( '#dialog' ).html( '이미 등록 된 아이디입니다.' );
			}
		} );
	}
	
	function idreadonly( readyn ){
		$( '#r_mbid' ).attr( 'readonly', readyn );
	}
	
</script>
</head>
<body>

	<div class="container">
	
	<%@ include file="/include/jsp/header.jsp" %>

	<form action="memberin" class="form-horizontal" method="post" name="frm" id="frm" >

		<fieldset>
			<legend>memberadd</legend>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbid">아이디</label>
				<div class="col-sm-7">
					<input id="r_mbid" name="r_mbid" class="form-control" type="text" value="${ model.member.MB_ID }" onclick="idreadonly(null);return false;" required idcheck="true" />
				</div>
				<div class="col-sm-3">
					<input type="button" class="form-control" onclick="idconfirm();" value="아이디중복확인" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbname">이름</label>
				<div class="col-sm-10">
					<input name="r_mbname" class="form-control" type="text" value="${ model.member.MB_NAME }" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbpswd">비밀번호</label>
				<div class="col-sm-10">
					<input name="r_mbpswd" class="form-control" type="password" value="${ model.member.MB_PSWD }" required rangelength="6, 16"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbpswdcon">비밀번호확인</label>
				<div class="col-sm-10">
					<input name="r_mbpswdcon" class="form-control" type="password" value="${ model.member.MB_PSWD }" required equalTo="input[name='r_mbpswd']"/>
				</div>
			</div>			
			<div class="form-group">
				<label for="r_mbzipcode" class="col-sm-2 control-label">우편번호</label>
				<div class="col-sm-5">
					<input id="r_mbzipcode" class="form-control" name="r_mbzipcode" type="text" value="${ model.member.MB_ZIPCODE }" readonly="readonly" required />
				</div>
				<div class="col-sm-5">
					<input type="button" class="form-control" onclick="getZipcode();" value="우편번호검색" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbaddr1">기본주소</label>
				<div class="col-sm-10">
					<input name="r_mbaddr1"  class="form-control" type="text" value="${ model.member.MB_ADDR1 }" readonly="readonly" required/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbaddr2">상세주소</label>
				<div class="col-sm-10">
					<input name="r_mbaddr2"  class="form-control" type="text" value="${ model.member.MB_ADDR2 }" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbemail">이메일</label>
				<div class="col-sm-10">
					<input name="r_mbemail"  class="form-control" type="text" value="${ model.member.MB_EMAIL }" required email="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbphone">휴대폰</label>
				<div class="col-sm-10">
					<input name="r_mbphone"  class="form-control" type="text" value="${ model.member.MB_PHONE }" required mobile="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbtel">전화번호</label>
				<div class="col-sm-10">
					<input name="r_mbtel"  class="form-control" type="text" value="${ model.member.MB_TEL }" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbbirth">생년월일</label>
				<div class="col-sm-10">
					<input name="r_mbbirth"  class="form-control" type="text" value="${ model.member.MB_BIRTH }" required/>
				</div>
			</div>
			<div class="form-group">
				<label for="r_mbemailuse" class="col-sm-2 control-label">이메일수신여부</label>
				<div class="col-sm-10">
					<label class="radio-inline">
						<input name="r_mbemailuse" type="radio" value="Y" checked="checked"/>YES
					</label>
					<label class="radio-inline">
						<input name="r_mbemailuse" type="radio" value="N" />NO
					</label>
				</div>
			</div>
			<div class="form-group">
				<label for="r_mbsmsuse" class="col-sm-2 control-label">문자수신여부</label>
				<div class="col-sm-10">
					<label class="radio-inline">
						<input name="r_mbsmsuse" type="radio" value="Y" checked="checked" />YES
					</label>
					<label class="radio-inline">
						<input name="r_mbsmsuse" type="radio" value="N" />NO
					</label>
				</div>
			</div>
<!-- 			<div class="form-group"> -->
<!-- 				<label class="col-sm-2 control-label" for="answer">보안문자입력</label> -->
<!-- 				<div class="col-sm-10"> -->
<!-- 					<input name="answer"  class="form-control" type="text" /> -->
<%-- 					<img name="captcha" src="<c:url value="/simpleCaptcha.png" />" /><a href="#" onclick="captcharReload();return false;">새로고침</a> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label class="col-sm-2 control-label" for="r_mblevel">레벨</label> -->
<%-- 				<div class="col-sm-10">
					<input name="r_mblevel"  class="form-control" type="text" value="${ model.member.MB_LEVEL }" /> --%>
<!-- 				</div>
			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label class="col-sm-2 control-label" for="r_mbtype">타입</label> -->
<%-- 				<div class="col-sm-10">
					<input name="r_mbtype"  class="form-control" type="text" value="${ model.member.MB_TYPE }" /> --%>
<!-- 				</div>
			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label class="col-sm-2 control-label" for="r_mbuse">사용여부</label> -->
<%-- 				<div class="col-sm-10">
					<input name="r_mbuse"  class="form-control" type="text" value="${ model.member.MB_USE }" /> --%>
<!-- 				</div>
			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label class="col-sm-2 control-label" for="r_mbmoid">수정아이디</label> -->
<%-- 				<div class="col-sm-10">
					<input name="r_mbmoid"  class="form-control" type="text" value="${ model.member.MB_MOID }" /> --%>
<!-- 				</div>
			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label class="col-sm-2 control-label" for="r_mbinid">등록아이디</label> -->
<%-- 				<div class="col-sm-10">
					<input name="r_mbinid"  class="form-control" type="text" value="${ model.member.MB_INID }" /> --%>
<!-- 				</div>
			</div> -->
			<!--<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbmodate">수정일</label>
				<div class="col-sm-10">
					<input name="r_mbmodate"  class="form-control" type="text" "${ fn:substring( model.member.MB_MODATE, 0, 16 ) }" required />
				</div>
			</div>-->
			<!--<div class="form-group">
				<label class="col-sm-2 control-label" for="r_mbindate">등록일</label>
				<div class="col-sm-10">
					<input name="r_mbindate"  class="form-control" type="text" "${ fn:substring( model.member.MB_INDATE, 0, 16 ) }" required />
				</div>
			</div>-->
		</fieldset>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-default" onclick="dataIn();return false;">저장</button>
	    	</div>
		</div>
	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

	<div id="dialog" title="아이디 중복 체크 결과" >
	</div>
	
	</div>
</body>
</html>