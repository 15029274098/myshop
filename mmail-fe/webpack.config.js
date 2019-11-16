/*
 * @Author: your name
 * @Date: 2019-11-16 09:36:39
 * @LastEditTime: 2019-11-16 23:26:10
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \mmail-fe\webpack.config.js
 */

var webpack = require('webpack');
//打包css,引入插件
var ExtractTextPlugin = require("extract-text-webpack-plugin");
//打包html的插件
var HtmlWebpackPlugin = require('html-webpack-plugin');
// 环境变量配置，dev / online
var WEBPACK_ENV = process.env.WEBPACK_ENV || 'dev';
var path = require("path")
//获取HtmlWebpackPlugin参数的方法
var getHtmlConfig = function (name, title) {
    return {
        //文件路径
        template: './src/view/' + name + '.html',
        //输出的文件路径
        filename: 'view/' + name + '.html',
        title: title,
        hash: true,
        inject: true,
        //需要引入的js列表
        chunks: ['common', name]
    }
}
/**
 * webpack-config 配置相关
 */
var config = {
    entry: {
        'common': ['./src/page/common/index.js'],
        'index': ['./src/page/index/index.js'],
        'login': ['./src/page/login/login.js']
    },
    output: {   
        path: './dist',
        publicPath : '/dist',
        filename: './js/[name].js'
    },
    resolve : {
        alias : {
            node_modules    : __dirname + '/node_modules',
            util            : __dirname + '/src/util',
            page            : __dirname + '/src/page',
            service         : __dirname + '/src/service',
            image           : __dirname + '/src/image'
        }
    },
    plugins: [
        //独立打包js
        new webpack.optimize.CommonsChunkPlugin({
            name: 'common',
            filename: 'js/base.js'
        }),
        //这里会按照output的路径打包到css文件夹下面对应的css的名字,独立打包css
        new ExtractTextPlugin('css/[name].css'),
        //对html模板的处理
        new HtmlWebpackPlugin(getHtmlConfig('index', '首页')),
        new HtmlWebpackPlugin(getHtmlConfig('login', '登录页')),

    ],
    module: {
        loaders:[{ test: /\.css$/, loader: ExtractTextPlugin.extract("style-loader","css-loader") },
            {test: /\.(gif|png|jpg|woff|svg|eot|ttf)\??.*$/,loader: 'url-loader?limit=100&name=resource/[name].[ext]' },
            { test: /\.string$/,  loader: 'html-loader' }
        ]
    }
}
if ('dev' === WEBPACK_ENV) {
    config.entry.common.push('webpack-dev-server/client?http://localhost:8088/');
}
module.exports = config;