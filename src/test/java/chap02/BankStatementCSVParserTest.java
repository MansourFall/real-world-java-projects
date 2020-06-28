package chap02;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class BankStatementCSVParserTest {
    private final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() {
        final String line = "28-03-2020,-600,Rent";
        final BankTransaction expected = new BankTransaction(LocalDate.of(2020, Month.MARCH, 28), -600, "Rent");

        final BankTransaction result = bankStatementCSVParser.parseFrom(line);

        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), 0.0d);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }

    @Test
    public void shouldParseAllLines() {
        final List<String> lines = Arrays.asList("30-01-2020,-20,Deliveroo", "20-03-2020,-10,Cinema", "11-05-2020,10000,Salary");
        final List<BankTransaction> expected = Arrays.asList(
                new BankTransaction(LocalDate.of(2020, Month.JANUARY, 30), -20, "Deliveroo"),
                new BankTransaction(LocalDate.of(2020, Month.MARCH, 20), -10, "Cinema"),
                new BankTransaction(LocalDate.of(2020, Month.MAY, 11), 10000, "Salary")
                );

        final List<BankTransaction> result = bankStatementCSVParser.parseLinesFrom(lines);

        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(expected.get(0), result.get(0));
        Assert.assertEquals(expected.get(1), result.get(1));
        Assert.assertEquals(expected.get(2), result.get(2));
    }
}
