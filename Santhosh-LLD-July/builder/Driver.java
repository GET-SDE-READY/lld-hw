public class Driver {
	public static void main(String[] args) {
		Query query1= new QueryBuilder()
				.setSelect("Select * from x")
				.setWhere(" where x=100 ")
				.setOrderBy(" name asc ")
				.setGroupBy(" group by name ")
				.build();
		System.out.println(query1);
	}
}


class Query {
	String select;
	String where;
	String groupBy;
	String orderBy;
	public Query(String select, String where, String orderBy, String groupBy) {
		// TODO Auto-generated constructor stub
		this.select= select;
		this.where = where;
		this.orderBy = orderBy;
		this.groupBy = groupBy;
	}
	@Override
	public String toString() {
		return "Query [select=" + select + ", where=" + where + ", groupBy=" + groupBy + ", orderBy=" + orderBy + "]";
	}
}

class QueryBuilder{

	String select;
	String where;
	String groupBy;
	String orderBy;
	QueryBuilder(){
		
	}
	
	public String getSelect() {
		return select;
	}

	public QueryBuilder setSelect(String select) {
		this.select = select;
		return this;
	}

	public String getWhere() {
		return where;
	}

	public QueryBuilder setWhere(String where) {
		this.where = where;
		return this;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public QueryBuilder setGroupBy(String groupBy) {
		this.groupBy = groupBy;
		return this;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public QueryBuilder setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}
	
	public Query build() {
		if(this.select == null) {
			throw new RuntimeException("Select query can't be null");
		}
		return new Query(this.select,this.where,this.orderBy,this.groupBy);
	}
	
	
}