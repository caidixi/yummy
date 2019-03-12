function getRestaurant() {
    let restaurant = {};
    restaurant.name = $("#name").val();
    restaurant.email = $("#email").val();
    restaurant.phone = $("#phone").val();
    restaurant.address = $("#address").val();
    restaurant.accountId = $("#accountId").val();
    restaurant.type = $("#type").val();
    restaurant.announcement = $("#announcement").val();
    return restaurant;
}

$("#signUpButton").click(function () {
    let restaurant = getRestaurant();

    if (restaurant.name !== '' && restaurant.email !== '' && restaurant.phone !== '' && restaurant.address !== '') {
        $.ajax({
            type: 'POST',
            url: "/common/restaurantSignUp",
            data: JSON.stringify(restaurant),
            success: function (data) {
                if (data.result === 0) {
                    alert('注册申请成功,请等待申请审批，审批结果会发送至您的邮箱');
                    window.location.href = '/';
                } else {
                    alert(data.opinion)
                }
            },
            contentType: 'application/json',
            dataType: 'json'
        });
    } else {
        alert('注册信息不得为空');
    }
});

$("#hasAccount").click(function () {
    window.location.href = "/";
});