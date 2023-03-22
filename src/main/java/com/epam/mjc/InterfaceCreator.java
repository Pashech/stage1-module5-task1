package com.epam.mjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        List<String> trueList = new ArrayList<>();
        return x -> {
            for(String s : x){
                if(Character.isUpperCase(s.charAt(0))){
                    trueList.add(s);
                }
            }
            return x.size() == trueList.size();
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        List<Integer> trueList = new ArrayList<>();
        return x -> {
            for(Integer i : x){
                if(i % 2 == 0){
                    trueList.add(i);
                }
            }
            x.addAll(trueList);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        List<String> tempList = new ArrayList<>();
        return () -> {
            for(String v : values){
                if((Character.isUpperCase(v.charAt(0))) && (v.length() >= 3) && (v.endsWith("."))){
                    tempList.add(v);
                }
            }
            return tempList;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Map<String, Integer> map = new HashMap<>();
        return x -> {
            for(String s : x){
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        List<Integer> list3 = new ArrayList<>();
        return (list1, list2) -> {
            list3.addAll(list1);
            list3.addAll(list2);
            return list3;
        };
    }
}
