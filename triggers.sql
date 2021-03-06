-- User
CREATE SEQUENCE user_seq
START WITH 1
INCREMENT BY 1
CACHE 100;

CREATE OR REPLACE TRIGGER user_seq_generator
BEFORE INSERT ON user_auth
FOR EACH ROW

BEGIN
  SELECT user_seq.NEXTVAL
  INTO   :new.authorize_id
  FROM   dual;
END;
/


-- Token
CREATE SEQUENCE token_seq
START WITH 1
INCREMENT BY 1
CACHE 100;

CREATE OR REPLACE TRIGGER user_seq_generator
BEFORE INSERT ON token
FOR EACH ROW

BEGIN
  SELECT token_seq.NEXTVAL
  INTO   :new.tokenId
  FROM   dual;
END;
/


-- Authority
CREATE SEQUENCE auth_seq
START WITH 1
INCREMENT BY 1
CACHE 100;

CREATE OR REPLACE TRIGGER user_seq_generator
BEFORE INSERT ON authority
FOR EACH ROW

BEGIN
  SELECT auth_seq.NEXTVAL
  INTO   :new.authorityId
  FROM   dual;
END;
/

-- Component
CREATE SEQUENCE component_seq
START WITH 1
INCREMENT BY 1
CACHE 100;

CREATE OR REPLACE TRIGGER component_seq_generator
BEFORE INSERT ON COMPONENT
FOR EACH ROW

BEGIN
  SELECT component_seq.NEXTVAL
  INTO   :new.componentId
  FROM   dual;
END;
/

-- Feature
CREATE SEQUENCE feature_seq
START WITH 1
INCREMENT BY 1
CACHE 100;

CREATE OR REPLACE TRIGGER feature_seq_generator
BEFORE INSERT ON FEATURE
FOR EACH ROW

BEGIN
  SELECT component_seq.NEXTVAL
  INTO   :new.featureId
  FROM   dual;
END;
/