fact.controller("factController", function($scope,$route, $http,$routeParams) {
	
		$scope.factForm = {};
		$scope.factForm1 = {};
		$scope.factForm.list = null;
		$scope.factForm.category = null;
		$scope.factForm.pieData=null;
		$scope.factForm1.list = null;
		$scope.factForm1.Newlist = null;
		$scope.factForm1.Randomlist = null;
		$scope.factForm1.category = null;
		
		$scope.init = function(){	
			
			$scope.factForm1.getFacts(); 
			$scope.factForm.getPieData();
		};
		
		 
		 $scope.$on('$routeChangeSuccess', function(event,next, current) { 
			   //... you could trigger something here ...
			 //console.log("ghh");
			 var str = next.params.value;
			 if (str=="BIOLOGY")
			    {
			    document.body.style.background="#ff4d88";
			   	}
		     else if (str=="CHEMISTRY")
			    {
			    document.body.style.background="#1aff8c";
			   	}
			 else if (str=="MATHS")
				{
				document.body.style.background="#884dff";
				}
			 else if (str=="PHYSICS")
				{
				document.body.style.background="#00cccc";
				}
			 else if (str=="SCIENTIST")
				{
				document.body.style.background="#ffb84d";
				}
			 else if (str=="WWII")
				{
				document.body.style.background="#ff944d";
				}
			 else if (str=="Home")
				{
				document.body.style.background="#222222";
				}

			 });
		
		
	$scope.factForm.getCategoryList = function() {
		
				
		var responsePromise = $http.get(URI + "FactAPI" + "/distinctCategory");

		responsePromise.then(function(response) {
			$scope.factForm.list = response.data;
			// console.log($scope.factForm.list);
		}, function(response) {
			$scope.factForm.list = null;
		});

	};
	
	
	$scope.factForm.getPieData=function(){
		//alert("ss")
		var responsePromise=$http.get(URI+"FactAPI"+"/countFacts");
		responsePromise.then(function(response){
			$scope.factForm.pieData=response.data;
		},function(response){
			$scope.factForm.pieData=null;
		});
		
	};
	
    
	$scope.factForm1.getFacts = function() {
		$scope.factForm1.category=$routeParams.value;
		$scope.factForm.category=$routeParams.value;
		//alert($scope.factForm.category);		
		
		var responsePromise = $http.get(URI + "FactAPI" + "/category/"+$routeParams.value);
		responsePromise.then(function(response) {
			$scope.factForm1.list = response.data;
			
			
			$scope.factForm1.Newlist=response.data;
			s=$scope.factForm1.Newlist.length;
			
			 var x = Math.floor((Math.random() *(s-1)) + 0);
			
			$scope.factForm1.Randomlist=$scope.factForm1.Newlist[x];
				
		}, function(response) {
			$scope.factForm1.list = null;

		});
	};
	
	$scope.init();

});