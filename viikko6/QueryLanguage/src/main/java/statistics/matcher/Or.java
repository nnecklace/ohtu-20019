package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {
    private Matcher[] matchers;

    public Or(Matcher... args) {
        this.matchers = args;
    }

    public boolean matches(Player p) {
        for (Matcher m : matchers) {
            if (m.matches(p)) {
                return true;
            }
        }
        return false;
    }
}