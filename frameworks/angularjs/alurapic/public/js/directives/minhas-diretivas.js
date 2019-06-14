angular.module('minhasDiretivas', [])
    .directive('meuPainel', function () {

        var ddo = {};

        ddo.templateUrl = 'js/directives/meu-painel.html';
        ddo.restrict = 'AE';
        ddo.transclude = true;
        ddo.scope = {
            titulo: '@'
        };

        return ddo;

    })
    .directive('minhaFoto', function () {

        var ddo = {};

        ddo.templateUrl = 'js/directives/minha-foto.html';
        ddo.restrict = 'AE';
        ddo.transclude = true;
        ddo.scope = {
            url: '@',
            titulo: '@'
        };

        return ddo;

    })
    .directive('meuBotaoPerigo', function () {
        var ddo = {};

        ddo.template = '<button class="btn btn-danger btn-block" ng-click="acao()">{{nome}}</button>';
        ddo.restrict = 'AE';
        ddo.transclude = true;
        ddo.scope = {
            nome: '@',
            acao: '&'
        };

        return ddo;
    })
    .directive('focus', function () {
        var ddo = {};

        ddo.restrict = 'A';
        ddo.link = function (scope, element) {
            scope.$on('fotoCadastrada', function () {
                element[0].focus();
            });
        };

        return ddo;
    });