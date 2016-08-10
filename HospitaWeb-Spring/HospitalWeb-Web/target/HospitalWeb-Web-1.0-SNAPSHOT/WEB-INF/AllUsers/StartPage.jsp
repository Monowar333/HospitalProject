<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Menu.jspf"%>
    </head>
    <body>
         <h3>Наши новости</h3>
        <article>
        <div>
         <div class="inner">
            <div class="main">
                <section id="content">
                    <div class="indent">
                    	<div class="wrapper">
                        	<article class="col-1">
                                <div class="bg">
                                    <div class="padding">
                                    	<h3 class="p5"></h3>
                                         <c:forEach var="item" items="">
                                        <div class="wrapper p5">
                                        	<figure class="img-indent"><img src="images/page5-img1.jpg" alt="" /></figure>
                                            <div class="extra-wrap">
                                            	<h3></h3>
                                                <p class="p">
                                                    Более подробную информацию можно узнать перейдя по ссылке
                                                </p>
                                                <a class="button-2" href="SelectDoctorsForAllUsers?param=${item.id}">Подробнее</a>
                                            </div>
                                        </div>
                                       </c:forEach>
                                    </div>
                                </div>
                            </article>
                        </div>
                    </div>
                </section>
                <div class="block"></div>
            </div>
        </div>
        </div>
        </article>
        
    </body>
</html>
