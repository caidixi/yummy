function loadStatistic() {
    $.ajax({
        type: 'GET',
        url: "/service/member/getDetailByMoney",
        headers:{'token':localStorage.getItem("token")},
        data:{'uid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                $('#totalPrice').append(body.totalPrice);
                $('#averagePrice').append(body.averagePrice);
                let orders = body.orders;
                for(let i = 0;i<orders.length;i++){
                    let orderStatistic = orders[i];
                    let tr = $("<tr>\n" +
                        "                        <td>"+orderStatistic.rid+"</td>>\n" +
                        "                        <td>"+orderStatistic.oid+"</td>\n" +
                        "                        <td>"+orderStatistic.time+"</td>\n" +
                        "                        <td>"+orderStatistic.price+"</td>\n" +
                        "                    </tr>");
                    $("#statisticTBody").append(tr);
                }
            }else {
                alert('获取会员订单花费统计失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('会员订单花费统计');
    loadStatistic();
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