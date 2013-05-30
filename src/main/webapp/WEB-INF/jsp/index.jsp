<!DOCTYPE html>
<html ng-app="SPA">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>SPA Boilerplate</title>
	<link href="assets/lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="assets/wro/a.css" rel="stylesheet" type="text/css">
	<link href="assets/lib/bootstrap/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<a href="#/users" class="nav-route">Users</a>
	</div>
	
	<div class="container-fluid" ng-view></div>

	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular-resource.min.js"></script>
	<script type="text/javascript" src="assets/wro/a.js"></script>
</body>
</html>