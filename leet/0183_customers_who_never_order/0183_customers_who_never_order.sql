# LeetCode 183. Customers Who Never Order
# https://leetcode.com/problems/customers-who-never-order/
SELECT name 'Customers'
FROM Customers c
LEFT JOIN Orders o
ON c.id = o.customerId
WHERE customerId is NULL;

#
SELECT name 'Customers'
FROM Customers
LEFT JOIN Orders
ON Customers.id = Orders.customerId
WHERE customerId is NULL;

#
SELECT name 'Customers'
FROM Customers
WHERE Customers.id
NOT IN (SELECT customerId from Orders);
