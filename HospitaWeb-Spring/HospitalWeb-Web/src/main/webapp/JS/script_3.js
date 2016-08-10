//$(document).ready(
//        
//        function(){
////            alert("hajabaja");
////            var x = prompt("title", null);
//            var x = confirm("delete this user?");
//            alert(x);
//        }
//        
//);

function deleteUserById(id){
    var x = confirm("Delete this user?" + id);
    if(x){
        //remove user
        $.ajax({
            type: "GET",
            url: "DalateDoc",
            data: {param:id},
            success: function(data,status){
                window.location.href = "/Hospital_new/Registrpage";
            },error: function (jqXHR, textStatus, errorThrown) {
                alert("cannot delete user");
            }
        });
    }
    return false;
}

function btn1(idb){
               var button = document.getElementById(idb);
                var act = document.getElementById("Action");

              if(button.id == 'b3'){
                act.action =  "/Hospital_new/specialization";
              } else  if(button.id == 'b4'){
                  act.action =  "/Hospital_new/AddDoctors";
              }else  if(button.id == 'b5'){
                  act.action =  "/Hospital_new/LogoutServlet";
              }
                   act.submit();              
            }

