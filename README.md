# feedback-portal
Small app that collects feedback from users/customers, stores it in a database


My ddl for Table Users {

CREATE TABLE IF NOT EXISTS public.users
(
id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass),
fname character varying(255) COLLATE pg_catalog."default" NOT NULL,
lname character varying(255) COLLATE pg_catalog."default" NOT NULL,
email character varying(255) COLLATE pg_catalog."default" NOT NULL,
created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT users_pkey PRIMARY KEY (id),
CONSTRAINT users_email_key UNIQUE (email)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
OWNER to pi5;

}

Feedback table {

-- Table: public.feedback

-- DROP TABLE IF EXISTS public.feedback;

CREATE TABLE IF NOT EXISTS public.feedback
(
id bigint NOT NULL DEFAULT nextval('feedback_id_seq'::regclass),
user_id bigint NOT NULL,
feedback_text character varying(255) COLLATE pg_catalog."default" NOT NULL,
submitted_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT feedback_pkey PRIMARY KEY (id),
CONSTRAINT fk_user_feedback FOREIGN KEY (user_id)
REFERENCES public.users (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.feedback
OWNER to pi5;

}