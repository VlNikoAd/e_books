CREATE TABLE IF NOT EXISTS public.user_data
(
    id             uuid      not null,
    name           varchar,
    login          varchar,
    password       varchar,
    login_at       timestamp not null,
    last_active_at timestamp not null,
    is_active      bool default true,

    CONSTRAINT user_pkey PRIMARY KEY (id)
)