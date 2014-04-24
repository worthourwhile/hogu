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
	  .when('/hogu', {
        templateUrl: 'views/hogu.html',
        controller: 'HoguCtrl'
      })
      .when('/hello', {
    	  templateUrl: 'views/hello.html',
    	  controller: 'Hello'
      })
      .when('/login', {
    	  templateUrl: 'views/facebook.html',
    	  controller: 'HoguCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });