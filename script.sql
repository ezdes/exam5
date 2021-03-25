create table request(
	id serial primary key,
	request_date_time timestamp not null,
	name varchar(55) not null,
	birth_year int not null,
	gender gender_t not null
)


create type gender_t as enum('male', 'female')