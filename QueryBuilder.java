package designpatterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class QueryBuilder {

	
	public static void main(String[] args) {
		String query = new QueryBuilderUtil().select("select").column(new String[] {"age","name"}).from("Employee").where("age",30).where("name", "XYZ").build();
		System.out.println(query);
	}


}



//select * from table_name
class Query {
	String select;
	String[] column;
	String from;
	LinkedHashMap<String,Object> where = new LinkedHashMap<>();
	
	public void setSelect(String select) {
		this.select = select;
	}
	
	public void setColumn(String[] column) {
		this.column = Arrays.copyOf(column, column.length);
	}
	
	
	public void setTable(String from) {
		this.from = from;
	}
	
	
	public void setTWhere(String key,Object value) {
		
		this.where.put(key, value);
	}
	
	public String getSelect() {
		return this.select;
	}
	public String[] getColumn() {
		return this.column;
	}
	
	public String getFrom() {
		return this.from;
	}
	
	public LinkedHashMap<String,Object> getWhere() {
		return this.where;
	}
}


class QueryBuilderUtil {
	private Query query;
	
	public QueryBuilderUtil() {
		this.query = new Query();
	}
	public QueryBuilderUtil select(String select) {
		this.query.select = select;
		return this;
	}
	
	public QueryBuilderUtil column(String[] columns) {
		this.query.column = Arrays.copyOf(columns, columns.length);
		return this;
	}
	public QueryBuilderUtil from(String from) {
		this.query.from = from;
		return this;
	}
	public QueryBuilderUtil where(String key,Object value) {
		this.query.where.put(key, value);
		return this;
	}
	
	public String build() {
		StringBuilder sb = new StringBuilder();
		if(this.query.getSelect()!= null && !this.query.getSelect().isEmpty() && this.query.getSelect().equalsIgnoreCase("SELECT")) {
			sb.append(this.query.getSelect()+" ");
		}else {
			throw new RuntimeException("Query should contain select statement");
		}
		if(this.query.getColumn() != null && this.query.getColumn().length >=1 ) {
			int len = this.query.getColumn().length;
			if(len == 1 && this.query.getColumn()[0].equals("*")) {
				sb.append(this.query.getColumn()[0]+" ");
			}else {
				
				  sb.append(String.join(",", this.query.getColumn())).append(" ");
				
			}
			
		}
		if(this.query.getFrom() != null && !this.query.getFrom().isEmpty()) {
			sb.append("from"+" "+this.query.getFrom()+" ");
		}
		if(!this.query.where.isEmpty()) {
			sb.append("where"+" ");
			int count = 0;
			for(Map.Entry<String,Object> entry :this.query.where.entrySet()) {
				if(count > 0) {
					sb.append("AND"+" ");
				}
				sb.append(entry.getKey()).append("=");
				if(entry.getValue() instanceof String) {
					sb.append("'").append(entry.getValue()).append("'");
				}else {
					sb.append(entry.getValue()).append(" ");
				}
				count++;
			}
		}
			
		return sb.toString();
	}
}
