package chap02;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0d;
        for(BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateAmountInMonth(final Month month) {
        double total = 0d;
        for(BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0d;
        for(BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double findHighestTransaction() {
        return findMaxBankTransaction(bankTransactions);
    }

    public double findLowestTransaction() {
        return findMinBankTransaction(bankTransactions);
    }

    public double findHighestTransactionInDateRange(final LocalDate startDate, final LocalDate endDate) {
        List<BankTransaction> bankTransactionsInRange = new ArrayList<>();
        if(endDate.compareTo(startDate) < 0) {
            return 0;//should throw an exception
        } else {
            for(BankTransaction bankTransaction : bankTransactions) {
                if((bankTransaction.getDate().compareTo(startDate) >= 0) && (bankTransaction.getDate().compareTo(endDate) <= 0)) {
                    bankTransactionsInRange.add(bankTransaction);
                }
            }
            return findMaxBankTransaction(bankTransactionsInRange);
        }
    }

    public double findLowestTransactionInDateRange(final LocalDate startDate, final LocalDate endDate) {
        List<BankTransaction> bankTransactionsInRange = new ArrayList<>();
        if(endDate.compareTo(startDate) < 0) {
            return 0;//should throw an exception
        } else {
            for(BankTransaction bankTransaction : bankTransactions) {
                if((bankTransaction.getDate().compareTo(startDate) >= 0) && (bankTransaction.getDate().compareTo(endDate) <= 0)) {
                    bankTransactionsInRange.add(bankTransaction);
                }
            }
            return findMinBankTransaction(bankTransactionsInRange);
        }
    }

    private double findMaxBankTransaction(final List<BankTransaction> bankTransactions) {
        if (bankTransactions == null || bankTransactions.isEmpty()) {
            return 0;
        } else {
            double highestTransaction = bankTransactions.get(0).getAmount();
            for(BankTransaction bankTransaction : bankTransactions) {
                if(bankTransaction.getAmount() > highestTransaction) {
                    highestTransaction = bankTransaction.getAmount();
                }
            }
            return  highestTransaction;
        }
    }

    private double findMinBankTransaction(final List<BankTransaction> bankTransactions) {
        if(bankTransactions.size() > 0) {
            double lowestTransaction = bankTransactions.get(0).getAmount();
            for(BankTransaction bankTransaction : bankTransactions) {
                if(bankTransaction.getAmount() < lowestTransaction) {
                    lowestTransaction = bankTransaction.getAmount();
                }
            }
            return  lowestTransaction;
        } else {
            return 0;
        }
    }
}
