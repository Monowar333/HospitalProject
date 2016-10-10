<%-- 
    Document   : receptionlist
    Created on : 09.10.2016, 14:37:19
    Author     : Жека
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%@include file="/WEB-INF/AllUsers/Menu.jspf"%>
    </head>
    <body>
       <table border="1" id="table1">
                    <thead>
                        <tr>
                            <th>Лечащий доктор</th>
                            <th>Номер карты пациента</th>
                            <th>Время регистрации</th>
                            <th>Диагнос</th>
                            <th>Симптомы</th>
                            <th>Статус</th>
                            <th>Рецепт</th>
                        </tr>
                    </thead>
                    
                    <tbody> 
                     <c:forEach var="item" items="${receptionlist}">
                      <tr>
                          
                          <c:if test="${item.status == 'close'}" >
                                <c:set var="myName" value="#ff9911"/>
                                </c:if>
                           <c:if test="${item.status == 'new' || item.status == 'repeat'}" >
                                <c:set var="myName" value="#32CD32"/>
                                </c:if>
                           
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.idUsers.name} ${item.idUsers.snme}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.idCard.number}"/> 
                          </td>
                        <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.time}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.idprovisionaldiagnosis.name}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.complaints}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.status}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                         <a href="watchMedicationLis/${item.id}">Рецепт</a>
                          </td>
                          
                      </tr>
                        </c:forEach>
                        
                        
                    </tbody>
                    
                </table>
    </body>
</html>
