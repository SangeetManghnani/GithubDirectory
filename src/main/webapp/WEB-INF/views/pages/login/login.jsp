<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Intranet - Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="shortcut icon" href="${requestScope.cdn}/resources/images/favicon.ico" type="image/x-icon">
  <link
    href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"
    rel="stylesheet">
 
</head>
<body class="">
<h1>LDAP Login page</h1>

 <form action="${requestScope.contextPath }/login" method="post" autocomplete="off">
		                                           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		                                           <div class="mt15">
		                                              <div class="input-group bor-b mt-10 fw">
		                                                   <input type="text" name="username" class="form-control bgtra custom-input tblack0" autocomplete="off" placeholder="User name / Email">
		                                                   <span class="input-group-addon b0 bgtra br-bottom pointer pr-15 br-0">
		                                                       <i class="fa fa-user tblack8 f1-25"></i>
		                                                   </span>
		                                               </div>
		                                          </div>
		                                          <div class="mt15">
		                                              <div class="input-group bor-b mt-10 fw">
		                                                  <input type="password" name="password" class="form-control  bgtra custom-input tblack0" autocomplete="off" placeholder="Password">
		                                                   <span class="input-group-addon b0 bgtra br-bottom pointer pr-15 br-0">
		                                                       <i class="fa fa-lock tblack8 f1-25"></i>
		                                                   </span>
		                                               </div>
		                                          </div>
		                                          <div class="mt15 ">
		                                              <div class="row m-0">
		                                                  <div class="col-sm-6 col-xs-6 mt-20 p-0">
		                                                      
		                                                  </div>
		                                                  <div class="col-sm-6 col-xs-6 text-right mt-20 p-0">
		                                                      <div><a class="black font1-1" data-toggle="modal"
                                                                data-target="#forgotPwd">Forgot password</a></div> 
		                                                  </div>
		                                                  <div class="col-sm-12  col-xs-12 text-center mt-30 p-0">
		                                                      <button type="submit" class="btn btn-tg"><i class="fa fa-sign-in pr-10" aria-hidden="true"></i>Login</button>
		                                                  </div>
		                                              </div>
		                                          </div>
		                                      </form>
    
</body>
</html>