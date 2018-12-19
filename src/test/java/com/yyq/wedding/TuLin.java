package com.yyq.wedding;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TuLin {
    /**
     * 图灵测试
     * @throws Exception
     */
    @Test
    public void test() throws Exception{
        String APIKEY = "1e78ca133c39443e961fb27bc1c77f43";
        String INFO = URLEncoder.encode("当前时间", "utf-8");//这里可以输入问题
        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();

        // 取得输入流，并使用Reader读取
        BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine())!= null) {
            sb.append(line);
        }
        reader.close();
        // 断开连接
        connection.disconnect();
        String[] ss = new String[10];
        String s = sb.toString();
       // System.out.println("完整代码"+s);
        String answer;
        if (s.contains("2018")){
            ss = s.split("年");
        }else {
            ss = s.split(":");
        }
        answer = ss[ss.length-1];
        answer = answer.substring(1,answer.length()-2);
        System.out.println(answer);
    }
}
