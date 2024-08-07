SELECT 
    customer_id, 
    COUNT(*) AS total_orders, 
    SUM(total_amount) AS total_spent
FROM 
    orders
WHERE 
    order_date BETWEEN '2024-01-01' AND '2024-12-31'
GROUP BY 
    customer_id
HAVING 
    total_orders > 5
ORDER BY 
    total_spent DESC
LIMIT 10;
