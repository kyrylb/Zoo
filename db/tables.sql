
CREATE TABLE myschema.users
(
    id integer NOT NULL DEFAULT nextval('myschema.users_id_seq'::regclass),
    u_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;



CREATE TABLE myschema.permissions
(
    id integer NOT NULL DEFAULT nextval('myschema.permissions_id_seq'::regclass),
    p_type character varying(100) COLLATE pg_catalog."default" NOT NULL,
    p_instance_id integer,
    CONSTRAINT permissions_pkey PRIMARY KEY (id),
    CONSTRAINT permissions_p_type_p_instance_id_key UNIQUE (p_type, p_instance_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


﻿CREATE TABLE myschema.user_permissions
(
    id integer NOT NULL DEFAULT nextval('myschema.user_permissions_id_seq'::regclass),
    up_p_id integer NOT NULL,
    up_u_id integer NOT NULL,
    CONSTRAINT user_permissions_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


CREATE SEQUENCE myschema.user_permissions_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE myschema.user_permissions_id_seq
    OWNER TO postgres;


CREATE SEQUENCE myschema.permissions_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE myschema.permissions_id_seq
    OWNER TO postgres;



CREATE SEQUENCE myschema.users_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE myschema.users_id_seq
    OWNER TO postgres;

