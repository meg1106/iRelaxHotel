$.ajax({
    url: '/member/checkLogin',
    type: 'GET',
    dataType: 'json'
  }).done(function (msg) {
    if (msg.status == 'success') {
      $('#loginBar').append(
        `
        <li><a id="account" class="drop">${msg.userMsg.realName}</a>
          <ul>
            <li><a href="#" style="background-color: rgba(10,198,252);">訂單查詢</a></li>
            <li><a href="#" style="background-color: rgba(10,198,252);">會員專區</a></li>
            <li><a href="" onclick="logout()" style="background-color: rgba(10,198,252);">登出</a></li>
          </ul>
        </li>
        `
      )
    } else {
      $('#loginBar').append(
        `
          <span><a href="/frontend/login.html" style="display: flex; flex-direction: row; flex-wrap: nowrap;">登入<span>
        `
      )
    }
  }).done(function (msg) {
    console.log(msg);
    $('.mId').val(msg.userMsg.id).text(msg.userMsg.id)
    $('.realName').val(msg.userMsg.realName).text(msg.userMsg.realName)
    $('.acc').val(msg.userMsg.account).text(msg.userMsg.account)
    $('.tel').val(msg.userMsg.tel).text(msg.userMsg.tel)
    $('.email').val(msg.userMsg.email).text(msg.userMsg.email)
  })
  function logout() {
    $.ajax({
        type: "POST",
        url: "/member/logout"
      })
  }