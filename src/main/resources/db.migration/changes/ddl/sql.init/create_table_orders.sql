-- Создание таблицы
CREATE TABLE orders (
                        order_id SERIAL PRIMARY KEY,
                        user_id BIGINT NOT NULL,
                        status VARCHAR(255) NOT NULL
);