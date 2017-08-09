/**
 * Created by maksim on 06-Jun-17.
 */
/**
 * Created by maksim on 31-May-17.
 */
(function() {
    "use strict";
    var modul = angular.module("UplatnicaModule", []);

    var UplatnicaController = function ($scope, $log,$resource,ModalsFactory) {



    };
    UplatnicaController.$inject = ['$scope', '$log','$resource','ToastrWrapper'];



    modul.directive("uplatnicaModalDirective", function () {
        var directive = {};
        directive.restrict = 'EA';
        directive.templateUrl = 'directives/Uplatnica/uplatnica.html';
        directive.controller = UplatnicaController;
        directive.controllerAs = 'uplatnicaCtrl';
        directive.scope = {};
        return directive;
    });
})();