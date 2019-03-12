function getFood() {
    let food = {};
    food.rid = localStorage.getItem('id');
    food.foodName = $("#foodName").val();
    food.announcement = $("#announcement").val();
    food.price = $("#price").val();
    food.packagePrice = $("#packagePrice").val();
    food.number = $("#number").val();
    food.picture = $("#picture").val();
    food.discount = $("#discount").val();
    food.discountLimit = $("#discountLimit").val();
    return food;
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
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

$('#addFoodButton').click(function () {
    let food = getFood();
    if (food.foodName !== '' && food.price !== '' && food.packagePrice !== '' && food.number !== '') {
        $.ajax({
            type: 'POST',
            url: "/service/restaurant/newFood",
            headers:{'token':localStorage.getItem("token")},
            data: JSON.stringify(food),
            success: function (data) {
                if (data.result === 0) {
                    alert('添加食品成功');
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