<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--<%@ page session="false"%>--%>
<%-- 
    Document   : AddDoctors
    Created on : 06.01.2016, 8:46:33
    Author     : Жека
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


    
<!DOCTYPE html>
<html>
   <head>
       <%@include file="/WEB-INF/AllUsers/Menu.jspf"%>
       <style type="text/css">
        input[type="text"] {
            
            border: 1px solid #D4E2F7;
        }
        input {
            margin: 3px 0px 3px 30px;
        }
        
        span.error {
	color: red;
        
    </style>
            <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <title>JSP Page</title>
        <script type="text/javascript" src = "https://code.jquery.com/jquery-3.0.0.js"></script>
        <script type="text/javascript" src = "/js/jsmy.js"></script>
    </head>
        <body>
            sdfdcvcbvbc 
            <form:form method="post" action="saveuser" commandName="users">
                    <table>
                            <tr>
                                    <td>Имя:</td>
                                    <td><form:input path="name" /></td>
                                    <td><span class="error" ><form:errors path="name" /></span></td>
                            </tr>
                            <tr>
                                    <td>Фамилия:</td>
                                    <td><form:input path="snme" /></td>
                                    <td><span class="error"><form:errors path="snme" /></span></td>
                            </tr>
                            <tr>
                                    <td>Стаж:</td>
                                    <td><form:input path="exp" /></td>
                                    <td><span class="error"><form:errors path="exp" /></span></td>
                            </tr>
                            <tr>
                                     <td>Отделение:</td>
                                     <td>
                                        <select <form:input path="idspecializationInt"/> >
                                            <c:forEach var="item" items="${Specialalization}">
                                                <option value="${item.id}">${item.name}</option>
                                            </c:forEach>
                                        </select>
                                     </td>
                            </tr>
                                    <tr>
                                    <td>Группа пользователей:</td>
                                    <td>
                                        <select <form:input path="status"/> >
                                            <option>doctors</option>
                                           <option>registry</option>
                                        </select>
                                    </td>
                                    </tr>
                            <tr>
                                    <td>Логин:</td>
                                    <td><form:input path="login" /></td>
                                    <td><span class="error"><form:errors path="login" /></span></td>
                            </tr>
                            <tr>
                                    <td>Пароль:</td>
                                    <td><form:password path="password" /></td>
                                    <td><span class="error"><form:errors path="password" /></span></td>
                            </tr>

                            <tr>
                                    <td>Повторите пароль:</td>
                                    <td><form:password path="confirmPassword" /></td>
                                    <td><span class="error"><form:errors path="confirmPassword" /></span></td>
                            </tr>

                            <!--<tr>-->
                                    <!--<td>Фото:</td>-->
                                    <!--<td></td>-->
                                    <!--<td><span class="error"></span></td>-->
                            <!--</tr>-->
                            <tr>
                                    <td>Телефон:</td>
                                    <td><form:input path="telephone" /></td>
                                    <td><span class="error"><form:errors path="telephone" /></span></td>
                            </tr>
                            <tr>
                                    <td>Email:</td>
                                    <td><form:input path="email" /></td>
                                    <td><span class="error"><form:errors path="email" /></span></td>
                            </tr>
                            <tr>
                                    <td colspan="3"><input type="submit" value="Добавить" /></td>
                            </tr>
                    </table>
            </form:form>

    
        </body>
</html>

