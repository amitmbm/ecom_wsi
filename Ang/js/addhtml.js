
  
var app=angular.module('demoApp', ['ngRoute']);

app.config(['$httpProvider', function($httpProvider) {
$httpProvider.defaults.withCredentials = false;
$httpProvider.defaults.useXDomain = true;
delete $httpProvider.defaults.headers.common['X-Requested-With'];
}
]);




app.controller('demoController', function($scope,$http) {

$scope.callService = function(){

// Simple POST request example (passing data) :
$http.post('http://localhost:9090/TestWS/api/v1/data/postadd', 
{
   "desc" : $scope.inputData.desc,
   "price" : $scope.inputData.price, 
  "subcat_id" :  $scope.inputData.subcat_id,
  "type_id" :  $scope.inputData.type_id,
  "mailid" : $scope.inputData.mailid
}).
  success(function(data, status, headers, config) {
    // this callback will be called asynchronously
    // when the response is available
	
	console.log(data);
	
	$scope.add=data;
	
  }).
  error(function(data, status, headers, config) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
	console.log(status);
  });

};

});


app.controller('loginController', function($scope,$http) {

$scope.callService = function(){
alert("test");
// Simple POST request example (passing data) :
$http.get('http://localhost:9090/TestWS/api/v1/manage/categories/4ab18d32-6906-45f4-be49-9ddda54398fa', 
{
   "username" : $scope.inputData.username,
   "password" : $scope.inputData.password
}).
  success(function(data, status, headers, config) {
    // this callback will be called asynchronously
    // when the response is available
	
	console.log(data);
	alert(data);
	$scope.add=data;
	
  }).
  error(function(data, status, headers, config) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
	alert(status);
	console.log(status);
  });

};

});


app.controller('addCatController', function($scope,$http) {

$scope.callService = function(){
alert("test");
// Simple POST request example (passing data) :
$http.post('http://localhost:9090/TestWS/api/v1/manage/categories', 
{
   "name" : $scope.inputData.name,
   "desc" : $scope.inputData.desc
}).
  success(function(data, status, headers, config) {
    // this callback will be called asynchronously
    // when the response is available
	
	console.log(data);
	alert(data);
	$scope.add=data;
	
  }).
  error(function(data, status, headers, config) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
	alert(status);
	console.log(status);
  });

};

$scope.callService1 = function(){
 
 var responsePromise = $http.get("http://localhost:9090/TestWS/api/v1/manage/categories/");

 //var responsePromise = $http.get("http://api.geonames.org/earthquakesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&username=demo ");

    responsePromise.success(function(data, status, headers, config) {
       // alert(JSON.stringify(data));
	   $scope.data2=data;
		console.log(JSON.stringify(data));
    });
	
	
    responsePromise.error(function(data, status ,headers ,config) {
        //alert("failure"+"data"+data+"status"+status+"headers"+ headers+"config"+JSON.stringify(data));
		
		console.log("failure"+"data"+data+"status"+status+"headers"+ headers+"config"+JSON.stringify(data));
});
};


});


app.controller('addSubCatController', function($scope,$http) {

$scope.callService = function(){
alert("test");
// Simple POST request example (passing data) :
$http.post('http://localhost:9090/TestWS/api/v1/manage/categories', 
{
   "name" : $scope.inputData.name,
   "desc" : $scope.inputData.desc
}).
  success(function(data, status, headers, config) {
    // this callback will be called asynchronously
    // when the response is available
	
	console.log(data);
	alert(data);
	$scope.add=data;
	
  }).
  error(function(data, status, headers, config) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
	alert(status);
	console.log(status);
  });

};

});



app.controller('addSubCatTypeController', function($scope,$http) {

$scope.callService = function(){
alert("test");
// Simple POST request example (passing data) :
$http.post('http://localhost:9090/TestWS/api/v1/manage/categories', 
{
   "name" : $scope.inputData.name
}).
  success(function(data, status, headers, config) {
    // this callback will be called asynchronously
    // when the response is available
	
	console.log(data);
	alert(data);
	$scope.add=data;
	
  }).
  error(function(data, status, headers, config) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
	alert(status);
	console.log(status);
  });

};

});