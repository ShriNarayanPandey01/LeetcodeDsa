# Write your MySQL query statement below
select e1.unique_id , e.name from Employees as e left join EmployeeUNI as e1 on e1.id=e.id
