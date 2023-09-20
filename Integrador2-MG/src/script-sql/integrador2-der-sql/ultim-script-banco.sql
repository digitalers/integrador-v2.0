
CREATE TABLE IF NOT EXISTS `banco`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(45) NULL DEFAULT NULL,
  `nombre` VARCHAR(55) NULL DEFAULT NULL,
  `apellido` VARCHAR(55) NULL DEFAULT NULL,
  `calle` VARCHAR(45) NULL DEFAULT NULL,
  `altura` INT NULL DEFAULT NULL,
  `barrio` VARCHAR(150) NULL DEFAULT NULL,
  `ciudad` VARCHAR(45) NULL DEFAULT NULL,
  `provincia` VARCHAR(45) NULL DEFAULT NULL,
  `codigo_postal` VARCHAR(20) NULL DEFAULT NULL,
  `email` VARCHAR(150) NULL DEFAULT NULL,
  `telefono` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idcliente`));
  
  CREATE TABLE IF NOT EXISTS `banco`.`cuenta` (
  `idcuenta` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `saldo` DOUBLE NULL DEFAULT NULL,
  `tipo_cuenta` ENUM('cuenta_ahorro', 'cuenta_corriente') NULL DEFAULT NULL,
  `interes` INT NULL DEFAULT NULL,
  `limite_descub` INT NULL DEFAULT NULL,
  INDEX `fk_cuenta_cliente_idx` (`cliente_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_cuenta_cliente`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `banco`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `banco`.`transacciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco`.`transacciones` (
  `idtransacciones` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `tipo_transaccion` ENUM('deposito', 'extraccion') NULL DEFAULT NULL,
  `fecha_y_hora` DATETIME NULL DEFAULT NULL,
  `monto` FLOAT NULL DEFAULT NULL,
  `cuenta_origen` INT NULL DEFAULT NULL,
  `cuenta_destino` INT NULL DEFAULT NULL,
  `cuenta_idcuenta` INT NOT NULL,
  INDEX `fk_transacciones_cuenta1_idx` (`cuenta_idcuenta` ASC, `cuenta_cliente_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_transacciones_cuenta1`
    FOREIGN KEY (`cuenta_idcuenta` , `cuenta_cliente_idcliente`)
    REFERENCES `banco`.`cuenta` (`idcuenta` , `cliente_idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDBcuenta
DEFAULT CHARACTER SET = utf8mb3;
