package designpatterns.RijavLLDJul25.com.designpatterns.creational.builder;

public class SqlQueryBuilder {
    private String select;
    private String from;
    private String where;
    private String join;

    public SqlQueryBuilder select(String cols) {
        this.select = "SELECT " + cols;
        return this;
    }

    public SqlQueryBuilder from(String table) {
        this.from = "FROM " + table;
        return this;
    }

    public SqlQueryBuilder join(String table, String onCondition) {
        this.join = "JOIN " + table + " ON " + onCondition;
        return this;
    }

    public SqlQueryBuilder where(String condition) {
        this.where = "WHERE " + condition;
        return this;
    }

    public String build() {
        StringBuilder query = new StringBuilder();
        if (select != null) query.append(select).append(" ");
        if (from != null) query.append(from).append(" ");
        query.append(join).append(" ");
        query.append(where);
        return query.toString().trim();
    }
}
