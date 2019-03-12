function getUser(){
    let user = {};
    user.name = $("#name").val();
    user.email = $("#email").val();
    user.phone = $("#phone").val();
    user.address = $("#address").val();
    return user;
}

$("#signUpButton").click(function () {
    let user = getUser();

    if (user.name !== '' && user.email !== ''&&user.phone!==''&&user.address!=='') {
        alert('请求正在提交，请稍候');
        $.ajax({
            type: 'POST',
            url: "/common/memberSignUp",
            data: JSON.stringify(user),
            success: function (data) {
                if (data.result === 0) {
                    alert('注册成功,请查看邮箱获取登陆密码');
                    window.location.href='/';
                } else  {
                    alert(data.opinion)
                }
            },
            contentType: 'application/json',
            dataType: 'json'
        });
    } else {
        alert('注册信息不得为空');
    }
});

$("#hasAccount").click(function () {
    window.location.href = "/";
});