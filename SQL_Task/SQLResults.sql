crete tables
Employee
Department

1 CREATE DATABASE CompanyDB;
2 USE CompanyDB;
3 CREATE TABLE Department (
DepartmentID INT PRIMARY KEY,
DepartmentName VARCHAR(50) NOT NULL
);
o/p==>
INSERT INTO Department VALUES
(1, 'HR'),
(2, 'IT'),
(3, 'Finance'),
(4, 'Sales');

o/p==>
DepartmentID	DepartmentName
1	        HR
2	        IT
3	        Finance
4	        Sales

CREATE TABLE Employee (
EmployeeID INT PRIMARY KEY,
EmployeeName VARCHAR(100) NOT NULL,
Salary DECIMAL(10,2),
HireDate DATE,
DepartmentID INT,
FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)
);

INSERT INTO Employee VALUES
(101, 'James', 50000, '2024-01-15', 1),
(102, 'Maria', 65000, '2023-08-10', 2),
(103, 'David', 70000, '2022-12-05', 2),
(104, 'John', 55000, '2024-03-20', 3),
(105, 'Michael', 80000, '2021-06-18', 4),
(106, 'James', 75000, '2023-11-01', 2),
(107, 'Emma', 60000, '2024-02-10', 1),
(108,'Anthony',58000,'2025-03-15'),
(109,'John',68000,'2025-06-20');

o/p==>
EmployeeID	EmployeeName	Salary	     HireDate	DepartmentID
102	           Maria	65000.00    2023-08-10	2
103	           David	70000.00    2022-12-05	2
105	          Michael	80000.00    2021-06-18	4
106	          James 	75000.00    2023-11-01	2
107	          Emma	        60000.00    2024-02-10	1
108	         Anthony	58000.00    2025-03-15	3
111	          James1	50000.00    2024-01-15	1
211	          James3	65000.00    2024-01-15	1
301	          jemmy	        60000.00    2026-01-01	3
401	          John	        50000.00    2024-03-15	2
502	          lara	        50000.00    2024-04-15	1
503	          gimmy	        50000.00    2024-04-17	1





1.TOP 5  highest SALARY

SELECT * FROM (

SELECT *, DENSE_RANK() OVER (ORDER BY SALARY DESC) AS NUMBER FROM Employee) T1
WHERE T1.NUMBER<=5

o/p==>
EmployeeID	EmployeeName	Salary	 HireDate	DepartmentID	NUMBER
105	        Michael	     80000.00	2021-06-18	4	        1
106	        James	      75000.00	2023-11-01	2	        2
103	        David	      70000.00	2022-12-05	2	        3
102	        Maria	      65000.00	2023-08-10	2	        4
211	       James3	      65000.00	2024-01-15	1	        4
301	       jemmy	      60000.00	2026-01-01	3	        5
107	       Emma	      60000.00	2024-02-10	1	        5

2. Department wise employees

SELECT d.DepartmentName,
       COUNT(e.EmployeeID) AS EmployeeCount
FROM Department d
INNER JOIN Employee e
ON d.DepartmentID = e.DepartmentID
GROUP BY d.DepartmentName;

o/p==>
DepartmentName	EmployeeCount
Finance  	2
HR	        5
IT	        4
Sales	        1

3.2nd highest salary

 SELECT * FROM (

SELECT *, DENSE_RANK() OVER (ORDER BY SALARY DESC) AS NUMBER FROM Employee) T1
WHERE T1.NUMBER=2

EmployeeID	EmployeeName	Salary	   HireDate	DepartmentID	NUMBER
106	         James  	75000.00  2023-11-01	2	          2


4.employee whose salary> department average salary

select emp.* from Employee emp
inner join (
SELECT DepartmentID, AVG(Salary) AS Average_Salary
FROM Employee
GROUP BY DepartmentID) deptAvg
on deptavg.DepartmentID = emp.DepartmentID
where emp.Salary > deptAvg.Average_Salary

o/p==>
EmployeeID	EmployeeName	Salary	  HireDate	DepartmentID
107	            Emma	60000.00  2024-02-10	1
211	          James3	65000.00  2024-01-15	1
106	           James	75000.00  2023-11-01	2
103	           David	70000.00  2022-12-05	2
301	           jemmy	60000.00  2026-01-01	3

5.inner join

SELECT e.EmployeeID,
       e.EmployeeName,
       d.DepartmentName
FROM Employee e
INNER JOIN Department d
ON e.DepartmentID = d.DepartmentID;

o/p==>

EmployeeID	EmployeeName	DepartmentName
102	           Maria	IT
103	             David	IT
105	          Michael	Sales
106	            James	IT
107	            Emma	HR
108	         Anthony	Finance
111	          James1	HR
211	            James3	HR
301	           jemmy	Finance
401	            John	IT
502	            lara	HR
503	           gimmy	HR

6 left join

SELECT e.EmployeeID,
       e.EmployeeName,
       d.DepartmentName
FROM Employee e
LEFT JOIN Department d
ON e.DepartmentID = d.DepartmentID;
o/p==>
EmployeeID	EmployeeName	DepartmentName
101	           James	HR
102	           Maria	IT
103	           David	IT
104	            John	Finance
105	         Michael	Sales
106	            James	IT
107	             Emma	HR
108	          Anthony	Finance
109	             John	IT
111	           James1	HR
211	           James3	HR

7.group by having

SELECT DepartmentID,
       COUNT(*) AS EmployeeCount
FROM Employee
GROUP BY DepartmentID
HAVING COUNT(*) > 2;
op==>
DepartmentID	EmployeeCount
1	         5
2	         4

8.Employees hired in last 6 months
SELECT *
FROM Employee
WHERE HireDate >= DATEADD(MONTH, -6, GETDATE());
o/p==>
EmployeeID	EmployeeName	Salary	HireDate	DepartmentID
301	              jemmy	60000	2026-01-01	3


9.Find the Duplicates records

SELECT EmployeeName,
       COUNT(*) AS CountOfRecords
FROM Employee
GROUP BY EmployeeName
HAVING COUNT(*) > 1;
op==>
EmployeeName	CountOfRecords
James	          2
John	          2


10. How to remove the duplicates record

with cte  as (
select EmployeeName,ROW_NUMBER() over(partition by EmployeeName 
order by EmployeeName) as number from Employee) 
select * from cte where number >1 =====> duplicate record

EmployeeName	number
John	         2
John	         3

delete==>
with cte  as (
select EmployeeName,ROW_NUMBER() over(partition by EmployeeName 
order by EmployeeName) as number from Employee) 
delete  from cte where number >1

o/p==>
(2 rows affected)


