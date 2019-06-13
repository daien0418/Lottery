package com.Lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author daien
 * @date 2019年6月10日
 */
public class App {

    public static Set<Integer> rPool = new TreeSet<Integer>();
    public static Set<Integer> bPool = new TreeSet<Integer>();
    public static int rNumber = 6;
    public static int bNumber = 1;

    /**
     * @Description
     * -dlt
     * -ssq
     *
     * -er exclude numbers from red pool
     * -eb exclude numbers from blue pool
     * -nr choosen number from red pool
     * -nb choosen number from blue pool
     * @param args
     */

    public static void main(String[] args) {
        if(args==null){
            System.err.println("请输入参数");
            System.exit(-1);
        }
        if(args[0].equals("-ssq")){
            args=Arrays.copyOfRange(args, 1, args.length);
            ssq(args);
        }else if(args[0].equals("-dlt")){
            args=Arrays.copyOfRange(args, 1, args.length);
            dlt(args);
        }
    }

    public static void ssq(String args[]){
        rNumber = 6;
        bNumber = 1;

        for(int i=1;i<34;i++){
            rPool.add(i);
        }
        for(int i=1;i<17;i++){
            bPool.add(i);
        }

        calculate(args);
    }

    public static void dlt(String args[]){
        rNumber = 5;
        bNumber = 2;

        for(int i=1;i<36;i++){
            rPool.add(i);
        }
        for(int i=1;i<13;i++){
            bPool.add(i);
        }

        calculate(args);
    }

    public static void calculate(String args[]){
        List<String> list = Arrays.asList(args);
        while (list.size() > 0) {

            if(list.get(0).equals("-er")){
                if(list.get(1) == null){
                    System.out.println("请输入er参数");
                    return;
                }
                String[] rNums = list.get(1).split(",");
                for(String string:rNums){
                    try {
                        Integer value = Integer.parseInt(string);
                        rPool.remove(value);
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的er参数，用逗号隔开");
                        return;
                    }
                }
                list = list.subList(2, list.size());
                continue;
            }

            if(list.get(0).equals("-eb")){
                if(list.get(1) == null){
                    System.out.println("请输入eb参数");
                    return;
                }
                String[] rNums = list.get(1).split(",");
                for(String string:rNums){
                    try {
                        Integer value = Integer.parseInt(string);
                        bPool.remove(value);
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的eb参数，用逗号隔开");
                        return;
                    }
                }
                list = list.subList(2, list.size());
                continue;
            }

            if(list.get(0).equals("-nr")){
                if(list.get(1) == null){
                    System.out.println("请输入nr参数");
                    return;
                }
                try {
                    rNumber = Integer.parseInt(list.get(1));
                } catch (NumberFormatException e) {
                    System.out.println("请输入正确的nr参数");
                    return;
                }
                list = list.subList(2, list.size());
                continue;
            }

            if(list.get(0).equals("-nb")){
                if(list.get(1) == null){
                    System.out.println("请输入nb参数");
                    return;
                }
                try {
                    bNumber = Integer.parseInt(list.get(1));
                } catch (NumberFormatException e) {
                    System.out.println("请输入正确的nb参数");
                    return;
                }
                list = list.subList(2, list.size());
                continue;
            }

            System.out.println("输入的参数不合法:"
                   + "\r\n -er exclude numbers from red pool,split with comma"
                   + "\r\n -eb exclude numbers from blue pool,split with comma"
                   + "\r\n -nr choosen number from red pool"
                   + "\r\n -nb choosen number from blue pool"
                    );
            return;
        }

        if(rNumber>rPool.size()){
            System.out.println("rPool个数不足");
            return;
        }

        if(bNumber>bPool.size()){
            System.out.println("bPool个数不足");
            return;
        }

        StringBuilder rBuilder = new StringBuilder();
        StringBuilder bBuilder = new StringBuilder();
        List<Integer> rList = new ArrayList<Integer>(rPool);
        List<Integer> bList = new ArrayList<Integer>(bPool);
        for(int r=0;r<rNumber;r++){
            Integer value = rList.get((int)(Math.random()*rList.size()));
            rList.remove(value);
            rBuilder.append(value);
            if(r!=rNumber-1){
                rBuilder.append(",");
            }
        }

        for(int b=0;b<bNumber;b++){
            Integer value = bList.get((int)(Math.random()*bList.size()));
            bList.remove(value);
            bBuilder.append(value);
            if(b!=bNumber-1){
                bBuilder.append(",");
            }
        }

        System.out.println("Reds:" + rBuilder.toString());
        System.out.println("Blues:" + bBuilder.toString());
    }
}
