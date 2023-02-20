function verify(token) {
    var formData = new FormData();
    formData.append('token', token);
      
    // Google Apps Script 部署為網路應用程式後取得的 URL
    var uriGAS = "https://script.google.com/macros/s/AKfycbx_Usin0gxpagwEFadFO60clzuBoMEp-C_uWl0wVWf-E7jACJRNvpLFnvoNo7LZHZEqkQ/exec";
        
    fetch(uriGAS, {
      method: "POST",
      body: formData
    }).then(response => response.json())
      .then(result => {
        if(result.success) {
            // 後端驗證成功，success 會是 true
            $('#verify').show();
        } else {
            // success 為 false 時，代表驗證失敗，error-codes 會告知原因
            window.alert(result['error-codes'][0])
        }
      })
      .catch(err => {
          window.alert(err)
      })
  }

  // 過期要做的事
  function expired(ex) {
    $('#verify').hide();
  }
  
  // 失敗要做的事
  function error(err) {
    window.alert('reCAPTCHA 驗證失敗')
  }