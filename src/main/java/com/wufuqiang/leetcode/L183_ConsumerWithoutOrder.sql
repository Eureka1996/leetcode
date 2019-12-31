select Name Customers
from Customers c
left join Orders o on c.Id = o.CustomerId
where o.Id is null
;