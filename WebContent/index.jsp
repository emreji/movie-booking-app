<!DOCTYPE html>
<%@page import="com.fdmgroup.model.MBUser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fdmgroup.model.Movie"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Movieplex</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/style.css" />
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <div class="insideBody">
            <div class="container" id="container">
                <header>
                    <div id="logo" class="logo">
                        <img alt="popcorn" src="images/popcorn.png" />
                        <label class="logo-text">Movieplex</label>
                    </div>
                    <ul class="nav justify-content-end navigation-links">
                        <li class="nav-item">
                            <form method="get" action="index">
                        		<input type="submit" value="Home" class="nav-link active" />
                        	</form>
                        </li>
                        <% HttpSession session1 = request.getSession();
						   MBUser loggedInUser = (MBUser)session1.getAttribute("loggedInUser");%>
						<% if(loggedInUser == null) { %>
	                        <li class="nav-item">
	                            <a href="#" class="nav-link" data-toggle="modal" data-target="#loginModal">Login</a>
	                        </li>
	                        <li class="nav-item">
	                            <a href="#" class="nav-link" data-toggle="modal" data-target="#registerModal">Register</a>
	                        </li>
                        <% } else { %>
	                        <li class="nav-item">
	                        	<a href="#" class="nav-link welcome-user">Welcome <%=loggedInUser.getFirstname() + " " + loggedInUser.getLastname()%></a>
		                    </li>
		                    <li class="nav-item">
	                        	<form method="get" action="logout">
	                        		<input type="submit" value="Log out" class="nav-link" />
	                        	</form>
	                        </li>
                        <% } %>
                    </ul>
                    <div class="input-group search">
                        <form method="get" action="search">
                        	<input type="text" class="form-control" id="searchItem" name="searchItem" placeholder="Search movie or genre" aria-label="Search Movie" aria-describedby="search-movie">
                        </form>
                    </div>
                </header>
                <% 
                Boolean registerSuccess = (Boolean)session.getAttribute("registerSuccess");
                if(registerSuccess != null && registerSuccess == true) { %>
                	<div class="alert alert-warning registerSuccess">
                		You have successfully registered! Please login to continue.
                	</div>
                <%} %>
                <ul class="movies">
                	<% 
                	ArrayList<Movie> movies = (ArrayList<Movie>) request.getAttribute("movies");
                	if(movies != null) {
                	for(Movie movie: movies) { %>
	                	<li class="card movie">
	                        <img class="card-img-top" src="<%=movie.getImage_url()%>" alt="Dr.Seuss The Grinch">
	                        <label class="movie-name"><%=movie.getName() %></label>
	                        <form method="get" action="showtimes">
	                        	<input type="hidden" value="<%=movie.getName()%>" name="movieName" />
	                        	<input type="submit" value="SHOWTIMES" class="showtime-btn btn" />
	                        </form>
	                    </li>
	                <% } }%>
                </ul>
            </div>
        </div>
        <footer>
            Movieplex &copy;2018
            <p>Designed and developed by Elizabeth Reji</p>
        </footer>
        
        <!--Login Modal -->
        <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitle">Login</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <form method="post" action="login" id="loginForm">
                    <div class="form-group">
                        <label for="loginUsername">Username</label>
                        <input type="text" class="form-control" id="username" aria-describedby="usernameHelp" name="username" placeholder="Enter username">
                    </div>
                    <div class="form-group">
                        <label for="loginPassword">Password</label>
                        <input type="password" class="form-control" name="password" id="loginPassword" placeholder="Password">
                    </div>
                    <input type="submit" class="btn button-link" value="Login" />
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </form>
              </div>
            </div>
          </div>
        </div>
        <!-- Register modal -->
        <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="Register" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitle">Register</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <form method="post" action="register" id="registerForm">
                    <div class="form-group">
                        <label for="firstname">First Name</label>
                        <input type="text" class="form-control" id="firstname" name="firstname" aria-describedby="firstNameHelp" placeholder="first name">
                    	<div class="invalid-feedback firstNameError">
				        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname">Last Name</label>
                        <input type="text" class="form-control" id="lastname" name="lastname" aria-describedby="lastNameHelp" placeholder="last name">
                    	<div class="invalid-feedback lastNameError">
				        </div>
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" id="usernameIn" name="username" aria-describedby="usernameHelp" placeholder="username">
                    	<div class="invalid-feedback usernameError">
				        </div>
                    </div>
                    <div class="form-group">
                        <label for="emailAddress">Email address</label>
                        <input type="email" class="form-control" id="emailAddress" name="email" aria-describedby="emailHelp" placeholder="eg: abc@xyz.com">
                    	<div class="invalid-feedback emailError">
				        </div>
                    </div>
                    <div class="form-group">
                        <label for="password1">Password</label>
                        <input type="password" class="form-control" id="password1" name="password" placeholder="Password">
                    	<div class="invalid-feedback passwordError">
				        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
                    	<div class="invalid-feedback conPasswordError">
				        </div>
                    </div>
                    <button type="submit" class="btn button-link">Register</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </form>
              </div>
            </div>
          </div>
        </div>
    </body>
</html>