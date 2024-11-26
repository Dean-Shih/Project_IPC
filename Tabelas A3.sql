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
CREATE TABLE IF NOT EXISTS mydb.Usuario (
  Id_Usuario INT NOT NULL AUTO_INCREMENT,
  Nome VARCHAR(45) NOT NULL,
  Cpf VARCHAR(11) NOT NULL,
  Telefone VARCHAR(11) NOT NULL,
  Email VARCHAR(45) NOT NULL,
  Senha VARCHAR(45) NOT NULL,
  Score INT NOT NULL,
  PRIMARY KEY (Id_Usuario),
  UNIQUE INDEX Id_UNIQUE (Id_Usuario ASC) VISIBLE,
  UNIQUE INDEX Documento_UNIQUE (Cpf ASC) VISIBLE,
  UNIQUE INDEX Telefone_UNIQUE (Telefone ASC) VISIBLE,
  UNIQUE INDEX Email_UNIQUE (Email ASC) VISIBLE,
  UNIQUE INDEX Senha_UNIQUE (Senha ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.Investimentos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.Investimentos (
  Id_Investimentos INT NOT NULL AUTO_INCREMENT,
  Nome VARCHAR(45) NOT NULL,
  Valor INT NOT NULL,
  PRIMARY KEY (Id_Investimentos))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.Relacao
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.Relacao (
  Id_Usuario INT NOT NULL,
  Id_Investimento INT NOT NULL,
  INDEX FK_IdInvestimento_idx (Id_Investimento ASC) VISIBLE,
  INDEX FK_IdUsuario_idx (Id_Usuario ASC) VISIBLE,
  CONSTRAINT FK_IdInvestimentos
    FOREIGN KEY (Id_Investimento)
    REFERENCES mydb.Investimentos (Id_Investimentos)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_IdUsuario
    FOREIGN KEY (Id_Usuario)
    REFERENCES mydb.Usuario (Id_Usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;