--
-- Load user table.
--
insert into user values (1, 'admin', 'admin','admin@david.com','123','admin','admin','admin',11211,'admin');
insert into user values (2, 'Pedro', 'Gavilan','pedro@disney.com','123 dorchester','Dorchester','','Mass',10022,'USA');
insert into user values (3, 'Edward', 'Jhons','edjohns@david.com','222','222 boston','boston','Mass',11212,'USA');
insert into user values (4, 'Anthony', 'James','ajames@david.com','hlhl','brickel ave','miami','Floritda',22121,'USA');


--
-- Load book table.
--
insert into book (AuthorFirstName,AuthorLastName,ISBN, Title, Editor, Edition, Year, Price)
            values ('Dale','Carnigie', '2312-1231-1', 'How to win frineds and influence people', 'Ligma Books', '1st','1955','12');
insert into book (AuthorFirstName,AuthorLastName,ISBN, Title, Editor, Edition, Year, Price)
            values ('Jose','Noriega', '231552-1231-1', 'Bad People', 'Ligma Books', '1st','2012','15');
insert into book (AuthorFirstName,AuthorLastName,ISBN, Title, Editor, Edition, Year, Price)
            values ('Carmelito','Moreno', '2310-1231-1', 'How to teach java', 'Sebastian Books', '2st','2009','32');           
--
--
-- Load invoice table.
--
InvoiceID INT NOT NULL AUTO_INCREMENT,
					 UserID INT NOT NULL,
                     TotalAmount INT NOT NULL,
                     IsProcessed VARCHAR(50) NOT NULL,
insert into course (UserID,TotalAmount,IsProcessed)
            values (2,123,'Yes');
insert into course (UserID,TotalAmount,IsProcessed)
            values (3,123,'Yes');
insert into course (UserID,TotalAmount,IsProcessed)
            values (4,523,'Yes');
