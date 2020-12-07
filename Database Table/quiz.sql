-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2020 at 03:14 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quiz`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `question` varchar(30) NOT NULL,
  `answer` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`question`, `answer`) VALUES
('question-1', 'James Gosling'),
('question-2', 'Bjarne Stroustrup'),
('question-3', 'Guido van Rossum'),
('question-4', 'Cale Bruckner');

-- --------------------------------------------------------

--
-- Table structure for table `submittedanswer`
--

CREATE TABLE `submittedanswer` (
  `username` varchar(30) NOT NULL,
  `question` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `submittedanswer`
--

INSERT INTO `submittedanswer` (`username`, `question`) VALUES
('question-1', 'James Gosling'),
('question-2', 'Dennis Richie'),
('question-3', 'Guido van Rossum'),
('question-4', 'Cale Bruckner');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `submittedanswer`
--
ALTER TABLE `submittedanswer`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
