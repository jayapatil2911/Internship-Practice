use CompanyDB

---Apply View on the data
CREATE VIEW Emp_DeptView AS
SELECT
    E.EmployeeID,
    E.EmployeeName,
    E.Salary,
    D.DepartmentName
FROM Employee E
INNER JOIN Department D
ON E.DepartmentID = D.DepartmentID;

select * from Emp_DeptView

select * from Employee

CREATE VIEW HighSalaryEmpview AS
SELECT EmployeeID,
       EmployeeName, 
        Salary
FROM Employee
WHERE Salary > 50000;

select * from HighSalaryEmpview
















