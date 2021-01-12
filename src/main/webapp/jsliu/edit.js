/// <reference path="../Utility/baseUtility.js" />
/*
*
*项目名称：申通手机官网
*创建时间：2017-03-13
*创建人：mengzhufeng
*项目说明：用于登录用户编辑/修改地址ajax请求控制器方法
*/

var addressEditNameSpace = ( function ()
{

    // 通过 JSSDK 获取？
    var openId = null; //"o2DTtjg-2VEuLEX-AhLBmNuRvDI0";

    // 访问路径
    var urlEnum = {
        List: "/Address/List",
        Add: "/Address/Add",
        InitializeForm: "/Address/InitializeForm",
        Update: "/Address/Update"
    };

    var layer = null;
    var id = null;
    var editMode = null;
    var addressCategory = null;
    var windowMode = null;

    $( document ).ready( function ()
    {
        id = $( "#hiddenId" ).val();
        editMode = $( "#hiddenEditMode" ).val();
        addressCategory = $( "#hiddenAddressCategory" ).val();
        windowMode = $( "#hiddenWindowMode" ).val();
        openId = $( "#hdOpenId" ).val();
        // 根据不同的地址类别，微调一下界面的说明文字。
        var $txtRealName = $( "#txtRealName" );
        var $lblIsDefault = $( "#lblIsDefault" );

        if ( addressCategory == AddressCategoryEnum.sender )
        {
            $txtRealName.attr( 'placeholder', '寄件人姓名' );
            $lblIsDefault.html( '设为默认寄件地址' );
        } else if ( addressCategory == AddressCategoryEnum.receive )
        {
            $txtRealName.attr( 'placeholder', '收件人姓名' );
            $lblIsDefault.html( '设为默认收件地址' );
        }
        if ( editMode == EditModeEnum.Add )
        {
            console.warn( '新增' );
        } else if ( editMode == EditModeEnum.Update )
        {
            console.warn( '修改' );
            initializeForm( id );
        }

        /*备注*/
        $( '.check_num button.tag' ).on( 'click', function ()
        {
            submit_Info( '备注信息不得超过200字', '备注信息提交成功' );
        } );

        /*留言*/
        $( '.message_box p a' ).on( 'click', function ()
        {
            submit_Info( '留言信息不得超过200字', '留言成功' );
        } );

        /*添加地址选择地区*/
        $( '.add_adress .choose' )
            .on( 'click',
                function ()
                {
                    checkArea( '#city_chose' );
                } );


        // 保存
        $( "#btnSave" ).click( function ()
        {
     
            var isChecked = checkForm();
            if ( !isChecked )
            {
                console.warn( '表单验证失败！' );
                return isChecked;
            }

            /*
             * 获取表单的值
             */
            var formData = $( "#editForm" ).serializeArray();

            /*
             * 额外处理 Checkbox（选中为 1，未选中为 0）。
             * 通过 serializeArray() 抓取表单的值时，如果 Checkbox 未选中那么它的值将无法被抓取，需手动拼接。
             * 可以通过 $("#chkIsDefault").is(":checked") 测试选中状况
             */
            var hasCheckBox = false;
            $.each( formData, function ( i, n )
            {
                // 发现有 IsDefault 这个属性对，就修正它的值
                if ( n.name == "IsDefault" )
                {
                    n.value = '1';
                    hasCheckBox = true;
                }
            } );
            // 如果没有 IsDefault 这个属性对，就为其补充
            if ( !hasCheckBox )
            {
          
                $.merge( formData,
                    [{ name: 'IsDefault', value: '0' }]
                );
            }

            /*
             * 总是合并 openId
             */
            $.merge( formData,
                [{ name: 'openId', value: openId }]
            );

       

            /*
             * 根据编辑模式不同确立路径
             */
            var url = "";
            if ( editMode == EditModeEnum.Add )
            {
                url = urlEnum.Add;
            } else if ( editMode == EditModeEnum.Update )
            {
                url = urlEnum.Update;
            } else
            {
                console.warn( 'url 地址不明确，url = ' + url );
            }

            // 发起请求
            $.ajax( {
                data: formData,
                url: url,
                type: "POST",
                dataType: "json",
                success: function ( result )
                {
             

                    if ( result.Status )
                    {
                        // 编辑成功后返回列表页面，并带回之前的地址类别信息，从而正确选中相应的 tab。
                        layer.open({ content: "编辑地址成功。", skin: 'msg', time: 3 });
                        window.location.replace(
                            urlEnum.List
                            + "?addressCategory=" + addressCategory
                            + "&windowMode=" + windowMode
                            + "&openId=" + openId
                            );
                    } else
                    {
                        layer.open( {
                            type: 0, // 默认：0 （0表示信息框，1表示页面层，2表示加载层）
                            content: result.StatusMessage,  // 设置弹层内容
                            title: '',   // 设置弹层标题
                            skin: 'msg', // 目前支持配置 footer（即底部对话框风格）、msg（普通提示） 两种风格
                            style: '',   // CSS 样式，比如 color:#fff;
                            className: '',  // 自定义一个css类
                            time: 3 // 控制自动关闭层所需秒数
                        } );
                    }
                },
                error: function ( result )
                {
                }
            } );   // end ajax

        } ); // end save

        // 取消
        $( "#btnCancel" ).click( function ()
        {
      
            history.back();
        } ); // end cancel


    } ); // end ready

    // 初始化表单
    function initializeForm( id )
    {
        // 发起请求
        $.ajax( {
            data: {
                id: id,
                openId: openId
            },
            url: urlEnum.InitializeForm,
            type: "GET",
            dataType: "json",
            success: function ( result )
            {
         

                if ( result.Data != null )
                {
                    $( "form#editForm" ).formFill( { data: result.Data } );

                    // $("#hiddenAddress_").val(result.Data.AreaAddressId);


                } else
                {
                    layer.open( {
                        content: '该地址已不存在'
                        , btn: '知道了'
                        , yes: function ( index )
                        {
                            window.location.href = urlEnum.List + "?addressCategory=" + addressCategory;
                        }
                    } );
                }
            },
            error: function ( result )
            {
            }
        } );   // end ajax
    }

    // 基本的表单验证
    function checkForm()
    {

        if ( $( "#txtRealName" ).val() == "" )
        {
            layer.open( {
                content: "请填写姓名",  // 设置弹层内容
                skin: 'msg', // 目前支持配置 footer（即底部对话框风格）、msg（普通提示） 两种风格
                time: 3 // 控制自动关闭层所需秒数
            } );
            return false;
        }
        if ( $( "#txtRealName" ).val().length > 15 )
        {
            layer.open( {
                content: "姓名不要超过 15 个字",
                skin: 'msg',
                time: 3
            } );
            return false;
        }

        if ( $( "#txtPhone" ).val() == "" )
        {
            layer.open( {
                content: "请填写联系电话",
                skin: 'msg',
                time: 3
            } );
            return false;
        }
        if ($("#txtPhone").val().length!=11)
        {
            layer.open({
                content: "请填写正确的电话",
                skin: 'msg',
                time: 3
            });
            return false;
        }
        if ( !( /^1[34578]\d{9}$/.test( $( "#txtPhone" ).val() ) ) )
        {
            layer.open( {
                content: "联系电话格式不正确",
                skin: 'msg',
                time: 3
            } );
            return false;
        }

        if ( $( "#city_chose" ).val() == "" )
        {
            layer.open( {
                content: "请填写所在地区",
                skin: 'msg',
                time: 3
            } );
            return false;
        }

        if ( $( "#txtAddress" ).val() == "" )
        {
            layer.open( {
                content: "请填写详细地址",
                skin: 'msg',
                time: 3
            } );
            return false;
        }
        if ( $( "#txtAddress" ).val().length > 30 )
        {
            layer.open( {
                content: "详细地址不要超过 30 个字",
                skin: 'msg',
                time: 3
            } );
            return false;
        }

        return true;
    }

    return {

        setLayer: function ( _layer )
        {
            layer = _layer;
        }

    }

} )(); // end self


