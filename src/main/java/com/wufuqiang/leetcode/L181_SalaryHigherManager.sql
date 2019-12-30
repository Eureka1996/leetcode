
select name Employee
from (
    select e1.name name,e1.salary esal,e2.salary msal
    from Employee e1
    join Employee e2 on e1.ManagerId = e2.id
)
where esal > msal;
