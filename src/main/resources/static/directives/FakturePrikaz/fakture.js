/**
 * Created by maksim on 06-Jun-17.
 */
/**
 * Created by maksim on 31-May-17.
 */
(function() {
    "use strict";
    var modul = angular.module("FaktureSveModule", ['UplatnicaModule']);

    var FaktureAllController = function ($scope, $log,$resource,ToastrWrapper,$uibModal) {
        var faktureResource = $resource("fakture/:id");
        $scope.fakture = faktureResource.query();

        $scope.uplatnicaDialogShow = function (faktura) {
            var modalInstance = $uibModal.open({
                animation: true,
                templateUrl: 'directives/Uplatnica/uplatnica.html',
                size: 'lg',
                controller: 'UplatnicaController',
                controllerAs : 'uplatnicaCtrl',
                resolve :{
                    faktura : faktura
                }
            });
            modalInstance.result.then(function (result) {
                var idx = $scope.fakture.indexOf(faktura);
                $scope.fakture.splice(idx,1);
            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });

        };


    };
    FaktureAllController.$inject = ['$scope', '$log','$resource','ToastrWrapper','$uibModal'];



    angular.module("FaktureSveModule").directive("faktureSveDirective", function () {
        var directive = {};
        directive.restrict = 'EA';
        directive.templateUrl = 'directives/FakturePrikaz/fakture.html';
        directive.controller = FaktureAllController;
        directive.controllerAs = 'faktureCtrl';
        directive.scope = {};
        return directive;
    });
})();