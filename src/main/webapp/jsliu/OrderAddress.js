/*
 * 项目名称：申通快递官网-会员中心
 * 创建人：mengzhufeng
 * 创建时间：2017-05-19
 * 项目说明：用于申通快递官网会员中心在线下单寄件人/收件人地址信息选择

 * 修改时间：
 * 修改内容：
 * 修改人：
 * */

$(function () {
    //点击寄件人图标弹窗
    layui.use('layer', function () {
        var layer = layui.layer;
        $(".order_address_list").click(function () {
            layer.open({
                title: '寄件人信息',
                type: 2,
                area: ['770px', '480px'],
                skin: 'layui-layer-rim', //加上边框
                content: ['/Address/List', 'yes']
            });
        });
    })
    //点击收件人图标弹窗
    layui.use('layer', function () {
        var layer = layui.layer;
        $(".order_address_recvList").click(function () {
            layer.open({
                title: '收件人信息',
                type: 2,
                area: ['770px', '480px'],
                skin: 'layui-layer-rim', //加上边框
                content: ['/Address/RecvList', 'yes']
            });
        });
    })
});

//获取地寄件人址列表信息进行文本赋值
function listCallBack(row) {
    if (row != null) {
        var address = row.address;
        var province = address.split("/")[0];
        var city = address.split("/")[1];
        var district = address.split("/")[2];
        var addressDetail = address.split("/")[3];
        if(row.send_type=="寄件人")
        {
            $("#SenderName").val(row.realname);
            $("#SenderMobile").val(row.phone);
            $("#sendFullAddress").val(province+"/"+city+"/"+district);
            $("#SendFullAddressDetail").val(addressDetail);
        }
    }
    else
    {
        layer.msg("您还没有寄件人地址信息");
    }
}

//获取收件人地址列表信息进行文本赋值
function recvListCallBack(rows) {
    if (rows != null) {
        var address = rows.address;
        var province = address.split("/")[0];
        var city = address.split("/")[1];
        var district = address.split("/")[2];
        var addressDetail = address.split("/")[3];
        if (rows.recev_type == "收件人") {
            $("#ReceiveName").val(rows.realname);
            $("#ReceiveMobile").val(rows.phone);
            $("#ReceiveFullAddress").val(province + "/" + city + "/" + district);
            $("#ReceiveFullAddressDetail").val(addressDetail);
        }
    }
    else {
        layer.msg("您还没有收件人地址信息");
    }
}