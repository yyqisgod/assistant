package com.yyq.wedding;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
public class TuLin {


    /**
     * 脑残版时间转换工具类
     * hzb commit
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        String time1 = "十二月 21, 2018";
        System.out.println(zhuanhuan(time1));


    }
//2018-12-21
    public String zhuanhuan(String str) {
        // System.out.println(str.substring(0,1));
        //String month = str.substring(0, 1);
        String riqi = null;
        String year = null;
        String month = StringUtils.substringBeforeLast(str, "月");
        if(month.equals("十一")||month.equals("十二")){
            riqi=str.substring(4, 6);
            year = str.substring(8, 12);
            if("十一".equals(month)){
                month = "11";
            }
            if("十二".equals(month)){
                month = "12";
            }
            String shuchu="输出==="+year+"-"+month+"-"+riqi;
            return shuchu;
        }

        if("一".equals(month)|| "二".equals(month)|| "三".equals(month)|| "四".equals(month)|| "五".equals(month)|| "六".equals(month)||
                "七".equals(month)|| "八".equals(month)||
                "九".equals(month)||"十".equals(month) ||"十一".equals(month) ||"十二".equals(month)
        ){
            if("一".equals(month)){
                month = "01";
            }
            if("二".equals(month)){
                month = "02";
            }
            if("三".equals(month)){
                month = "03";
            }
            if("四".equals(month)){
                month = "04";
            }
            if("五".equals(month)){
                month = "05";
            }
            if("六".equals(month)){
                month = "06";
            }
            if("七".equals(month)){
                month = "07";
            }
            if("八".equals(month)){
                month = "08";
            }
            if("九".equals(month)){
                month = "09";
            }
            if("十".equals(month)){
                month = "10";
            }
            if("十一".equals(month)){
                month = "11";
            }
            if("十二".equals(month)){
                month = "12";
            }
            riqi = str.substring(3, 5);
            year=str.substring(7, 11);
            String shuchu="输出==="+year+"-"+month+"-"+riqi;
            return shuchu;
        }

//        System.out.println(month);
//        System.out.println("riqi=="+riqi);
//        System.out.println("year==="+year);

       return "格式错误";


    }


}
