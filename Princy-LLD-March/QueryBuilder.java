public class QueryBuilder {
    private String select;
    private String from;
    private String where;
    private String orderBy;
    private String groupBy;
    
    private QueryBuilder(QueryBuilderBuilder builder) {
        this.select = builder.select;
        this.from = builder.from;
        this.where = builder.where;
        this.orderBy = builder.orderBy;
        this.groupBy = builder.groupBy;
    }
    
    public String buildQuery() throws Exception{
        if (select == null || from == null) {
            throw new Exception("SELECT and FROM can't be null!");
        }
        StringBuilder query = new StringBuilder();
        query.append("SELECT ").append(select).append(" FROM ").append(from);

        if (where != null) {
            query.append(" WHERE ").append(where);
        }
        if (groupBy != null) {
            query.append(" GROUP BY ").append(groupBy);
        }
        if (orderBy != null) {
            query.append(" ORDER BY ").append(orderBy);
        }

        return query.toString();
    }
    
    public static class QueryBuilderBuilder {
        private String select;
        private String from;
        private String where;
        private String orderBy;
        private String groupBy;

        public QueryBuilderBuilder select(String select) {
            this.select = select;
            return this;
        }

        public QueryBuilderBuilder from(String from) {
            this.from = from;
            return this;
        }

        public QueryBuilderBuilder where(String where) {
            this.where = where;
            return this;
        }

        public QueryBuilderBuilder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        public QueryBuilderBuilder groupBy(String groupBy) {
            this.groupBy = groupBy;
            return this;
        }

        public QueryBuilder build() {
            return new QueryBuilder(this);
        }
    }
    
    public static void main(String[] args) {
        try {
        QueryBuilder query = new QueryBuilder.QueryBuilderBuilder()
                .orderBy("age DESC")
                .groupBy("users")
                .from(null)
                .where("age > 18")
                .select("name, age")
                .build();

        System.out.println(query.buildQuery());
        } catch (Exception e) {
            System.out.println("Query Error: " + e.getMessage());
        }

    }
}

/*
Output:

princypareek@Princys-MacBook-Pro Princy-LLD-March % javac QueryBuilder.java

princypareek@Princys-MacBook-Pro Princy-LLD-March % java QueryBuilder  
    
SELECT name, age FROM users WHERE age > 18 GROUP BY users ORDER BY age DESC

 */