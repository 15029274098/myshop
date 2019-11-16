/*
 * @Author: your name
 * @Date: 2019-11-16 08:53:24
 * @LastEditTime: 2019-11-16 14:27:15
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editole
 * @FilePath: \mmail-fe\src\page\index\index.js
 */

'use strict'
var $ = require('jquery');
require('./index.css');
require('../module.js');
console.log('hello world');
$(function () {
    $('p').text('测试');
    $("#btn2").click(function () {
        $("ol").prepend("<li>在开头添加列表项</li>");
    });
});