package Design_Patterns.Creational.BuilderDesignPattern.QueryBuilder;

public class Main {

	public static class Query {

		private String select;
		private String where;
		private String groupby;
		private String orderby;
		private String query;

		private Query() {
		}

		public static class QueryBuilder {
			private Query query;

			public QueryBuilder() {
				query = new Query();
			}

			public QueryBuilder select(String table, String[] cols) {
				if (table == null || table.isEmpty()) {
					throw new RuntimeException("Invalid Query");
				}
				if (cols.length == 0) {
					this.query.setSelect("Select " + "*" + " from " + table + " ");
				} else {
					for (String col : cols) {
						if (col.isEmpty()) {
							throw new RuntimeException("Invalid Query, Please provide correct cols");
						}
					}
					this.query.setSelect("Select " + String.join(",", cols) + " from " + table + " ");
				}

				return this;
			}

			public QueryBuilder where(String col, String value) {

				if (col == null || col.isEmpty()) {
					throw new RuntimeException("Invalid Query,provide col");
				}
				if (value == null || value.isEmpty()) {
					throw new RuntimeException("Invalid Query,provide value");
				}
				this.query.setWhere("where " + col + "=" + value + " ");
				return this;
			}

			public QueryBuilder groupby(String col) {
				if (col == null || col.isEmpty()) {
					throw new RuntimeException("Invalid Query,provide col");
				}
				this.query.setGroupby("group by " + col);
				return this;
			}

			public QueryBuilder orderby(String col) {
				if (col == null || col.isEmpty()) {
					throw new RuntimeException("Invalid Query,provide col");
				}
				this.query.setOrderby(" order by " + col);
				return this;
			}

			public Query build() {
				StringBuilder query = new StringBuilder();
				if (this.query.getSelect() == null || this.query.getSelect().isEmpty()) {
					throw new RuntimeException("Invalid Query");
				} else {
					query.append(this.query.getSelect());
				}

				if (this.query.getWhere() == null || this.query.getWhere().isEmpty()) {

				} else {
					query.append(this.query.getWhere());
				}

				if (this.query.getGroupby() == null && this.query.getGroupby().isEmpty()) {
					query.append("");
				} else {
					query.append(this.query.getGroupby());
				}

				if (this.query.getOrderby() == null && this.query.getOrderby().isEmpty()) {
					query.append("");
				} else {
					query.append(this.query.getOrderby());
				}
				this.query.setQuery(query.toString());
				return this.query;
			}

		}

		public void setSelect(String select) {
			this.select = select;
		}

		public void setWhere(String where) {
			this.where = where;
		}

		public void setGroupby(String groupby) {
			this.groupby = groupby;
		}

		public void setOrderby(String orderby) {
			this.orderby = orderby;
		}

		private String getSelect() {
			return select;
		}

		private String getWhere() {
			return where;
		}

		private String getGroupby() {
			return groupby;
		}

		private String getOrderby() {
			return orderby;
		}

		private String getQuery() {
			return query;
		}

		private void setQuery(String query) {
			this.query = query;
		}

	}

	public static void main(String[] args) {

		Query q = new Query.QueryBuilder().orderby("employeeId").select("Employees", new String[] { "employeeId" })
				.groupby("department").where("employeeId", "1").build();

//		Query query = new Query.QueryBuilder().select("Employees").build();

		System.out.println(q.getQuery());

	}

}
