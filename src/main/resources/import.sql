-- CREATING SCHEMA
CREATE SCHEMA IF NOT EXISTS weather;

-- POPULING weather.privilege
--INSERT INTO weather.privilege(created_at, updated_at, id, name) VALUES(NOW(), NOW(), '82beb7a1-621c-4b9a-83eb-3ca196ed4345', 'READ_PRIVILEGE') ON CONFLICT DO NOTHING;
--INSERT INTO weather.privilege(created_at, updated_at, id, name) VALUES(NOW(), NOW(), '3f2146a9-5d43-448e-a1eb-455766d3a14a', 'WRITE_PRIVILEGE') ON CONFLICT DO NOTHING;

-- POPULING weather.role
INSERT INTO weather.role(created_at, updated_at, id, name) VALUES(NOW(), NOW(), '7c12004d-e843-4e00-be40-01845ad75834', 'ROLE_USER') ON CONFLICT DO NOTHING;
INSERT INTO weather.role(created_at, updated_at, id, name) VALUES(NOW(), NOW(), '52c57a80-4e3b-4a41-a864-58d0cea25b14', 'ROLE_MODERATOR') ON CONFLICT DO NOTHING;
INSERT INTO weather.role(created_at, updated_at, id, name) VALUES(NOW(), NOW(), '8652ec73-0a53-433c-93be-420f1d90c681', 'ROLE_ADMIN') ON CONFLICT DO NOTHING;

-- POPULING weather.role_privilege
--INSERT INTO weather.role_privilege(role_id, privilege_id) VALUES ('7c12004d-e843-4e00-be40-01845ad75834', '82beb7a1-621c-4b9a-83eb-3ca196ed4345') ON CONFLICT DO NOTHING;
--INSERT INTO weather.role_privilege(role_id, privilege_id) VALUES ('52c57a80-4e3b-4a41-a864-58d0cea25b14', '82beb7a1-621c-4b9a-83eb-3ca196ed4345') ON CONFLICT DO NOTHING;
--INSERT INTO weather.role_privilege(role_id, privilege_id) VALUES ('52c57a80-4e3b-4a41-a864-58d0cea25b14', '3f2146a9-5d43-448e-a1eb-455766d3a14a') ON CONFLICT DO NOTHING;
--INSERT INTO weather.role_privilege(role_id, privilege_id) VALUES ('8652ec73-0a53-433c-93be-420f1d90c681', '82beb7a1-621c-4b9a-83eb-3ca196ed4345') ON CONFLICT DO NOTHING;
--INSERT INTO weather.role_privilege(role_id, privilege_id) VALUES ('8652ec73-0a53-433c-93be-420f1d90c681', '3f2146a9-5d43-448e-a1eb-455766d3a14a') ON CONFLICT DO NOTHING;

-- POPULING weather.user
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '6120ce60-4499-4a8d-816b-9080e3f8e6e2', '00038059', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'marcelo.gadelha@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '67d43c5e-bd63-4e17-b386-09438e758194', '00038060', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'gael.gadelha@marinha.mil.br', true) ON CONFLICT DO NOTHING;

-- POPULING weather.user_role
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('6120ce60-4499-4a8d-816b-9080e3f8e6e2', '7c12004d-e843-4e00-be40-01845ad75834') ON CONFLICT DO NOTHING;
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('6120ce60-4499-4a8d-816b-9080e3f8e6e2', '8652ec73-0a53-433c-93be-420f1d90c681') ON CONFLICT DO NOTHING;
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('67d43c5e-bd63-4e17-b386-09438e758194', '8652ec73-0a53-433c-93be-420f1d90c681') ON CONFLICT DO NOTHING;