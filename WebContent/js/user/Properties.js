var URIConfiguration = {
	'PROTOCOL' : 'http',
	'DOMAIN_NAME' : 'localhost',
	'PORT_NUMBER' : '8765',
	'PROJECT_NAME' : 'FactBox'
}

var getURI = function(){
	var URL = URIConfiguration.PROTOCOL + "://" + URIConfiguration.DOMAIN_NAME + ":" + URIConfiguration.PORT_NUMBER + "/" + URIConfiguration.PROJECT_NAME + "/api/";
	return URL;
}