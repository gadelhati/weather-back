-- CREATING SCHEMA
CREATE SCHEMA IF NOT EXISTS weather;

-- CREATING SEQUENCE
CREATE SEQUENCE IF NOT EXISTS weather.hibernate_sequence;

-- POPULING weather.privilege
--INSERT INTO weather.privilege(created_at, updated_at, id, name) VALUES(NOW(), NOW(), '82beb7a1-621c-4b9a-83eb-3ca196ed4345', 'READ_PRIVILEGE') ON CONFLICT DO NOTHING;
--INSERT INTO weather.privilege(created_at, updated_at, id, name) VALUES(NOW(), NOW(), '3f2146a9-5d43-448e-a1eb-455766d3a14a', 'WRITE_PRIVILEGE') ON CONFLICT DO NOTHING;

-- POPULING weather.role
INSERT INTO weather.role(created_at, updated_at, id, name) VALUES(NOW(), NOW(), '7c12004d-e843-4e00-be40-01845ad75834', 'ROLE_USER') ON CONFLICT DO NOTHING;
INSERT INTO weather.role(created_at, updated_at, id, name) VALUES(NOW(), NOW(), '52c57a80-4e3b-4a41-a864-58d0cea25b14', 'ROLE_MODERATOR') ON CONFLICT DO NOTHING;
INSERT INTO weather.role(created_at, updated_at, id, name) VALUES(NOW(), NOW(), '8652ec73-0a53-433c-93be-420f1d90c681', 'ROLE_ADMIN') ON CONFLICT DO NOTHING;
INSERT INTO weather.role(created_at, updated_at, id, name) VALUES(NOW(), NOW(), 'f63b534f-154b-498f-b424-8469948d2f78', 'ROLE_RECTIFIER') ON CONFLICT DO NOTHING;
INSERT INTO weather.role(created_at, updated_at, id, name) VALUES(NOW(), NOW(), '8cbfd8a2-db75-4bca-850b-d638a33701aa', 'ROLE_OPERATOR') ON CONFLICT DO NOTHING;

-- POPULING weather.role_privilege
--INSERT INTO weather.role_privilege(created_at, updated_at, role_id, privilege_id) VALUES (NOW(), NOW(), '7c12004d-e843-4e00-be40-01845ad75834', '82beb7a1-621c-4b9a-83eb-3ca196ed4345') ON CONFLICT DO NOTHING;
--INSERT INTO weather.role_privilege(created_at, updated_at, role_id, privilege_id) VALUES (NOW(), NOW(), '52c57a80-4e3b-4a41-a864-58d0cea25b14', '82beb7a1-621c-4b9a-83eb-3ca196ed4345') ON CONFLICT DO NOTHING;
--INSERT INTO weather.role_privilege(created_at, updated_at, role_id, privilege_id) VALUES (NOW(), NOW(), '52c57a80-4e3b-4a41-a864-58d0cea25b14', '3f2146a9-5d43-448e-a1eb-455766d3a14a') ON CONFLICT DO NOTHING;
--INSERT INTO weather.role_privilege(created_at, updated_at, role_id, privilege_id) VALUES (NOW(), NOW(), '8652ec73-0a53-433c-93be-420f1d90c681', '82beb7a1-621c-4b9a-83eb-3ca196ed4345') ON CONFLICT DO NOTHING;
--INSERT INTO weather.role_privilege(created_at, updated_at, role_id, privilege_id) VALUES (NOW(), NOW(), '8652ec73-0a53-433c-93be-420f1d90c681', '3f2146a9-5d43-448e-a1eb-455766d3a14a') ON CONFLICT DO NOTHING;

