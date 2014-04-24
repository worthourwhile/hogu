'use strict';

angular.module('hoguApp')
  .controller('MainCtrl', function ($scope, $http) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];	// TODO what are these for?
  })
  .controller('HoguCtrl', function($scope, $http){
	  $http.get('http://localhost:8080/connect/facebook').
	  	success(function(data){
	  		console.log(data)
			$scope.data = {
				message : data.message
				, isAuthorized : data.isAuthorized
				, friends : data.friends
			}
		});
  })
  .controller('Hello', function ($scope,  $http) {
    $http.get('http://localhost:8080/person/find/MyungKyo').
        success(function(data) {
            $scope.person = data;
        });
  });