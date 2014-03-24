'use strict';

angular.module('hoguApp', [
  'ngResource',
  'ngRoute'
])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
	  .when('/hello', {
		templateUrl: 'views/hello.html',
        controller: 'Hello'
	  })
      .otherwise({
        redirectTo: '/'
      });
  });