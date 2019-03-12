function loadOrderInfo() {
    $('#oid').append(localStorage.getItem('oid'));
    $('#totalPrice').append(localStorage.getItem('totalPrice'));
    $('#packagePrice').append(localStorage.getItem('packagePrice'));
    $('#deliveryPrice').append(localStorage.getItem('deliveryPrice'));
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    loadOrderInfo();
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

$('#payButton').click(function () {
    let payment = {};
    payment.uid = localStorage.getItem('id');
    payment.oid = localStorage.getItem('oid');
    payment.accountId = $('#accountId').val();
    payment.accountPassword = $('#accountPassword').val();
    $.ajax({
        type: 'POST',
        url: "/service/member/payOrder",
        headers:{'token':localStorage.getItem("token")},
        data: JSON.stringify(payment),
        success: function (data) {
            if (data.result === 0) {
                alert('订单支付成功');
                window.location.href = "/memberOrder.html";
            } else {
                alert(data.opinion)
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
});