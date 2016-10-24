var app = angular.module("news", []);

app.controller('home', function($scope, $http) {
    $http.get('/api/news/1').success(function(data) {
        $scope.news = data;
    });
});

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

//app.controller('content', function($scope) {
//    $scope.selectNews = function(item) {
//        $scope.selected = item;
//    }();
//});