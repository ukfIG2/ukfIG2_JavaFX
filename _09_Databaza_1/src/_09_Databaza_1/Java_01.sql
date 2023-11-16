-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 16, 2023 at 11:53 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Java_01`
--

-- --------------------------------------------------------

--
-- Table structure for table `Tabulka_01`
--

CREATE TABLE `Tabulka_01` (
  `Id` int(11) NOT NULL,
  `Meno` varchar(20) NOT NULL,
  `Priezvisko` varchar(20) NOT NULL,
  `Popis_priestupku` text NOT NULL,
  `Datum` date NOT NULL,
  `Suma` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_slovak_ci;

--
-- Dumping data for table `Tabulka_01`
--

INSERT INTO `Tabulka_01` (`Id`, `Meno`, `Priezvisko`, `Popis_priestupku`, `Datum`, `Suma`) VALUES
(1, 'Fero', 'Mrkvicka', 'Vsetko pokazil', '2023-11-16', 555.222),
(2, 'Ivaan', 'Nejaky', 'Este horsie ako fero', '2023-11-15', 6666.56),
(3, 'Juro', 'ad', 'asdd', '2023-11-15', 55.55),
(5, 'kk', 'sfs', 'sdfsfsd', '2023-02-04', 55.5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Tabulka_01`
--
ALTER TABLE `Tabulka_01`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Tabulka_01`
--
ALTER TABLE `Tabulka_01`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
