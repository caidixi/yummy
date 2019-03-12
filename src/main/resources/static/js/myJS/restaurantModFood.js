function loadFood() {
    $.ajax({
        type: 'GET',
        url: "/common/getFoodInfo",
        data:{'fid':localStorage.getItem('fid')},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                $("#foodName").val(body.name);
                $("#announcement").val(body.announcement);
                $("#price").val(body.price);
                $("#packagePrice").val(body.packagePrice);
                $("#number").val(body.quality);
                $("#picture").val(body.picture);
                $("#discount").val(body.discount);
                $("#discountLimit").val(body.discountLimit);
            }else {
                alert('获取食品信息失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function getFood() {
    let food = {};
    food.rid = localStorage.getItem('id');
    food.fid = localStorage.getItem('fid');
    food.newFoodName = $("#foodName").val();
    food.newAnnouncement = $("#announcement").val();
    food.newPrice = $("#price").val();
    food.newPackagePrice = $("#packagePrice").val();
    food.newNumber = $("#number").val();
    food.newPicture = $("#picture").val();
    food.newDiscount = $("#discount").val();
    food.newDiscountLimit = $("#discountLimit").val();
    return food;
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    loadFood();
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

$('#modFoodButton').click(function () {
    let food = getFood();
    if (food.foodName !== '' && food.price !== '' && food.packagePrice !== '' && food.number !== '') {
        $.ajax({
            type: 'POST',
            url: "/service/restaurant/modifyFood",
            headers:{'token':localStorage.getItem("token")},
            data: JSON.stringify(food),
            success: function (data) {
                if (data.result === 0) {
                    alert('修改食品成功');
                    window.location.href = "/restaurantDetail.html";
                } else {
                    alert(data.opinion)
                }
            },
            contentType: 'application/json',
            dataType: 'json'
        });
    } else {
        alert('食品不得为空');
    }
});