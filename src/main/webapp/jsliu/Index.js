/*
 * 项目名称：申通快递官网-会员中心
 * 创建人：mengzhufeng
 * 创建时间：2017-05-19
 * 项目说明：用于申通快递官网会员中心在线下单
 * 
 * 修改时间：2017-05-22
 * 修改内容：完善了在线下单的验证，添加了运费时效查询ajax请求接口的方法
 * 修改人：mengzhufeng
 
 * 修改时间：2019-05-20
 * 修改内容：添加了400固话的正则验证
 * 修改人：吴剑飞
 * 
 * 修改时间：2019-05-22
 * 修改内容：添加了19、16开头的手机号验证
 * 修改人：吴剑飞
 * 
 * 修改时间：2019-05-29
 * 修改内容：修改寄件时间的展示，只展示当天时间和之后两天(当天16:30之后只展示明天和之后两天)，开始时间从10:00-16:30，结束时间从13:00-19:30，用户不选时的默认时间，在当天10点之后16:30之前是当前下单时间，结束时间延长3小时，10点之前或16:30之后，默认是10点开始，结束13:00
 * 修改人：吴剑飞

 * 修改时间：2019-07-25
 * 修改内容：添加姓名英文的正则验证
 * 修改人：吴剑飞
 * */
var goodtype = "";
$(function () {
    //Init();
    //日期选择
    $(":radio").click(function () {
        if ($(this).val() == "其他") {
            $("#memo").show();
        } else {
            $("#memo").hide();
        }
        goodtype = $(this).val();
    });
    //如果当前时间已经是16:30之后，则显示明天时间
    var time = new Date();
    time.setHours("16");
    time.setMinutes("30");
    time.setSeconds("0");
    if (new Date() > time) {
        document.getElementById("FetchTime").value = (new Date).getFullYear() + "-" + ((new Date).getMonth() + 1) + "-" + ((new Date).getDate()+1);
    } else {
        document.getElementById("FetchTime").value = (new Date).getFullYear() + "-" + ((new Date).getMonth() + 1) + "-" + ((new Date).getDate());
    }
    
    //初始化地区选择器
    var $citypicker1 = $('#sendFullAddress');
    var $citypicker2 = $('#ReceiveFullAddress');

    //将当前页面的标题banner高亮显示
    $(".navList ul li").eq(1).find("a").css("color", "#ed6900");

    //点击提交订单
    $("#orderSubmit").click(function () {
        //表单验证  寄件人信息验证
        if ($("input[name='SenderName']").val() == undefined || $("input[name='SenderName']").val() == "") {
            layer.msg("请填写寄件人姓名");
            $("input[name='SenderName']").focus();
            return false;
        }
        if (!/(^[\u4E00-\u9FA5]+$)|(^[\u4E00-\u9FA5]*·[\u4E00-\u9FA5]*$)/.test($("input[name='SenderName']").val())) {
            layer.msg("寄件人姓名格式不正确");
            $("input[name='SenderName']").focus();
            return false;
        } 
        if ($("input[name='SenderMobile']").val() == "" && $("input[name='SenderPhone']").val() == "") {
            layer.msg("手机号码和座机号码必须填写一个");
            $("input[name='SenderMobile']").focus();
            return false;
        }
        if ($("input[name='SenderMobile']").val().length > 11) {
            layer.msg("您输入的手机号码不正确");
            $("input[name='SenderMobile']").focus();
            return false;
        }
        if ($("input[name='SenderMobile']").val() && !$("input[name='SenderMobile']").val().match(/^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(17[0-9]{1})|(18[0-9]{1})|(19[0-9]{1}))+\d{8})$/)) {
            layer.msg("请输入有效的手机号码");
            $("input[name='SenderMobile']").focus();
            return false;
        }
        //if (!$("input[name='SenderPhone']").val().match(/^0[\d]{2,3}-[\d]{7,8}$/)) {
        //    layer.msg("请输入有效的寄件人座机号码");
        //    $("input[name='SenderMobile']").focus();
        //    return false;
        //}
        if (($("input[name='SenderPhone']").val() && !$("input[name='SenderPhone']").val().match(/^0[\d]{2,3}-[\d]{7,8}(-[\d]{4,4})?$/)) && ($("input[name='SenderPhone']").val() && !$("input[name='SenderPhone']").val().match(/^400(\d{7}|-\d{4}-\d{3})$/))) {
            layer.msg("寄件人座机号码输入错误");
            $("input[name='SenderPhone']").focus();
            return false;
        }

        if ($("input[name='sendFullAddress']").val() == "") {
            layer.msg("请选择寄件人地址");
            $("input[name='sendFullAddress']").focus();
            return false;
        }
        if ($("input[name='SendFullAddressDetail']").val() == "") {
            layer.msg("请填写寄件人详细地址");
            $("input[name='SendFullAddressDetail']").focus();
            return false;
        }
        if ($("select[name='PayType']").val() == "请选择付款方式") {
            layer.msg("请选择付款方式");
            $("select[name='PayType']").focus();
            return false;
        }
        ////验寄件人证邮箱格式
        //var myreg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
        //if (!myreg.test($("#SenderEmail").val())) {
        //    layer.msg("请输入正确的邮箱");
        //    $("#SenderEmail").focus();
        //    return false;
        //}
        if ($("select[name='PayType']").val() == "月结") {
            if ($('#MonthCustomer').val() == ""||$('#MonthCustomer').val() ==null)
            {
            var monindex=    layer.confirm('选择付款方式为月结，月结编号不能为空，是否前往维护月结客户', {
                    btn: ['确定', '取消']
                }, function () {
                    window.open("/Monthly/Index")
                    layer.close(monindex);
                })
                //layer.msg("付款方式为月结，月结编号不能为空");
                return false;
            }
        }
        //收件人信息验证
        if ($("input[name='ReceiveName']").val() == undefined || $("input[name='ReceiveName']").val() == "") {
            layer.msg("请填写收件人姓名");
            $("input[name='ReceiveName']").focus();
            return false;
        }
        if (!/(^[\u4E00-\u9FA5]+$)|(^[\u4E00-\u9FA5]*·[\u4E00-\u9FA5]*$)/.test($("input[name='ReceiveName']").val())) {
            layer.msg("收件人姓名格式不正确");
            $("input[name='ReceiveName']").focus();
            return false;
        } 
        if ($("input[name='ReceiveMobile']").val() == "" && $("input[name='ReceivePhone']").val() == "") {
            layer.msg("收件人手机号码和座机号码必须填写一个");
            $("input[name='ReceiveMobile']").focus();
            return false;
        }
        if ($("input[name='ReceiveMobile']").val().length > 11) {
            layer.msg("您输入的手机号码不正确");
            $("input[name='ReceiveMobile']").focus();
            return false;
        }
        if ($("input[name='ReceiveMobile']").val() && !$("input[name='ReceiveMobile']").val().match(/^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(17[0-9]{1})|(18[0-9]{1})|(19[0-9]{1}))+\d{8})$/)) {
            layer.msg("请输入有效的手机号码");
            $("input[name='ReceiveMobile']").focus();
            return false;
        }
        //if (!$("input[name='ReceivePhone']").val().match(/^0[\d]{2,3}-[\d]{7,8}$/)) {
        //    layer.msg("请输入有效的收件人座机号码");
        //    $("input[name='SenderMobile']").focus();
        //    return false;
        //}
        if (($("input[name='ReceivePhone']").val() && !$("input[name='ReceivePhone']").val().match(/^0[\d]{2,3}-[\d]{7,8}(-[\d]{4,4})?$/)) && ($("input[name='ReceivePhone']").val() && !$("input[name='ReceivePhone']").val().match(/^400(\d{7}|-\d{4}-\d{3})$/))) {
            layer.msg("收件人座机号码输入错误");
            $("input[name='ReceivePhone']").focus();
            return false;
        }
        if ($("input[name='ReceiveFullAddress']").val() == "") {
            layer.msg("请选择收件人地址");
            $("input[name='ReceiveFullAddress']").focus();
            return false;
        }
        if ($("input[name='ReceiveFullAddressDetail']").val() == "") {
            layer.msg("请填写收件人详细地址");
            $("input[name='ReceiveFullAddressDetail']").focus();
            return false;
        }
        if ($("input[name='DeliveryGoods']").val() == "" || $("input[name='DeliveryGoods']").val() == undefined) {
            layer.msg("请选择物品类型");
            return false;
        }
        //验证输入重量必须确保是数字
        if (!$("#Weight").val().match("^[0-9]*$")) {
            layer.msg("请输入0-9的数字");
            return false;
        }
        var Articleweight = $("#Weight").val()
        if (Articleweight > 50 || Articleweight < 0) {
            layer.alert("重量不得大于50kg或小于0kg");
            return false;
        }
        if (goodtype == "" || goodtype == undefined) {
            layer.msg("请选择物品类别");
            return false;
        }
        var content;
        if (goodtype == "其他") {
            if ($('#memo').val() == "") {
                layer.msg("如选择其他，请手动填写物品名称");
                return false;
            } else {
                content = "其他:" + $('#memo').val()
                $("#elseDeliveryGoods").val(content);
            }
        } 
        //预约时间验证
        var _date = new Date();
        var dateNow = _date.toLocaleDateString();
        dateNow = dateNow.replace('/', '');
        dateNow = parseInt(dateNow.replace('/', ''))//日期选择结果为yyyy/MM/dd 的形式,所以替换2次/
        var FetchTime = $("#FetchTime").val();
        //if (FetchTime == "")
        //{
        //    layer.alert("抱歉,请选择取件时间")
        //    return false;
        //}
        FetchTime = FetchTime.replace('-', '');
        FetchTime = parseInt(FetchTime.replace('-', ''))
        if (FetchTime < dateNow) {
            layer.alert("抱歉,您选择的日期已成为过去")
            return false;
        }
        var Fetchstartdate ="";
        var Fetchenddate = "";
        //判断是否选择了开始时间 吴剑飞 2019-05-29
        if ($("#Fetchstartdate").val() == "") {//开始时间为空，结束时间也为空
            //再判断当前时间是否过了16:30
            var timeFirst = new Date();
            timeFirst.setHours("16");
            timeFirst.setMinutes("30");
            timeFirst.setSeconds("0");
            var timeSecond = new Date();
            timeSecond.setHours("10");
            timeSecond.setMinutes("0");
            timeSecond.setSeconds("0");
            if (_date > timeFirst || _date < timeSecond) {//超过当天16:30或在当天10点之前，默认开始时间是10点,结束时间是13点
                 Fetchstartdate = "10:00:00";
                 Fetchenddate = "13:00:00";
            } else {//在10点到16：30之间则开始时间是当前下单时间
                //注意分钟的格式问题
                //alert(new Date("2019-4-2 9:9:0"));
                var minutes = _date.getMinutes();
                //添加秒的格式验证
                var seconds = _date.getSeconds();
                if (minutes >= 0 && minutes <= 9) {
                    minutes = "0" + _date.getMinutes();
                } 
                if (seconds >= 0 && seconds <= 9) {
                    seconds = "0" + _date.getSeconds();
                }
                Fetchstartdate = _date.getHours() + ":" + minutes +":"+ seconds;
                Fetchenddate = _date.getHours() + 3 + ":" + minutes + ":"+seconds;//下单时间默认比开始时间延长3个小时
            }
        } else {
            if ($("#Fetchenddate").val() == "") {//开始时间不为空，结束时间为空
                var timeArr = $("#Fetchstartdate").val().split(":");
                var hour = parseInt(timeArr[0]) + 3;
                 Fetchstartdate = $("#Fetchstartdate").val();
                 Fetchenddate = hour + ":" + timeArr[1] + ":" + timeArr[2];//下单时间默认比开始时间延长3个小时
            } else {//开始时间不为空，结束时间也不为空
                 Fetchstartdate = $("#Fetchstartdate").val();
                 Fetchenddate = $("#Fetchenddate").val();
            }
        }
        //var Fetchstartdate = parseInt($("#Fetchstartdate").val().replace(':', ''));
        //var Fetchenddate = parseInt($("#Fetchenddate").val().replace(':', ''));
        //if (Fetchstartdate > Fetchenddate || Fetchstartdate == Fetchenddate) {
        //    layer.alert("抱歉开始时间不能早等于结束时间")
        //    return false;
        //}
        if (FetchTime != "" && Fetchstartdate != "" && Fetchenddate != "")
        {
            $("#sdate").val($("#FetchTime").val() + " " + Fetchstartdate);
            $("#edate").val($("#FetchTime").val() + " " + Fetchenddate);
        }
    
        //if (time == "") {
        //    var times = time.split(':');
        //    var a = new Date(2017, 5, 22, parseInt(times[0]), parseInt(times[1]));
        //    var senderTime = addMinutes(90, a).getHours() + ":" + addMinutes(90, a).getMinutes();
        //    var s = parseInt((new Date).getFullYear() + "" + ((new Date).getMonth() + 1) + "" + (new Date).getDate());
        //    if (parseInt($("#FetchBeginTime").val().replace('-', '').replace('-', '')) == s) {
        //        e.stopPropagation();
        //        $(this).lqdatetimepicker({
        //            css: 'datetime-hour'
        //        }, senderTime);
        //    }
        //    else if (parseInt($("#FetchBeginTime").val().replace('-', '').replace('-', '')) > s) {
        //        e.stopPropagation();
        //        $(this).lqdatetimepicker2({
        //            css: 'datetime-hour'
        //        }, senderTime);
        //    } else {
        //        layer.msg("您选择的日期已成为过去");
        //        return false;
        //    }
        //}
        // 获取表单数据
        var serializeForm = $("#orderForm").serializeArray();
    //    alert($("#PayType").val());
        var userId = $("#hiddenUserId").val();
        // 记录阴影弹窗的索引，确保在必要时可以顺利获取到它，并对其关闭
        var shadeLayerIndex = 0;
        layer.open({
            content: '您确定下单吗？',
            btn: ['确定', '取消'],
            shadeClose: false,
            yes: function () {
                layer.msg("您已确认下单");
                // 发起请求
                $.ajax({
                    data: serializeForm,
                    url: '/Order/AddOrder',
                    type: "POST",
                    dataType: "json",
                    success: function (result) {
                        if (result.Status) {
                            layer.close(shadeLayerIndex);
                            window.location.href = "/Order/OrderResult?OrderId=" + result.ResultValue;
                            //提示
                            //layer.open({
                            //    content: result.StatusMessage,
                            //    skin: 'msg',
                            //    time: 1000,
                            //    end: function () {
                            //        // 下单成功跳转到订单列表页面
                            //      //  layer.msg("您已成功下单，感谢使用申通会员中心下单");
                            //     
                            //    }
                            //});
                        } else {
                            layer.msg(result.StatusMessage);
                        }
                    },
                    error: function (result) {
                    },
                    beforeSend: function () {
                        // 提交表单时呈现阴影弹窗
                        shadeLayerIndex = layer.msg("订单提交中...");
                    },
                    complete: function () {
                        // 服务端返回响应信息时将关闭阴影弹窗
                        layer.close(shadeLayerIndex);
                    }
                });   // end ajax
            }, no: function () {
                layer.msg('您选择了取消');
            }
        });
    });

    //点击查询时效路由
    $("#priceSearch").click(function () {
   
        var senderProCityAres = $("#sendFullAddress").val()
        var acceptProCityArea = $("#ReceiveFullAddress").val()
        var articleweight = $("#Weight").val()
        if (senderProCityAres != "" && articleweight != "" && acceptProCityArea != "") {
            if (senderProCityAres.split('/').length - 1 == 2) {
                if (acceptProCityArea.split('/').length - 1 == 2) {
                    $.ajax({
                        url: "/Order/GetPriceMessage",
                        type: "Post",
                        data: { startCity: senderProCityAres, endCity: acceptProCityArea, weight: articleweight, },
                        success: function (result) {
                            if (result.Status == true) {
                                //把值赋给显示的文本框中
                                jQuery("#Time").val(result.Data.Time);
                                jQuery("#Price").val(result.Data.Price + "元");
                                jQuery("#TranFee").val(result.Data.Price);
                            }
                            else {
                                layer.msg(result.StatusMessage);
                            }
                        }
                    })
                } else {
                    layer.msg("抱歉,您的收件地址还没有选择完毕");
                }
            } else {
                layer.msg("抱歉,您的发件地还没有选择完毕");
            }
        } else {
            layer.msg("抱歉,发件区县,收件区县和物品重量不能为空");
        }
    });
    InitAutoComplete();
});

