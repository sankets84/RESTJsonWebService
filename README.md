# RESTJsonWebService
Communicate using JSON Data over Restful Webservice Insert/Update

Build Source Code and use following urls to check for JSON Data.

http://172.25.18.58:8080/OESRestWebService/rest/json/tstctr/get/summary/10:00-12:00

http://172.25.18.58:8080/OESRestWebService/rest/json/tstctr/get/10:00-12:00

Postgresql db query ->

CREATE TABLE oes_dashboard1
(
  od_tc_id numeric(16,0) NOT NULL,
  od_test_date date NOT NULL,
  od_batch character varying(11) NOT NULL,
  od_audit_dt timestamp without time zone,
  od_content json,
  CONSTRAINT pk_dashboard1 PRIMARY KEY (od_tc_id, od_test_date, od_batch)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE oes_dashboard
(
  od_tc_id numeric(16,0) NOT NULL,
  od_test_date date NOT NULL,
  od_batch character varying(11) NOT NULL,
  od_audit_dt timestamp without time zone,
  od_content character varying(5000),
  CONSTRAINT pk_dashboard PRIMARY KEY (od_tc_id, od_test_date, od_batch)
)
WITH (
  OIDS=FALSE
);
