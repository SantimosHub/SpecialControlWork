-- В подключенном MySQL репозитории создать базу данных “Друзья человека”.
CREATE DATABASE mans_friends;

USE mans_friends;

-- Создать таблицы с иерархией из диаграммы в БД.

CREATE TABLE animals_purposes (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	purpose VARCHAR(50) NOT NULL UNIQUE
);

INSERT
	INTO
	animals_purposes (purpose)
VALUES
	('domestic_animal'),
	('pack_animal');

CREATE TABLE animals_specieses (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	species VARCHAR(50) NOT NULL UNIQUE
);

INSERT
	INTO
	animals_specieses (species)
VALUES
	('cat'),
	('dog'),
	('hamster'),
	('horse'),
	('camel'),
	('donkey');


CREATE TABLE animals (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	purpose BIGINT UNSIGNED,
	species BIGINT UNSIGNED,
	name VARCHAR(50),
	date_of_birth DATE,
	
	FOREIGN KEY (purpose) REFERENCES animals_purposes(id),
	FOREIGN KEY (species) REFERENCES animals_specieses(id)
);

CREATE TABLE commands (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal BIGINT UNSIGNED,
	name VARCHAR(50),
	
	FOREIGN KEY (animal) REFERENCES animals(id)
);


CREATE VIEW cats AS
SELECT
	a.id,
	a.name,
	a.date_of_birth,
	a.purpose
FROM animals a
WHERE a.species = 1;

CREATE VIEW dogs AS
SELECT
	a.id,
	a.name,
	a.date_of_birth,
	a.purpose
FROM animals a
WHERE a.species = 2;

CREATE VIEW hamsters AS
SELECT
	a.id,
	a.name,
	a.date_of_birth,
	a.purpose
FROM animals a
WHERE a.species = 3;

CREATE VIEW horses AS
SELECT
	a.id,
	a.name,
	a.date_of_birth,
	a.purpose
FROM animals a
WHERE a.species = 4;

CREATE VIEW camels AS
SELECT
	a.id,
	a.name,
	a.date_of_birth,
	a.purpose
FROM animals a
WHERE a.species = 5;

CREATE VIEW donkeys AS
SELECT
	a.id,
	a.name,
	a.date_of_birth,
	a.purpose
FROM animals a
WHERE a.species = 6;

-- Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения.

INSERT INTO animals (purpose, species, name, date_of_birth)
VALUES
	(1, 1, 'Sonya', '2022-05-28'),
	(1, 1, 'Frosya', '2008-02-20'),
	(1, 1, 'Mursik', '2021-12-22'),
	(1, 1, 'Barsik', '2020-04-15'),
	(1, 1, 'Pechenyushka', '2023-01-29'),
	(1, 1, 'Prohor', '2020-01-10'),
	(1, 1, 'Barsik', '2023-04-23'),
	(1, 2, 'Sharik', '2009-03-23'),
	(1, 2, 'Tobik', '2022-09-29'),
	(1, 2, 'Tika', '2021-08-17'),
	(1, 2, 'Zhuzha', '2019-08-01'),
	(1, 2, 'Lyusya', '2018-05-05'),
	(1, 2, 'Bax', '2023-02-24'),
	(1, 2, 'Lars', '2020-03-20'),
	(1, 3, 'Gosha', '2023-01-23'),
	(1, 3, 'Petya', '2022-12-12'),
	(2, 4, 'Luch', '2005-05-05'),
	(2, 4, 'Kazbek', '2000-05-03'),
	(2, 4, 'Seryy', '2022-12-01'),
	(2, 5, 'Zhorik', '2011-02-20'),
	(2, 5, 'Senya', '2015-04-30'),
	(2, 5, 'Igor', '2018-10-20'),
	(2, 6, 'Lahmatyy', '2012-12-12'),
	(2, 6, 'Ushastyy', '2021-11-04'),
	(2, 6, 'Plyusha', '2019-09-15'),
	(2, 6, 'Hrumka', '2000-07-05');

INSERT INTO commands (animal, name)
VALUES
	(1, 'eat'),
	(8, 'sit'),
	(8, 'run'),
	(9, 'sit'),
	(9, 'run'),
	(9, 'lie'),
	(10, 'sit'),
	(10, 'lie'),
	(12, 'sit'),
	(12, 'run'),
	(12, 'lie'),
	(14, 'sit'),
	(14, 'jump'),
	(16, 'sit'),
	(16, 'run'),
	(20, 'sit'),
	(20, 'run'),
	(22, 'jump'),
	(22, 'sit'),
	(22, 'run');

-- Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

DELETE commands
FROM commands 
JOIN animals ON
commands.animal = animals.id
WHERE animals.species = 5;

DELETE animals
FROM animals 
WHERE animals.species = 5;

CREATE VIEW horses_and_donkeys AS
SELECT * FROM horses
UNION
SELECT * FROM donkeys;

-- Создать новую таблицу «молодые животные» в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице.

CREATE VIEW young_animals AS
SELECT 
	a.id, a.name,
	a.date_of_birth,
	CONCAT
        (
            FLOOR((TIMESTAMPDIFF(MONTH, a.date_of_birth, CURDATE()) / 12)), ' years ',
            MOD(TIMESTAMPDIFF(MONTH, a.date_of_birth, CURDATE()), 12) , ' months'
        ) AS age
FROM animals a
WHERE
	a.date_of_birth + INTERVAL 3 YEAR > CURRENT_DATE()
	AND a.date_of_birth + INTERVAL 1 YEAR < CURRENT_DATE();

-- Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

SELECT * FROM animals; -- У меня изначально есть единая таблица animals.