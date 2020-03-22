-- dbtest.animals definition

CREATE TABLE `animals` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `origen` varchar(100) NOT NULL,
  `depredador` varchar(100) DEFAULT NULL,
  `dato_curioso` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
