package com.develogical;

import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static List<Integer> findNumbers(String query) {
        List<Integer> result = new ArrayList<>();
        String[] l = query.split(" ");
        for (String s:l) {
            if(isNumeric(s)) {
                result.add(Integer.parseInt(s));
            }
        }
        return result;
    }
    public String process(String query) {

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("what is your team name")) {
            return "The Egg Deluxe";
        }
        if (query.toLowerCase().contains("plus")) {
            List<Integer> numbers = findNumbers(query);
            int result = numbers.get(0) + numbers.get(1);
            return Integer.toString(result);
        }
        if (query.toLowerCase().contains("multiplied")) {
            List<Integer> numbers = findNumbers(query);
            int result = numbers.get(0)* numbers.get(1);
            return Integer.toString(result);
        }
        if (query.toLowerCase().contains("which of the following numbers is the largest")) {
            String x = query.toLowerCase();
            String y = x.substring(x.lastIndexOf(":") + 1);
            String[] z = y.split(",");
            int m = Integer.MIN_VALUE;
            try {
                for (String i : z) {
                    m = Integer.max(Integer.parseInt(i.trim()), m);
                }
            } catch (NumberFormatException e){
                return "Unparsable String: " + e.getMessage();
            }
            return Integer.toString(m);
        }

        System.out.println("Warning: Unknown query: \"" + query + "\"");
        return "";
    }
}

