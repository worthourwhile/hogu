'use strict';

angular.module('hoguApp')
  .controller('MainCtrl', function ($scope, $http) {
    
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
  })
  .controller("PayCtrl", function($scope) {
  var payManList = $scope.manList = [];
  var payMoneyList = $scope.payList = [];
    $scope.addMan = function(name) {
      var man = {name:name, pay:0, pays:[]};
      for (var i=0;i<payMoneyList.length;i++) {
        man.pays.push({attend:false});
      }
      payManList.push(man);
      calc();
    }

    $scope.addPay = function(item) {
      payMoneyList.push(item);
        for (var i=0;i<payManList.length;i++) {
          payManList[i].pays.push({attend:false});
        }
        calc();
    }

    var calc = $scope.calcAll = function() {

      var payCount = [];
      $scope.totalMoney = 0;

      for (var a=0;a<payMoneyList.length;a++) {
        payCount.push(0);
        $scope.totalMoney +=payMoneyList[a];
      }

     for (var i=0; i<payManList.length; i++) {
        console.log(payManList[i]);
        if (!payManList[i].pays) {
          continue;
        }

        for (var j=0;j<payManList[i].pays.length;j++) {
          if (payManList[i].pays[j].attend == true) {
            payCount[j] += 1;
          }
        }
     }

     for (var k=0;k<payManList.length;k++) {
      payManList[k].pay = 0;
      if (!payManList[k].pays) {
          continue;
        }
      for (var l=0;l<payManList[k].pays.length;l++) {
        if (payManList[k].pays[l].attend == true) {
          payManList[k].pay += Math.floor(payMoneyList[l] / payCount[l]);
        }
      }
     }

       
      console.log("paycount : " + payCount);
      

    }


  });