-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Jun 2024 pada 07.29
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pelanggaran_database`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `catatan_pelanggaran`
--

CREATE TABLE `catatan_pelanggaran` (
  `id` int(11) NOT NULL,
  `id_siswa` int(11) DEFAULT NULL,
  `id_pelanggaran` int(11) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `poin` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `catatan_pelanggaran`
--

INSERT INTO `catatan_pelanggaran` (`id`, `id_siswa`, `id_pelanggaran`, `keterangan`, `poin`) VALUES
(1, 1, 2, 'solobbb', 1),
(2, 1, 1, 'parah ni anak', 14),
(3, 3, 3, 'lalaalala', 2000),
(4, 2, 2, 'solob', 1),
(5, 2, 1, 'tidak bawa buku sesuai jadwal sesuai jadwal', 14),
(6, 2, 1, 'tidak bawa buku sesuai jadwal sesuai jadwal', 14),
(7, 2, 1, 'tidak bawa buku sesuai jadwal sesuai jadwal', 14),
(8, 2, 1, 'tidak bawa buku sesuai jadwal sesuai jadwal', 14),
(9, 2, 1, 'tidak bawa buku sesuai jadwal sesuai jadwal', 14),
(10, 2, 1, 'tidak bawa buku sesuai jadwal sesuai jadwal', 14),
(11, 2, 1, 'tidak bawa buku sesuai jadwal sesuai jadwal', 14),
(12, 2, 1, 'tidak bawa buku sesuai jadwal sesuai jadwal', 14),
(13, 2, 1, 'tidak bawa buku sesuai jadwal sesuai jadwal', 14),
(14, 2, 1, 'tidak bawa buku sesuai jadwal sesuai jadwal', 14),
(15, 2, 1, 'tidak bawa buku sesuai jadwal sesuai jadwal', 14),
(16, 2, 8, 'Terlambat Masuk Kelas', 20),
(17, 2, 8, 'Terlambat Masuk Kelas', 20),
(18, 2, 8, 'Terlambat Masuk Kelas', 20),
(19, 2, 8, 'Terlambat Masuk Kelas', 20),
(20, 2, 8, 'Terlambat Masuk Kelas', 20),
(21, 2, 8, 'Terlambat Masuk Kelas', 20),
(22, 2, 8, 'Terlambat Masuk Kelas', 20),
(23, 2, 8, 'Terlambat Masuk Kelas', 20),
(24, 2, 8, 'Terlambat Masuk Kelas', 20),
(25, 2, 8, 'Terlambat Masuk Kelas', 20),
(26, 2, 8, 'Terlambat Masuk Kelas', 20),
(27, 2, 8, 'Terlambat Masuk Kelas', 20),
(28, 2, 8, 'Terlambat Masuk Kelas', 20),
(29, 2, 8, 'Terlambat Masuk Kelas', 20),
(30, 2, 8, 'Terlambat Masuk Kelas', 20),
(31, 2, 8, 'Terlambat Masuk Kelas', 20),
(32, 2, 8, 'Terlambat Masuk Kelas', 20),
(33, 2, 9, 'Mencuri', 50),
(34, 2, 9, 'Mencuri', 50),
(35, 2, 9, 'Mencuri', 50),
(36, 2, 9, 'Mencuri', 50),
(37, 2, 9, 'Mencuri', 50),
(38, 3, 8, 'Terlambat Masuk Kelas', 20),
(39, 3, 8, 'Terlambat Masuk Kelas', 20),
(40, 3, 8, 'Terlambat Masuk Kelas', 20),
(41, 3, 8, 'Terlambat Masuk Kelas', 20),
(42, 3, 8, 'Terlambat Masuk Kelas', 20),
(43, 3, 8, 'Terlambat Masuk Kelas', 20),
(44, 3, 8, 'Terlambat Masuk Kelas', 20),
(45, 3, 8, 'Terlambat Masuk Kelas', 20),
(46, 3, 8, 'Terlambat Masuk Kelas', 20),
(47, 3, 8, 'Terlambat Masuk Kelas', 20);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggaran`
--

CREATE TABLE `pelanggaran` (
  `id` int(11) NOT NULL,
  `bentuk_pelanggaran` varchar(255) DEFAULT NULL,
  `kategori` varchar(255) DEFAULT NULL,
  `poin` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pelanggaran`
--

INSERT INTO `pelanggaran` (`id`, `bentuk_pelanggaran`, `kategori`, `poin`) VALUES
(8, 'Terlambat Masuk Kelas', 'Sedang', 20),
(9, 'Mencuri', 'Berat', 50);

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `kelas` varchar(255) DEFAULT NULL,
  `no_absen` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `siswa`
--

INSERT INTO `siswa` (`id`, `nama`, `kelas`, `no_absen`) VALUES
(1, 'Achmad Zafran Alysyam', 'Rekayasa Perangkat Lunak', 1),
(2, 'Adji Surwo Firmansyah', 'Rekayasa Perangkat Lunak', 2),
(3, 'Adrian Trinata ', 'Rekayasa Perangkat Lunak', 3);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `catatan_pelanggaran`
--
ALTER TABLE `catatan_pelanggaran`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pelanggaran`
--
ALTER TABLE `pelanggaran`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `catatan_pelanggaran`
--
ALTER TABLE `catatan_pelanggaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT untuk tabel `pelanggaran`
--
ALTER TABLE `pelanggaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `siswa`
--
ALTER TABLE `siswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
