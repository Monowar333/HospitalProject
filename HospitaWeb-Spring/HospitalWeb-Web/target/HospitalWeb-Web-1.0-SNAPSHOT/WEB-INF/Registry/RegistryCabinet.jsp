<%-- 
    Document   : RegistryCAbinet
    Created on : 18.07.2016, 21:24:04
    Author     : Жека
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
        <%@include file="/WEB-INF/AllUsers/Menu.jspf"%>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>RegistryCabinet</title>
    
  </head>
    
    <body>
        <h3> 
        Личный кабинет регистратуры
        </h3>
         <a href="AddCard">Добавить новую карту</a>
        <table border="1">
                    <thead>
                        <tr>
                            <th>Номер карты</th>
                            <th>Имя</th>
                            <th>Фамилия</th>
                            <th>дата рождения</th>
                            <th>дата регистрации</th>
                            <th>Адресс</th>                                                     
                            <th>Телефон</th>
                            <th>E-mail</th>
                            <th>Статус</th>
                            
                        </tr>
                    </thead>
                    
                <tbody>
                       
                <c:forEach var="item" items="${cardlist}">
                      <tr>
                          
                            <c:if test="${item.status == false}" >
                                <c:set var="myName" value="#ff9911"/>
                                </c:if>
                           <c:if test="${item.status == true}" >
                                <c:set var="myName" value="#32CD32"/>
                                </c:if>
                           <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.number}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.name}"/> 
                          </td>
                         <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.sname}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.dateofBirthdey}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.dateRegistr}"/> 
                          </td>
                         <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.address}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.telephone}"/> 
                          </td>
                           <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.email}"/> 
                          </td>
                           <td style="background-color:${myName}; color:#ffffff">
                           <c:out value="${item.status}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                              <a href="EditCard?param=${item.id}">Изменить</a>
                          </td>
                           <td>
                             <a href="DeleteCard?param=${item.id}">Удалить</a>
                          </td>
                          
                      </tr>
                
                </c:forEach>
            </tbody>          
    </body>
</html>
