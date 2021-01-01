package com.yidu.shentongkdi.controller;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author y99y
 * @version 1.0
 * @description:
 * @date 2020/12/29 9:30
 */
@Controller
@RequestMapping("getCode")
public class Yz {
    String str="";//0123456789

    @ResponseBody
    @RequestMapping("yzm")
    public String yzm( String uphones){
        //生成一个四位数的随机验证码
        str="";//0123456789
        for (int i = 0; i <4 ; i++) {
            str+=(int)Math.floor(Math.random()*10);
        }
        sendMsg(uphones,str);
        System.out.println("uphones="+uphones);
        return "true";
    }
    @ResponseBody
    @RequestMapping("yzms")
    public String yzms(String uphone){
        //生成一个四位数的随机验证码
        str="";//0123456789
        for (int i = 0; i <4 ; i++) {
            str+=(int)Math.floor(Math.random()*10);
        }
        //获取前台传送过来的手机号
        //String uphone=request.getParameter("uphone");
        sendMsg(uphone,str);
        return "true";
    }

    @ResponseBody
    @RequestMapping("yzyzm")
    public String yz(String code, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(code.equals(str)){
            return "牛逼,注册成功！直接为大哥跳到登录！";

        }else {
            return "臭小子，验证码错了！";
        }
    }
    @ResponseBody
    @RequestMapping("yzyzms")
    public String yzs(String code, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(code.equals(str)){
            return "好大哥登录成功！将为您跳到主页！";

        }else {
            return "臭小子，验证码错了！";
        }
    }

    public void sendMsg(String uphone ,String str){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GKtbv2t6E26p14xyFbi", "4g4rf3j3k8JA1ess5xCygbGs2klbrV");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", uphone);
        request.putQueryParameter("SignName", "ANTAofficial");
        request.putQueryParameter("TemplateCode", "SMS_202818576");
        request.putQueryParameter("TemplateParam", "{'code':'"+str+"'}");
        System.out.println(uphone);
        System.out.println(str);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
