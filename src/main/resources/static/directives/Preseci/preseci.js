/**
 * Created by maksim on 06-Jun-17.
 */
/**
 * Created by maksim on 31-May-17.
 */
(function() {
    "use strict";
    var modul = angular.module("PresekModule", []);

    var PreseciController = function ($scope, $log,$http,ToastrWrapper) {
        var datepickers = {};
        datepickers.minDatepicker = {};
        datepickers.maxDatepicker = {};
        $scope.datepickers = datepickers;
        var maxDay = new Date();
        // maxDay.setHours(0,0,0,0);
        /// min datepicker
        datepickers.format = 'dd.MM.yyyy';
        datepickers.dateOptions = {
            maxDate : maxDay,
            // maxDate: new Date(2020, 5, 22),
            showWeeks : true,
            startingDay : 1,
            popupPlacement : 'bottom-right',
            showButtonBar : false
        };
        datepickers.opened = false;
        datepickers.value = maxDay;
        datepickers.open = function () {
            $scope.datepickers.opened = true;
        };


        var adjstDate = function (dst) {
            var src = new Date();
            dst.setHours(src.getHours(),src.getMinutes(),src.getSeconds(),src.getMilliseconds());
            return dst;
        }


        // $scope.rbrPreseka = 18;
        $scope.search = function(){
            $scope.rbrPreseka = 0;
            $scope.pages = [];
            $scope.presek = null;
            $scope.currentPage = 1;

            $scope.dto = {};
            $scope.dto.datum = adjstDate($scope.izvodDate);
            $scope.dto.brojRacuna = $scope.$root.user.brojRacuna;
            // dto.rbrPreseka = -1;

            getSubQuery();
        }

       var getSubQuery = function(){
            $scope.dto.rbrPreseka = $scope.rbrPreseka+1;

            $http({
                method:"POST",
                data:$scope.dto,
                url:'/presek'
            }).then(
                function successIzvodi(response) {

                    // ako je nemamo inicijalizovan header
                    if($scope.presek==null){
                        $scope.presek = response.data;
                    }

                    // ako trebamo uci dalje u rekurziju
                    if( response.data.stavke.length>0){
                        $scope.pages[$scope.rbrPreseka] = response.data.stavke;
                        $scope.rbrPreseka++;
                        getSubQuery();
                    }


                }, function errorIzvodi(response) {
                    ToastrWrapper.toaster('error','Ne mozemo ucitati izvode za zeljeni dan.')
                }
            )

        }



    };
    PreseciController.$inject = ['$scope', '$log','$http','ToastrWrapper'];



    angular.module("PresekModule").directive("preseciDirective", function () {
        var directive = {};
        directive.restrict = 'EA';
        directive.templateUrl = 'directives/Preseci/preseci.html';
        directive.controller = PreseciController;
        directive.controllerAs = 'preseciCtrl';
        directive.scope = {};
        return directive;
    });
})();