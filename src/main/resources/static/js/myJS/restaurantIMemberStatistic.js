function loadStatistic() {
    $.ajax({
        type: 'GET',
        url: "/service/restaurant/getDetailByMember",
        headers:{'token':localStorage.getItem("token")},
        data:{'rid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                let members = body.members;
                for(let i = 0;i<members.length;i++){
                    let member = members[i];
                    let tr = $("<tr>\n" +
                        "                        <td>"+member.uid+"</td>>\n" +
                        "                        <td>"+member.name+"</td>\n" +
                        "                        <td>"+member.totalTimes+"</td>\n" +
                        "                        <td>"+member.totalMoney+"</td>\n" +
                        "                    </tr>");
                    $("#statisticTBody").append(tr);
                }
            }else {
                alert('获取餐厅消费顾客统计失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('餐厅消费顾客统计');
    loadStatistic();
}

intimate();

$('#restaurantButton1').click(function () {
    window.location.href = "/restaurant.html";
});

$('#restaurantButton2').click(function () {
    window.location.href = "/restaurantInfo.html";
});

$('#restaurantButton3').click(function () {
    window.location.href = "/restaurantDetail.html";
});

$('#restaurantButton4').click(function () {
    window.location.href = "/restaurantStatistic1.html";
});

$('#restaurantButton5').click(function () {
    window.location.href = "/restaurantStatistic2.html";
});

$('#restaurantButton6').click(function () {
    window.location.href = "/restaurantStatistic3.html";
});

$('#restaurantButton7').click(function () {
    localStorage.clear();
    alert('退出成功');
    window.location.href = "/";
});