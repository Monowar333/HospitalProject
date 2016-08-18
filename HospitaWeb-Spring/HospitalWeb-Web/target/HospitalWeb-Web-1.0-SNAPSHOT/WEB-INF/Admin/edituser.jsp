<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- 
    Document   : EditUser
    Created on : 07.07.2016, 19:38:29
    Author     : Жека
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/AllUsers/Menu.jspf"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
             

             <form:form method="post" action="updatruser" commandName="usersupdate">
               <input type ="hidden" name = "id" value="${usersupdate.id}">
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
                                        <select name="idspecialization1" >
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
