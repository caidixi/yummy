function getUser(){
    let user = {};
    user.username = $("#username").val();
    user.password = $("#password").val();
    return user;
}

$("#loginButton").click(function () {
    let user = getUser();

    if (user.username !== '' && user.password !== '') {
        $.ajax({
            type: 'POST',
            url: "/common/logIn",
            data: JSON.stringify(user),
            success: function (data) {
                if (data.result === 0) {
                    alert('登陆成功');
                    let userInformation = data.body;
                    localStorage.setItem('token',userInformation.token);
                    localStorage.setItem('id',userInformation.id);
                    localStorage.setItem('type',userInformation.type);
                    localStorage.setItem('name',userInformation.name);
                    window.location.href = "/"+userInformation.type+".html";
                } else {
                    alert(data.opinion)
                }
            },
            contentType: 'application/json',
            dataType: 'json'
        });
    } else {
        alert('用户名和密码不得为空');
    }
});

$("#noAccount").click(function () {
    window.location.href = "/memberSignUp.html";
});

$("#noRestAccount").click(function () {
    window.location.href = "/restaurantSignUp.html";
});