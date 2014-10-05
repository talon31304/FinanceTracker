USE MASTER
DROP DATABASE FinanceTracker
GO
CREATE DATABASE FinanceTracker
GO

USE [FinanceTracker]
GO
drop user [financeuser]
GO
drop login [financeuser]
GO
CREATE LOGIN [financeuser] WITH PASSWORD=N'financeuser', DEFAULT_DATABASE=[FinanceTracker], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
CREATE USER [financeuser] FOR LOGIN [financeuser]
GO

CREATE TABLE Accounts (account_id int identity(1,1) PRIMARY KEY, Name varchar(100) not null, Description varchar(2000), account_type_id INT not null, user_id varchar(50))
CREATE TABLE AccountType (account_type_id int identity(1,1) PRIMARY KEY, Name varchar(100) not null, Description varchar(2000),Type varchar(20) not null)
CREATE TABLE AccountDetail (account_detail_id int identity(1,1) PRIMARY KEY, account_id int not null,transaction_type_id INT not null, Description VARCHAR(100), Memo VARCHAR(100), Amount FLOAT not null, Date date not null)
CREATE TABLE TransactionType (transaction_type_id int identity(1,1) PRIMARY KEY, Name varchar(50) not null, EffectOnBalance char(1) not null)
CREATE TABLE Configuration (configuration_property varchar(50) not null, configuration_value varchar(1000) not null)
CREATE TABLE Users (user_id varchar(50) primary key, firstname varchar(20), lastname varchar(30), emailaddress varchar(50))

ALTER TABLE Accounts WITH CHECK ADD CONSTRAINT [FK_Account_Type] FOREIGN KEY ([account_type_id]) REFERENCES AccountType ([account_type_id])
ALTER TABLE Accounts WITH CHECK ADD CONSTRAINT [FK_User_ID] FOREIGN KEY ([user_id]) REFERENCES Users ([user_id])
ALTER TABLE AccountDetail WITH CHECK ADD CON
STRAINT [FK_Account] FOREIGN KEY ([account_id]) REFERENCES Accounts ([account_id])
ALTER TABLE AccountDetail WITH CHECK ADD CONSTRAINT [FK_TransactionType] FOREIGN KEY (transaction_type_id) REFERENCES TransactionType ([transaction_type_id])

ALTER TABLE AccountType WITH CHECK ADD CONSTRAINT [UQ_account_type_name] unique nonclustered ([name])
ALTER TABLE TransactionType WITH CHECK ADD CONSTRAINT [UQ_transaction_type_name] unique nonclustered ([name])
ALTER TABLE Configuration WITH CHECK ADD CONSTRAINT [UQ_configuration_property] unique nonclustered ([configuration_property])


INSERT INTO AccountType (name, Description, Type) values ('Checking', 'Checking Account', 'Bank')
INSERT INTO AccountType (name, Description, Type) values ('Savings', 'Savings Account', 'Bank')
INSERT INTO AccountType (name, Description, Type) values ('Loan', 'Loan', 'Liability')
INSERT INTO	AccountType (name, Description, Type) values ('Investment', 'Investment Account (401k, IRA)', 'Asset')
INSERT INTO AccountType (name, Description, Type) values ('Collateral', 'Collateral (House, Vehicle)', 'Asset')

INSERT INTO TransactionType (Name, EffectOnBalance) VALUES ('Deposit', 'I')
INSERT INTO TransactionType (Name, EffectOnBalance) VALUES ('Withdrawal', 'D')
INSERT INTO TransactionType (Name, EffectOnBalance) VALUES ('Loan Payment', 'I')
INSERT INTO TransactionType (Name, EffectOnBalance) VALUES ('Collateral Adjustment - Increase','I')
INSERT INTO TransactionType (Name, EffectOnBalance)	values ('Collateral Adjustment - Decrease', 'D')

INSERT INTO Configuration (configuration_property, configuration_value) values ('Import/Export Path', 'C:\FinanceTracker\Files\')
INSERT INTO Configuration (configuration_property, configuration_value) values ('Reminder Days', '7')

--INSERT INTO Users (user_id, firstname, lastname, emailaddress) values ('keithb', 'Keith', 'Boermeester', 'keith_boermeester@student.uml.edu')

GO
declare @sql varchar(4000)
select @sql = ''

SELECT @sql = @sql + 'GRANT SELECT ON ' + name + ' TO public' + char(13)
FROM FinanceTracker.sys.tables

SELECT @sql = @sql + 'GRANT INSERT ON ' + name + ' TO public' + char(13)
FROM FinanceTracker.sys.tables

SELECT @sql = @sql + 'GRANT DELETE ON ' + name + ' TO public' + char(13)
FROM FinanceTracker.sys.tables

PRINT @sql
exec (@sql)
