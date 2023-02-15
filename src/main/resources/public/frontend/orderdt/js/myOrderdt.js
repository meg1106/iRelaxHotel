var oId = sessionStorage.getItem("order_id");
var totalAmount;
var tradeDesc;
var itemName;
$.ajax({
  url: '/member/checkLogin',
  type: 'GET',
  dataType: 'json'
}).done(function (msg) {
  $.ajax({
    url: `/order/o${oId}`,
    type: 'GET',
    dataType: 'json'
  }).done(function (msg) {
    console.log(msg);
    totalAmount = msg.items[0].room.roomType.roomPrice;
    // tradeDesc = msg.items[0].room.roomType.content;
    tradeDesc = "iRelaxHotel飯店訂單付款";
    itemName = msg.items[0].room.roomType.roomType;
    if (msg.items[0].status == 1) {
      $('#orderdt').append(`
            <form action="" method="">
        <h2 class="sub-heading-agileits">iRelax 訂房明細</h2>
        <div class="main-flex-w3ls-sectns">
          <div class="field-agileinfo-spc form-w3-agile-text1">
            <div class="radio-section">
              <h6>訂單編號：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.id}</label>
              </ul>
            </div>
          </div>
          <div class="field-agileinfo-spc form-w3-agile-text2">
            <div class="radio-section">
              <h6>訂單日期：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.orderDate}</label>
              </ul>
            </div>
          </div>
        </div>
        <div class="main-flex-w3ls-sectns">
          <div class="field-agileinfo-spc form-w3-agile-text1">
            <div class="radio-section">
              <h6>入住日期：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.items[0].checkinDate}</label>
              </ul>
            </div>
          </div>
          <div class="field-agileinfo-spc form-w3-agile-text2">
            <div class="radio-section">
              <h6>退房日期：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.items[0].checkoutDate}</label>
              </ul>
            </div>
          </div>
        </div>

        <div class="triple-wthree">
          <div class="field-agileinfo-spc form-w3-agile-text11">
            <div class="radio-section">
              <h6>房型名稱：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.items[0].room.roomType.roomType}</label>
              </ul>
            </div>
          </div>
          <div class="field-agileinfo-spc form-w3-agile-text22">
            <div class="radio-section">
              <h6>樓　　層：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.items[0].room.roomFloor}</label>
              </ul>
            </div>
          </div>
          <div class="field-agileinfo-spc form-w3-agile-text33">
            <div class="radio-section">
              <h6>房　　號：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.items[0].room.roomNum}</label>
              </ul>
            </div>
          </div>
        </div>
        <div class="radio-section">
          <div class="radio-section">
            <h6>價　　格：</h6>
            <ul class="radio-buttons-w3-agileits">
              <label for="a-option">${msg.items[0].room.roomType.roomPrice}</label>
            </ul>
          </div>
        </div>
        <h3 class="sub-heading-agileits">iRelax 預訂者</h3>
        <div class="main-flex-w3ls-sectns">
          <div class="field-agileinfo-spc form-w3-agile-text1">
            <div class="radio-section">
              <h6>會員名稱：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.member.realName}</label>
              </ul>
            </div>
          </div>
          <div class="field-agileinfo-spc form-w3-agile-text2">
            <div class="radio-section">
              <h6>會員帳號：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.member.account}</label>
              </ul>
            </div>
          </div>
        </div>
        <div class="field-agileinfo-spc form-w3-agile-text">
          <div class="radio-section">
            <h6>連絡電話：</h6>
            <ul class="radio-buttons-w3-agileits">
              <label for="a-option">${msg.member.tel}</label>
            </ul>
          </div>
        </div>

        <div class="main-flex-w3ls-sectns">
          <div class="field-agileinfo-spc form-w3-agile-text1">
            <div class="radio-section">
              <h6>信　　箱：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">gavinlin123@yahoo.com.tw</label>
              </ul>
            </div>
          </div>
        </div>
        <div class="clear"></div>
        <a class="btn btn-warning btn-lg" href="javascript:payment()" role="button">
          付款
        </a>
        <a class="btn btn-warning btn-lg" href="../myorder.html" role="button">
          返回
        </a>
        <div class="clear"></div>
      </form>
            `)
    } else {
      $('#orderdt').append(`
            <form action="#" method="post">
        <h2 class="sub-heading-agileits">iRelax 訂房明細</h2>
        <div class="main-flex-w3ls-sectns">
          <div class="field-agileinfo-spc form-w3-agile-text1">
            <div class="radio-section">
              <h6>訂單編號：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.id}</label>
              </ul>
            </div>
          </div>
          <div class="field-agileinfo-spc form-w3-agile-text2">
            <div class="radio-section">
              <h6>訂單日期：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${orderDate}</label>
              </ul>
            </div>
          </div>
        </div>
        <div class="main-flex-w3ls-sectns">
          <div class="field-agileinfo-spc form-w3-agile-text1">
            <div class="radio-section">
              <h6>入住日期：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${checkinDate}</label>
              </ul>
            </div>
          </div>
          <div class="field-agileinfo-spc form-w3-agile-text2">
            <div class="radio-section">
              <h6>退房日期：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${checkoutDate}</label>
              </ul>
            </div>
          </div>
        </div>

        <div class="triple-wthree">
          <div class="field-agileinfo-spc form-w3-agile-text11">
            <div class="radio-section">
              <h6>房型名稱：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.items[0].room.roomType.roomType}</label>
              </ul>
            </div>
          </div>
          <div class="field-agileinfo-spc form-w3-agile-text22">
            <div class="radio-section">
              <h6>樓　　層：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.items[0].room.roomFloor}</label>
              </ul>
            </div>
          </div>
          <div class="field-agileinfo-spc form-w3-agile-text33">
            <div class="radio-section">
              <h6>房　　號：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.items[0].room.roomNum}</label>
              </ul>
            </div>
          </div>
        </div>
        <div class="radio-section">
          <div class="radio-section">
            <h6>價　　格：</h6>
            <ul class="radio-buttons-w3-agileits">
              <label for="a-option">${msg.items[0].room.roomType.roomPrice}</label>
            </ul>
          </div>
        </div>
        <h3 class="sub-heading-agileits">iRelax 預訂者</h3>
        <div class="main-flex-w3ls-sectns">
        <div class="field-agileinfo-spc form-w3-agile-text2">
            <div class="radio-section">
              <h6>會員帳號：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.member.account}</label>
              </ul>
            </div>
          </div>
          <div class="field-agileinfo-spc form-w3-agile-text1">
            <div class="radio-section">
              <h6>會員名稱：</h6>
              <ul class="radio-buttons-w3-agileits">
                <label for="a-option">${msg.member.realName}</label>
              </ul>
            </div>
          </div>
          
        </div>
        <div class="field-agileinfo-spc form-w3-agile-text">
          <div class="radio-section">
            <h6>連絡電話：</h6>
            <ul class="radio-buttons-w3-agileits">
              <label for="a-option">${msg.member.tel}</label>
            </ul>
          </div>
        </div>
        <a class="btn btn-warning btn-lg" href="../myorder.html" role="button">
          返回
        </a>
        <div class="clear"></div>
      </form>
            `)
    }
  })
})

function payment() {
  console.log(oId);
  console.log(totalAmount);
  console.log(tradeDesc);
  console.log(itemName);
  window.sessionStorage.setItem("order_id", oId);
  window.sessionStorage.setItem("totalAmount", totalAmount);
  window.sessionStorage.setItem("tradeDesc", tradeDesc);
  window.sessionStorage.setItem("itemName", itemName);
  location.href = "../paymentForm.html";
}