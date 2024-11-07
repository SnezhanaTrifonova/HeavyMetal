-- liquibase formatted sql
-- changeset s.trifonova:4

create table discount_by_count_visits
(
    id uuid PRIMARY KEY,
    percent int not null,
    count_visits int not null
)