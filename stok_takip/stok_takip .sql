-- phpMyAdmin SQL Dump

-- version 4.7.4

-- https://www.phpmyadmin.net/

--
-- Anamakine: 127.0.0.1

-- Üretim Zamanı: 02 Nis 2018, 15:46:16

-- Sunucu sürümü: 10.1.28-MariaDB

-- PHP Sürümü: 7.0.25

SET 
SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

SET AUTOCOMMIT = 0;
START TRANSACTION;

SET time_zone = "+00:00";



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;

/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;

/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;

/*!40101 SET NAMES utf8mb4 */;


--
-- Veritabanı: `stok_takip`
--

-- --------------------------------------------------------

--

-- Tablo için tablo yapısı `araba`

--

CREATE TABLE `araba` (
  
	`araba_modeli` varchar(32) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`araba_markasi` varchar(32) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`araba_ulkesi` varchar(32) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`uretim_yili` int(10) 
UNSIGNED NOT NULL,
  
	`motor_no` varchar(32) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`sase_numarasi` varchar(32) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`araba_kopya_sayisi` int(10) 
UNSIGNED NOT NULL,
  
	`kiralama` tinyint(1) NOT NULL
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


--
-- Tablo döküm verisi `araba`

--

INSERT INTO `araba` (`araba_modeli`, `araba_markasi`, `araba_ulkesi`, `uretim_yili`, `motor_no`, `sase_numarasi`, `araba_kopya_sayisi`, `kiralama`) 
VALUES
('partner_tepee', 'peugeot', 'fransa', 2016, '123456789', '567K02016', 0, 0),

('i30', 'hyundai', 'kore', 2016, '134679852', '798K02016', 0, 0),

('efqe', 'ewf', 'twet', 2001, '163987452', '874K02001', 0, 0),

('djhhfk', 'fee', 'get', 2001, '4952652984694', '652K02001', 0, 0),

('C200d', 'Mercedes', 'Almanya', 2015, '9719755100418', '971K02016', 3, 0),

('transporter', 'wolksvagen', 'Almanya', 2003, '987654321', '543K02003', 0, 0);


-- --------------------------------------------------------

--

-- Tablo için tablo yapısı `kisi`

--

CREATE TABLE `kisi` (
  
	`TC_no` varchar(16) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`kisi_adi` varchar(16) 
CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,

	`kisi_soyadi` varchar(16) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`mail` varchar(32) CHARACTER SET utf16 
COLLATE utf16_unicode_ci NOT NULL,
  
	`alis_tarihi` varchar(16) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`donus_tarihi` varchar(16) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`alinan_araba` varchar(32) 
COLLATE utf8_unicode_ci NOT NULL
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8 
COLLATE=utf8_unicode_ci;


--
-- Tablo döküm verisi `kisi`

--

INSERT INTO `kisi` (`TC_no`, `kisi_adi`, `kisi_soyadi`, `mail`, `alis_tarihi`, `donus_tarihi`, `alinan_araba`) 
VALUES
('', 'rqewr', 't4t4t', '34y', '0', '0', '0'),

('123456', 'Kübra', 'Güven', 'kübra@gmail.com', '0', '0', '0'),

('12369874', 'Aliye', 'Ertürk', 'aliye@gmail.com', '0', '0', '0'),

('159632478', 'Yavuz', 'Öndağ', 'yavuz@gmail.com', '0', '0', '0'),

('27823445634', 'Ayşe', 'Alyanak', 'ayse@gmail.com', '0', '0', '0'),

('28606164216', 'Eda', 'Uysal', 'eda@gmail.com', '0', '0', '0'),

('ryh', 'rqewr', 't4t4t', '', '0', '0', '0');


-- --------------------------------------------------------

--

-- Tablo için tablo yapısı `personel`

--

CREATE TABLE `personel` (
  
	`TC_no` varchar(16) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`sicil_no` varchar(16) 
COLLATE utf8_unicode_ci NOT NULL,
 
	`personel_adi` varchar(16) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`personel_soyadi` varchar(16) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`personel_unvani` varchar(32) 
COLLATE utf8_unicode_ci NOT NULL,
  
	`personel_sifre` varchar(16) 
COLLATE utf8_unicode_ci NOT NULL
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8 
COLLATE=utf8_unicode_ci;


--
-- Tablo döküm verisi `personel`

--

INSERT INTO `personel` (`TC_no`, `sicil_no`, `personel_adi`, `personel_soyadi`, `personel_unvani`, `personel_sifre`) 
VALUES
('27823445634', '123456', 'Melike', 'Aydemir', 'Mühendis', '123456'),

('14789632', '147896100', 'Aybüke', 'Aydoğan', 'Gçrevli', '14789632');


--
-- Dökümü yapılmış tablolar için indeksler

--

--
-- Tablo için indeksler `araba`

--
ALTER TABLE `araba`
  
ADD PRIMARY KEY (`motor_no`),
  
ADD UNIQUE KEY `barkod` (`sase_numarasi`);


--
-- Tablo için indeksler `kisi`

--
ALTER TABLE `kisi`
  
ADD PRIMARY KEY (`TC_no`),
  
ADD UNIQUE KEY `mail` (`mail`);


--
-- Tablo için indeksler `personel`

--
ALTER TABLE `personel`
  
ADD PRIMARY KEY (`sicil_no`),
  
ADD UNIQUE KEY `TC_no` (`TC_no`);

COMMIT;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;

/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
