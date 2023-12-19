use ecomm;
create table customers ( 
customer_id int primary key, name varchar(30), 
email varchar(255),password varchar(15));

create table products (
    product_id int primary key, name varchar(25),
    price int, description varchar(255), stockQuantity int);
    
create table cart (
    cart_id int primary key, customer_id int,
    product_id int, quantity int,
    foreign key (customer_id) references customers(customer_id),
    foreign key (product_id) references products(product_id));
    
create table orders (
    order_id int primary key, customer_id int,
    order_date date, total_price int,
    shipping_address varchar(255),
    foreign key (customer_id) references customers(customer_id));
    
create table order_items (
    order_item_id int primary key, order_id int,
    product_id int, quantity int,
    foreign key (order_id) references orders(order_id),
    foreign key (product_id) references products(product_id));
    
-- Customers data
insert into customers values (1, 'krishna', 'krishna@gmail.com', 'securepass1');
insert into customers values (2, 'aruna', 'aruna@gmail.com', 'mypassword123');
insert into customers values (3, 'devi', 'devi@gmail.com', 'strongpass456');
insert into customers values (4, 'rajesh', 'rajesh@gmail.com', 'password789');
insert into customers values (5, 'jaya', 'jaya@gmail.com', 'securepass2');
insert into customers values (6, 'sundar', 'sundar@gmail.com', 'mypassword999');
insert into customers values (7, 'priya', 'priya@gmail.com', 'strongpass777');
insert into customers values (8, 'krithika', 'krithika@gmail.com', 'password111');
insert into customers values (9, 'manoj', 'manoj@gmail.com', 'securepass3');
insert into customers values (10, 'anitha', 'anitha@gmail.com', 'mypassword555');

-- Products data
insert into products values (1, 'Smartphone', 499, 'High-end mobile device', 100);
insert into products values (2, 'Headphones', 79, 'Wireless noise-canceling headphones', 50);
insert into products values (3, 'Smartwatch', 199, 'Fitness tracking smartwatch', 30);
insert into products values (4, 'Tablet', 299, '10-inch touchscreen tablet', 40);
insert into products values (5, 'Camera', 599, 'Digital SLR camera', 20);
insert into products values (6, 'Gaming Laptop', 1299, 'Powerful gaming laptop', 15);
insert into products values (7, 'Printer', 149, 'Wireless color printer', 25);
insert into products values (8, 'Fitness Tracker', 69, 'Activity and sleep tracker', 60);
insert into products values (9, 'External Hard Drive', 89, '1TB USB 3.0 hard drive', 35);
insert into products values (10, 'Wireless Router', 49, 'High-speed dual-band router', 45);

-- Cart data
insert into cart values (1, 1, 2, 3);
insert into cart values (2, 3, 4, 1);
insert into cart values (3, 2, 1, 2);
insert into cart values (4, 1, 3, 1);
insert into cart values (5, 2, 2, 4);
insert into cart values (6, 3, 1, 1);
insert into cart values (7, 1, 4, 2);
insert into cart values (8, 2, 3, 1);
insert into cart values (9, 3, 2, 3);
insert into cart values (10, 1, 1, 2);

-- Orders data
insert into orders values (1, 1, '2023-11-30', 1499, 'Chennai, Tamil Nadu');
insert into orders values (2, 2, '2023-11-29', 899, 'Coimbatore, Tamil Nadu');
insert into orders values (3, 3, '2023-11-28', 249, 'Madurai, Tamil Nadu');
insert into orders values (4, 4, '2023-11-27', 799, 'Trichy, Tamil Nadu');
insert into orders values (5, 5, '2023-11-26', 349, 'Salem, Tamil Nadu');
insert into orders values (6, 6, '2023-11-25', 1599, 'Erode, Tamil Nadu');
insert into orders values (7, 7, '2023-11-24', 599, 'Tirunelveli, Tamil Nadu');
insert into orders values (8, 8, '2023-11-23', 999, 'Vellore, Tamil Nadu');
insert into orders values (9, 9, '2023-11-22', 449, 'Kanchipuram, Tamil Nadu');
insert into orders values (10, 10, '2023-11-21', 749, 'Nagercoil, Tamil Nadu');

-- Order_Items data
insert into order_items values (1, 1, 1, 2);
insert into order_items values (2, 1, 2, 1);
insert into order_items values (3, 2, 3, 3);
insert into order_items values (4, 2, 1, 1);
insert into order_items values (5, 3, 2, 2);
insert into order_items values (6, 3, 3, 1);
insert into order_items values (7, 4, 1, 1);
insert into order_items values (8, 4, 2, 2);
insert into order_items values (9, 5, 3, 1);
insert into order_items values (10, 5, 1, 3);
