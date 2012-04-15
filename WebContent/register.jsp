<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<script type="text/javascript" src="scripts/jquery.js"></script>
	<script type="text/javascript" src="scripts/common.js"></script>
	<script type="text/javascript" src="scripts/register.js"></script>
	<link href='http://fonts.googleapis.com/css?family=Chango' rel='stylesheet' type='text/css' />
	<link href='http://fonts.googleapis.com/css?family=Londrina+Solid' rel='stylesheet' type='text/css' />
	<link rel="stylesheet" type="text/css" href="style.css" />
	<title>CMU Events :: Students event in Carnegie Mellon</title>
</head>
<body>
<div id="container">
	<header>
		<hgroup>
			<h1>CMU Events.com</h1>
			<h2>Find an event, and you'll be there</h2>
		</hgroup>
		<nav>
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">My Events</a></li>
				<li><a href="#">My Profile</a></li>
			</ul>
		</nav>
		<div id="login_box">
			<a href="register.html">Join</a>
			&nbsp;/&nbsp;
			<a href="#">Login</a>
		</div>
	</header>
	<div class="contents" id="register_contents">
		<h3>Thank you for joining CMU Events.com</h3>
		<form id="register_form" method="post" action="register.do">
			<ul id="register_box">	
				<li>
					<label for="username">ID</label>&nbsp;
					<input type="text" id="username" name="username" maxlength="30" autofocus="autofocus" required="required" placeholder="Your unique ID" />
					<span id="id_error" class="error"></span>
				</li>
				<li>
					<label for="password">Password</label>&nbsp;
					<input type="password" id="password" name="password" maxlength="12" required="required" placeholder="********" />
				</li>
				<li>
					<label for="password2">Confirm Password</label>&nbsp;
					<input type="password" id="password2" name="password2" maxlength="12" required="required" placeholder="********" />
					<span id="password_confirm_error" class="error">&nbsp;Password does not match</span>
				</li>
				<li>
					<label for="email">E-mail</label>&nbsp;
					<input type="email" id="email" name="email" required="required" placeholder="abc@gmail.com" />
				</li>
				<li class="center">
					<input type="submit" id="action" value="Join" name="action" />
				</li>
			</ul>
		</form>
	</div>
</div>
</body>
</html>