/*
 * @Author: your name
 * @Date: 2019-11-16 08:53:24
 * @LastEditTime: 2019-11-24 23:29:32
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editole
 * @FilePath: \mmail-fe\src\page\index\index.js
 */

'use strict'
var _mm = require('util/mm.js');
require('./index.css');
require('../common/layout.css');
require('node_modules/font-awesome/css/font-awesome.min.css');
var html = '<div>{{data}}</div>';
var data = {
    data: 123
}
console.log(_mm.renderHtml(html, data));