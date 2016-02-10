/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.6.24 : Database - ta_nita
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ta_nita` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ta_nita`;

/*Table structure for table `barang` */

DROP TABLE IF EXISTS `barang`;

CREATE TABLE `barang` (
  `id_barang` varchar(30) NOT NULL,
  `nama_barang` varchar(30) DEFAULT NULL,
  `satuan` varchar(30) DEFAULT NULL,
  `Spesifikasi` text,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `barang` */

insert  into `barang`(`id_barang`,`nama_barang`,`satuan`,`Spesifikasi`) values ('BRG0001','Pena','PCS','Warna hitam'),('BRG0002','Pensil','PAK','Diameter 5mm'),('BRG0003','A4 Kertas','RIM','ukuran 80 gr'),('BRG0004','Spidol','PCS','Warna Merah');

/*Table structure for table `dapartemen` */

DROP TABLE IF EXISTS `dapartemen`;

CREATE TABLE `dapartemen` (
  `id_dapartement` varchar(30) NOT NULL,
  `nama_dapartement` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_dapartement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dapartemen` */

insert  into `dapartemen`(`id_dapartement`,`nama_dapartement`) values ('Dep01','Dep Keuangan'),('Dep02','Dep Operasiona'),('Dep03','Dep Humaniora'),('Dep04','Dep Oper'),('Dep05','Dep Marketing');

/*Table structure for table `opb` */

DROP TABLE IF EXISTS `opb`;

CREATE TABLE `opb` (
  `id_opb` varchar(30) NOT NULL,
  `id_dapartement` varchar(30) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `Keterangan` text,
  PRIMARY KEY (`id_opb`),
  KEY `id_dapartement` (`id_dapartement`),
  CONSTRAINT `opb_ibfk_1` FOREIGN KEY (`id_dapartement`) REFERENCES `dapartemen` (`id_dapartement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `opb` */

insert  into `opb`(`id_opb`,`id_dapartement`,`tanggal`,`Keterangan`) values ('0PB001','Dep02','2016-01-01','OPERASI'),('opb0001','Dep01','2016-01-21','Untuk barang'),('OPB001','Dep01','2016-01-01','KEBUTUHAN PRODUKSI');

/*Table structure for table `ppb` */

DROP TABLE IF EXISTS `ppb`;

CREATE TABLE `ppb` (
  `id_ppb` varchar(30) NOT NULL,
  `tanggalppb` date DEFAULT NULL,
  `Keterangan` text,
  PRIMARY KEY (`id_ppb`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ppb` */

insert  into `ppb`(`id_ppb`,`tanggalppb`,`Keterangan`) values ('PPB-0001','2016-01-01','DGBJH'),('PPB-0002','2016-01-21','Hariini juga');

/*Table structure for table `transk_barang` */

DROP TABLE IF EXISTS `transk_barang`;

CREATE TABLE `transk_barang` (
  `id_transk` int(11) NOT NULL AUTO_INCREMENT,
  `id_barang` varchar(30) DEFAULT NULL,
  `id_opb` varchar(30) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_transk`),
  KEY `id_opb` (`id_opb`),
  KEY `id_barang` (`id_barang`),
  CONSTRAINT `transk_barang_ibfk_1` FOREIGN KEY (`id_opb`) REFERENCES `opb` (`id_opb`),
  CONSTRAINT `transk_barang_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `transk_barang` */

insert  into `transk_barang`(`id_transk`,`id_barang`,`id_opb`,`jumlah`) values (1,'BRG0001','OPB001',3),(2,'BRG0001','0PB001',4),(3,'BRG0001','opb0001',100);

/*Table structure for table `trnsk_opb` */

DROP TABLE IF EXISTS `trnsk_opb`;

CREATE TABLE `trnsk_opb` (
  `id_transkopb` int(11) NOT NULL AUTO_INCREMENT,
  `id_opb` varchar(30) DEFAULT NULL,
  `id_ppb` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_transkopb`),
  KEY `id_ppb` (`id_ppb`),
  KEY `id_opb` (`id_opb`),
  CONSTRAINT `trnsk_opb_ibfk_2` FOREIGN KEY (`id_ppb`) REFERENCES `ppb` (`id_ppb`),
  CONSTRAINT `trnsk_opb_ibfk_3` FOREIGN KEY (`id_opb`) REFERENCES `opb` (`id_opb`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `trnsk_opb` */

insert  into `trnsk_opb`(`id_transkopb`,`id_opb`,`id_ppb`) values (1,'OPB001','PPB-0001'),(2,'opb0001','PPB-0002'),(3,'OPB001','PPB-0002');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(30) DEFAULT NULL,
  `Password` varchar(30) DEFAULT NULL,
  `User` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`idUser`,`Username`,`Password`,`User`) values (2,'Nita','Nita','Logistik'),(3,'Admin','Admin','Administrator'),(4,'xx','xx','Logistik');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
