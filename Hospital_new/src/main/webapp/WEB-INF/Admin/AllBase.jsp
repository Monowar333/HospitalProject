<%-- 
    Document   : AllBase
    Created on : 05.01.2016, 8:28:15
    Author     : Жека
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/AllUsers/Menu.jspf"%>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>AllBase</title>
    
    </head>
    <h3> 
        Личный кабинет администратора
    </h3>
    <body>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.0.0.js"></script>
        <script type="text/javascript" src = "JS/script_3.js"></script>
            <form id = "Action" action="" method="POST">
                <input type="button" id ="b3" value="Добавить специализации" onclick = "btn1(this.id)">
                <input type="button" id ="b4" value="Добавить сотрудника" onclick = "btn1(this.id)">
                <input type="button" id ="b5" value="Logout" onclick = "btn1(this.id)">
            </form>
        

        <table border="1" id="table1">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Имя</th>
                            <th>Фамилия</th>
                            <th>Стаж</th>
                            <th>Логин</th>
                            <th>Пароль</th>
                            <th>Отделение</th>
                            <th>Телефон</th>
                            <th>E-mail</th>
                            <th>Статус работы</th>
                            <th>Статус регистрации</th>
                            
                        </tr>
                    </thead>
                    
                    <tbody>
                       
                        <c:forEach var="item" items="${users}">
                      <tr>
                          
                            <c:if test="${item.statusWork == false}" >
                                <c:set var="myName" value="#ff9911"/>
                                </c:if>
                           <c:if test="${item.statusWork == true}" >
                                <c:set var="myName" value="#32CD32"/>
                                </c:if>
                           <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.id}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.name}"/> 
                          </td>
                         <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.snme}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.exp}"/> 
                          </td>
                         
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.login}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.password}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.idspecialization.name}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.telephone}"/> 
                          </td>
                           <td style="background-color:${myName}; color:#ffffff">
                        <c:out value="${item.email}"/> 
                          </td>
                           <td style="background-color:${myName}; color:#ffffff">
                           <c:out value="${item.statusWork}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                           <c:out value="${item.statusregistr}"/> 
                          </td>
                          <td style="background-color:${myName}; color:#ffffff">
                         <a href="EditDoc?param=${item.id}">Изменить</a>
                          </td>
                           <td>
                         <a href="DalateDoc?param=${item.id}" onclick="return deleteUserById(${item.id})">Удалить</a>
                          </td>
                          
                      </tr>
                        </c:forEach>
                        
                        
                    </tbody>
                    
                </table>

                
    </body>
</html>
