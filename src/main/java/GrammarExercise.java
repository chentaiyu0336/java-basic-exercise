import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import  java.util.Arrays;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";
        Scanner input = new Scanner(System.in);
        firstWordList=input.next();
        secondWordList=input.next();
        input.close();

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        System.out.print(result);
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        List<String> list1=Arrays.asList(firstWordList.split(","));
        List<String> list2=Arrays.asList(secondWordList.split(","));
        List<String> res=new ArrayList<String>();
        if(!(list1.stream().allMatch(s -> s.matches("[a-zA-Z]+")))||!(list2.stream().allMatch(s->s.matches("[a-zA-Z]+")))){
            throw new RuntimeException("input not valid");
        }
        list1.stream().forEach(s1 -> {
            list2.stream().forEach(s2->{
                if(s2.toUpperCase().equals(s1.toUpperCase()))
                    res.add(s1.toUpperCase());
            });
        });
        return res.stream().distinct().sorted().map(s -> s.replace(""," ").trim())
                .collect(Collectors.toList());
    }
}
