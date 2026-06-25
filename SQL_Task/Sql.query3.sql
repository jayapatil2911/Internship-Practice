USE CompanyDB
--1.ROW_NUMBER()--
SELECT EmployeeName, Salary,
       ROW_NUMBER() OVER(ORDER BY Salary DESC) AS RowNum
FROM Employee;
select * from Employee

---2.RANK()--
SELECT EmployeeName, Salary,
       RANK() OVER(ORDER BY Salary DESC) AS RankNo
FROM Employee;

---3.DENSE_RANK()
SELECT EmployeeName, Salary,
       DENSE_RANK() OVER(ORDER BY Salary DESC) AS DenseRankNo
FROM Employee;

--4. LEAD()
SELECT EmployeeName, Salary,
       LEAD(Salary) OVER(ORDER BY Salary) AS NextSalary
FROM Employee;

--5.LAG()--
SELECT EmployeeName, Salary,
       LAG(Salary) OVER(ORDER BY Salary) AS PreviousSalary
FROM Employee;

--6.SUM() OVER()
SELECT EmployeeName, Salary,
       SUM(Salary) OVER(ORDER BY EmployeeID) AS RunningTotal
FROM Employee;

-- AVG() OVER()--
SELECT EmployeeName, Salary,
       AVG(Salary) OVER() AS AvgSalary
FROM Employee;

---7 NTILE()
SELECT
    EmployeeID,
    EmployeeName,
    Salary,
    NTILE(3) OVER (ORDER BY Salary DESC) AS SalaryGroup
FROM Employee;


---8 FIRST VALUE-
SELECT
    EmployeeName,
    Salary,
    FIRST_VALUE(Salary) OVER (ORDER BY Salary DESC) AS HighestSalary
FROM Employee;

--9LAST_VALUE()
SELECT EmployeeName,
       Salary,
       LAST_VALUE(Salary) OVER (
           ORDER BY Salary
           ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
       ) AS LastSalary
FROM Employee;
