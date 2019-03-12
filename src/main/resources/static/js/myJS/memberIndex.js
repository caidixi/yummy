function loadRestaurantList() {
    $.ajax({
        type: 'GET',
        url: "/service/member/getRestaurantList",
        headers:{'token':localStorage.getItem("token")},
        data:{'uid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                let restaurants = body.restaurants;
                for(let i = 0;i<restaurants.length;i++){
                    let restaurant = restaurants[i];
                    let tr = $("<tr>\n" +
                        "                        <td>"+restaurant.name+"</td>>\n" +
                        "                        <td>"+restaurant.rid+"</td>\n" +
                        "                        <td><img src=\""+restaurant.picture+"\" border='0' class=\"img-responsive\"></td>\n" +
                        "                        <td>"+restaurant.type+"</td>\n" +
                        "                        <td>"+restaurant.distance+"</td>\n" +
                        "                        <td>"+restaurant.probablyTime+"</td>\n" +
                        "                        <td>\n" +
                        "                            <button class=\"btn btn-sm\" value=\""+restaurant.rid+"\">开始点餐</button>\n" +
                        "                        </td>\n" +
                        "                    </tr>");
                    $("#restaurantTBody").append(tr);
                }
                bind();
            }else {
                alert('获取餐厅列表失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('餐厅列表');
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

let bind = ()=>{
    $('.btn-sm').click(function () {
        localStorage.setItem('rid',$(this).val());
        window.location.href = "/memberMakeOrder.html";
    });
};