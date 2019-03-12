function loadApplyList() {
    $.ajax({
        type: 'GET',
        url: "/service/manager/getApplyList",
        headers:{'token':localStorage.getItem("token")},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                let applications = body.applications;
                for(let i = 0;i<applications.length;i++){
                    let application = applications[i];
                    let tr = $("<tr>\n" +
                        "                        <td>"+application.rid+"</td>>\n" +
                        "                        <td>"+application.name+"</td>\n" +
                        "                        <td>"+application.email+"</td>\n" +
                        "                        <td>"+application.phone+"</td>\n" +
                        "                        <td>"+application.address+"</td>\n" +
                        "                        <td>"+application.type+"</td>\n" +
                        "                        <td>"+application.announcement+"</td>\n" +
                        "                        <td>\n" +
                        "                            <button class=\"btn btn-sm\" value=\""+application.rid+"\">approve</button>\n" +
                        "                            <button class=\"btn btn-sm\" value=\""+application.rid+"\">refuse</button>\n" +
                        "                        </td>\n" +
                        "                    </tr>");
                    $("#restaurantTBody").append(tr);
                }
                bind();
            }else {
                alert('获取餐厅注册列表失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    $("#caption1").text('餐厅注册申请');
    loadApplyList();
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

let bind = ()=>{
    $('.btn-sm').click(function () {
        alert('请求正在提交，请稍候');
        let request = {};
        request.rid = $(this).val();
        request.mid = localStorage.getItem("id");
        request.attitude = $(this).text();
        $.ajax({
            type: 'POST',
            url: "/service/manager/approveApplication",
            headers:{'token':localStorage.getItem("token")},
            data: JSON.stringify(request),
            success: function (data) {
                if (data.result === 0) {
                    alert('审核成功');
                    window.location.reload();
                } else {
                    alert(data.opinion);
                }
            },
            contentType: 'application/json',
            dataType: 'json'
        });
    });
};