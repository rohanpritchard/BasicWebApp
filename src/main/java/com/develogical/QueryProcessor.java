package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("george")) {
            return "Rhymes with anchor.";
        }
        if (query.toLowerCase().contains("ed")) {
            return "Has curly hair.";
        }
        if (query.toLowerCase().contains("what is your team name")) {
            return "The Egg Deluxe";
        }
        if (query.toLowerCase().contains("plus")) {
            String[] temp = query.split(" ");
            int result = Integer.parseInt(temp[2]) + Integer.parseInt(temp[4]);
            return Integer.toString(result);
        }
        return "";
    }
}
