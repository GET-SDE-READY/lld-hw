import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryBuilderTest {

    @Test
    void testQueryMandatoryParams() {
        QueryBuilder queryBuilder = QueryBuilder.create("name, age", "person");
        assertEquals("select name, age from person", queryBuilder.build());
    }

    @Test
    void testQueryMandatoryParamsEmpty() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> QueryBuilder.create("", ""));
        assertEquals("select or from can't be null", exception.getMessage());
    }

    @Test
    void testQueryOptionalParams() {
        QueryBuilder queryBuilder = QueryBuilder.create("name, age", "person")
                .orderBy("id")
                .groupBy("city");
        assertEquals("select name, age from person group by city order by id", queryBuilder.build());

    }

    @Test
    void testWithWhereClause() {
        QueryBuilder query = QueryBuilder.create("*", "employee")
                .where("salary > 50000");

        assertEquals("select * from employee where salary > 50000", query.build());
    }

    @Test
    void testWithOverridingParams() {
        QueryBuilder query = QueryBuilder.create("*", "employee")
                .select("name")
                .from("employee")
                .where("salary > 50000");
        assertEquals("select name from employee where salary > 50000", query.build());
    }


}