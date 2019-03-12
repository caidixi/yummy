function loadOrderList() {
    $.ajax({
        type: 'GET',
        url: "/service/member/getOrderList",
        headers:{'token':localStorage.getItem("token")},
        data:{'uid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                let orders = body.orders;
                for(let i = 0;i<orders.length;i++){
                    let order = orders[i];
                    let tr = $("<tr>\n" +
                        "                        <td>"+order.rid+"</td>>\n" +
                        "                        <td>"+order.restaurantName+"</td>\n" +
                        "                        <td>"+order.oid+"</td>\n" +
                        "                        <td>"+order.time+"</td>\n" +
                        "                        <td>"+order.price+"</td>\n" +
                        "                        <td>"+order.firstFood+"</td>\n" +
                        "                        <td>"+order.state+"</td>\n" +
                        "                        <td>\n" +
                        "                            <button class=\"btn btn-sm\" value=\""+order.oid+"\">detail</button>\n" +
                        "                        </td>\n" +
                        "                    </tr>");
                    $("#orderTBody").append(tr);
                }
                bind();
            }else {
                alert('获取订单列表失败');
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

let bind = ()=>{
    $('.btn-sm').click(function () {
        localStorage.setItem('oid',$(this).val());
        window.location.href = "/memberOrderDetail.html";
    });
};