(function(){
    var mainModule = angular.module('FirmModule',['ngResource','ngRoute','ngAnimate', 'ngSanitize', 'ui.bootstrap','LocalStorageModule','ToastrWrapperModule','FakturaNovaModule','FaktureSveModule','PresekModule']);

    angular.module('FirmModule').controller('FirmController',['$scope','$log','$resource',function($scope,$log,$resource){
        $scope.hello = true;


    }]);

})();