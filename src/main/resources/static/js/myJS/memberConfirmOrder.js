function loadFoodList() {
    $('#memberName').append(localStorage.getItem('name'));
    $('#restaurantName').append(localStorage.getItem('restaurantName'));
    $('#restaurantAddress').append(localStorage.getItem('restaurantAddress'));
    $('#restaurantDiscount').append(localStorage.getItem('restaurantDiscount'));

    let foods = JSON.parse(localStorage.getItem('foods'));
    for(let i = 0;i<foods.length;i++){
        let food = foods[i];
        let tr = $("<tr>\n" +
            "                        <td>"+food.name+"</td>>\n" +
            "                        <td>"+food.fid+"</td>\n" +
            "                        <td>"+food.number+"</td>\n" +
            "                    </tr>");
        $("#foodTBody").append(tr);
    }

    $.ajax({
        type: 'GET',
        url: "/service/member/getInformation",
        headers:{'token':localStorage.getItem("token")},
        data:{'uid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0) {
                let body = data.body;
                $('#memberDiscount').append(body.memberDiscount);
                let tr = $(
                    "                            <option>"+body.address1+"</option>\n" +
                    "                            <option>"+body.address2+"</option>\n" +
                    "                            <option>"+body.address3+"</option>");
                $("#memberAddress").append(tr);
            }else {
                alert('加载用户信息失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('订单食品列表');
    loadFoodList();
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

$('#submitButton').click(function () {
    let order = {};
    order.uid = localStorage.getItem('id');
    order.rid = localStorage.getItem('rid');
    order.foods = JSON.parse(localStorage.getItem('foods'));
    order.address = $('#memberAddress').val();
    order.numOfDinner = $('#numOfDinner').val();
    order.remark = $('#remark').val();
    if (order.numOfDinner>0) {
        $.ajax({
            type: 'POST',
            url: "/service/member/makeOrder",
            headers:{'token':localStorage.getItem("token")},
            data: JSON.stringify(order),
            success: function (data) {
                if (data.result === 0) {
                    let body = data.body;
                    localStorage.setItem('oid',body.oid);
                    localStorage.setItem('totalPrice',body.totalPrice);
                    localStorage.setItem('packagePrice',body.packagePrice);
                    localStorage.setItem('deliveryPrice',body.deliveryPrice);
                    alert('成功确认订单，请于15分钟内付款');
                    window.location.href = "/memberPayOrder.html";
                } else {
                    alert(data.opinion)
                }
            },
            contentType: 'application/json',
            dataType: 'json'
        });
    } else {
        alert('请输入正确的用餐人数');
    }
});

$('#returnButton').click(function () {
    window.location.href = "/memberMakeOrder.html";
});