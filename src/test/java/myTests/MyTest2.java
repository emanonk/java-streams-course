package myTests;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by manoskammas on 04/11/2018.
 */
public class MyTest2 {


    @Test
    public void another(){
List<Integer> badNumbers = new ArrayList<>();
        badNumbers.add(4);
        badNumbers.add(5);
        badNumbers.add(2);
        badNumbers.add(15);



        Collections.sort(badNumbers);

        SortedSet<Integer> one = new

        Set<Integer> badSet = badNumbers.stream().collect(Collectors.toSet());


        int l = 1;
        int r = 10;


        int max = 0;
        int counter = 0;
        for(int i=l; i<=r; i++){

            System.out.println("i:"+i);


            if(!badSet.contains(i)){
                counter++;
                System.out.println("counter:"+counter);
            }else{
                if(counter > max) {
                    max = counter;
                    System.out.println("max rep:"+max);
                }else{

                }
                counter = 0;
            }
            //counter++;


        }
        if(counter > max) {
            max = counter;
            System.out.println("max rep:" + max);
        }
        System.out.println(max);


    }

    @Test
    public void test() throws Exception {
        System.out.println("Hi");
        Stack<Character> stack = new Stack<>();

        List<Character> special=Lists.newArrayList();

        special.add('{');
        special.add('}');
        special.add('[');
        special.add(']');
        special.add('(');
        special.add(')');


        Map<Character,Character> map = new HashMap<>();

        map.put('}','{');
        map.put(')','(');
        map.put(']','[');


        String data = "{asdas[asdasd](asd)}";

        boolean valid = true;

        for(int i=0;i<data.length();i++){
            char c = data.charAt(i);

            if(special.contains(c)){

                System.out.println("e:"+c);
                if(stack.contains(c)){
                    valid=false;
                    break;
                }




                if(!stack.empty()){
                    System.out.println("peek:"+stack.peek() + " c:"+map.get(c));

                    Character peek = stack.peek();
                    Character alter = map.get(c);

                    if(alter != null && peek == (alter)){
                        stack.pop();
                        continue;
                    }


                }



                    stack.push(c);



            }

            System.out.println(stack);


        }



    }
}
