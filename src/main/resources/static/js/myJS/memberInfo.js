function loadRestaurantList() {
    $.ajax({
        type: 'GET',
        url: "/service/member/getInformation",
        headers:{'token':localStorage.getItem("token")},
        data:{'uid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                let tr1 = $("<tr>\n" +
                    "                        <td>会员编号</td>>\n" +
                    "                        <td>"+body.uid+"</td>\n" +
                    "                    </tr>");
                let tr2 = $("<tr>\n" +
                    "                        <td>姓名</td>>\n" +
                    "                        <td>"+body.name+"</td>\n" +
                    "                    </tr>");
                let tr3 = $("<tr>\n" +
                    "                        <td>电话</td>>\n" +
                    "                        <td>"+body.phone+"</td>\n" +
                    "                    </tr>");
                let tr4 = $("<tr>\n" +
                    "                        <td>邮箱</td>>\n" +
                    "                        <td>"+body.email+"</td>\n" +
                    "                    </tr>");
                let tr5 = $("<tr>\n" +
                    "                        <td>会员等级</td>>\n" +
                    "                        <td>"+body.level+"</td>\n" +
                    "                    </tr>");
                let tr6 = $("<tr>\n" +
                    "                        <td>经验</td>>\n" +
                    "                        <td>"+body.xp+"</td>\n" +
                    "                    </tr>");
                let tr7 = $("<tr>\n" +
                    "                        <td>会员折扣</td>>\n" +
                    "                        <td>"+body.memberDiscount+"</td>\n" +
                    "                    </tr>");
                let tr8 = $("<tr>\n" +
                    "                        <td>地址1（默认）</td>>\n" +
                    "                        <td>"+body.address1+"</td>\n" +
                    "                    </tr>");
                let tr9 = $("<tr>\n" +
                    "                        <td>地址2</td>>\n" +
                    "                        <td>"+body.address2+"</td>\n" +
                    "                    </tr>");
                let tr10 = $("<tr>\n" +
                    "                        <td>地址3</td>>\n" +
                    "                        <td>"+body.address3+"</td>\n" +
                    "                    </tr>");
                $("#infoTBody").append(tr1,tr2,tr3,tr4,tr5,tr6,tr7,tr8,tr9,tr10);
            }else {
                alert('获取会员信息失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('会员信息');
    loadRestaurantList();
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
    window.location.href = "/memberModPassword.html";
});

$('#modMemberInfoButton').click(function () {
    window.location.href = "/memberModInfo.html";
});

$('#logOffButton').click(function () {
    window.location.href = "/memberLogOff.html";
});