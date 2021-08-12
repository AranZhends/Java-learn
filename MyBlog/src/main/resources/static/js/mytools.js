function getParamValue(urlkey) {
    var param = location.search;//k1=v1&k2=v2
    param = param.substring(1);//取问号后的所有信息
    var paramArr = param.split("&");
    for (var i=0;i<paramArr.length;i++) {
        var item = paramArr[i].split("=");//得到key和value
        if(item[0] == urlkey) {
            return item[1];
        }
    }
    return null;
}