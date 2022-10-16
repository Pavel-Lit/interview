angular.module('crud', []).controller('indexController', function ($scope, $http) {
    $scope.fillTable = function () {
        $http.get('http://localhost:8081/interview/api/v1/student')
            .then(function (response) {
                $scope.students = response.data;
                // console.log(response);
            });
    };

    $scope.deleteStudent = function (id) {
        $http.delete('http://localhost:8081/interview/api/v1/student/' + id)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.createNewStudent = function () {
        // console.log($scope.newProduct);
        $http.post('http://localhost:8081/interview/api/v1/student', $scope.newStudent)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            });
    }

    $scope.updateSomeStudent = function (){
        $http.put('http://localhost:8081/interview/api/v1/student/update', $scope.updateStudent)
            .then(function (response) {
                $scope.updateStudent = null;
                $scope.fillTable();
            })
    }

    $scope.fillTable();
});