package myTests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyTest1 {
    static int substrings(String input) {
        String data = input.replaceAll("\\s+","");
        int count =0;
        char[] chars = data.toCharArray();
        Map<String, Integer> dataMap= new HashMap();

        for(int i=0;i<chars.length-4;i++){

            String subString = data.substring(i,i+3);
            Integer counter = dataMap.get(subString);
            if( counter == null){
                dataMap.put(subString,1);
            }else{
                dataMap.put(subString,counter+1);
            }


        }

        Set<String> keys = dataMap.keySet();

        count = (int) keys.stream().filter(key -> dataMap.get(key) > 1).count();

        return count;

    }

    static int substrings2(String input) {
        String data = input.replaceAll("\\s+","");

        System.out.println(data);
        Map<String, Integer> dataMap= new HashMap();
        int finalCounter = 0;
        for(int i=0;i<data.length()-3;i++){

            String subString = data.substring(i,i+4);
            System.out.println(subString);


            Integer counter = dataMap.get(subString);


            if( counter == null){
                dataMap.put(subString,1);
            }else{
                dataMap.put(subString,counter+1);
            }
        }


        Set<String> keys = dataMap.keySet();

        for(String key:keys){
            System.out.println("key:"+key);
            System.out.println("value:"+dataMap.get(key));
            if(dataMap.get(key) > 1){
                finalCounter++ ;
            }
        }

        return finalCounter;

    }


    @Test
    public void test() throws Exception {
        System.out.println(substrings2("tralala tralala"));
    }


    static String reproduceString(String fullText) {

        String input = fullText.replaceAll("\\s+","");
        char[] chars = input.toCharArray();
        StringBuilder newString = new StringBuilder();
        for(int i=0; i<input.length();i++){
            char c = chars[i];
            String s = String.valueOf(c);
            if(s.equalsIgnoreCase("a") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("u")){
                //ignore
            }else{
                newString.append(c);
            }
        }

        if(newString.toString().isEmpty()){
            return "-";
        }
        return newString.toString();

    }


    @Test
    public void test2() throws Exception {
        System.out.println(reproduceString("Identity"));
    }


    static String haha(int input){
        int num = (int) Math.round(Math.pow(input, 1.0/3.0));

        if(num > 31){
            return "";
        }
        for(int i =2; i<= num / 2; i++){
            if( num % i == 0){
                return "no";
            }
        }
        return "yes";
    }


    static String haha2(int input){

        Map<Integer,Integer> cubeMap = new HashMap();





        for(int num=0;num<31;num++){

            boolean isPrime=true;
            for(int i =2; i<= num / 2; i++){
                if( num % i == 0){
                    isPrime=false;
                }
            }
            if(isPrime) {
                int cube = num * num * num;
                cubeMap.put(cube, num);
            }
        }
        if(cubeMap.get(input) != null){
            return "yes";
        }
        return "no";
    }


    @Test
    public void test3() throws Exception {


        System.out.println(haha2(64));





    }
}
