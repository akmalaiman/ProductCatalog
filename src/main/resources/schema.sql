create table `product` (
    `id` int not null auto_increment,
    `code` varchar(255) not null,
    `name` varchar(255) not null,
    `category` varchar(255) not null,
    `brand` varchar(255) not null,
    `type` varchar(255) not null,
    `description` text not null,
    primary key (`id`)
    );