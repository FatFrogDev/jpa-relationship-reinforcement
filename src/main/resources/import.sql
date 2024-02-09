

-- Insert statements for Client
INSERT INTO clients (name, lastname) VALUES ('John', 'Doe');
INSERT INTO clients (name, lastname) VALUES ('Jane', 'Smith');
INSERT INTO clients (name, lastname) VALUES ('Robert', 'Johnson');
INSERT INTO clients (name, lastname) VALUES ('Michael', 'Williams');
INSERT INTO clients (name, lastname) VALUES ('Sarah', 'Jones');
INSERT INTO clients (name, lastname) VALUES ('Emily', 'Brown');
INSERT INTO clients (name, lastname) VALUES ('James', 'Davis');
INSERT INTO clients (name, lastname) VALUES ('Jessica', 'Miller');
INSERT INTO clients (name, lastname) VALUES ('Christopher', 'Wilson');
INSERT INTO clients (name, lastname) VALUES ('Amanda', 'Moore');

-- Insert statements for Invoice
INSERT INTO invoices (description, total, client_id) VALUES ('Web development services', 1500.00, 1);
INSERT INTO invoices (description, total, client_id) VALUES ('Graphic design services', 800.00, 1);
INSERT INTO invoices (description, total, client_id) VALUES ('Monthly maintenance', 300.00, 1);

INSERT INTO invoices (description, total, client_id) VALUES ('Data analysis services', 1200.00, 2);
INSERT INTO invoices (description, total, client_id) VALUES ('SEO services', 600.00, 2);
INSERT INTO invoices (description, total, client_id) VALUES ('Monthly maintenance', 300.00, 2);

-- Continue this pattern for the rest of the clients...