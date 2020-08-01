$(function () {

    //防止图书录入信息为空
    //绑定按钮单击事件
    $("#nullbool").click(function () {
       var nameval = $("#name").val();
       var priceval = $("#price").val();
       var autorval = $("#autor").val();
       var salesval = $("#sales").val();
       var stockval = $("#stock").val();

       if(nameval==""||priceval==""||autorval==""||salesval==""||stockval==""){
           $("span.errorMsg").text("图书信息不可为空！");
           return false;
       } else {
           $("span.errorMsg").text("");
       }
    });

    //绑定输入框失去焦点事件
    $("#name").blur(function () {
        var nameval = $("#name").val();
        if(nameval==""){
            $("span.errorMsg").text("图书信息不可为空！");
        }else {
            $("span.errorMsg").text("");
        }
    });

    $("#price").blur(function () {
        var priceval = $("#price").val();
        if(priceval==""){
            $("span.errorMsg").text("图书信息不可为空！");
        }else {
            $("span.errorMsg").text("");
        }
    });

    $("#autor").blur(function () {
        var autorval = $("#autor").val();
        if(autorval==""){
            $("span.errorMsg").text("图书信息不可为空！");
        }else {
            $("span.errorMsg").text("");
        }
    });

    $("#sales").blur(function () {
        var salesval = $("#sales").val();
        if(salesval==""){
            $("span.errorMsg").text("图书信息不可为空！");
        }else {
            $("span.errorMsg").text("");
        }
    });

    $("#stock").blur(function () {
        var stockval = $("#stock").val();
        if(stockval==""){
            $("span.errorMsg").text("图书信息不可为空！");
        }else {
            $("span.errorMsg").text("");
        }
    });

})
