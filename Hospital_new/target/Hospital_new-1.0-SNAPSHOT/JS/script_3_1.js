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
    var x = confirm("Delete this user?");
    if(x){
        //remove user
        $.ajax({
            type: "GET",
            url: "DeleteSpecalization",
            data: {param:id},
            success: function(data,status){
                window.location.href = "/Hospital_new/specialization";
            },error: function (jqXHR, textStatus, errorThrown) {
                alert("cannot delete user");
            }
        });
    }
    return false;
}


