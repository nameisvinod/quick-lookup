-- Given 2 tables cards with schema 

-- Create table Cards ( id int, card_number varchar(256)); 

-- Create table transactions (card_id int, transactions varchar(256)); 
-- Transaction contains amount data in either usd or EUR in representated as '10.23USD' or '17.75EUR'.
-- Your goal is to return a selection which has the following columns card_number, usd_total, eur_total I.e total spend on each card in each currency against each card number. 
-- Order the rows in ascending order of card numbers.




WITH Transactions_Formatted AS (
  SELECT 
    card_id,
    CASE WHEN transactions LIKE '%USD' THEN CAST(SUBSTRING(transactions, 1, LOCATE('USD', transactions) - 1) AS DECIMAL(10,2)) ELSE 0 END AS usd_amount,
    CASE WHEN transactions LIKE '%EUR' THEN CAST(SUBSTRING(transactions, 1, LOCATE('EUR', transactions) - 1) AS DECIMAL(10,2)) ELSE 0 END AS eur_amount
  FROM transactions
)
SELECT 
  c.card_number,
  SUM(tf.usd_amount) AS usd_total,
  SUM(tf.eur_amount) AS eur_total
FROM cards c
INNER JOIN Transactions_Formatted tf ON c.id = tf.card_id
GROUP BY c.card_number
ORDER BY c.card_number ASC;
