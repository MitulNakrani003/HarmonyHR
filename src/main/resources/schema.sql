
create table if not exists address (
	addressId serial primary key,
	fullAddress varchar(999) not null
);

create table if not exists employee (
	empId serial primary key,
	firstName varchar(200) not null,
	lastName varchar,
	email varchar(200) not null unique,
	contact varchar(50) not null,
	addressId int not null,
	jobTitle varchar(200) not null,
	dob date not null,
	joiningDate date not null default now(),
	isServing boolean not null default true,
	constraint fk_addressId_address foreign key (addressId) references address(addressId)
);


create table if not exists job (
	jobId serial primary key,
	jobTitle varchar(500) not null,
	postedOn date not null default now(),
	compensation int not null default 0,
	postedBy int not null,
	hiringManager int not null,
	jobDescription text,
	isActive boolean not null default true,
	constraint fk_postedBy_employee foreign key (postedBy) references employee(empId),				
	constraint fk_hiringManager_employee foreign key (hiringManager) references employee(empId)
);

create index employee_index on employee(empId);
create index job_index on job(jobId);
create index address_index on address(addressId);
