/**
 * Requirements:
 * 1. Create a class to implement QueryBuilder following Builder design pattern
 * 2. The class should support select, from, where, order by and group by clause (done)
 * 3. The class should return the final query in string format on calling build method
 * 4. The returned query should be syntactically correct
 * 5. The select and from clause should be mandatory, rest can be optional
 * 6. You can skip aggregate functions and joins for the purpose of homework.
 */

public class BuilderPattern {

  public static void main(String[] args) {
    System.out.println("Query Builder started");
    String query = new QueryBuilder()
        .select("name, email")
        .from("sample_table")
        .build();
    System.out.println("Query1: " + query);

    String query2 = new QueryBuilder()
        .select("name, email")
        .from("sample_table")
        .where("name='prudhvi'")
        .orderBy("name desc")
        .build();
    System.out.println("Query2: " + query2);

    String query3 = new QueryBuilder()
        .from("sample_table")
        .where("name='prudhvi'")
        .orderBy("name desc")
        .build();
    System.out.println("Query2: " + query3);
  }
}

class Query {
  private String select;
  private String from;
  private String where;
  private String orderBy;
  private String groupBy;

  public String getSelect() {
    return select;
  }

  public void setSelect(String select) {
    this.select = select;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getWhere() {
    return where;
  }

  public void setWhere(String where) {
    this.where = where;
  }

  public String getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  public String getGroupBy() {
    return groupBy;
  }

  public void setGroupBy(String groupBy) {
    this.groupBy = groupBy;
  }
}

class QueryBuilder {
  private Query query;

  QueryBuilder() {
    this.query = new Query();
  }

  public QueryBuilder select(String select) {
    this.query.setSelect(select);
    return this;
  }

  public QueryBuilder from(String from) {
    this.query.setFrom(from);
    return this;
  }

  public QueryBuilder where(String where) {
    this.query.setWhere(where);
    return this;
  }

  public QueryBuilder orderBy(String orderBy) {
    this.query.setOrderBy(orderBy);
    return this;
  }

  public QueryBuilder groupBy(String groupBy) {
    this.query.setGroupBy(groupBy);
    return this;
  }

  public String build() {
    if (this.query.getSelect() == null) {
      throw new RuntimeException("SELECT is mandatory!");
    }
    if (this.query.getFrom() == null) {
      throw new RuntimeException("FROM is mandatory!");
    }

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT ").append(this.query.getSelect())
        .append(" FROM ").append(this.query.getFrom());

    if (this.query.getWhere() != null) {
      stringBuilder.append(" WHERE ").append(this.query.getWhere());
    }
    if (this.query.getGroupBy() != null) {
      stringBuilder.append(" GROUP BY ").append(this.query.getGroupBy());
    }
    if (this.query.getOrderBy() != null) {
      stringBuilder.append(" ORDER BY ").append(this.query.getOrderBy());
    }

    return stringBuilder.toString();
  }

}