DROP TABLE IF EXISTS LINEITEM;
create table LINEITEM
(
	ID INTEGER not null primary key,
	QUANTITY INTEGER,
	DESCRIPTION VARCHAR(255),
	UNIT_PRICE DECIMAL(5),
	LINE_ITEM_TOTAL DECIMAL(5),
        INVOICE_ID INTEGER
);

DROP TABLE IF EXISTS INVOICE;
create table INVOICE
(
	ID INTEGER not null primary key,
	CLIENT VARCHAR(255),
	VAT_RATE INTEGER,
        INVOICE_DATE DATE,
	SUB_TOTAL DECIMAL(5),
	VAT DECIMAL(5),
	TOTAL DECIMAL(5),
	LINEITEMS INTEGER,
        FOREIGN  KEY (LINEITEMS) REFERENCES LINEITEM(id)
);

insert into LINEITEM values(1,1,'eo555h',2,2,1);
insert into LINEITEM values(2,1,'e77oh',2,2,2);
insert into LINEITEM values(3,1,'eo554h',2,2,3);
insert into LINEITEM values(4,1,'eyyyoh',2,2,4);

--insert into INVOICE values(1,'eo96h',2,2,4,2,1);
--insert into INVOICE values(2,'eo8996544h',2,2,4,2,2);
--insert into INVOICE values(3,'e0987oh',2,2,4,2,3);
--insert into INVOICE values(4,'eyuioh',2,2,4,2,4);

insert into INVOICE values(1,'eo96h',2,'2018-06-29',2,4,2,1);
insert into INVOICE values(2,'eo8996544h',2,'2018-06-29',2,4,2,2);
insert into INVOICE values(3,'e0987oh',2,'2018-06-29',2,4,2,3);
insert into INVOICE values(4,'eyuioh',2,'2018-06-29',2,4,2,4);