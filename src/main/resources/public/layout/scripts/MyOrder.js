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
                <li><a href="localhost:8080/frontend/myorder" style="background-color: rgba(10,198,252);">訂單查詢</a></li>
                <li><a href="localhost:8080/frontend/person" style="background-color: rgba(10,198,252);">會員專區</a></li>
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
    $.ajax({
        url: `/member/${msg.userMsg.id}`,
        type: 'GET',
        dataType: 'json'
    }).done(function (msg) {
        msg.orders.forEach(function(value, index) {
            console.log(msg);
            $('#order').append(`
            <tr>
                <td>
                    <div class="guest-bx">
                        <img class="me-3" src="data:image/jpeg;base64,${value.items[index].room.roomType.roomPic}" alt="">
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[index].room.roomType.roomType}
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[index].room.roomFloor}
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[index].room.roomNum}
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[index].status}
                    </div>
                </td>
                <td>
                    <a class="btn" onclick="getOrderdt(${value.id})" role="button">查看</a>
                </td>
            </tr>
            `)
        });

    })
})
function logout() {
    $.ajax({
        type: "POST",
        url: "/member/logout"
    })
}
function getOrderdt(oId) {
    sessionStorage.setItem("order_id", oId)
    location.href = "./orderdt/orderdt.html"
}
