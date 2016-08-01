<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/AllUsers/Menu.jspf"%>
        <title>JSP Page</title>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.0.0.js"></script>
        <script type="text/javascript" src = "JS/script_3_1.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
             <ul>
                <c:forEach var="item" items="${error}">
                    <li>${item}</li>                
                </c:forEach>
            </ul>
        <form id="Login1" action="" method="POST">
             <c:if test="${addoredit eq 'true'}">
                  
                        <table>
                            <tbody>
                                <tr>
                                    Добавить новую специальность
                                </tr>
                                <tr>
                                    <td>Нaзвание специализации</td>
                                    <td>
                                        <input type="text" name="spename1"  value="" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <input type="button" id ="b1" value="Добавить новую специальность" onclick = "btn1(this.id)">
                       
                        
                
             </c:if>
                <c:if test="${addoredit eq 'false'}">

                           <table>
                               <tbody>
                                   <tr>
                                       Редактировать специализацию
                                       <input type ="hidden" name = "id1" value="${specchange.id}">
                                   </tr>
                                   <tr>
                                       <td>Нaзвание специализации</td>

                                       <td>
                                           <input type="text" name="spename"  value="${specchange.name}" />
                                       </td>
                                   </tr>
                               </tbody>
                           </table>
                                <input type="button" id ="b2" value="Сохранить изменения" onclick = "btn1(this.id)">


                    </c:if>
        </form>
         
         
                <table border="1">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Название</th>
                           
                            <th>Статус работы</th>
                            
                        </tr>
                    </thead>
                    
                    <tbody>
                       
                        <c:forEach var="item" items="${specialization}">
                        <tr class="table-data" id="${item.id}">
                          
                           
                           <td >
                        <c:out value="${item.id}"/> 
                          </td>
                          <td >
                        <c:out value="${item.name}"/> 
                          </td>

                          <td >
                         <a href="EditSpecialization?param=${item.id}">Изменить</a>
                          </td>
                           <td>
                         <a href="DeleteSpecalization?param=${item.id}" onclick="return deleteUserById(${item.id})">Удалить</a>
                          </td>
                          
                      </tr>
                        </c:forEach>
                        
                        
                    </tbody>
                    
                </table>
        
    </body>
</html>
   <script>
            function btn1(idb){
                var button = document.getElementById(idb);
                var act = document.getElementById("Login1");
               
               act.action = (button.id == 'b1') ? "DeleteSpecalization" : "EditSpecialization";
                   act.submit();       
            }
            </script>