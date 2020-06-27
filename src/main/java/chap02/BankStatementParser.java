package chap02;

import java.util.List;

public interface BankStatementParser {
    List<BankTransaction> parseLinesFrom(final List<String> lines);
}
