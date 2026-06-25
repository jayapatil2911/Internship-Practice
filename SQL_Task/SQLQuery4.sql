use CompanyDB

---- Handle Case When in the data

SELECT
    EmployeeID,
    EmployeeName,
    Salary,
    CASE
        WHEN Salary >= 70000 THEN 'High Salary'
        WHEN Salary >= 60000 THEN 'Medium Salary'
        ELSE 'Low Salary'
    END AS SalaryCategory
FROM Employee;