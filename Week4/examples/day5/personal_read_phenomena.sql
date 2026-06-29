SET SEARCH_PATH TO test2;

DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
	account_id INT PRIMARY KEY,
	customer_name VARCHAR(50),
	balance DECIMAL (10, 2)
)

INSERT INTO accounts VALUES
(1, 'Alice', 1000),
(2, 'Bob', 500),
(3, 'Charlie', 800);

SELECT * FROM accounts;

-- Dirty read SQL: A transaction reads data that another transaction has modified but not comitted
-- postgresql has the lowest isolation level as READ COMITTED will not allow dirty reads
-- but if has READ UNCOMITTED isolation level this is possible

-- Non repeatable READ: You readxd the same row twice in one transactiuon and get different values because
-- another transcation comitted the changes
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;


-- read comitted -> read repeatable -> read serializable - in order of isolation low - hi