//输入手机号码带出寄件人地址信息,初始化autocomplete,选中时并赋值给文本框
function InitAutoComplete() {
    //寄件人地址信息
    $("#SenderMobile").autocomplete({
        source: "/Order/GetAddressByMobile",
        minLength: 11,
        select: function (event, ui) {
            //此处因手机号是本身输入的，所以select本身就已经赋值了，在后台value给定输入的值就可以了
            //$("#SenderMobile").val(ui.item.label.split("-")[0]);
            $("#SenderName").val(ui.item.label.split("-")[1]);
            $("#sendFullAddress").val(ui.item.label.split("-")[2] + "/" + ui.item.label.split("-")[3] + "/" + ui.item.label.split("-")[4]);
            $("#SendFullAddressDetail").val(ui.item.label.split("-")[5]);
        }
    });
    //收件人地址信息
    $("#ReceiveMobile").autocomplete({
        source: "/Order/GetAddressByMobile",
        minLength: 11,
        select: function (event, ui) {
            //$("#SenderMobile").val(ui.item.label.split("-")[0]);
            $("#ReceiveName").val(ui.item.label.split("-")[1]);
            $("#ReceiveFullAddress").val(ui.item.label.split("-")[2] + "/" + ui.item.label.split("-")[3] + "/" + ui.item.label.split("-")[4]);
            $("#ReceiveFullAddressDetail").val(ui.item.label.split("-")[5]);
        }
    });
}

