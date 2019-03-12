function loadOrder() {
    let request = {'uid':localStorage.getItem('id'),'oid':localStorage.getItem('oid')};
    $.ajax({
        type: 'POST',
        url: "/service/member/getOrderDetail",
        headers:{'token':localStorage.getItem("token")},
        data:JSON.stringify(request),
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                localStorage.setItem('orderState',body.state);
                localStorage.setItem('totalPrice',body.totalPrice);
                localStorage.setItem('packagePrice',body.packagePrice);
                localStorage.setItem('deliveryPrice',body.deliveryPrice);
                let tr1 = $("<tr>\n" +
                    "                        <td>订单号</td>>\n" +
                    "                        <td>"+body.oid+"</td>\n" +
                    "                    </tr>");
                let tr2 = $("<tr>\n" +
                    "                        <td>订单状态</td>>\n" +
                    "                        <td>"+body.state+"</td>\n" +
                    "                    </tr>");
                let tr3 = $("<tr>\n" +
                    "                        <td>下单/支付时间</td>>\n" +
                    "                        <td>"+body.time+"</td>\n" +
                    "                    </tr>");
                let tr4 = $("<tr>\n" +
                    "                        <td>餐厅编号</td>>\n" +
                    "                        <td>"+body.rid+"</td>\n" +
                    "                    </tr>");
                let tr5 = $("<tr>\n" +
                    "                        <td>总价</td>>\n" +
                    "                        <td>"+body.totalPrice+"</td>\n" +
                    "                    </tr>");
                let tr6 = $("<tr>\n" +
                    "                        <td>包装费</td>>\n" +
                    "                        <td>"+body.packagePrice+"</td>\n" +
                    "                    </tr>");
                let tr7 = $("<tr>\n" +
                    "                        <td>快递费</td>>\n" +
                    "                        <td>"+body.deliveryPrice+"</td>\n" +
                    "                    </tr>");
                $("#infoTBody").append(tr1,tr2,tr3,tr4,tr5,tr6,tr7);
                let foods = body.foods;
                for(let i = 0;i<foods.length;i++){
                    let food = foods[i];
                    let tr = $("<tr>\n" +
                        "                        <td>"+food.name+"</td>>\n" +
                        "                        <td>"+food.price+"</td>\n" +
                        "                        <td>"+food.discount+"</td>\n" +
                        "                        <td>"+food.number+"</td>\n" +
                        "                        <td>"+food.discountLimit+"</td>\n" +
                        "                    </tr>");
                    $("#foodTBody").append(tr);
                }
                bind();
            }else {
                alert('获取订单详细信息失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('订单详情');
    loadOrder();

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

$('#payOrderButton').click(function () {
    window.location.href = "/memberPayOrder.html";
});

$('#cancelOrderButton').click(function () {
    let order = {};
    order.uid = localStorage.getItem('id');
    order.oid = localStorage.getItem('oid');
    $.ajax({
        type: 'POST',
        url: "/service/member/cancelOrder",
        headers:{'token':localStorage.getItem("token")},
        data: JSON.stringify(order),
        success: function (data) {
            if (data.result === 0) {
                alert('订单取消成功');
                window.location.href = "/memberOrder.html";
            } else {
                alert(data.opinion)
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
});

$('#confirmOrderButton').click(function () {
    let order = {};
    order.uid = localStorage.getItem('id');
    order.oid = localStorage.getItem('oid');
    $.ajax({
        type: 'POST',
        url: "/service/member/confirmOrder",
        headers:{'token':localStorage.getItem("token")},
        data: JSON.stringify(order),
        success: function (data) {
            if (data.result === 0) {
                alert('订单已确认送达');
                window.location.href = "/memberOrder.html";
            } else {
                alert(data.opinion)
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
});

let bind = ()=>{
    let state = localStorage.getItem('orderState');
    if(state==='cancel'||state==='done'){
        $('#payOrderButton').remove();
        $('#cancelOrderButton').remove();
        $('#confirmOrderButton').remove();
    }else if(state === 'paid'){
        $('#payOrderButton').remove();
    }else if(state === 'unpaid'){
        $('#confirmOrderButton').remove();
    }
};