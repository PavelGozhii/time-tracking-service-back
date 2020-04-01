CREATE TABLE public.subscription
(
    id serial NOT NULL,
    name character varying NOT NULL,
    duration integer NOT NULL,
    " usage" integer NOT NULL,
    price money NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.organization
(
    id serial NOT NULL,
    name character varying,
    description character varying,
    PRIMARY KEY (id)
);

CREATE TABLE public."purсhased_subscription"
(
    id serial NOT NULL,
    time_to_end date NOT NULL,
    type_id serial NOT NULL,
    organization_id serial NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT subscription_type FOREIGN KEY (type_id)
        REFERENCES public.subscription (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT subscription_organization FOREIGN KEY (organization_id)
        REFERENCES public.organization (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.role
(
    id serial NOT NULL,
    name character varying NOT NULL,
    description character varying,
    PRIMARY KEY (id)
);

CREATE TABLE public.event
(
    id serial NOT NULL,
    start_date timestamp without time zone NOT NULL,
    end_date timestamp without time zone NOT NULL,
    name character varying NOT NULL,
    description character varying
);

CREATE TABLE public.comment_type
(
    id serial NOT NULL,
    name character varying NOT NULL,
    description character varying,
    PRIMARY KEY (id)
);

CREATE TABLE public.team
(
    id serial NOT NULL,
    name character varying NOT NULL,
    description character varying,
    organization_id serial NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT organazation_team FOREIGN KEY (organization_id)
        REFERENCES public.organization (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.project
(
    id serial NOT NULL,
    name character varying NOT NULL,
    description character varying,
    team_id serial NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT team_project FOREIGN KEY (id)
        REFERENCES public.team (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public."user"
(
    id serial NOT NULL,
    name character varying NOT NULL,
    login character varying NOT NULL,
    password character varying NOT NULL,
    birth_date character varying,
    email character varying NOT NULL,
    telegram character varying,
    status character varying NOT NULL,
    working_days character varying,
    total_hours_in_week integer,
    team_id serial NOT NULL,
    organization_id serial NOT NULL,
    role_id serial NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT user_team FOREIGN KEY (team_id)
        REFERENCES public.team (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT user_organization FOREIGN KEY (organization_id)
        REFERENCES public.organization (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT user_role FOREIGN KEY (role_id)
        REFERENCES public.role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.event_user
(
    id serial NOT NULL,
    event_id serial NOT NULL,
    user_id serial NOT NULL,
    accepted boolean NOT NULL,
    no_accepted_reason character varying,
    PRIMARY KEY (id),
    CONSTRAINT user_fk FOREIGN KEY (user_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT event_fk FOREIGN KEY (event_id)
        REFERENCES public.event (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.task
(
    id serial NOT NULL,
    executor_id serial NOT NULL,
    owner_id serial NOT NULL,
    name character varying NOT NULL,
    description character varying,
    PRIMARY KEY (id),
    CONSTRAINT task_executor FOREIGN KEY (executor_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT task_owner FOREIGN KEY (owner_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.task_comment
(
    id serial NOT NULL,
    writer_id serial NOT NULL,
    text character varying NOT NULL,
    date timestamp without time zone NOT NULL,
    type_id serial NOT NULL,
    task_id serial NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT task_comment_user FOREIGN KEY (writer_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT task_comment_type FOREIGN KEY (type_id)
        REFERENCES public.comment_type (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT task_comment_task FOREIGN KEY (task_id)
        REFERENCES public.task (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.time_record
(
    id serial NOT NULL,
    "time" time without time zone NOT NULL,
    date date NOT NULL,
    user_id serial NOT NULL,
    task_id serial NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT time_record_user FOREIGN KEY (user_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT time_record_task FOREIGN KEY (task_id)
        REFERENCES public.task (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.log_request
(
    ticket character varying NOT NULL,
    request_body character varying NOT NULL,
    operation character varying NOT NULL,
    PRIMARY KEY (ticket)
);

CREATE TABLE public.log_response
(
    ticket character varying NOT NULL,
    response_body character varying NOT NULL,
    operation character varying NOT NULL,
    PRIMARY KEY (ticket)
);
