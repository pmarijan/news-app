var app = angular.module("admin", ['ngSanitize']);

app.controller('adminNews', function($scope, $http) {
    
    $scope.categoriesList = function() {
        $http.get('/api/categories').success(function(data) {
            console.log(data);
            $scope.categories = data;
        });
    };
    
    $scope.getNewsList = function() {
            $http.get('/api/news').success(function(data) {
            $scope.newsList = data;
        });
    };

    $scope.create = function(data) {
        var item = JSON.stringify({"title":data.title, "category":data.category, "text":data.text});
        console.log(item);
        
        var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        
        $http.post('/api/news', item, config)
            .then(
                function(response) {
                    //function executed successfully
                    if(response.data && response.status === 200) {
                        $scope.createResponse = "News created successfully.";
                        $scope.getNewsList();
                        $scope.clearNews(data);
                    } else {
                        $scope.createResponse = "Warning: " + response.status + ", " + response.statusText;
                    }
                },
                function(response) {
                    //error
                    $scope.createResponse = "News creation failed: " + response.status + ", " + response.statusText;
                }
            );
    };
    
    $scope.update = function(item) {
        var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        
        $http.put('/api/news/' + item.id, JSON.stringify(item), config)
            .then(
                function(response) {
                    //function executed successfully
                    if(response.data && response.status === 200) {
                        $scope.updateResponse = "Update successfull.";
                    } else {
                        $scope.updateResponse = "Warning: " + response.status + ", " + response.statusText;
                    }
                },
                function(response) {
                    //error
                    $scope.updateResponse = "Update failed: " + response.status + ", " + response.statusText;
                }
            );
    };

    $scope.delete = function(item) {
        $http.delete('/api/news/' + item.id)
                .then(
                    function(response) {
                        console.log(response);
                        if(response.status === 200) {
                            $scope.deleteResponse = "Delete successfull.";
                            $scope.clearNews(item);
                        } else {
                            $scope.deleteResponse = "Warning: " + response.status + ", " + response.statusText;
                        }
                        $scope.getNewsList();
                    },
                    function(response) {
                        $scope.deleteResponse = "Delete failed: " + response.status + ", " + response.statusText;
                    }
                );
    };

    $scope.selectNews = function(item) {
        $scope.selected = item;
        $scope.isNewsSelected = true;
    };
    
    $scope.isSelected = function(section) {
        return $scope.selected === section;
    };
    
    $scope.clearNews = function(news) {
        news.title = undefined;
        news.text = undefined;
        news.date = undefined;
        news.category = undefined;
        news = undefined;
        
        $scope.isNewsSelected = false;
        $scope.selected = undefined;
    };
    
    $scope.showCreateForm = function() {
        $scope.isNewsSelected = false;
        $scope.createForm.news = undefined;
    };

});

app.controller('admin_navigation', function($rootScope, $window, $http) {
    var self = this;
    
    self.logout = function () {
        $http.post('/logout', {}).finally(function () {
            $rootScope.authenticated = false;
            $window.location.href = '/';
//            $location.path("/");
        });
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