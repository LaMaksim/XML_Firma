/**
 * Created by maksim on 06-Jun-17.
 */
/**
 * Created by maksim on 31-May-17.
 */
(function() {
    "use strict";
    var modul = angular.module("FakturaNovaModule", []);

    var FakturaNovaController = function ($scope, $log,$resource,ModalsFactory) {

        $scope.setupItem = function(){
            $scope.novaStavka = {};
            $scope.novaStavka.vrsta = 'roba';
            $scope.novaStavka.kolicina = 0;
            $scope.novaStavka.jedinicnaCena = 0;
            $scope.novaStavka.iznosRabata = 0;
        };
        $scope.setupTicket = function () {
            $scope.setupItem();

            $scope.novaFaktura = {};
            $scope.novaFaktura.stavke = [];
            $scope.novaFaktura.datumValute = new Date();
            $scope.novaFaktura.datumRacuna = new Date();
            $scope.novaFaktura.rbrRacuina = Math.floor(Math.random()*100000);
            $scope.novaFaktura.oznakaValute = "RSD";

            $scope.currPartner = null;

        }

        $scope.newTicket = function () {
            $scope.novaFaktura.kupacNaziv = $scope.currPartner.naziv;
            $scope.novaFaktura.kupacAdresa = $scope.currPartner.adresa;
            $scope.novaFaktura.kupacPIB = $scope.currPartner.pib;

            $scope.novaFaktura.dobavljacNaziv = $scope.$root.user.naziv;
            $scope.novaFaktura.dobavljacAdresa = $scope.$root.user.adresa;
            $scope.novaFaktura.dobavljacPIB = $scope.$root.user.pib;

            $scope.novaFaktura.vrednostRobe = $scope.fakturaVrednostSegmenta("roba");
            $scope.novaFaktura.vrednostUsluga = $scope.fakturaVrednostSegmenta("usluga");
            $scope.novaFaktura.vrednostUkupno = $scope.fakturaVrednostUkupno();
            $scope.novaFaktura.vrednostRabat = $scope.fakturaVrednostRabat();
            $scope.novaFaktura.vrednostPorez = -1;
            $scope.novaFaktura = $scope.fakturaUkupno();


            $scope.setupTicket();
        };
        $scope.newTicket();

        $scope.newItem = function () {
          $scope.novaStavka.vrednost = $scope.stavkaVrednost($scope.novaStavka);
          $scope.novaStavka.procenatRabata = $scope.stavkaProcenatRabata($scope.novaStavka);
          $scope.novaStavka.umanjenoZaRabat = $scope.stavkaUmanjenoRabatom($scope.novaStavka);
          $scope.novaFaktura.stavke.push($scope.novaStavka);

          $scope.setupItem();

        };

        $scope.remove = function(item){
            var idx = $scope.novaFaktura.stavke.indexOf(item);
            $scope.novaFaktura.stavke.splice(idx,1);
        };


        $scope.stavkaVrednost = function(stavka){
            if(!stavka.kolicina || !stavka.jedinicnaCena){
                return 0;
            }
            return parseFloat((stavka.kolicina*stavka.jedinicnaCena).toFixed(2));
        };
        $scope.stavkaProcenatRabata = function (stavka) {
          return parseInt((stavka.iznosRabata/stavka.vrednost)*100);
        };
        $scope.stavkaUmanjenoRabatom = function(stavka){
            var umanjenoZa = stavka.iznosRabata?stavka.iznosRabata:0;
            return $scope.stavkaVrednost(stavka)-umanjenoZa;
        };
        $scope.fakturaVrednostSegmenta = function (tip) {
            var sum = 0;
            $scope.novaFaktura.stavke.forEach(function (stavka) {
               if(stavka.vrsta===tip){
                   sum+=$scope.stavkaVrednost(stavka);
               }
            });
            return sum;
        };
        $scope.fakturaVrednostUkupno = function () {
            return $scope.fakturaVrednostSegmenta("roba") + $scope.fakturaVrednostSegmenta("usluga");
        };
        $scope.fakturaVrednostRabat = function(){
            var sum = 0;
            $scope.novaFaktura.stavke.forEach(function (stavka) {
                sum += stavka.iznosRabata;
            });
            return sum;
        };
        $scope.fakturaUkupno = function () {
            return $scope.fakturaVrednostUkupno() - $scope.fakturaVrednostRabat();
        }


    };
    FakturaNovaController.$inject = ['$scope', '$log','$resource','ToastrWrapper'];



    angular.module("FakturaNovaModule").directive("fakturaNovaDirective", function () {
        var directive = {};
        directive.restrict = 'EA';
        directive.templateUrl = 'directives/FaktureSlanje/nove_fakture.html';
        directive.controller = FakturaNovaController;
        directive.controllerAs = 'fakturaNovaCtrl';
        directive.scope = {};
        return directive;
    });
})();