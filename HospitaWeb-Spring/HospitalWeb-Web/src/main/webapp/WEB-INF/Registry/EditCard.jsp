<%-- 
    Document   : EditUsers
    Created on : 24.07.2016, 15:55:08
    Author     : Жека
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

        
    </style>
            <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
       <title>EditCard</title>
    </head>
    <body>
        <form:form method="post" action="saveupdate" commandName="card">
            
                    <table>
                            <tr>
                                    <td>ID:</td>
                                    <td><form:input path="id" /></td>
                            </tr>
                            <tr>
                                    <td>Имя:</td>
                                    <td><form:input path="name" /></td>
                                    <td><span class="error" ><form:errors path="name" /></span></td>
                            </tr>
                            <tr>
                                    <td>Фамилия:</td>
                                    <td><form:input path="sname" /></td>
                                    <td><span class="error"><form:errors path="sname" /></span></td>
                            </tr>

                              <tr>
                                    <td>Номер карты:</td>
                                  <td><input type="text" name="number" value = "${card.number}" readonly=""/><td>
                     
                              </tr>
                         
                              <tr>
                                  <td>Дата регистрации:</td>
                                  <td><input type="text" name="dateRegistr1" value="${dateRegistr1}" readonly=""/><td>
                     
                              </tr>
                            
                             
                            <tr>
                                <td>Дата рождения</td>
                                <td>
                                <select name="day" >
                                    
                                <c:forEach var="item" items="${date.getDay()}">
                                <option><c:out value="${item}"/></option>
                                </c:forEach>
                                </select>
                                <select name="month" >
                                <c:forEach var="item" items="${date.getMonth()}">
                                 <option><c:out value="${item}"/></option>
                                 </c:forEach>
                                </select>
                               <select name="year" >
                                <c:forEach var="item" items="${date.getYear()}">
                                <option> <c:out value="${item}"/></option>
                                 </c:forEach>
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
                                    <td>Адресс:</td>
                                    <td><form:input path="address" /></td>
                                    <td><span class="error"><form:errors path="address" /></span></td>
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
