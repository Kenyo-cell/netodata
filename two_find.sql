SELECT * FROM orders LEFT JOIN customers c on c.id = orders.customer_id
where lower("name") = 'alexey';