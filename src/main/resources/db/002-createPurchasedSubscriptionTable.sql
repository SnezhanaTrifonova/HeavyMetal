-- liquibase formatted sql
-- changeset s.trifonova:2

create table purchased_subscription
(
    id uuid PRIMARY KEY,
    sportsman_id uuid not null
        constraint purchased_subscription_sportsman_id_fk
            references sportsman,
    subscription_id uuid not null
        constraint purchased_subscription_subscription_id_fk
            references subscription,
    started_date timestamp not null,
    stopped_date timestamp,
    paid decimal (10,2),
    active boolean default true
)