-- POPULING weather.user
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), 'b4c48fe3-4cf2-411d-9d4b-82f7c63eff9c', '00038059', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'marcelo.gadelha@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '9063f71e-9599-4b43-9754-f4a5ba00ca50', '14148102', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'diego.pinto@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), 'f7c8f99b-90c8-47af-a237-753a58781114', '21185042', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'thamyres.lima@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), 'e8b255ae-90cd-4d55-9561-9f85e7932c3d', '86768646', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'jeferson.lessa@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), 'f2199ebe-0306-4ade-943c-db708c418fae', '14088185', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'thiago.gomes@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '38108890-55b7-4b8c-80c0-f363b003083b', '18090311', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'barreto.lopes@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '1818580a-48da-4ce4-8482-213d0563ce6c', '21403724', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'siqueira.felipe@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '21161d05-df8e-44fb-80b8-08ecc18cb110', '14147203', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'matheus.augusto@marinha.mil.br', true) ON CONFLICT DO NOTHING;

INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '1a3dbddf-d1e5-48f5-b28a-89ee779668d4', '07363729', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.supervisor01@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '7d053026-0d47-4207-9c64-9c2a6035032d', '85936928', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.supervisor02@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '3a0cb49f-c92a-4e44-9f48-58e165778414', '10123776', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.operador01@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), 'bb3f033f-8043-4514-b528-68571abc2607', '12134368', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.operador02@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '79a9d758-ee0e-44a9-bda5-ca3203567c03', '10024085', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.operador03@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), 'ddd6a3e9-a14c-490d-9193-2241901953a0', '14148331', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.operador04@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '350ff8b8-f0f8-469d-b9db-857d7bd4cfdd', '14149800', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.operador05@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '1f63f3a9-379c-46d7-b2ea-1401bc203bc2', '15158365', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.operador06@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), 'c85dc0a2-420f-41cc-988f-995ec5c3d6ee', '16113471', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.operador07@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '749fd144-257a-4f52-b86e-e17deb3adf50', '16113667', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.operador08@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), '975aa04f-b735-46a8-83a1-8f05ada1d3e4', '16113233', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.operador09@marinha.mil.br', true) ON CONFLICT DO NOTHING;
INSERT INTO weather.user_entity(created_at, updated_at, id, username, password, email, active) VALUES (NOW(), NOW(), 'e19656a6-a730-4f42-b658-5aee0abb0e41', '16113977', '$2a$10$v5q8rJ5T/OlmZ2NKSYB2YOOxkn9AI1K04Bn9pemlEZTAMybsq6ona', 'teste.operador10@marinha.mil.br', true) ON CONFLICT DO NOTHING;

-- POPULING weather.user_role
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('b4c48fe3-4cf2-411d-9d4b-82f7c63eff9c', '7c12004d-e843-4e00-be40-01845ad75834') ON CONFLICT DO NOTHING;
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('9063f71e-9599-4b43-9754-f4a5ba00ca50', '7c12004d-e843-4e00-be40-01845ad75834') ON CONFLICT DO NOTHING;
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('f7c8f99b-90c8-47af-a237-753a58781114', '52c57a80-4e3b-4a41-a864-58d0cea25b14') ON CONFLICT DO NOTHING;
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('e8b255ae-90cd-4d55-9561-9f85e7932c3d', '8652ec73-0a53-433c-93be-420f1d90c681') ON CONFLICT DO NOTHING;
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('f2199ebe-0306-4ade-943c-db708c418fae', '8652ec73-0a53-433c-93be-420f1d90c681') ON CONFLICT DO NOTHING;
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('38108890-55b7-4b8c-80c0-f363b003083b', '8652ec73-0a53-433c-93be-420f1d90c681') ON CONFLICT DO NOTHING;
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('1818580a-48da-4ce4-8482-213d0563ce6c', '8652ec73-0a53-433c-93be-420f1d90c681') ON CONFLICT DO NOTHING;
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('21161d05-df8e-44fb-80b8-08ecc18cb110', '8652ec73-0a53-433c-93be-420f1d90c681') ON CONFLICT DO NOTHING;

