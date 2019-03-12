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

function logOff() {
    $.ajax({
        type: 'GET',
        url: "/service/member/logOff",
        headers:{'token':localStorage.getItem("token")},
        data:{'uid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0){
                alert('注销成功');
                localStorage.clear();
                window.location.href='/';
            }else {
                alert(data.opinion);
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

$('#logOffButton').click(function () {
    let member = {};
    member.uid = localStorage.getItem('id');
    member.password = $('#password').val();
    $.ajax({
        type: 'POST',
        url: "/service/member/verifyPassword",
        headers:{'token':localStorage.getItem("token")},
        data: JSON.stringify(member),
        success: function(data){
            if (data.result === 0) {
                logOff();
            } else {
                alert(data.opinion);
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
});

