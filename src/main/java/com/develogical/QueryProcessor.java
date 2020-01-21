package com.develogical;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(query);
        while (m.find()) {
            result.add(Integer.parseInt(m.group()));
        }
        return result;
    }
    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
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
        if (query.toLowerCase().contains("which city is the eiffel tower in")) {
            return "Paris";
        }

        if (query.toLowerCase().contains("who played James Bond in the film Dr No")) {
            return "Sean Connery";
        }
        if (query.toLowerCase().contains("what colour is a banana")) {
            return "Yellow";
        }
        if (query.toLowerCase().contains("which of the following numbers is both a square and a cube:")) {
            return "";
        }
        if (query.toLowerCase().contains("plus")) {
            List<Integer> numbers = findNumbers(query);
            int result = 0;
            for (int n:numbers) {
                result += n;
            }
            return Integer.toString(result);
        }
        if (query.toLowerCase().contains("minus")) {
            List<Integer> numbers = findNumbers(query);
            int result = numbers.get(0) - numbers.get(1);
            return Integer.toString(result);
        }
        if (query.toLowerCase().contains("multiplied")) {
            List<Integer> numbers = findNumbers(query);
            int result = numbers.get(0) * numbers.get(1);
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
        if (query.toLowerCase().contains("which of the following numbers are primes")) {
            String x = query.toLowerCase();
            String y = x.substring(x.lastIndexOf(":") + 1);
            String[] z = y.split(",");
            List<String> s = new ArrayList<String>();
            for (String i : z) {
                int a = Integer.parseInt(i.trim());
                if (isPrime(a)) {
                    s.add(Integer.toString(a));
                }
            }
            return String.join(", ", s);
        }
        if (query.toLowerCase().contains("fibonacci")) {
            String x = query.toLowerCase();
            String[] y = x.split(" ");
            int i = Integer.parseInt(y[3].substring(0, y[3].length() - 2));
            return Integer.toString(fib(i));
        }

        System.out.println("Warning: Unknown query: \"" + query + "\"");
        return "";
    }
}

