angular.module('news', [])
    .controller('home', function($scope, $http) {
        $http.get('/api/news/1').success(function(data) {
            $scope.news = data;
        })
});