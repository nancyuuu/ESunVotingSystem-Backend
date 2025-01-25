SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS esun_vote DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE esun_vote;

CREATE TABLE vote_items (
  id int NOT NULL,
  item_name varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO vote_items (id, item_name) VALUES(6, 'mouse');
INSERT INTO vote_items (id, item_name) VALUES(14, 'mouse1');
INSERT INTO vote_items (id, item_name) VALUES(1, 'screen');

CREATE TABLE vote_records (
  id int NOT NULL,
  voter_name varchar(30) NOT NULL,
  vote_item int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO vote_records (id, voter_name, vote_item) VALUES(2, 'pl3w', 1);
INSERT INTO vote_records (id, voter_name, vote_item) VALUES(3, 'nancy', 1);
INSERT INTO vote_records (id, voter_name, vote_item) VALUES(5, 'PBW', 14);
INSERT INTO vote_records (id, voter_name, vote_item) VALUES(6, 'nancy', 14);
INSERT INTO vote_records (id, voter_name, vote_item) VALUES(8, 'PPP', 14);


ALTER TABLE vote_items
  ADD PRIMARY KEY (id),
  ADD UNIQUE KEY item_name (item_name);

ALTER TABLE vote_records
  ADD PRIMARY KEY (id),
  ADD KEY vote_item (vote_item);


ALTER TABLE vote_items
  MODIFY id int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

ALTER TABLE vote_records
  MODIFY id int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;


ALTER TABLE vote_records
  ADD CONSTRAINT vote_records_ibfk_1 FOREIGN KEY (vote_item) REFERENCES vote_items (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
