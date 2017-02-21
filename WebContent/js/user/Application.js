var URI = getURI();



// -----------------------REGISTERING THE APPLICATION AND DEPENDENCIES-----------------------

var fact = angular.module("Application", ['ngRoute','chart.js']);

fact.config(function($httpProvider) {
	$httpProvider.defaults.headers.post['Content-Type'] = "application/json; charset=UTF-8";
	$httpProvider.defaults.headers.post['Data-Type'] = "json";
});


// ----------------------CONFIGURING THE APPLICATION------------------------

fact.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/getFacts/:value', {
		templateUrl : 'GetFacts.html',
		controller : 'factController'
	}).when('/:value', {
		templateUrl : 'Home.html',
		controller :'factController'
	}).otherwise({
		redirectTo : '/Home'
	});
} ]);

