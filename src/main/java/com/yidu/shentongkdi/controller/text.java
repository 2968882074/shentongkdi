package com.yidu.shentongkdi.controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author y99y
 * @version 1.0
 * @description:
 * @date 2020/12/28 18:43
 */
public class text {
    public static void main(String[] args) {
    DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GKtbv2t6E26p14xyFbi", "4g4rf3j3k8JA1ess5xCygbGs2klbrV");
    IAcsClient client = new DefaultAcsClient(profile);

    CommonRequest request = new CommonRequest();
    request.setMethod(MethodType.POST);
    request.setDomain("dysmsapi.aliyuncs.com");
    request.setVersion("2017-05-25");
    request.setAction("SendSms");
    request.putQueryParameter("RegionId", "cn-hangzhou");
    request.putQueryParameter("PhoneNumbers", "17670654299");
    request.putQueryParameter("SignName", "ANTAofficial");
    request.putQueryParameter("TemplateCode", "SMS_202818576");
    request.putQueryParameter("TemplateParam", "{'code':'1111'}");
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
