$(function () {
    GetAuthorizationHeader();

    GetApiResponse();
})

$(setInterval(function () {
    GetAuthorizationHeader();

    GetApiResponse();
},10000))

var accesstokenStr;

function GetAuthorizationHeader() {    
    const parameter = {
        grant_type:"client_credentials",
        client_id: "s1042180-7261d862-223d-4e9f",
        client_secret: "da220e20-4494-4afd-850e-f056f838a3be"
    };
    
    let auth_url = "https://tdx.transportdata.tw/auth/realms/TDXConnect/protocol/openid-connect/token";
        
    $.ajax({
        type: "POST",
        url: auth_url,
        crossDomain:true,
        dataType:'JSON',                
        data: parameter,
        async: false,       
        success: function(data){            
            $("#accesstoken").text(JSON.stringify(data));   
            accesstokenStr = JSON.stringify(data);                         
        },
        error: function (xhr, textStatus, thrownError) {
            
        }
    });          
}

function GetApiResponse(){    
    let accesstoken = JSON.parse(accesstokenStr);    

    if(accesstoken !=undefined){
        $.ajax({
            type: 'GET',
            url: 'https://tdx.transportdata.tw/api/basic/v2/Bus/EstimatedTimeOfArrival/City/Taichung?%24select=StopSequence%2CPlateNumb%2CRouteName&%24filter=StopName%2FZh_tw%20eq%20%27%E5%85%AC%E7%9B%8A%E5%A4%A7%E5%A2%A9%E8%B7%AF%E5%8F%A3%27&%24top=30&%24format=JSON',             
            headers: {
                "authorization": "Bearer " + accesstoken.access_token,                
              },            
            async: false,
            success: function (Data) {
                // $('#apireponse').text(JSON.stringify(Data));                
                console.log('Data', JSON.stringify(Data));
            },
            error: function (xhr, textStatus, thrownError) {
                console.log('errorStatus:',textStatus);
                console.log('Error:',thrownError);
            }
        });
    }
}