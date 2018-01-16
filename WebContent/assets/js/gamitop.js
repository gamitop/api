$(document).ready(function () {

    var myToken = localStorage.token;
    //   var headers = {
    //     "Accept": "application/xml",
    //     "Content-Type": "application/xml"
    //   };
    //   var data = {
    //     login: $("#txtLogin").val(),
    //     pass: $("#txtPass").val(),
    //   }
    //   var url = "http://localhost:8080/gamitop/api/entity?token=" + myToken



    $("#login").click(function () {
        console.log("login: " + $("#email").val(),
            " pass:" + $("#password").val())
        $.ajax({
                method: "POST",
                url: "http://localhost:8080/gamitop/api/auth",
                data: {
                    login: $("#email").val(),
                    pass: $("#password").val(),
                }
            })
            .done(function (msg) {
                console.log("Token: " + msg)
                localStorage.setItem("token", msg);
                window.location.href = "app.html";
            });
    });

    $("#formLogin").click(function () {

        window.location.href = "login.html";
    });

    $("#formRegister").click(function () {
        window.location.href = "register.html";
    });

    $("#register").click(function () {
    	console.log("aa")
        $.ajax({
                method: "POST",
                url: "http://localhost:8080/gamitop/api/entity",
                data: {
                    name:$("#name").val(),
                    email: $("#email").val(),
                    password: $("#password").val(),
                }
            })
            .done(function (msg) {
                console.log("Token: " + msg)
                //localStorage.setItem("token", msg);
                //window.location.href = "app.html";
            });
    });
    var headers = {
        "Accept": "application/xml",
        "Content-Type": "application/xml"
    };
    var data = {
        login: $("#txtLogin").val(),
        pass: $("#txtPass").val(),
    }

    // function generalAJax(method, url, headers, data) {

    //   $.ajax({
    //       method: method,
    //       url: url,
    //       headers: headers,
    //       data: data,
    //     })
    //     .done(function (msg) {
    //       console.log(msg)

    //     });

    // }




});