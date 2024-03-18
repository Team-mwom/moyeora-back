package com.mwom.moyeora.member;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
@Service
public class KakaoService {
//  https://velog.io/@akskflwn/Rest-API-%ED%99%9C%EC%9A%A9%ED%95%9C-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EC%86%8C%EC%85%9C-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B5%AC%ED%98%84ReactSpring-boot
  private final String restKey,redirectUrl;
 KakaoService(@Value("${kakaoLogin.rest_key}") String restKey, @Value("${kakaoLogin.redirect}") String redirectUrl){
   this.restKey = restKey;
   this.redirectUrl = redirectUrl;

 }
  public String getKaKaoAccessToken(String code) throws IOException{
    System.out.println(restKey);
    System.out.println(redirectUrl);
    String access_Token = "";
    String refresh_Token = "";
    String reqURL = "https://kauth.kakao.com/oauth/token";

    String result = null;
    String id_token = null;
    try {
      URL url = new URL(reqURL);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
      conn.setRequestMethod("POST");
      conn.setDoOutput(true);

      //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
      StringBuilder sb = new StringBuilder();
      sb.append("grant_type=authorization_code");
      sb.append("&client_id="+restKey); // TODO REST_API_KEY 입력
      sb.append("&redirect_uri="+redirectUrl); // TODO 인가코드 받은 redirect_uri 입력
      System.out.println("code = " + code);
      sb.append("&code=" + code);
      bw.write(sb.toString());
      bw.flush();

      //결과 코드가 200이라면 성공
      int responseCode = conn.getResponseCode();
      System.out.println("responseCode : " + responseCode);
      //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line = "";
      result = "";

      while ((line = br.readLine()) != null) {
        result += line;
      }
      // bearer 토큰 값만 추출(log에 찍히는 값의 이름은 id_Token)
      System.out.println("response body : " + result);
      String[] temp = result.split(",");
      id_token = temp[3].substring(11);
      System.out.println("idToken = " + id_token);


//            Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
      JsonParser parser = new JsonParser();
      JsonElement element = parser.parse(result);

      access_Token = element.getAsJsonObject().get("access_token").getAsString();
      refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();



      br.close();
      bw.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    String[] arrTokens = new String[3];
    arrTokens[0] = access_Token;
    arrTokens[1] = refresh_Token;
    arrTokens[2] = id_token;

    return createKakaoUser(arrTokens[0]);
  }


  public String createKakaoUser(String token) throws IOException {

    //1.유저 정보를 요청할 url
    String reqURL = "https://kapi.kakao.com/v2/user/me";

    //2.access_token을 이용하여 사용자 정보 조회
    URL url = new URL(reqURL);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    conn.setRequestMethod("POST");
    conn.setDoOutput(true);
    conn.setRequestProperty("Authorization", "Bearer " + token); //전송할 header 작성, access_token전송

    //결과 코드가 200이라면 성공
    int responseCode = conn.getResponseCode();
    System.out.println("responseCode : " + responseCode);

    //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String line = "";
    String result = "";

    while ((line = br.readLine()) != null) {
      result += line;
    }

    System.out.println("response body : " + result);

    //Gson 라이브러리로 JSON파싱
    JsonElement element = JsonParser.parseString(result);

    String id = element.getAsJsonObject().get("id").getAsString();
//    boolean hasEmail = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_email").getAsBoolean();
//    //사용자의 이름
//    String nickname = element.getAsJsonObject().get("properties").getAsJsonObject().get("nickname").getAsString();
//    //사용자의 이메일
//    String email = "";
//    if (hasEmail) {
//      email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString();
//    }


  return id;
  }
  }
