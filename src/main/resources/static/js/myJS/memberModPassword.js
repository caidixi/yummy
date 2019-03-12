function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
}

intimate();

$('#restaurantButton1').click(function () {
    window.location.href = "/member.html";
});

$('#restaurantButton2').click(function () {
    window.location.href = "/memberOrder.html";
});

$('#restaurantButton3').click(function () {
    window.location.href = "/memberInfo.html";
});

$('#restaurantButton4').click(function () {
    window.location.href = "/memberStatistic1.html";
});

$('#restaurantButton5').click(function () {
    window.location.href = "/memberStatistic2.html";
});

$('#restaurantButton6').click(function () {
    window.location.href = "/memberStatistic3.html";
});

$('#restaurantButton7').click(function () {
    localStorage.clear();
    alert('退出成功');
    window.location.href = "/";
});

$('#modPasswordButton').click(function () {
    let member = {};
    member.uid = localStorage.getItem('id');
    member.oldPassword = $('#password').val();
    member.newPassword = $('#newPassword').val();
    let newPasswordAgain = $('#newPasswordAgain').val();

    if (member.newPassword===newPasswordAgain&&member.oldPassword!==member.newPassword) {
        $.ajax({
            type: 'POST',
            url: "/service/member/modifyPassword",
            headers:{'token':localStorage.getItem("token")},
            data: JSON.stringify(member),
            success: function (data) {
                if (data.result === 0) {
                    alert('修改用户密码成功,请重新登陆');
                    window.location.href = "/";
                } else {
                    alert(data.opinion);
                }
            },
            contentType: 'application/json',
            dataType: 'json'
        });
    } else {
        alert('请重新输入新密码');
    }
});
