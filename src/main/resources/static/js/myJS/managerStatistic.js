function getRestaurantStatistics() {
    $.ajax({
        type: 'GET',
        url: "/service/manager/getRestaurantStatistics",
        headers:{'token':localStorage.getItem("token")},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                let tr1 = $("<tr>\n" +
                    "                        <td>当前餐厅总数</td>>\n" +
                    "                        <td>"+body.restaurantNumber+"</td>\n" +
                    "                    </tr>");
                let tr2 = $("<tr>\n" +
                    "                        <td>餐厅申请注册数</td>>\n" +
                    "                        <td>"+body.applicationNumber+"</td>\n" +
                    "                    </tr>");
                $("#restaurantTBody").append(tr1,tr2);
            }else {
                alert('获取餐厅统计信息失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function getMemberStatistics() {
    $.ajax({
        type: 'GET',
        url: "/service/manager/getMemberStatistics",
        headers:{'token':localStorage.getItem("token")},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                let tr1 = $("<tr>\n" +
                    "                        <td>当前会员总数</td>>\n" +
                    "                        <td>"+body.memberNumber+"</td>\n" +
                    "                    </tr>");
                let tr2 = $("<tr>\n" +
                    "                        <td>注销会员总数</td>>\n" +
                    "                        <td>"+body.logOffMemberNumber+"</td>\n" +
                    "                    </tr>");
                $("#restaurantTBody").append(tr1,tr2);
            }else {
                alert('获取会员统计信息失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function getFinancialStatistics() {
    $.ajax({
        type: 'GET',
        url: "/service/manager/getFinancialStatistics",
        headers:{'token':localStorage.getItem("token")},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                let tr1 = $("<tr>\n" +
                    "                        <td>订单总数</td>>\n" +
                    "                        <td>"+body.totalOrder+"</td>\n" +
                    "                    </tr>");
                let tr2 = $("<tr>\n" +
                    "                        <td>总交易额</td>>\n" +
                    "                        <td>"+body.totalIncome+"</td>\n" +
                    "                    </tr>");
                $("#restaurantTBody").append(tr1,tr2);
            }else {
                alert('获取财务统计信息失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('Yummy系统统计信息');
    getRestaurantStatistics();
    getMemberStatistics();
    getFinancialStatistics();
}

intimate();

$('#managerButton1').click(function () {
    window.location.href = "/manager.html";
});

$('#managerButton2').click(function () {
    window.location.href = "/managerModList.html";
});

$('#managerButton3').click(function () {
    window.location.href = "/managerStatistic.html";
});

$('#managerButton4').click(function () {
    localStorage.clear();
    alert('退出成功');
    window.location.href = "/";
});