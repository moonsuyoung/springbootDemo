package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	//참고 https://marrrang.tistory.com/19
	
	public interface MaxNumber {
		public int maxNum(int num);
	}

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("test");
        
        //람다식
        MaxNumber maxNumber = x -> (x>0) ? x:0;
        System.out.println(maxNumber.maxNum(0));
        
        //스트림
        String[] array = {"개발","자바","스트림"};
        Stream<String> strStream = Arrays.stream(array);
        
        strStream.filter(str->str.length()==2)
        		.forEach(str->System.out.println(str+" "));
        
        List<String> strList = Arrays.asList("개발자","자바","백엔드","프론트엔드","스트림");
        
        long strCount = strList.stream()
        		.map(str->str + "!")
        		.filter(str->str.length() > 3)
        		.peek(System.out::println)
        		.count();
        
       System.out.println("ea="+strCount);
       
       Stream<String> stream = Stream.<String>builder()
           	.add("개발자")
           	.add("자바")
           	.build();
       
       
       stream.filter(str-> str.length() > 2).forEach(str->System.out.println(str));
       
       List<String> strList2 = Arrays.asList("개발자","자바","스트림");
       strList2.stream()
       		.sorted()
       		.forEach(System.out::println);
       
       strList2.stream()
  		.sorted(Comparator.reverseOrder())
  		.forEach(System.out::println);
        
        
    }

}
