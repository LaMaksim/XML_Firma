/**
 * Created by maksim on 06-Jun-17.
 */
/**
 * Created by maksim on 31-May-17.
 */
(function() {
    "use strict";
    var modul = angular.module("UplatnicaModule", []);

    var UplatnicaController = function ($scope, $log,$http,ToastrWrapper,$uibModalInstance) {
        var $ctrl = this;


        $scope.ok = function () {
            // var targetPort;
            // var pib = $scope.$resolve.faktura.dobavljacPIB;
            // $scope.$root.partners.forEach(function (partner) {
            //    if(partner.pib == pib){
            //        targetPort = partner.port;
            //    }
            // });

            var targetUrl = "fakture/"+$scope.$resolve.faktura.id;
            $http({
                url:targetUrl,
                method:'POST',
                data:$scope.uplatnica
            }).then(function successUplatnica(response) {
                ToastrWrapper.toaster('success','Uplatnica je poslata');
                $uibModalInstance.close();
            },function errorUplatnica(response) {
                ToastrWrapper.toaster('error','Nije moguce izvrsiti uplacivanje');
                $uibModalInstance.dismiss();
            });

        };

        $scope.cancel = function () {
            $uibModalInstance.dismiss();
        };
        $scope.currDate = new Date();

        $scope.uplatnica = {
            duznikNaziv : $scope.$root.user.naziv +"\r\n"+$scope.$root.user.adresa,
            duznikRacun: $scope.$root.user.brojRacuna,
            primalacNaziv: $scope.$resolve.faktura.dobavljacNaziv +"\r\n"+$scope.$resolve.faktura.dobavljacAdresa,
            racunPoverioca : $scope.$resolve.faktura.dobavljacRacun,
            datumValute :new Date,
            datumUplate : new Date(),
            oznakaValute : "DIN",
            iznos : $scope.$resolve.faktura.vrednost
        };





    };
    UplatnicaController.$inject = ['$scope', '$log','$http','ToastrWrapper','$uibModalInstance'];
    modul.controller('UplatnicaController',UplatnicaController);



    angular.module("UplatnicaModule").directive("uplatnicaModalDirective", function () {
        var directive = {};
        directive.restrict = 'EA';
        directive.templateUrl = 'directives/Uplatnica/uplatnica.html';
        directive.controller = UplatnicaController;
        directive.controllerAs = 'uplatnicaCtrl';
        directive.scope = {};
        return directive;
    });
})();