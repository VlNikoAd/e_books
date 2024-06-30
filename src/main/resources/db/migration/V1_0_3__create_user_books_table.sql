CREATE TABLE IF NOT EXISTS public.user_books
(
    id      uuid not null,
    book_id uuid not null,
    user_id uuid not null,

    CONSTRAINT user_book_pkey PRIMARY KEY (id),

    CONSTRAINT user_book_book_fk FOREIGN KEY (book_id) REFERENCES public.books (id),
    CONSTRAINT user_book_user_fk FOREIGN KEY (user_id) REFERENCES public.users (id)
);