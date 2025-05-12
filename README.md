# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: {Farhandhika Nurrohman}</li>
  <li>NIM: {23552011203}</li>
  <li>Studi Kasus: {Sistem Todo List Fullstack (Spring Boot + Thymeleaf)}</li>
</ul>

## Judul Studi Kasus
<p>Sistem Todo List Fullstack (Spring Boot + Thymeleaf)</p>

## Penjelasan Studi Kasus
<p>Pada proyek ini, saya membuat sebuah aplikasi To-Do List berbasis web menggunakan Spring Boot dan Thymeleaf. Aplikasi ini memungkinkan pengguna untuk mendaftar, login, kemudian dapat menambahkan tugas, mengedit, menghapus, atau menandai tugas sebagai selesai. Setiap tugas hanya bisa dilihat oleh user yang membuatnya. Data pengguna dan tugas tersimpan dalam database MySQL, dan untuk keamanan aplikasi, saya menggunakan Spring Security sebagai sistem autentikasi.</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Dalam aplikasi ini, konsep inheritance saya terapkan saat membuat class `UserDetailsServiceImpl` yang mewarisi interface bawaan dari Spring, yaitu `UserDetailsService`. Dengan pewarisan ini, saya bisa menyesuaikan cara Spring mengambil data pengguna dari database.</p>

### 2. Encapsulation
<p>Semua atribut dalam class model seperti User dan ToDo saya set sebagai private, kemudian akses dan perubahan datanya hanya bisa dilakukan melalui getter dan setter. Hal ini menjaga agar data tetap aman dan terkontrol.</p>

### 3. Polymorphism
<p>Polimorfisme saya gunakan saat method menerima tipe interface atau superclass, tapi objek yang digunakan bisa dari subclass-nya. Misalnya saat service menggunakan interface UserDetailsService, namun implementasinya adalah UserDetailsServiceImpl. Selain itu, penggunaan lambda dengan Optional.ifPresent() juga menunjukkan fleksibilitas pemanggilan fungsi.</p>

### 4. Abstract
<p>Konsep abstraksi saya terapkan dengan membuat service layer, seperti ToDoService, yang menyembunyikan detail implementasi dari akses database. Jadi, di controller saya hanya cukup memanggil method seperti saveTodo() tanpa perlu tahu bagaimana data itu diproses di dalamnya.</p>

## Demo Proyek
<ul>
  <li>Github: <a href="">Github</a></li>
  <li>Google Drive: <a href="">https://drive.google.com/drive/folders/1A8ZO1xfPjAxBKTMXkcIEu_DSsnIzoAtZ?usp=sharing</a></li>
</ul>
