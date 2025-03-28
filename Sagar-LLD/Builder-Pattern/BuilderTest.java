public class BuilderTest {
    public static void main(String[] args) {
        String selectStatement = QueryBuilder.builder().select("department, SUM(salary) AS total_salary")
                .from("employees")
                .where("hire-date > '2020-01-01'")
                .groupBy("department")
                .having("SUM(salary) > 100000")
                .orderBy("total_salary DESC")
                .build();
        System.out.println(selectStatement);
    }
}
