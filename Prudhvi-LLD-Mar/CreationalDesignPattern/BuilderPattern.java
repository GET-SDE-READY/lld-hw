import java.util.Objects;

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
    String query1 = new QueryBuilder()
        .select("name, email")
        .from("sample_table")
        .where("     ")
        .build();
    System.out.println("Query1: " + query1);
    /*
       Query1 output: SELECT name, email FROM sample_table;
    */

    String query2 = new QueryBuilder()
        .select("name, email")
        .from("sample_table")
        .where("name='prudhvi'")
        .orderBy("name desc")
        .build();
    System.out.println("Query2: " + query2);

    /*
     Query2 output: SELECT name, email FROM sample_table WHERE name='prudhvi' ORDER BY name desc;
     */

    String query3 = new QueryBuilder()
        .select("name, sum(amount)")
        .from("salary")
        .where("amount > 100")
        .groupBy("name")
        .orderBy("name desc")
        .build();
    System.out.println("Query3: " + query3);
    /*
    Query3 output: SELECT name, sum(amount) FROM sample_table WHERE amount > 100 GROUP BY name ORDER BY name desc;
     */

    String selectWithBlank = new QueryBuilder()
        .select("  ")
        .from("salary")
        .where("amount > 100")
        .groupBy("name")
        .orderBy("name desc")
        .build();
    System.out.println("Query4: " + selectWithBlank);
    /*
    Query4 output: SELECT is mandatory! and it can't be blank or null!
     */

    String selectNotPassed = new QueryBuilder()
        .from("salary")
        .where("amount > 100")
        .groupBy("name")
        .orderBy("name desc")
        .build();
    System.out.println("Query5: " + selectNotPassed);
  /*
   Query5 output: SELECT is mandatory! and it can't be blank or null!
   */
    String fromIsBlank = new QueryBuilder()
        .select("name")
        .from("")
        .where("amount > 100")
        .groupBy("name")
        .orderBy("name desc")
        .build();
    System.out.println("Query6: " + fromIsBlank);
  }
  /*
   Query6 output: FROM is mandatory! and it can't be blank or null!
   */
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
    if (Objects.isNull(this.query.getSelect()) || this.query.getSelect().isBlank()) {
      throw new RuntimeException("SELECT is mandatory! and it can't be blank or null!");
    }
    if (Objects.isNull(this.query.getFrom()) || this.query.getFrom().isBlank()) {
      throw new RuntimeException("FROM is mandatory! and it can't be blank or null!");
    }

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT ").append(this.query.getSelect())
        .append(" FROM ").append(this.query.getFrom());

    if (Objects.nonNull(this.query.getWhere()) && !this.query.getWhere().isBlank()) {
      stringBuilder.append(" WHERE ").append(this.query.getWhere());
    }
    if (Objects.nonNull(this.query.getGroupBy()) && !this.query.getGroupBy().isBlank()) {
      stringBuilder.append(" GROUP BY ").append(this.query.getGroupBy());
    }
    if (Objects.nonNull(this.query.getOrderBy()) && !this.query.getOrderBy().isBlank()) {
      stringBuilder.append(" ORDER BY ").append(this.query.getOrderBy());
    }
    stringBuilder.append(";");

    return stringBuilder.toString();
  }

}