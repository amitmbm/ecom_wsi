
  
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
$http.post('http://54.169.190.228:8080/TestWS/api/v1/manage/categories', {name:"from angular",desc: "from angular"}).
  success(function(data, status, headers, config) {
    // this callback will be called asynchronously
    // when the response is available
	
	console.log(data);
	
	$scope.cat=data;
	
  }).
  error(function(data, status, headers, config) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
	console.log(status);
  });

};

});