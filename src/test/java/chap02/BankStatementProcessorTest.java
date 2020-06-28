package chap02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BankStatementProcessorTest {
    private BankStatementProcessor bankStatementProcessor;


    @Test
    public void shouldCalculateTotalAmount() {

    }

    @Test
    public void shouldFindHighestTransaction() {
        bankStatementProcessor = new BankStatementProcessor(regularBankTransaction());
        final double expected = 6000;

        final double result = bankStatementProcessor.findHighestTransaction();

        Assert.assertEquals(expected, result, 0.0d);
    }

    @Test
    public void shouldFindLowestTransaction() {
        bankStatementProcessor = new BankStatementProcessor(regularBankTransaction());
        final double expected = -600;

        final double result = bankStatementProcessor.findLowestTransaction();

        Assert.assertEquals(expected, result, 0.0d);
    }

    @Test
    public void shouldReturnZero() {
        bankStatementProcessor = new BankStatementProcessor(emptyBankTransaction());
        final double expected = 0d;

        final double result = bankStatementProcessor.findHighestTransaction();

        Assert.assertEquals(expected, result, 0.0d);
    }

    @Test
    public void shouldReturnHighestTransactionInRange() {
        bankStatementProcessor = new BankStatementProcessor(regularBankTransaction());
        final double expected = 99;
        final double result = bankStatementProcessor.findHighestTransactionInDateRange(LocalDate.of(2020, Month.MARCH, 1),
                LocalDate.of(2020, Month.MARCH, 30));

        Assert.assertEquals(expected,result,0.0d);
    }


    private List<BankTransaction> regularBankTransaction() {
        return Arrays.asList(
                new BankTransaction(LocalDate.of(2020, Month.MARCH, 10), 99, "Gift"),
                new BankTransaction(LocalDate.of(2020, Month.MARCH, 20), -10, "Cinema"),
                new BankTransaction(LocalDate.of(2020, Month.MARCH, 30), -600, "Rent"),
                new BankTransaction(LocalDate.of(2020, Month.APRIL, 01), 100, "Gas"),
                new BankTransaction(LocalDate.of(2020, Month.APRIL, 02), -200, "Gift"),
                new BankTransaction(LocalDate.of(2020, Month.APRIL, 05), 6000, "Salary"),
                new BankTransaction(LocalDate.of(2020, Month.APRIL, 12), 600, "Stocks")
        );
    }

    private List<BankTransaction> emptyBankTransaction() {
        return Collections.emptyList();
    }
}
