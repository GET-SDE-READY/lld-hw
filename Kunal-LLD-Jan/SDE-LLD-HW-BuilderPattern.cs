using System;

public class Test
{
	public static void Main()
	{
		
		SQLQueryBuilder sqb = new SQLQueryBuilder();
		//string sqlQuery = sqb.SelectPartOfQuery("id, name, amount, category ").FromPartOfQuery("ProductTable").WherePartOfQuery("category = 'Electronics'").OrderByPartOfQuery("amount").BuildQuery();
		
		//Testing query builder without FROM clause
		string sqlQuery = sqb.SelectPartOfQuery("id, name, amount, category ").WherePartOfQuery("category = 'Electronics'").OrderByPartOfQuery("amount").BuildQuery();
		
		Console.WriteLine(sqlQuery);
		
	}
}

class ProductTableColumns
{
    public string TabpleName = "ProductTable";
    public string IdColumn = "ProductId";
    public string NameColumn = "Name";
    public string AmountColumn = "ProductAmount";
}


class SQLQueryBuilder
{
    private string selectQueryVariables;
    private string fromQueryVariables;
    private string whereQueryVariables;
    private string orderByQueryVariables;
    
    //for SELECT clause
    public SQLQueryBuilder SelectPartOfQuery(string selectData)
    {
        this.selectQueryVariables = selectData;
        return this;
    }
    
    //for FROM clause
    public SQLQueryBuilder FromPartOfQuery(string fromData)
    {
        this.fromQueryVariables = fromData;
        return this;
    }
    
    //for WHERE clause
    public SQLQueryBuilder WherePartOfQuery(string whereData)
    {
        this.whereQueryVariables = whereData;
        return this;
    }
    
    //for ORDERBY clause
    public SQLQueryBuilder OrderByPartOfQuery(string orderByData)
    {
        this.orderByQueryVariables = orderByData;
        return this;
    }
    
    public string BuildQuery()
    {
        if(this.selectQueryVariables == null)
        {
            throw new Exception("Cannot create query without SELECT clause");
        }
        
        if(this.fromQueryVariables == null)
        {
            throw new Exception("Cannot create query without FROM clause");
        }
        
        return "SELECT "+ this.selectQueryVariables + " FROM " + this.fromQueryVariables +" WHERE " + this.whereQueryVariables + " ORDER BY "+ this.orderByQueryVariables;
    }
}
