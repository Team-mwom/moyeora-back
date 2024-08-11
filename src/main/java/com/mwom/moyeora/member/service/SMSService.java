package com.mwom.moyeora.member.service;


import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.HashMap;

@Service
public class SMSService {

  private
  Message coolsms =null;

  public SMSService( @Value("${coolsms.key}") String api_key,@Value("${coolsms.secret}") String api_secret){
    coolsms =  new Message(api_key, api_secret);
  }

  public void send(String phone,String number) {


    // 4 params(to, from, type, text) are mandatory. must be filled
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", phone);	// 수신전화번호
    params.put("from", "01045207141");	// 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
    params.put("type", "SMS");
    params.put("text", "[모여라] 본인확인 인증번호("+number+")입력시 정상처리 됩니다.");
    params.put("app_version", "test app 1.2"); // application name and version

    try {
      JSONObject obj = (JSONObject) coolsms.send(params);
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
  }

}
