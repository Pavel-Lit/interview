create table students (
                          id          bigserial primary key,
                          name       varchar(255),
                          age       smallint,
                          created_at  timestamp default current_timestamp,
                          updated_at  timestamp default current_timestamp
);


insert into students (name, age) values
                                        ('Mark', 20),
                                        ('Kate', 23),
                                        ('Alex', 35),
                                        ('Semen', 20),
                                        ('Oleg', 66);