/*提交信息*/
function submit_Info( textspring, returninfo )
{
    layer.open( {
        title: false,
        anim: 'up',
        content: "<textarea class='beizhu' placeholder='" + textspring + "'></textarea>",
        btn: ['提　交', '取　消'],
        yes: function ()
        {
            var content = $( '.beizhu' ).val();
            if ( content.length > 0 )
            {
                $.post( "/Comment/Add/", { content: content, parentId: '', objectId: $( '#hdBillCode' ).val(), openId: $( '#hdOpenId' ).val() }, function ( data )
                {
                    if ( data.Status )
                    {
                        $( '.beizhu' ).val( '' ).focus();
                        var dateNow = new Date();
                        var time = dateNow.getFullYear() + '-' + ( dateNow.getMonth() + 1 ) + '-' + dateNow.getDate() + ' ' + dateNow.getHours() + ':' + dateNow.getMinutes() + ':' + dateNow.getSeconds();
                        // http://www.w3school.com.cn/jquery/jquery_dom_add.asp
                        // 最新评论的容器添加一个li元素就可以了
                        $( '.message_box p' ).after( '<div class="list_message"><img src="' + $( '#hdHead' ).val() + '"><dl><dt>' + $( '#hdNickName' ).val() + '</dt><dd>' + content + '</dd><dd class="time">' + time + '</dd></dl></div>' );
                        layer.open( { content: returninfo, skin: 'msg', time: 1 } );
                    } else
                    {
                        layer.open( { content: data.StatusMessage, skin: 'msg', time: 5 } );
                    }
                } );
            } else
            {
                $( '.beizhu' ).focus();
            }
        },
        no: function ( index )
        {
            layer.close( index );
        }
    } );
}


/*弹窗选择地址*/
/*设置选择完毕后给赋值的父页面ID:IdData*/
function checkArea( IdData )
{

    /*获取父级页面视窗的高度*/
    var ParBodyHei = $( window ).height();

    /*设置弹出窗的高度为视窗高度的80%*/
    var WindowPage = Math.floor( ParBodyHei * 0.8 );


    var tabIframe = function ( src )
    {
        return '<iframe id="iframe" name="' + IdData + '" frameborder="0" src="' + src + '" style="width:100%; height:' + WindowPage + 'px;"></iframe>';
    };

    layer.open( {
        type: 1,
        content: tabIframe( '/Address/Choose' ),
        anim: 'up',
        style: 'position:fixed; bottom:0; left:0; width: 100%; height: ' + WindowPage + 'px; padding:0px; border:none;border-top:2px solid #ff9d5b;'
    } );


}