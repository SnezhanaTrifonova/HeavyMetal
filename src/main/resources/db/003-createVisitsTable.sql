-- liquibase formatted sql
-- changeset s.trifonova:3

create table visits
(
    id uuid PRIMARY KEY,
    sportsman_id uuid not null
        constraint visits_sportsman_id_fk
            references sportsman,
    purchased_subscription_id uuid not null
        constraint visits_purchased_subscription_id_fk
            references purchased_subscription,
    created_date timestamp not null
)