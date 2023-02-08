$(function () {
    getWeather();
})

$(setInterval(function () {
    getWeather();
},10000))


function getWeather() {
    $.ajax({
        type: 'GET',
        url: 'https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0003-001?Authorization=CWB-1D8048FE-4B0B-446F-8CF1-525AF90FBCAF&stationId=467490',                     
        async: false,
        success: function (Data) {
            // $('#weather').text(JSON.stringify(Data.records.location[0].parameter[0].parameterValue + " " + Data.records.location[0].weatherElement[3].elementValue + " " + Data.records.location[0].weatherElement[20].elementValue));  
            console.log("天氣資訊" , Data.records.location[0].parameter[0].parameterValue + " " + Data.records.location[0].weatherElement[3].elementValue + " " + Data.records.location[0].weatherElement[20].elementValue);
        },
        error: function (xhr, textStatus, thrownError) {
            console.log('errorStatus:',textStatus);
            console.log('Error:',thrownError);
        }
    });
}