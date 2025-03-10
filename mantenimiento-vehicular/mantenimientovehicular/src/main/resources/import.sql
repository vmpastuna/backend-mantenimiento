--Vehiculos
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(1,'PAX-453','AVENTADOR LP 780-4 ULTIMAE','Negro','Lamborghini');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(2,'APF-645','JOY HB BLACK','Rojo','chevrolet');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(3,'TYA-234','CERATO','Plomo','Kia');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(4,'JYT-567','MOMENTUMDESDE','NEGRO','Wolwo');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES (5,'PMT-654','812 GTS','Plomo','Ferrari');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(6,'AYE-809','RIO-5','blanco','Kia');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(7,'TDS-546','DB11','blanco','Aston Martin');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(8,'PDA-345','ONIX TURNO SEDAN','NEGRO','Chevrolet');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(9,'RTX-245','A4TFSI','Azul','Audi');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(10,'PAT-234','SCAPE ASE2','NEGRO','Ford');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(11,'RTX-245','SPORTS2','NEGRO','Jac');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(12,'ABC-321','SLTDS15','NEGRO','Ram');
INSERT INTO TBL_VEHICULOS(id,PLACA,MODELO,COLOR,MARCA) VALUES(13,'RTX-245','A4TFSI','NEGRO','Audi');

--Mantenimientos 

INSERT INTO TBL_MANTENIMIENTOS(id,NOMBRE,FECHA_MANTENIMIENTO,PRECIO,TIPO,VEHICULO_ID) VALUES(1,'Cambio de aceite','2022-04-23',30.00,"Mantenimiento Preventivo",1);
INSERT INTO TBL_MANTENIMIENTOS(id,NOMBRE,FECHA_MANTENIMIENTO,PRECIO,TIPO,VEHICULO_ID) VALUES(2,'Presion de llantas','2022-06-01',25.00,"Mantenimiento Preventivo",1);
INSERT INTO TBL_MANTENIMIENTOS(id,NOMBRE,FECHA_MANTENIMIENTO,PRECIO,TIPO,VEHICULO_ID) VALUES(3,'Revision Filtro de Aire','2022-08-01',60.00,"Mantenimiento Preventivo",1);
INSERT INTO TBL_MANTENIMIENTOS(id,NOMBRE,FECHA_MANTENIMIENTO,PRECIO,TIPO,VEHICULO_ID) VALUES(4,'Arreglo de Suspencion','2022-02-25',80.00,"Mantenimiento Correctivo",1);
INSERT INTO TBL_MANTENIMIENTOS(id,NOMBRE,FECHA_MANTENIMIENTO,PRECIO,TIPO,VEHICULO_ID) VALUES(5,'Corrección de Motor','2022-07-16',150.00,"Mantenimiento Correctivo",1);
INSERT INTO TBL_MANTENIMIENTOS(id,NOMBRE,FECHA_MANTENIMIENTO,PRECIO,TIPO,VEHICULO_ID) VALUES(6,'Cambio de aceite','2022-04-23',30.00,"Mantenimiento Preventivo",2);
INSERT INTO TBL_MANTENIMIENTOS(id,NOMBRE,FECHA_MANTENIMIENTO,PRECIO,TIPO,VEHICULO_ID) VALUES(7,'Revision Filtro de Aire','2022-06-24',30.00,"Mantenimiento Preventivo",3);
INSERT INTO TBL_MANTENIMIENTOS(id,NOMBRE,FECHA_MANTENIMIENTO,PRECIO,TIPO,VEHICULO_ID) VALUES(8,'Cambio de llantas','2022-03-01',60.00,"Mantenimiento Correctivo",3);
INSERT INTO TBL_MANTENIMIENTOS(id,NOMBRE,FECHA_MANTENIMIENTO,PRECIO,TIPO,VEHICULO_ID) VALUES(9,'Correccion de Motor','2022-03-01',60.00,"Mantenimiento Correctivo",2);
INSERT INTO TBL_MANTENIMIENTOS(id,NOMBRE,FECHA_MANTENIMIENTO,PRECIO,TIPO,VEHICULO_ID) VALUES(10,'Cambio de llantas','2022-03-01',60.00,"Mantenimiento Correctivo",2);



--Repuesto

INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(1,"Aceite Motor","Repuesto Original","Ninguna",1,1);
INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(2,"Kit Bandas","Repuesto Original","Ninguna",1,1);
INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(3,"Llantas Michellin","Repuesto Original","Ninguna",1,1);
INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(4,"Aceite Motor","Repuesto Original","Ninguna",1,2);
INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(5,"Kit Bandas","Repuesto Original","Ninguna",1,2);
INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(6,"Llantas Michellin","Repuesto Original","Ninguna",1,2);
INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(7,"Aceite Motor","Repuesto Original","Ninguna",1,3);
INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(8,"Kit Bandas","Repuesto Original","Ninguna",1,3);
INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(9,"Llantas Michellin","Repuesto Original","Ninguna",1,3);
INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(10,"Aceite Motor","Repuesto Original","Ninguna",1,3);
INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(11,"Kit Bandas","Repuesto Original","Ninguna",1,4);
INSERT INTO TBL_REPUESTOS(id,NOMBRE,TIPO,DESCRIPCION,CANTIDAD,VEHICULO_ID) VALUES(12,"Llantas Michellin","Repuesto Original","Ninguna",1,4);



--USUARIO
--Gerente_taller

INSERT INTO TBL_USERS(ID,NAMES,PASSWORDS,ENABLEDS) VALUES (1, 'Vanesa','$2a$10$BpB82hDSOJ.fDPimyUWYZea0BZtfEgXxVSmiX9ajX7cVCBy5fu2uK', 1);
--ROLES

INSERT INTO TBL_ROLES(ID, ROLES, USER_ID) VALUES (1, 'ROLE_GERENTE', 1); 
INSERT INTO TBL_ROLES(ID, ROLES, USER_ID) VALUES (2, 'ROLE_CLIENTE', 1);
INSERT INTO TBL_ROLES(ID, ROLES, USER_ID) VALUES (3, 'ROLE_CLIENTE', 2);
INSERT INTO TBL_ROLES(ID, ROLES, USER_ID) VALUES (4, 'ROLE_CLIENTE', 3);
