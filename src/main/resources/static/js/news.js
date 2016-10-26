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

app.controller('news_navigation', function($rootScope, $window, $http) {
    var self = this;
    
    self.logout = function () {
        $http.post('/logout', {}).finally(function () {
            $rootScope.authenticated = false;
            $window.location.href = '/';
//            $location.path("/");
        });
    };
    
    self.admin = function() {
        $window.location.href = '/admin/index.html';
    };
    
    self.home = function() {
        $window.location.href = '/';
    };
    
    var authenticate = function (credentials, callback) {
        var headers = credentials ? {authorization: "Basic "
                    + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('/user', {headers: headers}).then(function (response) {
            if (response.data.name) {
                $rootScope.authenticated = true;
            } else {
                $rootScope.authenticated = false;
            }
            callback && callback();
        }, function () {
            $rootScope.authenticated = false;
            callback && callback();
        });
    };
    
    authenticate();
});