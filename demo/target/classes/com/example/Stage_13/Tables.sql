-- Название базы данных watch_store
CREATE TABLE manufacturers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    country VARCHAR(255)
);

CREATE TABLE watches (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    price INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    manufacturer_id INTEGER REFERENCES manufacturers(id) ON DELETE CASCADE
);