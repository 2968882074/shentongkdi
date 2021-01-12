/*
 * 基础工具集合
 * 创建人：罗霄
 * 创建时间：2016-12-08
 * 
 * 实现原理说明：基于自执行函数的闭包机制。
 * 
 *  2016-12-14 增加了若干 jQuery 扩展：
 *      1、清空表单 formClear
 *      2、填充表单 formFill，能支持填充 Checkbox
 *  2016-12-09 增加了“枚举-快递地址类别”和“枚举-编辑模式”
 *  2016-12-19 增加了“枚举-窗体模式”
 */


/* 枚举-快递地址类别 */
var AddressCategoryEnum = (function () {
    return {
        // 寄件人地址
        sender: 1,
        // 收件人地址
        receive: 2
    };
})();

/* 枚举-编辑模式 */
var EditModeEnum = (function () {
    return {
        // 新增
        Add: 1,
        // 修改
        Update: 2
    };
})();

/* 枚举-窗体模式 */
var WindowModeEnum = (function () {
    return {
        // 页面模式
        page: 1,
        // 对话框模式
        dialog: 2
    };
})();


/* jQuery 扩展 */
jQuery.fn.extend({

    /* 清空表单 */
    formClear: function () {
        this.find("input:text,select,input:hidden,input:password").each(function () {
            $(this).val("");
        });
        this.find("input:checkbox,input:radio").each(function () {
            $(this).removeAttr("checked");
        });
    },

    /* 填充表单 */
    // 例如 $('form').formFill({ data : {id:1} , prefix : "user." })，填充后形如 <input name='user.id' value='1' >
    formFill: function (option) {
        var prefix = option.prefix;
        if (prefix == undefined) prefix = "";
        var frmData = option.data;
        for (i in frmData) {
            var dataKey = i;
            var thisData = this.find("[name='" + prefix + i + "']");
            var text = "text";
            var hidden = "hidden";
            if (thisData != null) {
                var thisDataType = thisData.attr("type");
                var val = frmData[i];
                var isdata = (val != null && val.toString().lastIndexOf("/Date(") != -1);
                if (thisDataType == "radio") {
                    thisData.filter("[value=" + val + "]").attr("checked", "checked")
                    if (val == true || val == "0") val = "True";
                    else if (val == false || val != "0") val = "False";
                    thisData.filter("[value=" + val + "]").not("donbool").attr("checked", "checked")
                } else if (thisDataType == "checkbox") {
                    if (thisData.size() == 1) {
                        if (val == "true" || val == 1 || val == "True" || val == "1") {
                            thisData.attr("checked", "checked");
                        } else {
                            thisData.removeAttr("checked");
                        }
                    } else {

                        thisData.removeAttr("checked");
                        var cbIndex = i;
                        if (val.lastIndexOf(",") == -1) {
                            this.find("[name='" + prefix + dataKey + "'][value='" + prefix + val + "']").attr("checked", "checked");
                        } else {
                            jQuery(val.split(',')).each(function (i, v) {
                                this.find("[name='" + prefix + dataKey + "'][value='" + prefix + v + "']").attr("checked", "checked");;
                            })
                        }
                    }

                } else {
                    if (isdata) {
                        val = jQuery.Convert.jsonReductionDate(val);
                    }
                    if (val == "null" || val == null)
                        val = "";
                    if (val == "" && thisData.attr("watertitle") == thisData.val()) {
                    } else {
                        thisData.val(val + "");
                        thisData.removeClass("watertitle");
                    }
                }
            }
        }
    },

    /* 抓取表单 */
    // changeToBool 设置为true的话，会把string型"true"和"false"字符串值转化为boolean型
    formSerialize: function (changeToBool) {
        var formArray = this.serializeArray();
        var oRet = {};
        for (var i in formArray) {
            if (typeof (oRet[formArray[i].name]) == 'undefined') {
                if (changeToBool) {
                    oRet[formArray[i].name] = (formArray[i].value == "true" || formArray[i].value == "false") ? formArray[i].value == "true" : formArray[i].value;
                }
                else {
                    oRet[formArray[i].name] = formArray[i].value;
                }
            }
            else {
                if (changeToBool) {
                    oRet[formArray[i].name] = (formArray[i].value == "true" || formArray[i].value == "false") ? formArray[i].value == "true" : formArray[i].value;
                }
                else {
                    oRet[formArray[i].name] += "," + formArray[i].value;
                }
            }
        }
        return oRet;
    }
});


jQuery.extend({

    /*linq*/
    linq: {
        contains: function (thisVal, cobj) {
            if (jQuery.valiData.isEmpty(thisVal)) {
                return false;
            }
            return thisVal.toString().lastIndexOf(cobj.toString()) != -1;
        },
        /*where*/
        where: function (obj, action) {
            if (action == null) return;
            var reval = new Array();
            $(obj)
                .each(function (i, v) {
                    if (action(v)) {
                        reval.push(v);
                    }
                });
            return reval;
        },
        single: function (obj, action) {
            if (action == null) return;
            var reval = null;
            $(obj)
                .each(function (i, v) {
                    if (action(v)) {
                        reval = (v);
                    }
                });
            return reval;
        },
        remove: function (obj, action) {
            var removeItem = $.linq.single(obj, action);
            obj.splice(jQuery.inArray(removeItem, obj), 1);
        },
        /*any*/
        any: function (obj, action) {
            if (action == null) return;
            var reval = false;
            $(obj)
                .each(function (i, v) {
                    if (action(v)) {
                        reval = true;
                        return false;
                    }
                });
            return reval;
        },
        /*select*/
        select: function (obj, action) {
            if (action == null) return;
            var reval = new Array();
            $(obj).each(function (i, v) {
                reval.push(action(v));
            });
            return reval;
        },
        /*each*/
        each: function (obj, action) {
            if (action == null) return;
            jQuery(obj).each(function (i, v) {
                action(i, v);
            });
        },
        /*first*/
        first: function (obj, action) {
            if (action == null) return;
            var reval = new Array();
            $(obj)
                .each(function (i, v) {
                    if (action(v)) {
                        reval.push(v);
                        return false;
                    }
                });
            return reval[0];
        },
        order: function (obj, field, orderByType) {
            var p = obj;
            p.sort(function down(x, y) {
                if (orderByType != null && orderByType.toLocaleLowerCase() == "desc") {
                    return (x[field] < y[field]) ? 1 : -1;
                } else {
                    return (x[field] > y[field]) ? 1 : -1;
                }

            });
            return p;
        }

    }
});



