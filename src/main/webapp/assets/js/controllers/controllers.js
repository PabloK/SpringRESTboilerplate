function UserListCtrl($scope, User) {
	$scope.state = 'loading...';
	$scope.tempUser = new User();
	
	$scope.users = User.query(function() {
		$scope.state = 'synced';
	});
	
	$scope.createUser = function() {
		$scope.state = 'loading...';
		$scope.tempUser.$save(function(user) {
			$scope.users.push(user);
			$scope.tempUser = new User();
			
			$scope.state = 'synced';
		});
	}
	
	$scope.deleteUser = function(user) {
		$scope.state = 'loading...';
		user.$remove(function() {
			$scope.users.splice($scope.users.indexOf(user), 1);
			$scope.state = 'synced';
		});			
	}
	
}

function UserDetailCtrl($scope, $location, $routeParams, User) {
	
	$scope.state = 'synced';
	
	$scope.user = User.get({id: $routeParams.id}, function() {		
	})
	
	$scope.updateUser = function() {
		$scope.state = 'loading...';
		$scope.user.$update(function() {
			$location.path('/users');
		});
	}
	
}