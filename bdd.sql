-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:3306
-- Généré le :  Mar 09 Juin 2015 à 15:06
-- Version du serveur :  5.5.38
-- Version de PHP :  5.5.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `cookme`
--

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id_recette` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date` date NOT NULL,
  `titre` varchar(25) NOT NULL,
  `contenu` text NOT NULL,
  `note` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `recette`
--

CREATE TABLE `recette` (
`id` int(11) NOT NULL,
  `preparation` int(11) NOT NULL,
  `difficulte` int(11) NOT NULL,
  `personnes` int(11) NOT NULL,
  `type` varchar(25) NOT NULL,
  `resume` varchar(100) NOT NULL,
  `procedure` text NOT NULL,
  `titre` varchar(50) NOT NULL,
  `img` varchar(250) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `recette`
--

INSERT INTO `recette` (`id`, `preparation`, `difficulte`, `personnes`, `type`, `resume`, `procedure`, `titre`, `img`) VALUES
(1, 5, 1, 1, 'salade', 'Salade cesar aux olives', 'Il faut salade\r\nOlive\r\nVinegrette', 'Salade Cesar du SUD', ''),
(2, 5, 3, 5, 'pates', 'Pates cesar aux olives', 'Il faut pates\r\nOlive\r\nVinegrette', 'Pates Cesar du SUD', ''),
(3, 5, 1, 1, 'salade', 'Pates cesar aux olives', 'Il faut pates\r\nOlive\r\nVinegrette', 'Pates Cesar du SUD', '');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `age` int(11) NOT NULL,
  `mail` varchar(70) NOT NULL,
  `login` varchar(25) NOT NULL,
  `pwd` varchar(25) NOT NULL,
`id` int(11) NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`firstname`, `lastname`, `age`, `mail`, `login`, `pwd`, `id`, `admin`) VALUES
('benj', 'lacroixx', 15, 'bb@c.fr', 'benobab2', 'benben', 13, 1),
('tristan', 'defour', 15, 'bbb@c.fr', 'titou', 'benben', 17, 0),
('tristan', 'defour', 15, 'bbb@c.fr', 'guiBraa', 'benben', 18, 0),
('bhjklh', 'khjb', 12, 'kugh@jfk.fr', 'Bena', 'be', 19, 0);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
 ADD PRIMARY KEY (`id_recette`,`id_user`), ADD KEY `FK_user` (`id_user`);

--
-- Index pour la table `recette`
--
ALTER TABLE `recette`
 ADD PRIMARY KEY (`id`), ADD KEY `id` (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`), ADD KEY `id` (`id`), ADD KEY `id_2` (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `recette`
--
ALTER TABLE `recette`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
ADD CONSTRAINT `FK_recette` FOREIGN KEY (`id_recette`) REFERENCES `recette` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `FK_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
