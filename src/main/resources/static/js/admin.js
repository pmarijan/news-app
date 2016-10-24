var app = angular.module("admin", ['ngSanitize']);

app.controller('adminNews', function($scope, $http) {
    $http.get('/api/news').success(function(data) {
        $scope.newsList = data;
    });
    
    $scope.create = function() {
        var item = $.param({
           title: $scope.title,
           category: $scope.category,
           text: $scope.text
        });
        
        var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        
        $http.post('/api/news', item, config)
                .then(
                    function(response) {
                        //function executed successfully
                        if(response.data) {
                            $scope.createResponse = "News created successfully.";
                        }
                    },
                    function(response) {
                        //error
                        $scope.createResponse = "News creation failed: " + response.status + ", " + response.statusText;
                    }
                );
    };
    
    $scope.update = function(item) {
        $http.put('/api/news/' + item.id, JSON.stringify(item))
                .then(
                    function(response) {
                        //function executed successfully
                        if(response.data) {
                            $scope.updateResponse = "Update successfull.";
                        }
                    },
                    function(response) {
                        //error
                        $scope.updateResponse = "Update failed: " + response.status + ", " + response.statusText;
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
});
