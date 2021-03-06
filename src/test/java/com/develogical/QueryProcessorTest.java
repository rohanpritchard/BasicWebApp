package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void KnowsAboutEfielTower() throws Exception {
        assertThat(queryProcessor.process("which city is the Eiffel tower in"), containsString("Paris"));
    }


    @Test
    public void knowsAboutMultiply() throws Exception {
        assertThat(queryProcessor.process("what is 1 multiplied by 2"), containsString("2"));
    }

    //@Test
    //public void knowsAboutMultiplyError() throws Exception {
        //assertThat(queryProcessor.process("what is k multiplied by 2"), containsString("Unparsable String: For input string: \"k\""));
    //}

    @Test
    public void knowsAboutPlus() throws Exception {
        assertThat(queryProcessor.process("what is 1 plus 2"), containsString("3"));
    }

    //@Test
    //public void knowsAboutPlusError() throws Exception {
        //assertThat(queryProcessor.process("what is 1 plus k"), containsString("Unparsable String: For input string: \"k\""));
    //}

    @Test
    public void knowsAboutTeamName() throws Exception {
        assertThat(queryProcessor.process("what is your team name"), containsString("The Egg Deluxe"));
    }

    @Test
    public void knowsAboutBanana() throws Exception {
        assertThat(queryProcessor.process("what colour is a banana"), containsString("Yellow"));
    }

    @Test
    public void knowsAboutMinus() throws Exception {
        assertThat(queryProcessor.process("what is 1 minus 2"), containsString("-1"));
    }
    @Test
    public void knowsHowToFindMax() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 22, 23"), containsString("23"));
    }
    @Test
    public void knowsHowToFindMaxError() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 22, k"), containsString("Unparsable String: For input string: \"k\""));
    }

    @Test
    public void knowsPrimes() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers are primes: 2, 11, 6, 5"), containsString("2, 11, 5"));
    }

    @Test
    public void knowsFibs() throws Exception {
        assertThat(queryProcessor.process(" what is the 16th number in the Fibonacci sequence"), containsString("610"));
    }

    @Test
    public void knowsPowers() throws Exception {
        assertThat(queryProcessor.process("what is 2 to the power of 4"), containsString("16"));
    }
}
