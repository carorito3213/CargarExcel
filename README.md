# CargarExcel
Este repositorio contiene un servicio REST desarrollado en Java usando Spring Boot, que permite cargar un archivo Excel y almacenar la información contenida en dos tablas de una base de datos.


#Querys SQL para creacion de la base de datos 

-- Database: crehanadb

-- DROP DATABASE IF EXISTS crehanadb;

CREATE DATABASE crehanadb
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table: public.empleado

-- DROP TABLE IF EXISTS public.empleado;

CREATE TABLE IF NOT EXISTS public.empleado
(
    id integer NOT NULL,
    nombre character(250) COLLATE pg_catalog."default",
    apellido character(250) COLLATE pg_catalog."default",
    email character(250) COLLATE pg_catalog."default",
    telefono character(15) COLLATE pg_catalog."default",
    CONSTRAINT "Empleado_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.empleado
    OWNER to postgres;
-- SEQUENCE: public.empleado_seq

-- DROP SEQUENCE IF EXISTS public.empleado_seq;

CREATE SEQUENCE IF NOT EXISTS public.empleado_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 99999
    CACHE 1;

ALTER SEQUENCE public.empleado_seq
    OWNER TO postgres;

-- Table: public.role

-- DROP TABLE IF EXISTS public.role;

CREATE TABLE IF NOT EXISTS public.role
(
    id integer NOT NULL,
    nombre character(250) COLLATE pg_catalog."default",
    empleado_id integer,
    CONSTRAINT "Empleado" FOREIGN KEY (empleado_id)
        REFERENCES public.empleado (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.role
    OWNER to postgres;

-- SEQUENCE: public.role_seq

-- DROP SEQUENCE IF EXISTS public.role_seq;

CREATE SEQUENCE IF NOT EXISTS public.role_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 99999
    CACHE 1;

ALTER SEQUENCE public.role_seq
    OWNER TO postgres;

El archivo excel con el que se realizaron las pruebas esta en la carpeta de resource y se llama Empleados2.xlsx 
El projecto postman con el cual se realizaron las pruebas esta en la carpeta de resource y se llama ExcelUpload.postman_collection.json 
