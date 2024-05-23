SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

CREATE FUNCTION public.context_date() RETURNS timestamp without time zone
    LANGUAGE plpgsql
    SECURITY DEFINER
AS
$$
DECLARE
    context_date timestamp;
BEGIN
    SELECT CURRENT_SETTING('ebooks.context_date') into context_date;
    return context_date;
EXCEPTION
    WHEN OTHERS THEN
        select now() into context_date;
        return context_date;
END;
$$;