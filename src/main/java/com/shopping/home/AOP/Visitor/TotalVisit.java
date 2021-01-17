package com.shopping.home.AOP.Visitor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TotalVisit {

    private static List<Integer> visitors;

    private static LocalDateTime time;

    private static LocalDateTime prev_time;

    private static Integer random(){
        return (int)(Math.random()*50);
    }

    private static boolean setTime(){

        time = LocalDateTime.now();

        if(prev_time==null){
            prev_time = LocalDateTime.now();
        }

        if(prev_time.getDayOfYear()!=time.getDayOfYear()){
            return true;
        }

        return false;
    }
    public static void add(){
        if(visitors==null){
            visitors = new ArrayList<>();

            visitors.add(0);

            for(int i=1;i<7;i++){
                visitors.add(random());
            }
        }

        if(setTime()){
            visitors.add(0);
            visitors.remove(visitors.size()-1);
        }
        else{
            prev_time = time;
        }

        visitors.set(0,visitors.get(0) + 1);
    }

    public static List<Integer> getVisitors() {
        if(visitors==null){
            visitors = new ArrayList<>();

            visitors.add(0);

            for(int i=1;i<7;i++){
                visitors.add(random());
            }
        }

        if(setTime()){
            visitors.add(0);
            visitors.remove(visitors.size()-1);
        }
        else{
            prev_time = time;
        }

        return visitors;
    }
}
