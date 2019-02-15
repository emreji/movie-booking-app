<!DOCTYPE html>
<%@page import="com.fdmgroup.model.MBUser"%>
<%@page import="com.fdmgroup.model.Theatre"%>
<%@page import="com.fdmgroup.model.Screen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fdmgroup.model.Movie"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Movieplex</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/movieDetailStyle.css" />
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
                </header>
                <div class="movie-detail">
                    <section>
                    	<% Movie movie = (Movie)request.getAttribute("movie");
                    	   Boolean movieBooked = (Boolean)session.getAttribute("movieBooked");%>
                        <div id="movie-img">
                            <img alt="<%=movie.getName() %>" src="<%=movie.getImage_url() %>" />
                        </div>
                        <div id="movie-info-short">
                            <h3 class="movie-title"><%=movie.getName() %></h3>
                            <h6 class="release-date"><%=movie.getRelease_date() %></h6>
                            <div class="">
                                <small>Length: <span class="duration"><%=movie.getDuration() %></span></small>
                                <div class="genre"><%=movie.getGenre() %></div>
                            </div>
                        </div>
						   <% if(loggedInUser == null) { %>
						   	<span class="login-msg">Please login to book ticket</span>
						   <%} else if(movieBooked != null && movieBooked == true) { %>
						   	<span class="login-msg confirmBooking">Your booking is confirmed! Enjoy the movie.</span>
						   <%}else {%>
                        	<button class="bookBtn showtime-btn btn" data-toggle="modal" data-target="#bookTicketModal">Book Ticket</button>
                        <% } %>
                    </section>
                    <section id="movie-info">
                        <div>
                            <h3>Synopsis</h3>
                            <p><%=movie.getSynopsis() %></p>
                            <h3>Directors</h3>
                            <p><%=movie.getDirectors() %></p>
                            <h3>Cast</h3>
                            <p><%=movie.getCast() %></p>
                            <h3>Producers</h3>
                            <p><%=movie.getProducers() %></p>
                        </div>
                        
                    </section>
                </div>
            </div>
        </div>
        <footer>
            Movieplex &copy;2018
            <p>Designed and developed by Elizabeth Reji</p>
        </footer> 
        
        <!-- Book Ticket Form -->
        <div class="modal fade" id="bookTicketModal" tabindex="-1" role="dialog" aria-labelledby="Book Ticket" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitle">Book Ticket</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <form method="post" action="BookTicket">
                    <div class="form-group">
                        <label for="numOfTickets">Number of Tickets</label>
                        <input type="number" name="numOfTickets" maxlength="1" />
                    </div>
                    <div class="form-group">
                        <label for="theatre">Choose Theatre</label>
                        <% ArrayList<Theatre> theatres = (ArrayList<Theatre>) request.getAttribute("theatres"); %>
                        <select class="custom-select" id="theatre" name="theatre">
                        	<option selected>Choose...</option>
						    <% for(Theatre theatre : theatres) { %>
						    	<option value="<%=theatre.getId() %>"><%=theatre.getName() %></option>
						    <% } %>
						</select>
                    </div>
                    <input type="hidden" value="<%=movie.getId()%>" name="movieBookedId" />
                    <input type="hidden" value="<%=movie.getName()%>" name="movieName" />
                    <input type="submit" value="Book" class="bookBtn showtime-btn btn"/>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </form>
              </div>
            </div>
          </div>
        </div>
        
        <!--Login Modal -->
        <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitle">Login</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <form method="post" action="login">
                    <div class="form-group">
                        <label for="loginUsername">Username</label>
                        <input type="text" class="form-control" id="username" aria-describedby="usernameHelp" name="username" placeholder="Enter username">
                    </div>
                    <div class="form-group">
                        <label for="loginPassword">Password</label>
                        <input type="password" class="form-control" name="password" id="loginPassword" placeholder="Password">
                    </div>
                    <input type="hidden" value="<%=movie.getName()%>" name="movieName" />
                    <input type="submit" class="btn button-link" value="Login" />
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </form>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Register modal -->
        <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitle">Register</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <form method="post" action="register">
                    <div class="form-group">
                        <label for="firstname">First Name</label>
                        <input type="text" class="form-control" id="firstname" name="firstname" aria-describedby="firstNameHelp" placeholder="first name">
                    </div>
                    <div class="form-group">
                        <label for="lastname">Last Name</label>
                        <input type="text" class="form-control" id="lastname" name="lastname" aria-describedby="lastNameHelp" placeholder="last name">
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" id="usernameIn" name="username" aria-describedby="usernameHelp" placeholder="username">
                    </div>
                    <div class="form-group">
                        <label for="emailAddress">Email address</label>
                        <input type="email" class="form-control" id="emailAddress" name="email" aria-describedby="emailHelp" placeholder="eg: abc@xyz.com">
                    </div>
                    <div class="form-group">
                        <label for="password1">Password</label>
                        <input type="password" class="form-control" id="password1" name="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
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