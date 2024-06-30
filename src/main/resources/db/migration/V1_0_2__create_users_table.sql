CREATE TABLE IF NOT EXISTS public.users
(
    id              uuid      not null,
    login           varchar,
    passport        varchar,
    created_at      timestamp not null,
    last_updated_at timestamp not null,
    is_active       bool default true,

    CONSTRAINT user_pkey PRIMARY KEY (id)
)