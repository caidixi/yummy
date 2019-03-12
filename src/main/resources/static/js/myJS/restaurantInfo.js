function loadRestaurantInfo() {
    $.ajax({
        type: 'GET',
        url: "/service/restaurant/getInformation",
        headers:{'token':localStorage.getItem("token")},
        data:{'rid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                let tr1 = $("<tr>\n" +
                    "                        <td>餐厅名</td>>\n" +
                    "                        <td>"+body.name+"</td>\n" +
                    "                    </tr>");
                let tr2 = $("<tr>\n" +
                    "                        <td>餐厅注册码</td>>\n" +
                    "                        <td>"+body.rid+"</td>\n" +
                    "                    </tr>");
                let tr3 = $("<tr>\n" +
                    "                        <td>餐厅注册邮箱</td>>\n" +
                    "                        <td>"+body.email+"</td>\n" +
                    "                    </tr>");
                let tr4 = $("<tr>\n" +
                    "                        <td>餐厅电话</td>>\n" +
                    "                        <td>"+body.phone+"</td>\n" +
                    "                    </tr>");
                let tr5 = $("<tr>\n" +
                    "                        <td>餐厅地址</td>>\n" +
                    "                        <td>"+body.address+"</td>\n" +
                    "                    </tr>");
                let tr6 = $("<tr>\n" +
                    "                        <td>餐厅类型</td>>\n" +
                    "                        <td>"+body.type+"</td>\n" +
                    "                    </tr>");
                let tr7 = $("<tr>\n" +
                    "                        <td>餐厅备注</td>>\n" +
                    "                        <td>"+body.announcement+"</td>\n" +
                    "                    </tr>");
                $("#orderTBody").append(tr1,tr2,tr3,tr4,tr5,tr6,tr7);
            }else {
                alert('获取餐厅注册信息失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('餐厅注册信息');
    loadRestaurantInfo();
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

$('#modRestInfoButton').click(function () {
    window.location.href = "/restaurantModInfo.html";
});