$(function () {
    getWeather();
})

$(setInterval(function () {
    getWeather();
},600000))


function getWeather() {
    $.ajax({
        type: 'GET',
        url: 'https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0003-001?Authorization=CWB-1D8048FE-4B0B-446F-8CF1-525AF90FBCAF&stationId=467490',                     
        async: false,
        success: function (Data) {
            // console.log(Data);
            console.log(Data.records.location[0].parameter[0].parameterValue)
            // $('#weather').text(JSON.stringify(Data.records.location[0].parameter[0].parameterValue + " " + Data.records.location[0].weatherElement[3].elementValue + " " + Data.records.location[0].weatherElement[20].elementValue));  
            console.log("天氣資訊" , Data.records.location[0].parameter[0].parameterValue + " " + Data.records.location[0].weatherElement[3].elementValue + " " + Data.records.location[0].weatherElement[20].elementValue);
            $('#weather_content').empty();

            if(Data.records.location[0].weatherElement[20].elementValue == '多雲時晴' || Data.records.location[0].weatherElement[20].elementValue == '晴時多雲' || Data.records.location[0].weatherElement[20].elementValue == '多雲' ){
                $('#weather_content').append(
                    `
                  <span style="font-size: 16px;">${Data.records.location[0].parameter[0].parameterValue}</span>
                  <span style="font-size: 16px; padding:0 5px;">${Data.records.location[0].weatherElement[3].elementValue}°C</span>
                  <img src="https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/03.svg" class="weather_img"></img>
                  `
                  )
            }else if(Data.records.location[0].weatherElement[20].elementValue == '多雲時陰' || Data.records.location[0].weatherElement[20].elementValue == '陰時多雲' || Data.records.location[0].weatherElement[20].elementValue == '陰'){
                $('#weather_content').append(
                    `
                  <span style="font-size: 16px;">${Data.records.location[0].parameter[0].parameterValue}</span>
                  <span style="font-size: 16px; padding:0 5px;">${Data.records.location[0].weatherElement[3].elementValue}°C</span>
                  <img src="https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/07.svg" class="weather_img"></img>
                  `
                  )
            }else if(Data.records.location[0].weatherElement[20].elementValue == '多雲陣雨' || Data.records.location[0].weatherElement[20].elementValue == '多雲短暫雨' || Data.records.location[0].weatherElement[20].elementValue == '短暫陣雨' || Data.records.location[0].weatherElement[20].elementValue == '雨天' || Data.records.location[0].weatherElement[20].elementValue == '陰短暫雨' ){
                $('#weather_content').append(
                    `
                  <span style="font-size: 16px;">${Data.records.location[0].parameter[0].parameterValue}</span>
                  <span style="font-size: 16px; padding:0 5px;">${Data.records.location[0].weatherElement[3].elementValue}°C</span>
                  <img src="https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/08.svg" class="weather_img"></img>
                  `
                  )
            }else if(Data.records.location[0].weatherElement[20].elementValue == '多雲時陰有雨' || Data.records.location[0].weatherElement[20].elementValue == '晴時多雲陣雨 ' || Data.records.location[0].weatherElement[20].elementValue == '多雲時陰'){
                $('#weather_content').append(
                    `
                  <span style="font-size: 16px;">${Data.records.location[0].parameter[0].parameterValue}</span>
                  <span style="font-size: 16px; padding:0 5px;">${Data.records.location[0].weatherElement[3].elementValue}°C</span>
                  <img src="https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/10.svg" class="weather_img"></img>
                  `
                  )
            }else if(Data.records.location[0].weatherElement[20].elementValue == '晴'){
                $('#weather_content').append(
                    `
                  <span style="font-size: 16px;">${Data.records.location[0].parameter[0].parameterValue}</span>
                  <span style="font-size: 16px; padding:0 5px;">${Data.records.location[0].weatherElement[3].elementValue}°C</span>
                  <img src="https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/01.svg" class="weather_img"></img>
                  `
                )
            }else{
                $('#weather_content').append(
                    `
                  <span style="font-size: 16px;">${Data.records.location[0].parameter[0].parameterValue}</span>
                  <span style="font-size: 16px; padding:0 5px;">${Data.records.location[0].weatherElement[3].elementValue}°C</span>
                  <img src="https://www.cwb.gov.tw/V8/assets/img/weather_icons/weathers/svg_icon/day/03.svg" class="weather_img"></img>
                  `
                  )
            } 
            
        },
        error: function (xhr, textStatus, thrownError) {
            console.log('errorStatus:',textStatus);
            console.log('Error:',thrownError);
        }
    });
}