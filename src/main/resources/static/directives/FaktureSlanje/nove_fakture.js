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