package com.fanhf.javastudy.guavaTest;

import com.google.common.base.Joiner;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;
import static com.google.common.collect.ImmutableMap.of;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-12-30 16:17
 */
public class JoinerTest {
    private static final List<String> stringList = Arrays.asList("Google", "Guava", "Scala", "Kafka", "Java");
    private static final List<String> stringNullList = Arrays.asList("Google", "Guava", "Scala", null, "Java");
    private static final String targetFileName = "d:/study/guava-joiner.txt";
    private static final String targetFileNameMap = "d:/study/guava-joiner-map.txt";
    private static final Map<String, String> stringMap = of("hello", "guava", "hi", "java");

    public static void main(String[] args) {

        String join = Joiner.on("#").join(stringList);
        System.out.println("join: " + join);

        String joinnull = Joiner.on("%").skipNulls().join(stringNullList);
        System.out.println("joinnull: " + joinnull);

        String joinWithNull = Joiner.on("%").useForNull("DEFAULT").join(stringNullList);
        System.out.println("joinWithNull: " + joinWithNull);

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = Joiner.on("#").useForNull("DEFAULT").appendTo(stringBuilder, stringNullList);
        System.out.println("stringBuilder1: " + stringBuilder1);

        try (FileWriter writer = new FileWriter(new File(targetFileName));) {
            Joiner.on("%").useForNull("DEFAULT").appendTo(writer, stringNullList);
//            System.out.println( Files.isFile().test(new File(targetFileName)));
        } catch (IOException e) {
            System.out.println("failed append");
        }
        String collect = stringNullList.stream().filter(item -> item != null && !item.isEmpty()).collect(joining("#"));
        System.out.println("collect: " + collect);

        String collectMap = stringNullList.stream()
                .map(item -> item == null || item.isEmpty() ? "DEFAULT" : item).collect(joining("$"));
        System.out.println("collectMap: " + collectMap);

        String join1 = Joiner.on("#").withKeyValueSeparator("-").join(stringMap);
        System.out.println("join1 : " + join1);

        try (FileWriter writer = new FileWriter(new File(targetFileNameMap));) {
            Joiner.on("%").withKeyValueSeparator("--").appendTo(writer, stringMap);
//            System.out.println( Files.isFile().test(new File(targetFileNameMap)));
        } catch (IOException e) {
            System.out.println("failed append");
        }
    }

}   
