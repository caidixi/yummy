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

$('#modDiscountButton').click(function () {
    let modification = {};
    modification.rid = localStorage.getItem('id');
    modification.totalDiscount = $('#totalDiscount').val();
    modification.fullRections = {};
    if (modification.totalDiscount!=='') {
        $.ajax({
            type: 'POST',
            url: "/service/restaurant/newDiscount",
            headers:{'token':localStorage.getItem("token")},
            data: JSON.stringify(modification),
            success: function (data) {
                if (data.result === 0) {
                    alert('修改优惠成功');
                    window.location.href = "/restaurantDetail.html";
                } else {
                    alert(data.opinion)
                }
            },
            contentType: 'application/json',
            dataType: 'json'
        });
    } else {
        alert('折扣必须小于1，大于0，不得为空');
    }
});