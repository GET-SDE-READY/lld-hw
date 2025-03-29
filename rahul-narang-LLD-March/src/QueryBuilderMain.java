class QueryBuilder {
    private String select;
    private String from;
    private String where;
    private String groupBy;
    private String orderBy;
    private String having;

    private QueryBuilder(String select, String from) {
        this.select = select;
        this.from = from;
    }

    public static QueryBuilder create(String select, String from) {
        if (select == null || select.isEmpty() || from == null || from.isEmpty())
            throw new RuntimeException("select or from can't be null");
        return new QueryBuilder(select, from);
    }

    public QueryBuilder select(String select) {
        this.select = select;
        return this;
    }

    public QueryBuilder from(String from) {
        this.from = from;
        return this;
    }

    public QueryBuilder where(String where) {
        this.where = where;
        return this;
    }

    public QueryBuilder groupBy(String groupBy) {
        this.groupBy = groupBy;
        return this;
    }

    public QueryBuilder orderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public QueryBuilder having(String having) {
        this.having = having;
        return this;
    }

    public String build() {
        StringBuilder query = new StringBuilder();
        query.append("select ")
                .append(this.select)
                .append(" from ")
                .append(this.from);

        if (this.where != null && !this.where.isEmpty())
            query.append(" where ").append(this.where);

        if (this.groupBy != null && !this.groupBy.isEmpty())
            query.append(" group by ").append(this.groupBy);

        if (this.orderBy != null && !this.orderBy.isEmpty())
            query.append(" order by ").append(this.orderBy);

        if (this.having != null && !this.having.isEmpty())
            query.append(" having ").append(this.having);

        return query.toString();
    }
}

public class QueryBuilderMain {
    public static void main(String[] args) {
        try {
            QueryBuilder queryBuilder = QueryBuilder.create("name, age", "person");
            String query = queryBuilder
                    .orderBy("id")
                    .groupBy("city")
                    .build();

            System.out.println(query);
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
