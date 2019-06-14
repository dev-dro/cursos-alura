angular.module('alurapic').controller('FotoController', function ($scope, $http, $routeParams, recursoFoto, cadastroDeFoto) {
    $scope.mensagem = '';
    $scope.foto = {};

    if ($routeParams.fotoId) {
        recursoFoto.get({fotoId: $routeParams.fotoId},
            function (foto) {
                $scope.foto = foto;
            },
            function (erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter a foto.';
            });
    }

    $scope.submeter = function () {
        if ($scope.formulario.$valid) {
            cadastroDeFoto.cadastrar($scope.foto)
                .then(function (resposta) {
                    $scope.mensagem = resposta.mensagem;

                    if (resposta.inclusao) {
                        $scope.foto = {};
                        $scope.formulario.$setPristine();
                    }
                })
                .catch(function (resposta) {
                    $scope.mensagem = resposta.mensagem;
                })
        }
    };
});