-- Database creation: reactive
CREATE DATABASE reactive
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table creation
CREATE TABLE public.products
(
    id bigserial NOT NULL,
    name character varying(40) NOT NULL,
    description character varying(512),
    price double precision NOT NULL,
    image_url text NOT NULL,
    stock integer NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.products
    OWNER to postgres;

CREATE TABLE public.cart
(
    user_id bigint NOT NULL,
    product_id bigint NOT NULL,
    quantity integer NOT NULL DEFAULT 1,
    FOREIGN KEY (product_id)
        REFERENCES public.products (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT valid_count CHECK (quantity > 1)
);

ALTER TABLE IF EXISTS public.cart
    OWNER to postgres;