var App = angular.module("SPA", ['userService']);

App.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
		when('/users', {templateUrl: 'assets/partials/userlist.html', controller: 'UserListCtrl'}).
		when('/users/:id', {templateUrl: 'assets/partials/userdetail.html', controller: 'UserDetailCtrl'});
}]);