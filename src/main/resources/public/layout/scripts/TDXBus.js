$(function () {
    GetAuthorizationHeader();

    GetApiResponse();
})

$(setInterval(function () {
    GetAuthorizationHeader();

    GetApiResponse();
}, 30000))

var accesstokenStr;

function GetAuthorizationHeader() {
    const parameter = {
        grant_type: "client_credentials",
        client_id: "s1042180-7261d862-223d-4e9f",
        client_secret: "da220e20-4494-4afd-850e-f056f838a3be"
    };

    let auth_url = "https://tdx.transportdata.tw/auth/realms/TDXConnect/protocol/openid-connect/token";

    $.ajax({
        type: "POST",
        url: auth_url,
        crossDomain: true,
        dataType: 'JSON',
        data: parameter,
        async: false,
        success: function (data) {
            $("#accesstoken").text(JSON.stringify(data));
            accesstokenStr = JSON.stringify(data);
        },
        error: function (xhr, textStatus, thrownError) {

        }
    });
}

function GetApiResponse() {
    let accesstoken = JSON.parse(accesstokenStr);

    if (accesstoken != undefined) {
        $.ajax({
            type: 'GET',
            url: 'https://tdx.transportdata.tw/api/basic/v2/Bus/EstimatedTimeOfArrival/City/Taichung?%24select=StopSequence%2CPlateNumb%2CRouteName&%24filter=StopName%2FZh_tw%20eq%20%27%E5%85%AC%E7%9B%8A%E5%A4%A7%E5%A2%A9%E8%B7%AF%E5%8F%A3%27&%24top=30&%24format=JSON',
            headers: {
                "authorization": "Bearer " + accesstoken.access_token,
            },
            async: false,
            success: function (Data) {
                Data.forEach(element => {
                    if (element.RouteName.Zh_tw == 27) {
                        switch (element.Direction) {
                            case 0:
                                if (element.StopStatus == 0) {
                                    if (element.EstimateTime != 0) {
                                        $('#27_0').text(element.EstimateTime/60 + "分鐘")                                        
                                    }else {
                                        $('#27_0').text("進站中")
                                    }
                                }else {
                                    $('#27_0').text(new Date(element.NextBusTime).getHours() + " : " + new Date(element.NextBusTime).getMinutes())   
                                    console.log(String(new Date(element.NextBusTime).getHours()) + " : " + String(new Date(element.NextBusTime).getMinutes()));
                                }
                                break;
                            
                            case 1:
                                if (element.StopStatus == 0) {
                                    if (element.EstimateTime != 0) {
                                        $('#27_1').text(element.EstimateTime/60 + "分鐘")                                        
                                    }else {
                                        $('#27_1').text("進站中")
                                    }                                    
                                }else {
                                    $('#27_1').text(String(new Date(element.NextBusTime).getHours()).padStart(2, '0') + " : " + String(new Date(element.NextBusTime).getMinutes()).padStart(2, '0'))   
                                    console.log(String(new Date(element.NextBusTime).getHours()).padStart(2, '0') + " : " + String(new Date(element.NextBusTime).getMinutes()).padStart(2, '0'));
                                }
                                break;

                            default:
                                break;
                        }
                    }
                    if (element.RouteName.Zh_tw == 72) {
                        switch (element.Direction) {
                            case 0:
                                if (element.StopStatus == 0) { 
                                    if (element.EstimateTime != 0) {
                                        $('#72_0').text(element.EstimateTime/60 + "分鐘")                                        
                                    }else {
                                        $('#72_0').text("進站中")
                                    }                                   
                                }else {
                                    $('#72_0').text(String(new Date(element.NextBusTime).getHours()).padStart(2, '0') + " : " + String(new Date(element.NextBusTime).getMinutes()).padStart(2, '0'))   
                                }
                                break;
                            
                            case 1:
                                if (element.StopStatus == 0) { 
                                    if (element.EstimateTime != 0) {
                                        $('#72_1').text(element.EstimateTime/60 + "分鐘")                                        
                                    }else {
                                        $('#72_1').text("進站中")
                                    }                                   
                                }else {
                                    $('#72_1').text(String(new Date(element.NextBusTime).getHours()).padStart(2, '0') + " : " + String(new Date(element.NextBusTime).getMinutes()).padStart(2, '0'))   
                                }
                                break;

                            default:
                                break;
                        }
                    }
                    if (element.RouteName.Zh_tw == 81) {
                        switch (element.Direction) {
                            case 0:
                                if (element.StopStatus == 0) {                 
                                    if (element.EstimateTime != 0) {
                                        $('#81_0').text(element.EstimateTime/60 + "分鐘")                                        
                                    }else {
                                        $('#81_0').text("進站中")
                                    }                   
                                }else {
                                    $('#81_0').text(String(new Date(element.NextBusTime).getHours()).padStart(2, '0') + " : " + String(new Date(element.NextBusTime).getMinutes()).padStart(2, '0'))   
                                }
                                break;
                            
                            case 1:
                                if (element.StopStatus == 0) {      
                                    if (element.EstimateTime != 0) {
                                        $('#81_1').text(element.EstimateTime/60 + "分鐘")                                        
                                    }else {
                                        $('#81_1').text("進站中")
                                    }                              
                                }else {
                                    $('#81_1').text(String(new Date(element.NextBusTime).getHours()).padStart(2, '0') + " : " + String(new Date(element.NextBusTime).getMinutes()).padStart(2, '0'))   
                                }
                                break;

                            default:
                                break;
                        }
                    }
                    if (element.RouteName.Zh_tw == 107) {
                        switch (element.Direction) {
                            case 0:
                                if (element.StopStatus == 0) {             
                                    if (element.EstimateTime != 0) {
                                        $('#107_0').text(element.EstimateTime/60 + "分鐘")
                                    }else {
                                        $('#107_0').text("進站中")
                                    }                       
                                }else {
                                    $('#107_0').text(String(new Date(element.NextBusTime).getHours()).padStart(2, '0') + " : " + String(new Date(element.NextBusTime).getMinutes()).padStart(2, '0'))   
                                }
                                break;
                            
                            case 1:
                                if (element.StopStatus == 0) {      
                                    if (element.EstimateTime != 0) {
                                        $('#107_1').text(element.EstimateTime/60 + "分鐘")                                        
                                    }else {
                                        $('#107_1').text("進站中")
                                    }                              
                                }else {
                                    $('#107_1').text(String(new Date(element.NextBusTime).getHours()).padStart(2, '0') + " : " + String(new Date(element.NextBusTime).getMinutes()).padStart(2, '0'))   
                                }
                                break;

                            default:
                                break;
                        }
                    }
                });
            },
            error: function (xhr, textStatus, thrownError) {
                console.log('errorStatus:', textStatus);
                console.log('Error:', thrownError);
            }
        });
    }
}
