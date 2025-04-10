public class Builder_Assignment {
    public static void main(String[] args) {
        Query q = new Query();
        q.Select("name");
        q.From("class");
        q.Where("marks>60");
        q.Order_by("marks");
        q.Group_by("Subjects");
       String newQuery= q.Build();
       System.out.println(newQuery);
    }
}
class QueryBuilder{
    String SELECT;
    String FROM;
    String WHERE;
    String ORDER_BY ;
    String GROUP_BY ;
}
class Query{
    public QueryBuilder qb;
    public  Query(){
        qb=new QueryBuilder();
    }

    public Query Select(String select){
        this.qb.SELECT=select;
        return this;
    }
    public Query From(String from){
        this.qb.FROM=from;
        return this;
    }
    public Query Where(String where){
        this.qb.WHERE=where;
        return this;
    }
    public Query Order_by(String order_by){
        this.qb.ORDER_BY=order_by;
        return this;
    }
    public Query Group_by(String group_by){
        this.qb.GROUP_BY=group_by;
        return this;
    }
    public  String Build(){
        if(qb.SELECT==null){
            throw  new RuntimeException("cannot find Select clause");
        }
        if(qb.FROM==null){
            throw  new RuntimeException("Cannot find From clause");
        }
        String Query="Select "+qb.SELECT+" From "+qb.FROM;
        if(qb.WHERE!=null)
            Query=Query+" Where "+qb.WHERE;
        if(qb.ORDER_BY!=null)
            Query= Query+" ORDER BY "+qb.ORDER_BY;
        if(qb.GROUP_BY!=null)
            Query= Query+" GROUP BY "+qb.GROUP_BY;
        return  Query;
    }

}
