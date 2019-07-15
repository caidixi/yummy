package wnderful.yummy.util;

import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsHelper {
    public int sendMessage(String phoneNumber,String message) {
        //初始化clnt,使用单例方式
        YunpianClient clnt = new YunpianClient("9e821c5c22f36285081f40fa25a4db32").init();

        //发送短信API
        Map<String, String> param = clnt.newParam(2);
        param.put(YunpianClient.MOBILE, phoneNumber);
        param.put(YunpianClient.TEXT, "【云片网】您的验证码是"+message);
        Result<SmsSingleSend> result = clnt.sms().single_send(param);
        //获取返回结果，返回码:r.getCode(),返回码描述:r.getMsg(),API结果:r.getData(),其他说明:r.getDetail(),调用异常:r.getThrowable()
        System.out.println("短信发送，code:"+result.getCode()+", message:"+result.getMsg());
        //账户:clnt.user().* 签名:clnt.sign().* 模版:clnt.tpl().* 短信:clnt.sms().* 语音:clnt.voice().* 流量:clnt.flow().* 隐私通话:clnt.call().*

        //释放clnt
        clnt.close();
        return result.getCode();
    }
}
