CREATE TABLE customers (
    customer_id int PRIMARY KEY,
    name  varchar(100) NOT NULL,
    phone varchar(20),
    email varchar(45) NOT NULL UNIQUE,
    password varchar(200) NOT NULL,
    role varchar(45) NOT NULL,
    created_at date
);

CREATE TABLE accounts (
    account_number int PRIMARY KEY,
    customer_id int NOT NULL,
    account_type varchar(100) NOT NULL,
    agency_address varchar(200) NOT NULL,
    created_at date,

    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
CREATE INDEX idx_customer_id_accounts ON accounts(customer_id);

CREATE TABLE account_transactions (
    transaction_id varchar(200) PRIMARY KEY,
    account_number int NOT NULL,
    customer_id int NOT NULL,
    transaction_date date NOT NULL,
    transaction_description varchar(200) NOT NULL,
    transaction_type varchar(100) NOT NULL,
    transaction_amount decimal(15,2) NOT NULL,
    closing_balance decimal(15,2) NOT NULL,
    created_at date,

    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    CONSTRAINT fk_account_number FOREIGN KEY (account_number) REFERENCES accounts(account_number)
);
CREATE INDEX idx_customer_id_acct_trans ON account_transactions(customer_id);
CREATE INDEX idx_account_number_acct_trans ON account_transactions(account_number);

CREATE TABLE loans (
    loan_number int PRIMARY KEY,
	customer_id int NOT NULL,
	start_date date NOT NULL,
	loan_type varchar(100) NOT NULL,
	total_loan_amount decimal(15,2) NOT NULL,
	amount_paid decimal(15,2) NOT NULL,
	outstanding_amount decimal(15,2) NOT NULL,
	created_at date,

    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
CREATE INDEX idx_customer_id_loans ON loans(customer_id);

CREATE TABLE cards (
    card_id int PRIMARY KEY,
	card_number varchar(100) NOT NULL,
	customer_id int NOT NULL,
	card_type varchar(100) NOT NULL,
	total_limit decimal(15,2) NOT NULL,
	used_limit decimal(15,2) NOT NULL,
	available_limit decimal(15,2) NOT NULL,
	created_at date,

    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
CREATE INDEX idx_customer_id_cards ON cards(customer_id);

CREATE TABLE notices (
    notice_id int PRIMARY KEY,
	notice_summary varchar(200) NOT NULL,
	notice_details varchar(1000) NOT NULL,
	notice_begin_date date NOT NULL,
	notice_end_date date,
	update_date date,
	created_at date
);

CREATE TABLE contacts (
    contact_id varchar(50) PRIMARY KEY,
	contact_name varchar(100) NOT NULL,
	contact_email varchar(100) NOT NULL,
	subject varchar(500) NOT NULL,
	message varchar(2000) NOT NULL,
	created_at date
);

CREATE TABLE authorities (
    authority_id int PRIMARY KEY,
    customer_id int NOT NULL,
    role varchar(100) NOT NULL,

    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
CREATE INDEX idx_customer_id_authorities ON authorities(customer_id);


INSERT INTO customers (customer_id, name, phone, email, password, role, created_at)
VALUES (3, 'Israel', '41999999999', 'israel@email.com', '$2a$12$M4P/4sL2aERkEMiuRkW/leyBcHBwCvHLbp5dA5SfVfyby0ccb1TOq', 'admin', CURRENT_DATE);

INSERT INTO accounts (account_number, customer_id, account_type, agency_address, created_at)
VALUES (123456789, 3, 'Conta Poupança', 'Rua das Flores, 123, Cidade A, Estado X', CURRENT_DATE);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_date, transaction_description, transaction_type, transaction_amount, closing_balance, created_at)
VALUES ('123456789', 123456789, 3, '2024-04-01', 'Depósito Inicial', 'Depósito', 1000.00, 1000.00, CURRENT_DATE);
VALUES ('987654321', 123456789, 3, '2024-04-02', 'Compra Online', 'Débito', -50.00, 950.00, CURRENT_DATE);
VALUES ('456123789', 123456789, 3, '2024-04-03', 'Transferência Recebida', 'Crédito', 200.00, 1150.00, CURRENT_DATE);

INSERT INTO loans (loan_number, customer_id, start_date, loan_type, total_loan_amount, amount_paid, outstanding_amount, created_at)
VALUES (1003, 3, '2024-03-10', 'Empréstimo para Veículo', 10000.00, 2000.00, 8000.00, CURRENT_DATE);

INSERT INTO cards (card_id, card_number, customer_id, card_type, total_limit, used_limit, available_limit, created_at)
VALUES
(1, '1234 5678 9012 3456', 3, 'Platinum', 10000.00, 5000.00, 5000.00, CURRENT_DATE),
(2, '9876 5432 1098 7654', 3, 'Gold', 5000.00, 2000.00, 3000.00, CURRENT_DATE);

INSERT INTO notices (notice_id, notice_summary, notice_details, notice_begin_date, notice_end_date, update_date, created_at)
VALUES
(1, 'Aviso Importante', 'Este é um aviso importante para todos os clientes.', '2024-04-01', '2024-04-30', CURRENT_DATE, CURRENT_DATE),
(2, 'Mudança de Horário', 'A partir de amanhã, nosso horário de funcionamento será alterado.', '2024-04-05', NULL, CURRENT_DATE, CURRENT_DATE),
(3, 'Promoção Especial', 'Não perca nossa promoção especial de fim de semana!', '2024-04-10', '2024-04-12', CURRENT_DATE, CURRENT_DATE),
(4, 'Manutenção Programada', 'Haverá uma manutenção programada no sistema no próximo fim de semana.', '2024-04-15', '2024-04-16', CURRENT_DATE, CURRENT_DATE),
(5, 'Feriado Nacional', 'Informamos que estaremos fechados no feriado nacional.', '2024-04-21', NULL, CURRENT_DATE, CURRENT_DATE),
(6, 'Aviso de Segurança', 'Por favor, mantenha suas informações de login seguras.', '2024-04-25', '2024-05-01', CURRENT_DATE, CURRENT_DATE),
(7, 'Evento de Networking', 'Participe do nosso evento de networking no próximo sábado!', '2024-04-28', '2024-04-30', CURRENT_DATE, CURRENT_DATE),
(8, 'Atualização do Sistema', 'Estamos atualizando nosso sistema para melhorar o desempenho.', '2024-05-02', NULL, CURRENT_DATE, CURRENT_DATE),
(9, 'Reunião de Equipe', 'Lembrete: Reunião de equipe amanhã às 9h.', '2024-05-05', NULL, CURRENT_DATE, CURRENT_DATE),
(10, 'Encerramento de Conta', 'Por favor, note que sua conta será encerrada em breve.', '2024-05-10', NULL, CURRENT_DATE, CURRENT_DATE);

INSERT INTO authorities (authority_id, customer_id, role)
VALUES (1, 3, 'ROLE_ADMIN');

INSERT INTO authorities (authority_id, customer_id, role)
VALUES (2, 3, 'ROLE_USER');