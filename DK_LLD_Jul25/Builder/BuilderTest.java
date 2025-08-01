package designpatterns.DK_LLD_Jul25.Builder;

public class BuilderTest {

    public static void main(String[] args) {
        Query query = new QueryBuilder()
                .select("e.id, e.name, d.name as department")
                .from("employees e")
                .innerJoin("departments d", "e.dept_id = d.id")
                .where("e.age > 30")
                .orderBy("e.salary DESC")
                .build();
        System.out.println(query);
        // Output:
        // SELECT e.id, e.name, d.name as department FROM employees e INNER JOIN departments d ON e.dept_id = d.id WHERE e.age > 30 ORDER BY e.salary DESC
    }

}
