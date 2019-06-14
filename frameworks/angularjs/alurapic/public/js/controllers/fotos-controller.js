angular.module('alurapic').controller('FotosController', function ($scope, $http, recursoFoto) {

    $scope.mensagem = '';
    $scope.filtro = '';
    $scope.fotos = [];

    recursoFoto.query(
        function (fotos) {
            $scope.fotos = fotos;
        },
        function (erro) {
            console.log(erro);
        });

    $scope.remover = function (foto) {
        recursoFoto.delete({fotoId: $scope.foto._id},
            function () {
                var indexFoto = $scope.fotos.indexOf(foto);
                $scope.fotos.splice(indexFoto, 1);
                $scope.mensagem = 'Foto ' + foto.titulo + ' excluída com sucesso';
            },
            function (erro) {
                console.log(erro);
                $scope.mensagem = 'Erro ao excluir foto ' + foto.titulo + '.';
            });
    }
});