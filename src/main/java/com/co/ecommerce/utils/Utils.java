package com.co.ecommerce.utils;

import java.util.Random;

public class Utils {

    public static String aleatoryUser(){
        Random random=new Random();
        int number= random.nextInt(900)+100;
        return String.valueOf(number);
    }

    public static Integer aleatoryAccount(int count){
        Random random=new Random();
        return random.nextInt(count);
    }


}
