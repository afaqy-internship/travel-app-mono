-- Inserir voos
INSERT INTO tb_flight (from_airport, to_airport) VALUES ('GRU', 'MCO');
INSERT INTO tb_flight (from_airport, to_airport) VALUES ('GRU', 'MCO');
INSERT INTO tb_flight (from_airport, to_airport) VALUES ('GRU', 'JFK');
INSERT INTO tb_flight (from_airport, to_airport) VALUES ('GRU', 'ATL');
INSERT INTO tb_flight (from_airport, to_airport) VALUES ('GRU', 'MEX');

---- Inserir hotéis
INSERT INTO tb_hotel (nights) VALUES (5);
INSERT INTO tb_hotel (nights) VALUES (2);
INSERT INTO tb_hotel (nights) VALUES (3);
INSERT INTO tb_hotel (nights) VALUES (10);
INSERT INTO tb_hotel (nights) VALUES (30);

---- Inserir ordens
INSERT INTO tb_order (flight_id, hotel_id) VALUES (1, 1);
INSERT INTO tb_order (flight_id, hotel_id) VALUES (2, 2);
INSERT INTO tb_order (flight_id, hotel_id) VALUES (3, 3);
INSERT INTO tb_order (flight_id, hotel_id) VALUES (4, 4);
INSERT INTO tb_order (flight_id, hotel_id) VALUES (5, 5);
