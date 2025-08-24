package designpatterns.RijavLLDJul25.com.designpatterns.creational.builder;

public class Main {
    public static void main (String[] args) {
        SqlQueryBuilder builder = new SqlQueryBuilder();
        String query = builder
                .select("id, name")
                .from("users")
                .join("orders", "users.id = orders.user_id")
                .where("orders.amount > 1000")
                .build();
        System.out.println("Query = " + query);
    }
}
