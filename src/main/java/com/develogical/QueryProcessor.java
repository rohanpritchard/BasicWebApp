package com.develogical;

public class QueryProcessor {

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
            String[] temp = query.split(" ");
            int result = Integer.parseInt(temp[2]) + Integer.parseInt(temp[4]);
            return Integer.toString(result);
        }
        if (query.toLowerCase().contains("multiplied")) {
            String[] temp = query.split(" ");
            int result = Integer.parseInt(temp[2]) * Integer.parseInt(temp[5]);
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
