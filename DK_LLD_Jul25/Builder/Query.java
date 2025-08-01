package designpatterns.DK_LLD_Jul25.Builder;

public class Query {
    private String query;

    void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return query;
    }
}
