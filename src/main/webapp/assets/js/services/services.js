angular.module('userService', ['ngResource']).
	factory('User', function($resource) {
		return $resource('api/user/:id', { id:"@id" }, {
			update: { method:'PUT', parameters: { id:"@id" } }
		});
	});