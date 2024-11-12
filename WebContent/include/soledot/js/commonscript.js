/*
 * 
 * 
 * add = 추가
 * del = 삭제
 * edit = 수정
 * set = 값대입
 * get = 값출력
 * ch = 변경
 * on = 활성
 * off = 비활성
 * yn = 참거짓
 * ck = 체크
 * to = 변환
 */
	
	
	
	/*** 데이터 변환 ***/
	//---구분자로 배열 리턴
	function dataSplit(data,delim)
	{
		var strarr = data.split(delim);
		return strarr;
	}
	//----txt에서 delim 마지막 문자 제거
	function dataDelLastDelim(data,delim)
	{
		data = data.substring(0, data.lastIndexOf(delim) );
		return data;
	}
	//특정 자리수마다 기호찍기		
	function dataToDelim(data,datalen, delim)
	{
		var tempdata = '';
		data = data.replace(eval('/'+delim+'/gi'),'');		//delim제거
		if( data.length < datalen ) return data;				//원하는 숫자보다 작을 경우 그대로 리턴
		for( var i = data.length-1; i > -1 ; i-- )			//--거꾸로 정렬
		{		
			tempdata += data[i];
		}
		data='';
		for( var i = 0; i < tempdata.length; i++ )			//---특정 자리마다 delim찍어주기
		{		
			data += tempdata[i];
			if( i > 0 && (i+1) % datalen == 0 ) data+=delim;
		}
		if( data.length-1 == data.lastIndexOf(delim) )		//----delim이 앞에 찍히지 않게 처리
		{		
			data = data.substring(0, data.lastIndexOf(delim));
		}
		tempdata='';
		for( var i = data.length-1; i > -1 ; i-- )			//다시 정렬
		{			
			tempdata += data[i];
		}
		///substr로도 한 번 만들어 봐야함...
		return tempdata;
	}
	/*** 데이터 변환 ***/
	
	
	/*** input 관련 ***/
	//---input이름값으로 focus주기
	function focusOn(pobj)
	{
		pobj.focus();
	}
	/*** input 관련 ***/
	
	
	/*** 체크박스 관련 ***/
	//-----전체 체크,해제
	function checkAll( pobj, ckval )
	{
		for( var i = 0; i < pobj.length; i++ ){
			pobj[i].checked=ckval;
		}
	}
	//----선택 된 값 가져오기
	function checkValue( pobj, delim ){
		var txt = '';
		for( var i = 0; i < pobj.length; i++ )
		{
			if( pobj[i].checked )
			{
				txt += pobj[i].value+delim;
			}
		}
		return txt;
	}
	/*** 체크박스 관련 ***/
	
	/*** 셀렉트박스 관련 ***/
	//---셀렉트 박스 옵션 추가
	function optionAdd(pobj, opval, optxt)
	{
		
		var op = new Option();
		op.value = opval;
		op.text = optxt;
		pobj.options.add(op);
		
		//방법2
	//	var opobj = document.createElement('option');
	//	opobj.setAttribute('value',opval);
	//	var optext = document.createTextNode(optxt);
	//	opobj.appendChild(optext);
	//	pobj.appendChild(opobj);
		
		//방법3
	//	var opobj = document.createElement('option');
	//	opobj.value = opval;
	//	opobj.text = optxt;
	//	pobj.options.add(opobj);
		
		
	}
	/*** 셀렉트박스 관련 ***/
	
	
	
	//팝업 만들기
	function createPopUp(url, params, name, option)
	{
		window.open(url+'?'+params, name, option);
	}
	
	
	
	/****** 날짜 관련   *********/
	//---오늘 날짜 10자리로 가져옴.
	function getToday10(delim)
	{
	//	var today = new Date(2012,1,15);
		
		var todate = new Date();
		var yyyy = todate.getFullYear();
		var mm = todate.getMonth()+1;
		var dd = todate.getDate();
		
		if( mm < 10 ) mm = '0'+mm;			//달이 10보다 작을 경우 앞에0을 붙여줌.
		if( dd < 10 ) dd = '0'+dd;			//날짜이 10보다 작을 경우 앞에0을 붙여줌.
		
		return yyyy+delim+mm+delim+dd;
	}
	
	//----현재시간
	function getNowTime(){
		var todate = new Date();
		var gethour = todate.getHours();
		var getminute = todate.getMinutes();
		var getsecond = todate.getSeconds();
		
		alert( gethour+':'+getminute+':'+getsecond);
	}
	/****** 날짜 관련   *********/
	
	
	/****** null 또는 공백 관련   *********/
	//---공백이면 true 리턴
	function ckBlank(txt)
	{
		if( txt == '' ) return true;
	}
	//---공백이면 0리턴
	function blankToZero(txt)
	{
		if( txt == '' ) return 0;
	}
	
	//---null 일경우 true
	function nullCheck(txt)
	{
		if( txt == 'null' || txt == '' ) return true;
	}
	
	//---null이면 공백리턴
	function nullToBlank(txt)
	{
		if( txt == 'null' ) return '';
	}
	
	//---null이면 0리턴
	function nullToZero(txt)
	{
		if( txt == 'null' ) return 0;
	}
	/****** null 또는 공백 관련   *********/

	
	//---서브밋 함수(post방식)
	function formPostSubmit( f_name, url ){
		var frmobj = '';
		
		if( '' == f_name ){
			frmobj = $( 'form[name="frm"]' ); 
		}else{
			frmobj = $( 'form[name="'+f_name+'"]' );
		}
		
		if( url == '' ){
			frmobj.submit();
		}else{
			frmobj.attr( 'action', url ).submit();
		}
	}
	
	//---서브밋 함수(get방식)
	function formGetSubmit( url, params ){
		$( location ).attr( 'href', url+'?'+params );
	}
	
	//---* moveUrl
	function moveUrl( f_name, url, r_mnseq ){
		
		//---* post
//		$( 'input[name="r_mnseq"]' ).val( r_mnseq );
//		formPostSubmit( f_name, url );
		
		//---* get
		formGetSubmit( url, 'r_mnseq='+r_mnseq );
	}
	
