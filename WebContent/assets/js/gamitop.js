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
     //   var url = "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity?token=" + myToken



     $("#login").click(function () {
         console.log("login: " + $("#email").val(),
             " pass:" + $("#password").val())
         $.ajax({
                 method: "POST",
                 url: "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/auth",
                 data: {
                     login: $("#email").val(),
                     pass: $("#password").val(),
                 }
             })
             .done(function (msg) {
                 console.log("Token: " + msg)
                 localStorage.setItem("token", msg);
                 window.location.href = "dashboard.html";
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
                 url: "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity",
                 data: {
                     name: $("#name").val(),
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


     function generalAJax(method, url, data) {

         $.ajax({
                 method: method,
                 url: url,
                 data: data,
             })
             .done(function (msg) {
                 console.log(msg)
                 alert(msg)

             }).fail(function (error) {
                 alert(error.responseText)
             });


     }
     // var headers = {
     //     "Accept": "application/xml",
     //     "Content-Type": "application/xml"
     // };

     $("#createleaderboard").click(function () {
         var id_Entity = $('head').attr('id')
         console.log("cria")

         var data = {
             name: $("#nameLeaderboard").val(),
             description: $("#descriptionLeaderboard").val(),
             token: myToken
         }
         console.log(data)

         generalAJax("POST", "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/leaderboards", data);

     });

     $("#updateLeaderboard").click(function () {
         var id_Entity = $('head').attr('id')
         var id_Leaderboard = $('#leaderboardName').val()
         console.log("cria" + id_Leaderboard)

         var data = {
             name: $("#nameLeaderboard").val(),
             description: $("#descriptionLeaderboard").val(),
             token: myToken
         }
         console.log(data)

         generalAJax("PUT", "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/leaderboards/" + id_Leaderboard, data);
     });


     $("#removeLeaderboard").click(function () {
         var id_Entity = $('head').attr('id')
         var id_Leaderboard = $('#leaderboardName').val()
         console.log("DELETE")

         var data = {
             token: myToken
         }

         generalAJax("DELETE", "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/leaderboards/" + id_Leaderboard, data);
         window.location.reload();
         
     });

     $("#addPlayer").click(function () {
         var id_Entity = $('head').attr('id')
         var id_Leaderboard = $('#leaderboardName3').val()
         console.log("cria")

         var data = {
             name: $("#namePlayer").val(),
             score: $("#score").val(),
             win: $("#wins").val(),
             lose: $("#loses").val(),
             totalGames: $("#total").val(),
             token: myToken
         }
         console.log(data)

         generalAJax("POST", "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/leaderboards/" + id_Leaderboard + "/players", data);

     });

     $("#updatePlayer").click(function () {
         var id_Entity = $('head').attr('id')
         var id_Leaderboard = $('#leaderboardName2').val()
         var id_Player = $('#playerName').val()

         console.log("cria" + id_Player)

         var data = {
             name: $("#namePlayer").val(),
             score: $("#score").val(),
             win: $("#win").val(),
             lose: $("#loss").val(),
             totalGames: $("#total").val(),
             token: myToken
         }
         console.log(data)

         generalAJax("PUT", "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/leaderboards/" + id_Leaderboard + "/players/" + id_Player, data);
     });


     $("#removePlayer").click(function () {
         var id_Entity = $('head').attr('id')
         var id_Leaderboard = $('#leaderboardName2').val()
         var id_Player = $('#playerName').val()
         console.log("cria")

         var data = {
             token: myToken
         }
         console.log(data)

         generalAJax("DELETE", "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/leaderboards/" + id_Leaderboard + "/players/" + id_Player, data);
         window.location.reload();
     }); 

     $("#createAchievement").click(function () {

         var id_Entity = $('head').attr('id')
         console.log("cria")

         var data = {
             name: $("#nameAchivement").val(),
             description: $("#descriptionAchievement").val(),
             token: myToken
         }
         console.log(data)

         generalAJax("POST", "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/achievements", data);
     });

     $("#updateAchievement").click(function () {
         var id_Entity = $('head').attr('id')
         var id_Achievement = $('#achievementName').val()
         console.log("cria")

         var data = {
             name: $("#nameAchievement").val(),
             description: $("#descriptionAchievement").val(),
             token: myToken
         }
         console.log(data)

         generalAJax("PUT", "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/achievements/" + id_Achievement, data);
     });


     $("#removeAchievement").click(function () {
         var id_Entity = $('head').attr('id')
         var id_Achievement = $('#achievementName').val()
         console.log("cria")

         var data = {
             token: myToken
         }
         console.log(data)

         generalAJax("DELETE", "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/achievements/" + id_Achievement, data);
         window.location.reload();
         
     });


     $("#logout").click(function () {
        window.localStorage.clear()
     });

     $("#leaderboardName").change(function () {
         var id_Entity = $('head').attr('id')
         var id_Leaderboard = $('#leaderboardName').val()
         $.ajax({
                 method: "GET",
                 url: "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/leaderboards/" + id_Leaderboard + "?token=" + myToken,
                 headers: {
                     "Accept": "application/json",
                     "Content-Type": "application/json"
                 }

             })
             .done(function (data) {
                 console.log(data)
                 for (var i = 0; i < data.length; i++) {
                     $("#leaderboardName").append("<option value=" + data[i].id + ">" + data[i].name + "</option>")

                 }
                 if (data.length > 0) {
                     $("#nameLeaderboard").val(data[0].name)
                     $("#descriptionLeaderboard").val(data[0].description)
                     $("#linkLeaderboard").val(data[0].link)
                 }


             }).fail(function (error) {
                 console.log(error)
                 $('body').removeAttr("class").html(error.responseText)
                 $
             })
     })



     $("#leaderboardName2").change(function () {
         var id_Entity = $('head').attr('id')
         var id_Leaderboard = $('#leaderboardName2').val()

         $.ajax({
                 method: "GET",
                 url: "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/leaderboards/" + id_Leaderboard + "/players?token=" + myToken,
                 headers: {
                     "Accept": "application/json",
                     "Content-Type": "application/json"
                 }

             })
             .done(function (data2) {
                 console.log(data2)
                 $("#playerName").empty()
                 for (var i = 0; i < data2.length; i++) {
                     $("#playerName").append("<option value=" + data2[i].id + ">" + data2[i].name + "</option>")

                 }
                 if (data2.length > 0) {
                     $("#namePlayer").val(data2[0].name)
                     $("#score").val(data2[0].score)
                     $("#win").val(data2[0].win)
                     $("#loss").val(data2[0].lose)
                     $("#total").val(data2[0].totalGames)
                     $("#linkPlayer").val(data2[0].link)
                 }



             }).fail(function (error) {
                 console.log(error)
                 $('body').removeAttr("class").html(error.responseText)
                 $('body').show();
             });





     })

     $("#playerName").change(function () {
         var id_Entity = $('head').attr('id')
         var id_Leaderboard = $('#leaderboardName2').val()
         var id_Player = $('#playerName').val()
         $.ajax({
                 method: "GET",
                 url: "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/leaderboards/" + id_Leaderboard + "/players/" + id_Player + "?token=" + myToken,
                 headers: {
                     "Accept": "application/json",
                     "Content-Type": "application/json"
                 }

             })
             .done(function (data2) {
                 console.log(data2)

                 $("#namePlayer").val(data2[0].name)
                 $("#score").val(data2[0].score)
                 $("#win").val(data2[0].win)
                 $("#loss").val(data2[0].lose)
                 $("#total").val(data2[0].totalGames)
                 $("#linkPlayer").val(data2[0].link)



             }).fail(function (error) {
                 console.log(error)
                 $('body').removeAttr("class").html(error.responseText)
                 $('body').show();
             });


     })

     $("#achievementName").change(function () {
         var id_Entity = $('head').attr('id')
         var id_Achievement = $('#achievementName').val()
         $.ajax({
                 method: "GET",
                 url: "http://trabalhos.esmad.ipp.pt:8080/gamitop-api/api/entity/" + id_Entity + "/achievements/" + id_Achievement + "?token=" + myToken,
                 headers: {
                     "Accept": "application/json",
                     "Content-Type": "application/json"
                 }

             })
             .done(function (data) {
                 console.log(data)


                 $("#nameAchievement").val(data[0].name)
                 $("#descriptionAchievement").val(data[0].description)
                 $("#linkAchievement").val(data[0].link)



             }).fail(function (error) {
                 console.log(error)
                 $('body').removeAttr("class").html(error.responseText)
                 $
             })
     })









 });