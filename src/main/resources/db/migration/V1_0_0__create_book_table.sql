CREATE TABLE IF NOT EXISTS public.book
(
    id     UUID    not null,
    name   varchar not null,
    author varchar not null,

    CONSTRAINT book_pkey PRIMARY KEY (id)
);