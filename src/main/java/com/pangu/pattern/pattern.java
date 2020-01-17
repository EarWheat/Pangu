package com.pangu.pattern;

import java.util.regex.Pattern;

/*
 * @author:liuzhaolu
 * @createTime: 2020-01-17 15:00
 * @desc:
 */
public class pattern {
    public static void main(String[] args){
        String phone = "+454123456789";
//        int phone = 120349102;
        String pattern = "\\+(\\d*)";
        boolean isPhoneNum = Pattern.matches(pattern,phone);
        System.out.println(isPhoneNum);
    }
}
