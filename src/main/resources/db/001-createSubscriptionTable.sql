-- liquibase formatted sql
-- changeset s.trifonova:1

create table subscription (
       id uuid PRIMARY KEY,
       name VARCHAR(255),
       count_visits int default 0,
       price DECIMAL(10,2),
       action_time INT CHECK (action_time >= 0 OR action_time IS NULL)
)