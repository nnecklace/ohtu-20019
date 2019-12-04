package statistics;

import java.util.ArrayList;
import java.util.List;

import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
    private List<Matcher> matchers;
    public QueryBuilder() {
        matchers = new ArrayList<>();
    }

    public QueryBuilder playsIn(String category) {
        matchers.add(new PlaysIn(category));

        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));

        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));

        return this;
    }

    public Matcher build() {
        Matcher[] matchersList = new Matcher[matchers.size()];

        for (int i = 0; i < matchers.size(); ++i) {
           matchersList[i] = matchers.get(i); 
        }

        matchers.clear();

        return new And(matchersList);
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        matchers.add(new Or(m1, m2));

        return this;
    }
}