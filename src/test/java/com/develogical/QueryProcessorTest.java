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
    public void knowsAboutPlus() throws Exception {
        assertThat(queryProcessor.process("what is 1 plus 2"), containsString("3"));
    }
    @Test
    public void knowsAboutTeamName() throws Exception {
        assertThat(queryProcessor.process("what is your team name"), containsString("The Egg Deluxe"));
    }
    @Test
    public void knowsHowToFindMax() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 22, 23"), containsString("23"));
    }
    @Test
    public void knowsHowToFindMaxError() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 22, k"), containsString("Unparsable String: For input string: \"k\""));
    }
}
