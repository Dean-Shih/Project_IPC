-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS mydb DEFAULT CHARACTER SET utf8 ;
USE mydb ;

-- -----------------------------------------------------
-- Table mydb.Usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.usuario (
  id_Usuario INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  email VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  score INT NOT NULL,
  PRIMARY KEY (id_Usuario),
  UNIQUE INDEX id_UNIQUE (id_Usuario ASC) VISIBLE,
  UNIQUE INDEX documento_UNIQUE (Cpf ASC) VISIBLE,
  UNIQUE INDEX telefone_UNIQUE (Telefone ASC) VISIBLE,
  UNIQUE INDEX email_UNIQUE (Email ASC) VISIBLE,
  UNIQUE INDEX senha_UNIQUE (Senha ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.Investimentos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.investimentos (
  id_Investimentos INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  valor INT NOT NULL,
  PRIMARY KEY (id_Investimentos))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.Relacao
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.relacao (
  id_Usuario INT NOT NULL,
  id_Investimento INT NOT NULL,
  INDEX FK_IdInvestimento_idx (id_Investimento ASC) VISIBLE,
  INDEX FK_IdUsuario_idx (id_Usuario ASC) VISIBLE,
  CONSTRAINT FK_IdInvestimentos
    FOREIGN KEY (id_Investimento)
    REFERENCES mydb.investimentos (id_Investimentos)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_IdUsuario
    FOREIGN KEY (id_Usuario)
    REFERENCES mydb.usuario (id_Usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;