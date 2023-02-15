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
                <li><a href="/frontend/myorder.html" style="background-color: rgba(10,198,252);">訂單查詢</a></li>
                <li><a href="/frontend/person.html" style="background-color: rgba(10,198,252);">會員專區</a></li>
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
        msg.orders.forEach(function (value, index) {
            console.log(msg);
            if (value.items[0].status == 1) {
                $('#order').append(`
            <tr>
                <td>
                    <div class="guest-bx">
                        <img class="me-3" src="data:image/jpeg;base64,${value.items[0].room.roomType.roomPic}" alt="">
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomType.roomType}
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomFloor}
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomNum}
                    </div>
                </td>
                <td>
                    <div>
                        未付款
                    </div>
                </td>
                <td>
                    <a class="btn" onclick="getOrderdt(${value.id})" role="button">付款</a>
                </td>
            </tr>
            `)
            } else if (value.items[0].status == 2) {
                $('#order').append(`
            <tr>
                <td>
                    <div class="guest-bx">
                        <img class="me-3" src="data:image/jpeg;base64,${value.items[0].room.roomType.roomPic}" alt="">
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomType.roomType}
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomFloor}
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomNum}
                    </div>
                </td>
                <td>
                    <div>
                        已付款
                    </div>
                </td>
                <td>
                    <a class="btn" onclick="getOrderdt(${value.id})" role="button">查看</a>
                </td>
            </tr>
            `)
            }else if(value.items[0].status == 3){
                $('#order').append(`
            <tr>
                <td>
                    <div class="guest-bx">
                        <img class="me-3" src="data:image/jpeg;base64,${value.items[0].room.roomType.roomPic}" alt="">
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomType.roomType}
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomFloor}
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomNum}
                    </div>
                </td>
                <td>
                    <div>
                        已入住
                    </div>
                </td>
                <td>
                    <a class="btn" onclick="getOrderdt(${value.id})" role="button">查看</a>
                </td>
            </tr>
            `)
            }else {
                $('#order').append(`
            <tr>
                <td>
                    <div class="guest-bx">
                        <img class="me-3" src="data:image/jpeg;base64,${value.items[0].room.roomType.roomPic}" alt="">
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomType.roomType}
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomFloor}
                    </div>
                </td>
                <td>
                    <div>
                        ${value.items[0].room.roomNum}
                    </div>
                </td>
                <td>
                    <div>
                        已取消
                    </div>
                </td>
                <td>
                    <a class="btn" onclick="getOrderdt(${value.id})" role="button">查看</a>
                </td>
            </tr>
            `)
            }
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
