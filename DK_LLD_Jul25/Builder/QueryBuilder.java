package designpatterns.DK_LLD_Jul25.Builder;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {

    private String selectClause;
    private String fromClause;
    private final List<String> joinClauses = new ArrayList<>();
    private String whereClause;
    private String groupByClause;
    private String orderByClause;

    public QueryBuilder select(String columns) {
        if (columns == null || columns.trim().isEmpty()) {
            throw new IllegalArgumentException("SELECT clause cannot be null or empty");
        }
        this.selectClause = "SELECT " + columns;
        return this;
    }

    public QueryBuilder from(String tableName) {
        if (tableName == null || tableName.trim().isEmpty()) {
            throw new IllegalArgumentException("FROM clause cannot be null or empty");
        }
        this.fromClause = "FROM " + tableName;
        return this;
    }

    public QueryBuilder join(String joinType, String tableName, String onCondition) {
        if (tableName == null || tableName.trim().isEmpty()) {
            throw new IllegalArgumentException("Join table cannot be null or empty");
        }
        if (onCondition == null || onCondition.trim().isEmpty()) {
            throw new IllegalArgumentException("Join ON condition cannot be null or empty");
        }

        String joinClause = String.format("%s JOIN %s ON %s", joinType.toUpperCase(), tableName, onCondition);
        this.joinClauses.add(joinClause);
        return this;
    }

    public QueryBuilder innerJoin(String tableName, String onCondition) {
        return join("INNER", tableName, onCondition);
    }

    public QueryBuilder leftJoin(String tableName, String onCondition) {
        return join("LEFT", tableName, onCondition);
    }

    public QueryBuilder rightJoin(String tableName, String onCondition) {
        return join("RIGHT", tableName, onCondition);
    }

    public QueryBuilder where(String condition) {
        if (condition != null && !condition.trim().isEmpty()) {
            this.whereClause = "WHERE " + condition;
        }
        return this;
    }

    public QueryBuilder groupBy(String groupBy) {
        if (groupBy != null && !groupBy.trim().isEmpty()) {
            this.groupByClause = "GROUP BY " + groupBy;
        }
        return this;
    }

    public QueryBuilder orderBy(String orderBy) {
        if (orderBy != null && !orderBy.trim().isEmpty()) {
            this.orderByClause = "ORDER BY " + orderBy;
        }
        return this;
    }

    public Query build() {
        if (selectClause == null) {
            throw new IllegalStateException("SELECT clause is mandatory");
        }

        if (fromClause == null) {
            throw new IllegalStateException("FROM clause is mandatory");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(selectClause).append(" ")
                .append(fromClause).append(" ");

        for (String join : joinClauses) {
            sb.append(join).append(" ");
        }

        if (whereClause != null) {
            sb.append(whereClause).append(" ");
        }

        if (groupByClause != null) {
            sb.append(groupByClause).append(" ");
        }

        if (orderByClause != null) {
            sb.append(orderByClause);
        }

        Query query = new Query();
        query.setQuery(sb.toString().trim());
        return query;
    }
}

