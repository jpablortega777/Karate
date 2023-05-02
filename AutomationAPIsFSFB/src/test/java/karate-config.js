function fn(){

    var config = {
        baseURL : 'https://fsfb.azure-api.net',
        timestamp : Math.round(new Date().getTime() / 1000)
    };
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
}
