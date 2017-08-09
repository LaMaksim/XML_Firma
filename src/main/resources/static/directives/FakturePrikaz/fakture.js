/**
 * Created by maksim on 06-Jun-17.
 */
/**
 * Created by maksim on 31-May-17.
 */
(function() {
    "use strict";
    var modul = angular.module("FaktureSveModule", ['UplatnicaModule']);

    var FaktureAllController = function ($scope, $log,$resource,ModalsFactory) {



    };
    FaktureAllController.$inject = ['$scope', '$log','$resource','ToastrWrapper'];



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