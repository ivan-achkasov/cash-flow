CREATE TABLE currency
(
    code VARCHAR(3) PRIMARY KEY
);

CREATE TABLE account
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    name          VARCHAR(255)   NOT NULL UNIQUE,
    currency_code VARCHAR(3)     NOT NULL,
    amount        DECIMAL(20, 2) NOT NULL,
    CONSTRAINT account_to_currency_code_by_code_fk FOREIGN KEY (currency_code) REFERENCES currency (code)
);

CREATE TABLE interval_tax
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    from_date DATE,
    to_date   DATE,
    rate      DECIMAL(20, 2) NOT NULL,
    name      VARCHAR(255)   NOT NULL UNIQUE
);

CREATE TABLE tax
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    rate DECIMAL(20, 2) NOT NULL,
    name VARCHAR(255)   NOT NULL UNIQUE
);

CREATE TABLE income_category
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(255) NOT NULL UNIQUE,
    passive BOOLEAN      NOT NULL
);

CREATE TABLE income_history
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount        DECIMAL(20, 2) NOT NULL,
    category_id   BIGINT         NOT NULL,
    exchange_rate DECIMAL(20, 4) NOT NULL,
    account_id    BIGINT         NOT NULL,
    income_date   DATE           NOT NULL,
    tax_id        BIGINT,
    description   VARCHAR(500),
    CONSTRAINT income_history_to_income_category_by_id_fk FOREIGN KEY (category_id) REFERENCES income_category (id),
    CONSTRAINT income_history_to_account_by_id_fk FOREIGN KEY (account_id) REFERENCES account (id),
    CONSTRAINT income_history_to_tax_by_id_fk FOREIGN KEY (tax_id) REFERENCES tax (id)
);

CREATE TABLE expense_category
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE expenses_history
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount             DECIMAL(20, 2) NOT NULL,
    category_id        BIGINT         NOT NULL,
    description        VARCHAR(500),
    account_id         BIGINT         NOT NULL,
    expense_date       DATE           NOT NULL,
    creation_timestamp TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT expenses_history_to_expense_category_by_id_fk FOREIGN KEY (category_id) REFERENCES expense_category (id),
    CONSTRAINT expenses_history_to_account_by_id_fk FOREIGN KEY (account_id) REFERENCES account (id)
);

CREATE TABLE money_transfer_history
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT,
    from_account_id    BIGINT         NOT NULL,
    to_account_id      BIGINT         NOT NULL,
    send_amount        DECIMAL(20, 2) NOT NULL,
    received_amount    DECIMAL(20, 2) NOT NULL,
    exchange_rate      DECIMAL(20, 2) NOT NULL,
    transfer_date      DATE           NOT NULL,
    from_commission    DECIMAL(5, 2),
    to_commission      DECIMAL(5, 2),
    creation_timestamp TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT money_transfer_to_from_account_by_id_fk FOREIGN KEY (from_account_id) REFERENCES account (id),
    CONSTRAINT money_transfer_to_to_account_by_id_fk FOREIGN KEY (to_account_id) REFERENCES account (id)
)

