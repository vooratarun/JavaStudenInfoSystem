-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2015 at 11:56 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `jana`
--

-- --------------------------------------------------------

--
-- Table structure for table `ai`
--
CREATE DATABASE jana;
use jana;

CREATE TABLE IF NOT EXISTS `ai` (
  `questions` varchar(80) NOT NULL,
  `answer` varchar(20) NOT NULL,
  `options` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ai`
--

INSERT INTO `ai` (`questions`, `answer`, `options`) VALUES
('Which of the following is/are the part of AI?', 'All', 'Machine Learning##Data Mining##Face Recognition##All'),
('Maximally-Specific hypothesis is also known as?', 'Find-S Algorithm', 'Find-S Algorithm##Candidate Elimination Algorithm##Version S');

-- --------------------------------------------------------

--
-- Table structure for table `cn`
--

CREATE TABLE IF NOT EXISTS `cn` (
  `questions` varchar(30) NOT NULL,
  `answer` varchar(10) NOT NULL,
  `options` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cn`
--

INSERT INTO `cn` (`questions`, `answer`, `options`) VALUES
('How many bits for IPV4', '32', '32##64##128##256'),
('How many bits for IPV6', '128', '32##64##128##256'),
('which one is Larger', 'WAN', 'LAN##WAN##MAN##NONE'),
('segments related to?', 'TPL', 'TPL##NL##DLL');

-- --------------------------------------------------------

--
-- Table structure for table `course_details`
--

CREATE TABLE IF NOT EXISTS `course_details` (
  `CourseName` varchar(20) DEFAULT NULL,
  `ExamDate` datetime DEFAULT NULL,
  `MarksGainded` int(11) DEFAULT NULL,
  `TotalMarks` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_details`
--

INSERT INTO `course_details` (`CourseName`, `ExamDate`, `MarksGainded`, `TotalMarks`, `status`) VALUES
('CN', '2015-12-03 15:00:00', 0, 5, 0),
('OOPS', '2015-12-04 09:00:00', 0, 5, 0),
('ITW', '2015-12-05 14:00:00', 0, 5, 0),
('AI', '2015-12-06 08:30:00', 0, 5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `course_registration`
--

CREATE TABLE IF NOT EXISTS `course_registration` (
  `iddno` varchar(10) NOT NULL DEFAULT '',
  `course` varchar(20) NOT NULL DEFAULT '',
  `marks` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`iddno`,`course`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_registration`
--

INSERT INTO `course_registration` (`iddno`, `course`, `marks`, `status`) VALUES
('', 'AI', 0, 0),
('', 'CN', 4, 1),
('', 'ITW', 0, 0),
('', 'OOPS', 2, 1),
('N091130', 'AI', 0, 0),
('N091130', 'CN', 3, 1),
('N091130', 'ITW', 0, 0),
('N091130', 'OOPS', 0, 0),
('N1000', 'AI', 0, 0),
('N1000', 'CN', 4, 1),
('N1000', 'ITW', 1, 1),
('N1000', 'OOPS', 0, 0),
('N100205', 'AI', 0, 0),
('N100205', 'CN', 3, 1),
('N100205', 'ITW', 1, 1),
('N100205', 'OOPS', 0, 0),
('N100210', 'AI', 0, 1),
('N100210', 'CN', 0, 0),
('N100210', 'ITW', 0, 0),
('N100210', 'OOPS', 0, 0),
('N100211', 'AI', 0, 0),
('N100211', 'CN', 2, 1),
('N100211', 'ITW', 0, 0),
('N100211', 'OOPS', 0, 0),
('N100212', 'AI', 0, 0),
('N100212', 'CN', 3, 1),
('N100212', 'ITW', 0, 0),
('N100212', 'OOPS', 0, 0),
('N100213', 'AI', 0, 1),
('N100213', 'CN', 3, 1),
('N100213', 'ITW', 1, 1),
('N100213', 'OOPS', 0, 1),
('N100269', 'AI', 0, 0),
('N100269', 'CN', 0, 0),
('N100269', 'ITW', 0, 0),
('N100269', 'OOPS', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `itw`
--

CREATE TABLE IF NOT EXISTS `itw` (
  `questions` varchar(80) NOT NULL,
  `options` varchar(80) NOT NULL,
  `answer` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itw`
--

INSERT INTO `itw` (`questions`, `options`, `answer`) VALUES
('MatLab developed by ?', 'mathworks##thoughtworks##google##microsoft', 'mathworks'),
('MatLab is which type of language?', 'Low level##High level##Assembly level##None', 'High level');

-- --------------------------------------------------------

--
-- Table structure for table `oops`
--

CREATE TABLE IF NOT EXISTS `oops` (
  `questions` varchar(80) NOT NULL,
  `options` varchar(80) NOT NULL,
  `answer` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oops`
--

INSERT INTO `oops` (`questions`, `options`, `answer`) VALUES
('Who developed java ?', 'Ritche##Gosling##Babbeg##jana', 'Gosling'),
('Odd man out?', 'encapsulation##interface##inheritance##abstration##polymorphism', 'interface'),
('Which of the following is the purely object oriented language?', 'Smalltalk##Simula##Java##C++', 'Simula');

-- --------------------------------------------------------

--
-- Table structure for table `sample`
--

CREATE TABLE IF NOT EXISTS `sample` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sample`
--

INSERT INTO `sample` (`id`, `name`) VALUES
(2, 'jana'),
(5, 'name'),
(3, 'ravi'),
(4, 'raju'),
(10, 'dummy'),
(11, 'sdflkj');

-- --------------------------------------------------------

--
-- Table structure for table `sampletest`
--

CREATE TABLE IF NOT EXISTS `sampletest` (
  `questions` varchar(200) DEFAULT NULL,
  `options` varchar(80) DEFAULT NULL,
  `answer` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sampletest`
--

INSERT INTO `sampletest` (`questions`, `options`, `answer`) VALUES
('2+3 = ??', '4##3##5##6', '5'),
('what is cap of india??', 'hyd##dil##kol##mb', 'dil'),
('who is CM of AP??', 'babu##kcr##modi##none', 'babu'),
('How many bits for IPV4', '32##64##128##256', '32'),
('How many bits for IPV6', '32##64##128##256', '128'),
('which one is Larger', 'LAN##WAN##MAN##NONE', 'MAN'),
('MatLab developed by ?', 'mathworks##thoughtworks##google##microsoft', 'mathworks');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE IF NOT EXISTS `user_details` (
  `idno` varchar(10) NOT NULL DEFAULT '',
  `name` varchar(20) DEFAULT NULL,
  `batch` varchar(3) DEFAULT NULL,
  `branch` varchar(5) DEFAULT NULL,
  `class` varchar(2) DEFAULT NULL,
  `dob` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `cnctno` varchar(13) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`idno`, `name`, `batch`, `branch`, `class`, `dob`, `email`, `cnctno`, `password`) VALUES
('N091130', 'sushanth', 'E4', 'CSE', '3', '11-10-2015', 'sushanth@gmail.com', '23456789121', 'rgukt123'),
('N1000', 'abx', 'E4', 'CSE', '2', 'sdf', 'sdfklj', '1234567890', '123'),
('N10000', 'sfd', 'E4', 'ECE', '1', 'sdfklj', 'sdflkj@gmail.com', '1245678910', 'rj'),
('N100099', 'khadar', 'E4', 'CSE', '2', '03-01-1995', 'shaikkhad@gmail.com', '1234567890', 'asdf'),
('N100205', 'mahesh', 'E4', 'CSE', '2', '10-10-2010', 'mahesh@gmail.com', '12345678910', 'mahesh'),
('N100210', 'vikas', 'E4', 'MECH', '3', '10-06-1995', 'vikas@gmail.com', '9876543210', 'vikas123'),
('N100211', 'Ganesh', 'E4', 'CSE', '1', '10-06-1995', 'ganesh@gmail.com', '9885660692', 'rgukt123'),
('N100212', 'vijay', 'E4', 'ECE', '1', '10-06-1995', 'vijay@gmail.com', '8888844888', 'rgu'),
('N100213', '', 'E4', 'ECE', '2', '10-06-1995', 'janardhan.553@gmail.', '8885880693', '1'),
('N100269', 'mahalaxmi', 'E4', 'CSE', '2', '10-5-1995', 'sample@gmail.com', '9871234560', 'rgu'),
('sdfkn', 'sdflkj', 'E4', 'CSE', '1', 'sdff', 'sdfdsf', '1234567890', 'sdf');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
