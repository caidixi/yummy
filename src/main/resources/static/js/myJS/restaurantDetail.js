function loadRestaurantInfo() {
    $.ajax({
        type: 'GET',
        url: "/service/restaurant/getDetail",
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
                    "                        <td>餐厅折扣</td>>\n" +
                    "                        <td>"+body.totalDiscount+"</td>\n" +
                    "                    </tr>");
                $("#infoTBody").append(tr1,tr2,tr3);
                let foods = body.foods;
                for(let i = 0;i<foods.length;i++){
                    let food = foods[i];
                    let tr = $("<tr>\n" +
                        "                        <td>"+food.name+"</td>>\n" +
                        "                        <td>"+food.fid+"</td>\n" +
                        "                        <td>"+food.announcement+"</td>\n" +
                        "                        <td>"+food.picture+"</td>\n" +
                        "                        <td>"+food.price+"</td>\n" +
                        "                        <td>"+food.packagePrice+"</td>\n" +
                        "                        <td>"+food.discount+"</td>\n" +
                        "                        <td>"+food.discountLimit+"</td>\n" +
                        "                        <td>"+food.quality+"</td>\n" +
                        "                        <td>\n" +
                        "                            <button class=\"btn btn-sm\" value=\""+food.fid+"\">modify</button>\n" +
                        "                            <button class=\"btn btn-sm\" value=\""+food.fid+"\">delete</button>\n" +
                        "                        </td>\n" +
                        "                    </tr>");
                    $("#foodTBody").append(tr);
                }
                bind();
            }else {
                alert('获取餐厅详细信息失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('餐厅详细信息');
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

$('#modDiscountButton').click(function () {
    window.location.href = "/restaurantModDiscount.html";
});

$('#addFoodButton').click(function () {
    window.location.href = "/restaurantAddFood.html";
});

let bind = ()=>{
    $('.btn-sm').click(function () {
        let movement = $(this).text();
        if(movement==='modify'){
            localStorage.setItem('fid',$(this).val());
            window.location.href = "/restaurantModFood.html";
        }else if (movement === 'delete') {
            let request = {};
            request.rid = localStorage.getItem('id');
            request.fid = $(this).val();
            $.ajax({
                type: 'POST',
                url: "service/restaurant/deleteFood",
                headers:{'token':localStorage.getItem("token")},
                data: JSON.stringify(request),
                success: function (data) {
                    if (data.result === 0) {
                        alert('删除食品成功');
                        window.location.reload();
                    } else {
                        alert(data.opinion);
                    }
                },
                contentType: 'application/json',
                dataType: 'json'
            });
        }
    });
};