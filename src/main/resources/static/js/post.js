
var sda='{"id":1,"name":"l","password":"s","role":"user"}';

var obj = eval('(' + sda + ')');
function e(){
    $.ajax({
        type:"post",
        url:"so/login",
        // url:"so/s",
        contentType:'application/json;charset=utf-8',
        dataType:'json',
        data:sda,
        success:function (e){
            alert("状态"+e.zt);
          alert("成功");
        },
        error:function (e){
            alert(e);

            alert("失败");
        }

    })

}

alert("元素数据"+obj.id);
alert("请求后端");
e();