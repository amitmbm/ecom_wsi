
  
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
  "desc" : "tablet related Ads" ,
  "price" : 810,
  "subcat_id" : "1a8378b9-fc6f-46cf-a15c-bf12617e8657" ,
  "type_id" : "def2e3de-fe4f-4e1c-bc96-23e2ca08bb04" ,
  "is_negotiable" : true ,
  "mailid" : "amitmbm87@gmail.com"
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