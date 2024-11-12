
	//---*기본
	var handling = {
		dataAlert : function(msg){
			alert( msg );
		},
		dataAdd : function(){},
		dataIn : function(){},
		dataSearch : function(){},
		dataUp : function(){},
		dataDel : function(){},
		dataEdit : function(){},
		excelDown : function(){},
		dataList : function(){},
		pageMove : function( r_url, param ){
			if( '' == r_url || undefined == r_url ){
				if( '' == param || undefined == param ) $( location ).attr( 'href', '' );
				else $( location ).attr( 'href', ''+'?'+param );
			}else{
				if( '' == param || undefined == param ) $( location ).attr( 'href', r_url );
				else $( location ).attr( 'href', r_url+'?'+param );
			}
		},
		submit : function( fName, r_url ){
			if( '' == fName || undefined == fName ) frmObj = $( 'form[name="frm"]' ); 
			else frmObj = $( 'form[name="'+fName+'"]' );
			if( '' == r_url || undefined == r_url) frmObj.submit();
			else frmObj.attr( 'action', r_url ).submit();
//			else $( frmObj ).attr( 'action', r_url ).submit();
		}
	};
	//---기본
	
	
	//---*문자열관련
	var strFn = {
		delLastDelim : function( data, delim ){
			return data.substring(0, data.lastIndexOf(delim) );
		},
		splitDelim : function( data, delim ){
			return data.split(delim);
		},
		delDelim : function(data, delim){
			return data.replace(eval('/'+delim+'/gi'), '');
		},
	};
	//---문자열관련
	
	
	//---*생성관련
	var createHandling = {
		popup : function(r_url, param, name, option){
			if( '' == option ){
				option = 'toolbar=no, location=no, status=yes, menubar=no, scrollbars=yes, resizable=yes, width=400, height=300';
			}
			window.open(r_url+'?'+param, name, option);
		},
	};
	//---생성관련