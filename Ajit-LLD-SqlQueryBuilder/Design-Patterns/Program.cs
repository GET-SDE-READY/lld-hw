

using System.Text;

public class MyClass
{
    static void Main(string[] args)
    {
     

        QueryBuilder queryBuilder = new QueryBuilder();        

        var query = queryBuilder.SetFrom("Employee").SetWhere("name","Ashish").SetWhere("age","30")
            .SetOrderBy("name").SetgroupBy("name").Builder();

        Console.WriteLine(query.GetSQLQuery());


    }
}

//SQL QueryBuilder

public class Where
{
    public string Key { get; set; }

    public string Value { get; set; }
}
public class SQLQuery
{
    public string Select { get; set; }
    public string From { get; set; }

    public List<Where> Where { get; set; }
    public string GroupBy { get; set; }

    public string OrderBy { get; set; }

    public string GetSQLQuery()
    {
        string query;
        string whereClause = Where.Count > 0
    ? "WHERE " + string.Join(" AND ", Where.Select(x => $"{x.Key} = '{x.Value}'"))
    : "";

        string groupby = !string.IsNullOrWhiteSpace(GroupBy) ? "Group BY " + GroupBy : "";
        string orderby= !string.IsNullOrWhiteSpace(OrderBy) ? "Order BY " + OrderBy : "";
        query = "Select " + Select.TrimEnd(',') + " " + "From " + From + " " + whereClause + " " + groupby + " " + orderby;
        return query;
    }
}

public class QueryBuilder
{
    SQLQuery query = new SQLQuery();

    StringBuilder select=new StringBuilder();
    List<Where> where =new();

    StringBuilder groupBy=new StringBuilder();
    StringBuilder orderBy=new StringBuilder();

    public QueryBuilder SetSelect(string columns)
    {
        
         select.Append(columns + ",");
        query.Select = select.ToString();
        return this;
    }

    public QueryBuilder SetFrom(string from)
    {
        
        query.From = from.ToString();
        return this;
    }
    public QueryBuilder SetWhere(string key,string value)
    {
        this.where.Add(new Where { Key = key, Value = value });
        query.Where = where;
        return this;
    }

    public QueryBuilder SetgroupBy(string groupbys)
    {
        this.groupBy.Append(groupbys);
        query.GroupBy = this.groupBy.ToString(); ;
        return this;
    }

    public QueryBuilder SetOrderBy(string orderbys)
    {
        this.orderBy.Append(orderbys);
        query.OrderBy = orderBy.ToString() ;
        return this;
    }

    public SQLQuery Builder()
    {
        if(string.IsNullOrWhiteSpace(query.Select))
        {
            query.Select = "*";
        }
        if (string.IsNullOrWhiteSpace(query.From))
        {
            throw new Exception("From is required");
        }
        return query;
    }
}
public class Computer
{
    public string Processer { get; set; }

    public string Storage { get; set; }

    public bool GraphicsCard { get; set; }

    public void ShowDetails()
    {
        Console.WriteLine($"Processer: {Processer}, Storage: {Storage}, GraphicsCard: {GraphicsCard}");
    }
}
public class ComputerBuilder
{
    private Computer _computer =new Computer();

    public ComputerBuilder SetProcessor(string processor)
    {
        _computer.Processer = processor;
        return this;
    }
    public ComputerBuilder SetStorage(string storage)
    {
        _computer.Storage = storage;
        return this;
    }
    public ComputerBuilder SetGraphicsCard(bool isgrahicsCard)
    {
        _computer.GraphicsCard = isgrahicsCard;
        return this;
    }
    public Computer Builder()
    {
        return _computer;
    }
}


