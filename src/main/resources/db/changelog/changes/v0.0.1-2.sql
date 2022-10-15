--liquibase formatted sql
--changeset FN LN:c1

/* Create dummy objects */
INSERT INTO REPLACE_GROUP.DUMMY(name) VALUES ('Dummy A');
INSERT INTO REPLACE_GROUP.DUMMY(name) VALUES ('Dummy B');
INSERT INTO REPLACE_GROUP.DUMMY(name) VALUES ('Dummy C');
INSERT INTO REPLACE_GROUP.DUMMY(name) VALUES ('Dummy D');