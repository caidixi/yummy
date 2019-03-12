function loadFoodList() {
    let request = {'uid':localStorage.getItem('id'),'rid':localStorage.getItem('rid')};
    $.ajax({
        type: 'POST',
        url: "/service/member/getRestaurantDetail",
        headers:{'token':localStorage.getItem("token")},
        data: JSON.stringify(request),
        success: function (data) {
            if (data.result === 0) {
                let body = data.body;
                $('#restaurantName').append(body.name);
                $('#rid').append(body.rid);
                $('#restaurantAddress').append(body.address);
                $('#restaurantAnnouncement').append(body.announcement);
                $('#discount').append(body.totalDiscount);

                localStorage.setItem('restaurantName',body.name);
                localStorage.setItem('restaurantAddress',body.address);
                localStorage.setItem('restaurantDiscount',body.totalDiscount);

                let foods = body.foods;
                for(let i = 0;i<foods.length;i++){
                    let food = foods[i];
                    let tr = $("<tr>\n" +
                        "                        <td>"+food.name+"</td>>\n" +
                        "                        <td>"+food.fid+"</td>\n" +
                        "                        <td>"+food.announcement+"</td>\n" +
                        "                        <td><img src=\""+food.picture+"\" border='0' class=\"img-responsive\"></td>\n" +
                        "                        <td>"+food.price+"</td>\n" +
                        "                        <td>"+food.packagePrice+"</td>\n" +
                        "                        <td>"+food.discount+"</td>\n" +
                        "                        <td>"+food.discountLimit+"</td>\n" +
                        "                        <td>"+food.quality+"</td>\n" +
                        "                        <td> <input id=\""+food.fid+"\" name=\""+food.name+"\" pattern=\"[0-99]\" value=\"0\" type=\"number\"></td>"+
                        "                    </tr>");
                    $("#foodTBody").append(tr);
                }
            } else {
                alert(data.opinion);
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('餐厅食品列表');
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
    let food = $("input:first");
    let foods = [];
    let i = 0;
    while (true){
        foods[i] = {'fid':food.attr('id'),'number':food.val(),'name':food.attr('name')};
        food = food.next();
        if(food.attr('id')===undefined){
            break;
        }else {
            i = i+1;
        }
    }
    localStorage.setItem('foods',JSON.stringify(foods));
    window.location.href = "/memberConfirmOrder.html";
});