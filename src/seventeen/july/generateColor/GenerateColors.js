/**
 * Created by solitary.wang on 2017/7/6.
 */

//随机生成生成颜色
function getColors(num) {
    var colors = [];
    while (colors.length < num) {
        var color = getColorV1();
        if (!contains(colors, color)) {
            colors.push(color);
        }
    }
    console.log(colors);
    return colors;
}

function getColorV1() {
    var rand = Math.random();
    var r = parseInt(Math.round(rand * 256)).toString(16) + "";
    r = r.toUpperCase ();
    var g = parseInt(Math.round(rand * 256)).toString(16) + "";
    g = g.toLocaleUpperCase ();
    var b = parseInt(Math.round(rand * 256)).toString(16) + "";
    b = b.toLocaleUpperCase ();
    r = r.length == 1 ? "0" + r : r;
    g = g.length == 1 ? "0" + g : g;
    b = b.length == 1 ? "0" + b : b;
    return "#" + r + g + b;
}

//定义一个函数，实现随机生成十六进制颜色值
function getColorV2() {
    //定义字符串变量colorValue存放可以构成十六进制颜色值的值
    var colorValue = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f";
    //以","为分隔符，将colorValue字符串分割为字符数组["0","1",...,"f"]
    var colorArray = colorValue.split(",");
    var color = "#";//定义一个存放十六进制颜色值的字符串变量，先将#存放进去
    //使用for循环语句生成剩余的六位十六进制值
    for (var i = 0; i < 6; i++) {
        //colorArray[Math.floor(Math.random()*16)]随机取出
        // 由16个元素组成的colorArray的某一个值，然后将其加在color中，
        //字符串相加后，得出的仍是字符串
        color += colorArray[Math.floor(Math.random() * 16)];
    }
    return color;
}

function getColorV3() {
    return '#' + Math.floor(Math.random() * 0xffffff).toString(16);
}

function getColorV4() {
    return '#' + ('00000' + (Math.random() * 0x1000000 << 0).toString(16)).substr(-6);
}

//判断数组中是否已经包含某个元素
function contains(arr, obj) {
    var i = arr.length;
    while (i--) {
        if (arr[i] == obj) {
            return true;
        }
    }
    return false;
}