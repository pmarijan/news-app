var app = angular.module("news", ['ngSanitize']);

app.controller('list', function($scope, $http) {
    $http.get('/api/news').success(function(data) {
        $scope.newsList = data;
    });
    
    $scope.selectNews = function(item) {
        $scope.selected = item;
        $scope.isNewsSelected = true;
    };
    
    $scope.isSelected = function(section) {
        return $scope.selected === section;
    };
});