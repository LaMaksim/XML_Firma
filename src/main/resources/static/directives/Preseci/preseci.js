/**
 * Created by maksim on 06-Jun-17.
 */
/**
 * Created by maksim on 31-May-17.
 */
(function() {
    "use strict";
    var modul = angular.module("PresekModule", []);

    var PreseciController = function ($scope, $log,$resource,ModalsFactory) {
        var datepickers = {};
        datepickers.minDatepicker = {};
        datepickers.maxDatepicker = {};
        $scope.datepickers = datepickers;
        var maxDay = new Date();
        maxDay.setHours(0,0,0,0);
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

        $scope.search = function(){
            var dto = {};
            dto.datum = $scope.izvodDate;
            dto.brojRacuna = "to do";
            dto.rbrPreseka = -1;
        }



    };
    PreseciController.$inject = ['$scope', '$log','$resource','ToastrWrapper'];



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