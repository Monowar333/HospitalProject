<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/AllUsers/Menu.jspf"%>
        <title>JSP Page</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
        <script>
            function removeUser(id){
                if(confirm("remove this user?")){
                console.log('id = ' + id);
                var url = 'deletespecalization/'+id;
                $.ajax({
                    type: "GET",
                    url: url,
                    data: {id:id},
                    success: function(data,status){
                        //remove user from table
                        $('#usr_'+id).remove();
                    },
                    error:function(data,status){
                        $('#usr_'+id).remove();
                        //alert
                    }
                  });
              }
                  return false;
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
<!--        <form id="Login1" action="" method="POST">-->
            
                    <form:form method="post" action="addspec" commandName="specialization"  id= "spec">
                        <table>
                            <tbody>
                                <tr>
                                    Добавить новую специальность
                                </tr>
                                <tr>
                                    <td>Нaзвание специализации</td>
                                    <td><form:input path="name" /></td>
                                    <td><span class="error"><form:errors path="name" /></span></td>
                                </tr>
                            </tbody>
                        </table>
                       
                         <c:if test="${addoredit eq 'true'}">
                          <input type="button" id ="b1" value="Добавить новую специальность" onclick = "btn1(this.id)">
                         </c:if>
                           <c:if test="${addoredit eq 'false'}">
                               <form:input type = "hidden" path="id" />
                           <input type="button" id ="b2" value="Сохранить изменения" onclick = "btn1(this.id)">
                           </c:if>
                    </form:form>
                        
                
                           
        <!--</form>-->
         
         
                <table border="1">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Название</th>
                           
                            <th>Статус работы</th>
                            
                        </tr>
                    </thead>
                    
                    <tbody>
                       
                        <c:forEach var="item" items="${Specialalization}">
                        <tr class="table-data" id="usr_${item.id}">
                          
                           
                           <td >
                        <c:out value="${item.id}"/> 
                          </td>
                          <td >
                        <c:out value="${item.name}"/> 
                          </td>

                          <td >
                         <a href="editspec/${item.id}">Изменить</a>
                          </td>
                           <td>
                         <a href="deletespecalization/${item.id}" onclick="return removeUser(${item.id})">Удалить</a>
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
                var act = document.getElementById("spec");
               
               act.action = (button.id == 'b1') ? "addspec" : "saveedit";
                   act.submit();       
            }
            </script>