INSERT INTO weather.user_roles(user_id, role_id) VALUES ('1a3dbddf-d1e5-48f5-b28a-89ee779668d4', '8652ec73-0a53-433c-93be-420f1d90c681') ON CONFLICT DO NOTHING;
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('7d053026-0d47-4207-9c64-9c2a6035032d', '8652ec73-0a53-433c-93be-420f1d90c681') ON CONFLICT DO NOTHING;
INSERT INTO weather.user_roles(user_id, role_id) VALUES ('3a0cb49f-c92a-4e44-9f48-58e165778414', '7c12004d-e843-4e00-be40-01845ad75834') ON CONFLICT DO NOTHING;

-- POPULANDO weather.om
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), 'da65d957-d0ab-426b-b53e-4b28e195c32f', 'CHM') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '52b1d4d0-2625-4163-916e-31d31d3ee928', 'Taurus') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '68b542c2-041e-4f5b-a8d0-7a3e1790ef32', 'Amorim do Valle') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '78580d20-dc18-4585-83bd-a0792db559d4', 'Sirius') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), 'e219a7a4-e826-4ed3-bfab-b4b2d97cbc6b', 'Antares') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), 'e32f49d1-df10-4516-9bcc-25c0719b43cf', 'Cruzeiro do Sul') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '8c5de05f-4155-4e61-8434-75e50d580376', 'Graça Aranha') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '5ea7e183-ebd8-4ac0-a598-5d386dbe4987', 'Garnier Sampaio') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '717a78d0-d970-4416-ae30-4c7495a24cc6', 'Maximiano') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), 'aefc74e5-a9dd-4c08-b273-8b659d679dfc', 'Ary Rongel') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '81d5ee63-e314-4e84-ace1-52bc839c86ed', 'BHMN') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '89bdd283-c088-4c12-9675-ea02c9f2665d', 'CLSAOR') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), 'a8722565-27fd-4dcb-91cf-6ec4a509ab71', 'SSN6') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '25e881c1-f84c-4a6b-8bdb-1d2604808434', 'ComForMinVar') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '2e8bf3bc-e36d-4e11-9aba-32d2eba1a28e', 'DHN-20') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), 'fcdc6810-6ed0-48d8-b46a-2cf8a0269d38', 'Ten. Castelo') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '95d9a454-b3a0-4b33-8542-75e636386816', 'Rio Branco') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '3f241677-d89e-4971-893a-e4b2e5464798', 'Rio Tocantins') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), 'f5b0b592-cfa4-4d0b-abc0-88ecdc353a2f', 'Rio Xingú') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '02418e22-b623-48c1-81fa-93bcddf725c3', 'Rio Solimões') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '41d5fe53-0960-497b-8f3a-319aa7f7ca2a', 'Rio Negro') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '371804a1-b33f-4580-b774-c76150180470', 'SSN3') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '0b2fe11e-aab5-44ef-94e8-43c5a6b55b15', 'Ten. Boanerges') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '6ff1beaa-9a00-444c-b2ce-f06301ed24c8', 'Comte. Manhães') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), 'a6b2eb5d-b651-429e-8f0e-e8d52aed91e7', 'Comte. Varella') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '68efb470-daa8-4fc8-8688-fa7b0fcfb79d', 'DHN-LEPLAC') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '32c0ac94-9f6b-46ff-b60f-106d15d3c5c5', 'Mário Seixas') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '2f42701c-3a5f-4d6e-8c8e-005f13d9f668', 'Vital de Oliveira') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), 'df9b40ad-2676-4fb0-97b5-db1c2d322c78', 'Caravelas') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '94d716d0-7d09-4387-baf2-2797e93a614c', 'SSN9') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '726dd9a2-b030-4ad7-ab94-0eea11522f66', 'SSN2') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), 'b31059a4-f8a3-4d32-a78b-8f8a905f4199', 'GNHO') ON CONFLICT DO NOTHING;
INSERT INTO weather.om (created_at, updated_at, id, name) VALUES (NOW(), NOW(), '6c9e268f-ebf3-420c-b70b-e47c6932f317', 'AvPqAspMoura') ON CONFLICT DO NOTHING;
