package chap02;

import chap02.BankStatementCSVParser;
import chap02.BankTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class BankStatementCSVParserTest {
    private final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

    @Test
    public void shouldParseLines() {
        final List<String> lines = Arrays.asList("30-01-2017,-100,Deliveroo");
        final List<BankTransaction> expected = Arrays.asList(new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "Deliveroo"));

        final List<BankTransaction> target = bankStatementCSVParser.parseLinesFrom(lines);

        Assert.assertTrue(target.equals(expected));
    }
}
