function loadMemInfo() {
    $.ajax({
        type: 'GET',
        url: "/service/member/getInformation",
        headers:{'token':localStorage.getItem("token")},
        data:{'uid':localStorage.getItem('id')},
        success: function (data) {
            if(data.result===0){
                let body = data.body;
                $('#newName').val(body.name);
                $('#newPhone').val(body.phone);
                $('#address1').val(body.address1);
                $('#address2').val(body.address2);
                $('#address3').val(body.address3);
            }else {
                alert('获取用户信息失败');
            }
        },
        contentType: 'application/json',
        dataType: 'json'
    });
}

function intimate() {
    let name = localStorage.getItem("name");
    $("h1:first").append(name);
    loadMemInfo();
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

$('#modMemberInfoButton').click(function () {
    let member = {};
    member.uid = localStorage.getItem('id');
    member.newName = $('#newName').val();
    member.newPhone = $('#newPhone').val();
    member.address1 = $('#address1').val();
    member.address2 = $('#address2').val();
    member.address3 = $('#address3').val();

    if (member.newName!==''&&member.newPhone!=='') {
        $.ajax({
            type: 'POST',
            url: "/service/member/modifyInformation",
            headers:{'token':localStorage.getItem("token")},
            data: JSON.stringify(member),
            success: function (data) {
                if (data.result === 0) {
                    alert('修改用户信息成功');
                    window.location.href = "/memberInfo.html";
                } else {
                    alert(data.opinion)
                }
            },
            contentType: 'application/json',
            dataType: 'json'
        });
    } else {
        alert('会员信息不得为空');
    }
});
