function loadOrderList() {
    $.ajax({
        type: 'GET',
        url: "/service/restaurant/getOrderList",
        headers:{'token':localStorage.getItem("token")},
        data:{'rid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                let orders = body.orders;
                for(let i = 0;i<orders.length;i++){
                    let order = orders[i];
                    let tr = $("<tr>\n" +
                        "                        <td>"+order.uid+"</td>>\n" +
                        "                        <td>"+order.oid+"</td>\n" +
                        "                        <td>"+order.time+"</td>\n" +
                        "                        <td>"+order.price+"</td>\n" +
                        "                        <td>"+order.state+"</td>\n" +
                        "                        <td>"+JSON.stringify(order.foods)+"</td>\n" +
                        "                    </tr>");
                    $("#orderTBody").append(tr);
                }
            }else {
                alert('获取餐厅订单列表失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('订单列表');
    loadOrderList();
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