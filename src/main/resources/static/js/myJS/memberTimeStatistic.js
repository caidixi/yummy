function loadStatistic() {
    $.ajax({
        type: 'GET',
        url: "/service/member/getDetailByTime",
        headers:{'token':localStorage.getItem("token")},
        data:{'uid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                let mouths = body.mouths;
                for(let i = 0;i<mouths.length;i++){
                    let mouthStatistic = mouths[i];
                    let tr = $("<tr>\n" +
                        "                        <td>"+mouthStatistic.year+"</td>>\n" +
                        "                        <td>"+mouthStatistic.mouth+"</td>\n" +
                        "                        <td>"+mouthStatistic.times+"</td>\n" +
                        "                        <td>"+mouthStatistic.totalMoney+"</td>\n" +
                        "                        <td>"+mouthStatistic.averageMoney+"</td>\n" +
                        "                    </tr>");
                    $("#statisticTBody").append(tr);
                }
            }else {
                alert('获取会员花费统计失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('会员每月花费统计');
    loadStatistic();
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