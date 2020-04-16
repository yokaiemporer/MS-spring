hal browser :- localhost:8080
actuators :- localhost:8080/actuator
swagger docs :localhost:8080/v2/api-docs
swagger gui:


database:
Hibernate: drop table user if exists
Hibernate: drop sequence if exists hibernate_sequence
Hibernate: create sequence hibernate_sequence start with 1 increment by 1
Hibernate: create table user (id integer not null, birth_date timestamp, name varchar(255), primary key (id))
always use single quotes instead of double in .sql file

link:  localhost:8080/h2-console
jdbc-url:  jdbc:h2:mem:testdb