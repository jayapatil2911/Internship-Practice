use CompanyDB
----- Apply Triggers on the data
--create trigger
CREATE TRIGGER trg_InsertEmployee
ON Employee
AFTER INSERT
AS
BEGIN
    PRINT 'New Employee Added Successfully';
END;
-- insert value
INSERT INTO Employee
VALUES (110, 'Sophia', 72000, '2025-01-10', 1);
 
 select * from Employee

--update
 CREATE TRIGGER trg_EmployeeUpdate
ON Employee
AFTER UPDATE
AS
BEGIN
    PRINT 'Employee record updated';
END;
--check
SELECT name
FROM sys.triggers
WHERE name = 'trg_EmployeeUpdate';

UPDATE Employee
SET Salary = 55000
WHERE EmployeeID = 101;
--delete
DELETE FROM Employee
WHERE EmployeeID = 101;

CREATE TRIGGER trg_DeleteEmployee
ON Employee
AFTER DELETE
AS
BEGIN
    PRINT 'Employee Deleted';
END;
 --no  delete allow
CREATE TRIGGER trg_PreventDelete
ON Employee
INSTEAD OF DELETE
AS
BEGIN
    PRINT 'Delete Not Allowed';
END;

DELETE FROM Employee
WHERE EmployeeID = 102;