function getRestaurant() {
    let restaurant = {};
    restaurant.rid = localStorage.getItem('id');
    restaurant.newName = $("#newName").val();
    restaurant.newPhone = $("#newPhone").val();
    restaurant.newAddress = $("#newAddress").val();
    restaurant.newAccountId = $("#newAccountId").val();
    restaurant.newType = $("#newType").val();
    restaurant.newAnnouncement = $("#newAnnouncement").val();
    restaurant.newPicture = $("#newPicture").val();
    return restaurant;
}

function loadRestaurantInfo() {
    $.ajax({
        type: 'GET',
        url: "/service/restaurant/getInformation",
        headers:{'token':localStorage.getItem("token")},
        data:{'rid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                $('#newName').val(body.name);
                $('#newPhone').val(body.phone);
                $('#newAddress').val(body.address);
                $('#newAccountId').val(body.accountId);
                $('#newAnnouncement').val(body.announcement);
                $('#newPicture').val(body.picture);
            }else {
                alert('获取餐厅统计信息失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
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
    let restaurant = getRestaurant();

    if (restaurant.name !== '' && restaurant.email !== '' && restaurant.phone !== '' && restaurant.address !== '') {
        $.ajax({
            type: 'POST',
            url: "/service/restaurant/modifyInformation",
            headers:{'token':localStorage.getItem("token")},
            data: JSON.stringify(restaurant),
            success: function (data) {
                if (data.result === 0) {
                    alert('申请成功,请等待申请审批');
                    window.location.href = "/restaurantInfo.html";
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