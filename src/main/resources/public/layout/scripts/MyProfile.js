function getProfile(msg) {
    $.ajax({
        url: '/member/checkLogin',
        type: 'GET',
        dataType: 'json'
    }).done(function (msg) {
        console.log(msg);
        $('.mId').val(msg.userMsg.id).text(msg.userMsg.id)
        $('.realName').val(msg.userMsg.realName).text(msg.userMsg.realName)
        $('.acc').val(msg.userMsg.account).text(msg.userMsg.account)
        $('.tel').val(msg.userMsg.tel).text(msg.userMsg.tel)
        $('.email').val(msg.userMsg.email).text(msg.userMsg.email)
    })
}