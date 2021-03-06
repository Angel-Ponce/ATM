CREATE DATABASE ATM;
GO
USE ATM;
GO
CREATE TABLE "admin"(
	id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	"name" VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	age INT NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	pin INT NOT NULL,
	last_access SMALLDATETIME NOT NULL,
	pick VARCHAR(200) NOT NULL
);

CREATE TABLE "user"(
	card_number BIGINT NOT NULL PRIMARY KEY,
	"name" VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	age INT NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	pin INT NOT NULL,
	last_access SMALLDATETIME NOT NULL,
	pick VARCHAR(200) NOT NULL,
	current_balance INT NOT NULL,
	maximum_amount INT NOT NULL,
	count_pin_changed INT NOT NULL DEFAULT 0
);

CREATE TABLE "transaction"(
	id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	"type" VARCHAR(50) NOT NULL,
	amount INT NOT NULL,
	"date" SMALLDATETIME NOT NULL,
	card_number BIGINT NOT NULL,
	FOREIGN KEY (card_number) REFERENCES "user"(card_number) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE ticket(
	id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	"type" INT NOT NULL,
	size INT NOT NULL
);

CREATE TABLE properties(
	id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	theme VARCHAR(100) NOT NULL,
	current_balance INT NOT NULL,
	last_card_number BIGINT NOT NULL,
	"date" VARCHAR(50) NOT NULL,
	FOREIGN KEY (last_card_number) REFERENCES "user"(card_number) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE token(
	id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	token VARCHAR(50) NOT NULL
);

CREATE TABLE admin_register_user(
	id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	email_admin VARCHAR(100) NOT NULL,
	card_number BIGINT NOT NULL,
	"date" SMALLDATETIME NOT NULL, 
	FOREIGN KEY (card_number) REFERENCES "user"(card_number) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (email_admin) REFERENCES "admin"(email) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE admin_init_atm(
	id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	email_admin VARCHAR(100) NOT NULL,
	balance INT NOT NULL,
	"date" SMALLDATETIME NOT NULL,
	FOREIGN KEY (email_admin) REFERENCES "admin"(email) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE admin_add_cash(
	id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	email_admin VARCHAR(100) NOT NULL,
	balance INT NOT NULL,
	"date" SMALLDATETIME NOT NULL,
	FOREIGN KEY (email_admin) REFERENCES "admin"(email) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE admin_update_card(
	id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	email_admin VARCHAR(100) NOT NULL,
	card_number BIGINT NOT NULL,
	old_card_number BIGINT NOT NULL,
	new_card_number BIGINT NOT NULL,
	"date" SMALLDATETIME NOT NULL, 
	FOREIGN KEY (card_number) REFERENCES "user"(card_number) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (email_admin) REFERENCES "admin"(email) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE admin_update_limit(
	id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	email_admin VARCHAR(100) NOT NULL,
	card_number BIGINT NOT NULL,
	old_limit BIGINT NOT NULL,
	new_limit BIGINT NOT NULL,
	"date" SMALLDATETIME NOT NULL, 
	FOREIGN KEY (card_number) REFERENCES "user"(card_number) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (email_admin) REFERENCES "admin"(email) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE user_update_pin(
	id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	card_number BIGINT NOT NULL,
	old_pin BIGINT NOT NULL,
	new_pin BIGINT NOT NULL,
	"date" SMALLDATETIME NOT NULL,
	FOREIGN KEY (card_number) REFERENCES "user"(card_number) ON DELETE NO ACTION ON UPDATE CASCADE
);