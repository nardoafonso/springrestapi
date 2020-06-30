CREATE TABLE public.marca
(
    id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT marca_pkey PRIMARY KEY (id)
)

CREATE TABLE public.patrimonio
(
    id integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    identifier character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    marca bigint NOT NULL,
    CONSTRAINT patrimonio_pkey PRIMARY KEY (id),
    CONSTRAINT marca_fk FOREIGN KEY (marca)
        REFERENCES public.marca (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)