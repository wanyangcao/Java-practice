/*
 * Much of this Javascript is borrowed from the early chapters of another Manning title,
 * Ajax in Action.  Thanks to the authors of that book ( Dave Crane, Eric Pascarello, Darren James )
 * for letting us borrow some Ajax connectivity code.  
 */


var req=null;
var console=null;
var READY_STATE_UNINITIALIZED=0;
var READY_STATE_LOADING=1;
var READY_STATE_LOADED=2;
var READY_STATE_INTERACTIVE=3;
var READY_STATE_COMPLETE=4;

function sendRequest ( url, params, HttpMethod ) {
	
	if ( !HttpMethod ){
		HttpMethod="GET";
	}
	req=initXMLHTTPRequest();	
		
	if ( req ) {
		req.onreadystatechange=onReadyState;
		req.open(HttpMethod, url, true );
		req.setRequestHeader ( "Content-Type", "application/x-www-form-urlencoded");
		req.send (params);
	}
}

function initXMLHTTPRequest(){
	var xRequest=null;
	if (window.XMLHttpRequest) {
		xRequest=new XMLHttpRequest();
	} else if ( window.ActiveXObject ){
		xRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xRequest;
}


function onReadyState() {
	var ready=req.readyState;
	var jsonObject=null;
	
	if ( ready == READY_STATE_COMPLETE ){
			jsonObject=eval( "("+ req.responseText +")" );
		  toFinalConsole ( jsonObject );
	}
}

function toFinalConsole(jsonObject){
  if (console!=null){
    removeAllChildren ( console );
    var div = document.createElement("p");
    var txt=document.createTextNode("Name: " + jsonObject.artist.firstName + " " + jsonObject.artist.lastName );
    div.appendChild ( txt );
    console.appendChild(div);
    
    //mess of Javascript references because we didn't mediate the JSON interpretation of our maps, etc.
    var portfolios = jsonObject.artist.portfolios.entry;
    var portfolioCount = portfolios.length;
    for ( var index = 0;  index < portfolioCount; index++ ) {
    	 var portfolio = portfolios[index];
       txt=document.createTextNode("Portfolio Name: " + portfolio['string']  );
       div = document.createElement("p");
       div.appendChild ( txt );
       console.appendChild(div);
    }
  }
}

function removeAllChildren( node ){
	var childCount = node.childNodes.length;
	for ( var count = 1; count <= childCount; count++) {
		node.removeChild ( node.childNodes[0] );
	}
}

function fetchUser(){
  console=document.getElementById('console');
  var selectBox = document.getElementById('AjaxRetrieveUser_username');
  var selectedIndex = selectBox.selectedIndex;
  var selectedValue = selectBox.options[selectedIndex].value
  sendRequest("AjaxRetrieveUser.action", "username=" + selectedValue , "POST");
}