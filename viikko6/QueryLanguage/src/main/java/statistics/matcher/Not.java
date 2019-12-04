package statistics.matcher;

import statistics.Player;

public class Not implements Matcher {
    private Matcher statement;

    public Not(Matcher statement) {
        this.statement = statement;
    }

    public boolean matches(Player p) {
        return !statement.matches(p);
    }
}