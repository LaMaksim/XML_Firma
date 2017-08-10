(function(){
    var mainModule = angular.module('FirmModule',['ngResource','ngRoute','ngAnimate', 'ngSanitize', 'ui.bootstrap','LocalStorageModule','ToastrWrapperModule','FakturaNovaModule','FaktureSveModule','PresekModule']);

    angular.module('FirmModule').controller('FirmController',['$scope','$log','$resource',function($scope,$log,$resource){

        var firmaResource = $resource("/firme/:id");
        firmaResource.query().$promise.then(function ssuccesFirm(data, status) {
            var firme = data;
            var ja;
            firme.forEach(function (firma) {
                if(firma.ja){
                   ja = firma;
                }
            });
            $scope.$root.user = ja;
            var idx = firme.indexOf(ja);
            firme.splice(idx,1);
            $scope.$root.partners = firme;

        },function errorFirm(data, status) {
            $log.log('imamo problem pri ucitavanju');
        });





    }]);

})();