function Show() {
    layer.open({
        title: '申通快递服务协议',
        type: 1,
       area: ['780px', '570px'],
        shadeClose: true, //点击遮罩关闭
        content: $("#agreement")
    })
}


function func() {
    //获取被选中的option标签  
    var vs = $('select  option:selected').val();
    if (vs == "月结")
    {
        $('#MonthCustomerDiv').css({ display: 'block' });
    }else
    {
        $('#MonthCustomerDiv').css({ display: 'none' });
    }
  
}
var typeindex;
function Fastentry(type)
{
    typeindex = type;
    layerindex = layer.open({
        title: '地址智能识别',
        type: 1,
        area: ['560px', '230px'],
        shadeClose: false, //点击遮罩关闭
        content: $("#Fastentry"),
        end: function () {
            $('.Fastentry').css({ display: 'none' });
        }
    })
}

function Fastbtn() {
    // 
    var content = $("#Fastentrycontent").val();
    if (content == "") {
        layer.msg("请输入解析文本");
        return false;
    }
    var yes = 0;
    //if ($('#DeliveryGoods').is(':checked')) {
    //    yes = 1;
    //}
    $.ajax({
        data: {
            content: content,
            IsAdd: yes,
            type: typeindex
        },
        url: "/Order/IntelligentRecognition",
        type: "POST",
        dataType: "json",
        success: function (result) {
            if (result.Status) {
                layer.msg('解析成功');
                //     $('.popupHe2').css({ display: 'none' });
                if (typeindex == "1")
                    {
                $("#SenderName").val(result.Data.name);
                $("#SenderMobile").val(result.Data.phone);
                $("#sendFullAddress").val(result.Data.province +"/"+ result.Data.city +"/"+ result.Data.district);
                $("#SendFullAddressDetail").val(result.Data.address);
                } else if (typeindex=="2")
                {
                    $("#ReceiveName").val(result.Data.name);
                    $("#ReceiveMobile").val(result.Data.phone);
                    $("#ReceiveFullAddress").val(result.Data.province + "/" + result.Data.city + "/" + result.Data.district);
                    $("#ReceiveFullAddressDetail").val(result.Data.address);
                }
                layer.close(layerindex);
                $("#Fastentrycontent").val('');
            } else {
                layer.msg(result.StatusMessage);
            
            }
        },
    });   // end ajax
}
//返回日期的最小值
function minDate() {
    var time = new Date();
    time.setHours("16");
    time.setMinutes("30");
    time.setSeconds("0");
    if (time > new Date()) {
        // alert((new Date).getFullYear() + "-" + ((new Date).getMonth() + 1) + "-" + ((new Date).getDate()));
        return (new Date).getFullYear() + "-" + ((new Date).getMonth() + 1) + "-" + ((new Date).getDate());
    } else {
        // alert((new Date).getFullYear() + "-" + ((new Date).getMonth() + 1) + "-" + ((new Date).getDate() + 1));
        return (new Date).getFullYear() + "-" + ((new Date).getMonth() + 1) + "-" + ((new Date).getDate() + 1);
    }
}
//返回日期的最大值
function maxDate() {
    var time = new Date(minDate());
    //d.setDate(d.getDate() - 2);
    //alert(time);
    time.setDate(time.getDate() + 2);
    //alert(time);
    return time;
}
//返回时间的最小值
function minTime() {
    var minTime = new Date();
    minTime.setHours("10");
    minTime.setMinutes("0");
    minTime.setSeconds("0");
    //alert(time);
    var maxTime = new Date();
    maxTime.setHours("16");
    maxTime.setMinutes("30");
    maxTime.setSeconds("0");
    if (minTime > new Date() || maxTime < new Date()) {
        //alert(time);
        return "10:00:00";
    } else {
        // alert((new Date).getHours() + ":" + (new Date).getMinutes() + ":" + (new Date).getSeconds());
        return (new Date).getHours() + ":" + (new Date).getMinutes() + ":" + (new Date).getSeconds();
    }


}

