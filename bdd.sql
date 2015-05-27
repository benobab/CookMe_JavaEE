-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:3306
-- Généré le :  Mer 27 Mai 2015 à 15:19
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
  `preparation` time NOT NULL,
  `difficulte` int(11) NOT NULL,
  `personnes` int(11) NOT NULL,
  `type` varchar(25) NOT NULL,
  `resume` varchar(100) NOT NULL,
  `procedure` text NOT NULL,
  `titre` varchar(50) NOT NULL,
  `img` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
`id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`firstname`, `lastname`, `age`, `mail`, `login`, `pwd`, `id`) VALUES
('benj', 'lacroixx', 15, 'bb@c.fr', 'benobab2', 'benben', 13),
('tristan', 'defour', 15, 'bbb@c.fr', 'titou', 'benben', 14),
('Guillaume', 'Bresil', 11, 'g@b.com', 'guiBra', 'bebn', 15),
('tristan', 'defour', 15, 'bbb@c.fr', 'titou', 'benben', 16),
('tristan', 'defour', 15, 'bbb@c.fr', 'titou', 'benben', 17),
('tristan', 'defour', 15, 'bbb@c.fr', 'guiBraa', 'benben', 18);

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
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
ADD CONSTRAINT `FK_recette` FOREIGN KEY (`id_recette`) REFERENCES `recette` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `FK_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
