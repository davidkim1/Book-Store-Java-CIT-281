DROP DATABASE IF EXISTS book_store;

CREATE DATABASE IF NOT EXISTS book_store;
--
--
-- Change the database to book_store.
USE book_store;



-- DELIMITER //
create table book(BookID BIGINT NOT NULL auto_increment,
				  AuthorFirstName VARCHAR(20) NOT NULL,
				  AuthorLastName VARCHAR(20) NOT NULL,
                  ISBN VARCHAR(30) NOT NULL,
                  Title VARCHAR(100) NOT NULL,
                  Editor VARCHAR(50),
                  Edition VARCHAR(20),
                  Year INT,
                  Price INT,
--                  AuthorID BIGINT NOT NULL,
                  PRIMARY KEY (BookID));
--                  FOREIGN KEY(AuthorID) REFERENCES Author(AuthorID));
--
--
create table user(UserID INT NOT NULL ,
				  FirstName VARCHAR(50) NOT NULL,
                  LastName VARCHAR(50) NOT NULL,
                  EmailAddress VARCHAR(50) NOT NULL,
                  Password VARCHAR(20) NOT NULL,
                  Address VARCHAR(80) NOT NULL,
				  City VARCHAR (50)  NOT NULL,
				  State VARCHAR (50) NOT NULL,
				  Zip INT NOT NULL,
				  Country VARCHAR(50) NOT NULL,
                  PRIMARY KEY (UserID));
--

create table invoice(InvoiceID INT NOT NULL AUTO_INCREMENT,
					 UserID INT NOT NULL,
                     TotalAmount INT NOT NULL,
                     IsProcessed VARCHAR(50) NOT NULL,
                     PRIMARY KEY (InvoiceID),
                     FOREIGN KEY (UserID) REFERENCES user (UserID));
                     
--
--
-- Change delimiter to ;
DELIMITER ;

