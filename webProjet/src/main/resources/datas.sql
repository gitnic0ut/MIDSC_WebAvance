INSERT INTO Users (id, user_name, display_name, password, email, date_inscription) VALUES (1, 'admin', 'admin', '$2a$10$bpNMKeaQXKpJ4JVxOHWvu.tZdmCLT9nKcZreJ/ELfCgmTCyhC7GPy', 'nicolas.trotta@univ.fr', Cast('2019-10-30T11:25' as datetime));
INSERT INTO Users (id, user_name, display_name, password, email, date_inscription) VALUES (2, 'user', 'user', '$2a$10$TA.UfUqLa8uDeGkt95FfLeq7T5Y5vpDpzAtvJrHSLzLliY/PARXUq', 'user.user@sfr.fr', Cast('2018-10-30T11:25' as datetime));

INSERT INTO Projet (id, NB_MEMBER) VALUES (20, 1);