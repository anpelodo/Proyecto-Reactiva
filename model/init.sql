-- Database creation: reactive
CREATE DATABASE reactive
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table creation
DROP TABLE IF EXISTS public.products;
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

DROP TABLE IF EXISTS public.cart_items;
CREATE TABLE public.cart_items
(
    id bigserial NOT NULL DEFAULT,
    user_id bigint NOT NULL,
    product_id bigint NOT NULL,
	product_price double precision,
    quantity integer NOT NULL DEFAULT 1,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id)
        REFERENCES public.products (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT valid_count CHECK (quantity > 0) NOT VALID
);

ALTER TABLE IF EXISTS public.cart_items
    OWNER to postgres;