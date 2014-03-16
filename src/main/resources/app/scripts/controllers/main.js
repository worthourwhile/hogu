'use strict';

angular.module('hoguApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  })
  .controller('Hello', function ($scope,  $http) {
    $http.get('http://localhost:8080/person/find/MyungKyo').
        success(function(data) {
            $scope.person = data;
        });
  });