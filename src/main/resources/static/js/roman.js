var app = angular.module('romanApp', []);
app.controller('romanCtrl', function($scope, $http) {
	$scope.roman = "";
	$scope.romanError = false;
	$scope.update = function() {
		if (/\S/.test($scope.arabic)) { // There is an input
			$http.get("/roman", {
				params : {
					"arabic" : $scope.arabic
				}
			}).then(
					function(response) {
						$scope.romanError = false;
						$scope.roman = response.data.arabic + " = "
								+ response.data.roman;
					}, function(response) {
						$scope.romanError = true;
						$scope.roman = response.data.message;
					});
		} else { // Only whitespace
			$scope.roman = "";
		}
	};
});