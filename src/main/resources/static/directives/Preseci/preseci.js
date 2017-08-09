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