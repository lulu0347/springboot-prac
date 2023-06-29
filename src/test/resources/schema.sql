CREATE TABLE IF NOT EXISTS item
(
	itemNo int primary key auto_increment,
    kindNo int not null,
    itemName varchar(100) not null,
    itemPrice int not null,
    itemState int not null,
    soldTime dateTime not null,
    launchedTime dateTime not null,
    warrantyDate decimal(5,1) not null,
    itemProdDescription varchar(100)
);