##Product
from abs import ABC, abstractmethod

class Query(ABC):

    @abstractmethod

    def __init__(self):
        self.select = None
        self._from = None
        self.where = None
        self.groupby = None


# ##Builder Interface
# class QueryBuilder:
    
##Concreate Builder
class ConcreteQueryBuilder:
    
    def __init__(self):
        self.query = Query()

    def set_select(self, select: str):
        self.query.select = select
    
    def set_from(self, _from: str):
        self.query._from = _from
        
    def set_where(self, where: str):
        self.query.where = where
    
    def set_groupby(self, groupby: str):
        self.query.groupby = groupby
    

##Director
class QueryDirector:
    def __init__(self, builder: ConcreteQueryBuilder):
        self.builder = builder
        self.query_string = ""

    def build_query(self, select: str, _from: str, where: str, groupby: str):
        self.builder.set_select(select)
        self.builder.set_from(_from)
        self.builder.set_where(where)
        self.builder.set_groupby(groupby)

    def build(self):
        if self.builder.query.select is None:
            raise ValueError("Select statement is required")
        else:
            self.query_string += f"SELECT {self.builder.query.select} "

        if self.builder.query._from is None:
            raise ValueError("From statement is required") 
        else:
            self.query_string += f"FROM {self.builder.query._from} "

        if self.builder.query.where is not None:
            self.query_string += f"WHERE {self.builder.query.where} "    

        if self.builder.query.groupby is not None:
            self.query_string += f"GROUP BY {self.builder.query.groupby} "

        return self.query_string.strip()
# ##Client
if __name__ == "__main__":
    builder = ConcreteQueryBuilder()
    director = QueryDirector(builder)
    
    # Build the query
    query = director.build_query("*", "users", "age > 30", "country")

    print(query)







