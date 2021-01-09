package com.example.moviecatalogue.utils

import com.example.moviecatalogue.data.FilmEntity
import com.example.moviecatalogue.data.GenreEntity

object DataDummy {
    fun generateDummyMovies(): List<FilmEntity> {
        val movies = ArrayList<FilmEntity>()

        movies.add(FilmEntity("m1",
        "A Star Is Born",
        "Rilis",
        "Inggris",
        "05/10/2018",
        "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"))
        movies.add(FilmEntity("m2",
        "Alita: Battle Angel",
        "Rilis",
        "Inggris",
        "14/02/2019",
        "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg"))
        movies.add(FilmEntity("m3",
        "Aquaman",
        "Rilis",
        "Inggris",
        "21/12/2018",
        "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg"))
        movies.add(FilmEntity("m4",
        "Bohemian Rhapsody",
        "Rilis",
        "Inggris",
        "02/11/2018",
        "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"))
        movies.add(FilmEntity("m5",
        "Cold Pursuit",
        "Rilis",
        "Inggris",
        "08/02/2019",
        "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/cO802woIgZsLbOWPUSsleobKyDp.jpg"))
        movies.add(FilmEntity("m6",
        "Creed",
        "Rilis",
        "Inggris",
        "25/11/2015",
        "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg"))
        movies.add(FilmEntity("m7",
        "Fantastic Beasts: The Crimes of Grindelwald",
        "Rilis",
        "Inggris",
        "11/16/2018",
        "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"))
        movies.add(FilmEntity("m8",
        "Glass",
        "Rilis",
        "Inggris",
        "01/18/2019",
        "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg"))
        movies.add(FilmEntity("m9",
        "How to Train Your Dragon: The Hidden World",
        "Rilis",
        "Inggris",
        "02/22/2019",
        "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"))
        movies.add(FilmEntity("m10",
        "Avengers: Infinity War",
        "Rilis",
        "Inggris",
        "04/27/2018",
        "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"))


        return movies
    }

    fun generateDummyTVShows(): List<FilmEntity> {
        val shows = ArrayList<FilmEntity>()

        shows.add(FilmEntity("t1",
                "Doom Patrol",
                "Berlanjut",
                "Inggris",
                "2019",
                "Anggota Doom Patrol masing-masing mengalami kecelakaan mengerikan yang memberi mereka kemampuan super - tapi juga membuat mereka terluka dan cacat. Trauma dan tertindas, tim menemukan tujuan melalui The Chief, yang mengumpulkan mereka untuk menyelidiki fenomena paling aneh yang ada - dan untuk melindungi Bumi dari apa yang mereka temukan.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg"))
        shows.add(FilmEntity("t2",
                "Dragon Ball",
                "Berakhir",
                "Jepang",
                "1986",
                "Dahulu kala di pegunungan, seorang master pertempuran yang dikenal sebagai Gohan menemukan seorang bocah aneh yang ia beri nama Goku. Gohan membesarkannya dan melatih Goku dalam seni bela diri sampai dia mati. Bocah muda dan sangat kuat itu sendirian, tetapi mudah dikelola. Kemudian suatu hari, Goku bertemu dengan seorang gadis remaja bernama Bulma, yang pencariannya untuk bola naga membawanya ke rumah Goku. Bersama-sama, mereka berangkat untuk menemukan ketujuh bola naga dalam sebuah petualangan yang akan mengubah hidup Goku selamanya. Lihat bagaimana Goku bertemu teman-teman seumur hidupnya Bulma, Yamcha, Krillin, Master Roshi dan banyak lagi.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/6sMyV1KRpvnOTsry7ZUT0k2tDmk.jpg"))
        shows.add(FilmEntity("t3",
                "Fairy Tail",
                "Berakhir",
                "Jepang",
                "2009",
                "Lucy adalah seorang gadis berusia 17 tahun, yang ingin menjadi penyihir sejati. Suatu hari ketika mengunjungi Kota Harujion, dia bertemu dengan Natsu, seorang pemuda yang mudah sakit oleh semua jenis transportasi. Tapi Natsu bukan sembarang anak biasa, dia anggota salah satu serikat penyihir paling terkenal di dunia: Fairy Tail.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/r6SjKZSsVbdwVZhdutu4qvRe63c.jpg"))
        shows.add(FilmEntity("t4",
                "Family Guy",
                "Berlanjut",
                "Inggris",
                "1999",
                "Seri animasi animasi Freakin 'Sweet yang sakit, terpelintir, dan salah, menampilkan petualangan keluarga Griffin yang disfungsional. Peter yang kikuk dan Lois yang sudah lama menderita memiliki tiga anak. Stewie (bayi yang brilian tetapi sadis yang bertekad membunuh ibunya dan mengambil alih dunia), Meg (yang tertua, dan merupakan gadis yang paling tidak populer di kota) dan Chris (anak tengah, dia tidak terlalu cerdas tetapi memiliki hasrat untuk film ). Anggota terakhir keluarga itu adalah Brian - anjing yang bisa bicara dan lebih dari sekadar hewan peliharaan, ia menjaga Stewie, sementara menghirup Martinis dan memilah-milah masalah hidupnya sendiri.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/q3E71oY6qgAEiw6YZIHDlHSLwer.jpg"))
        shows.add(FilmEntity("t5",
                "The Flash",
                "Berlanjut",
                "Inggris",
                "2014",
                "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.\"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"))
        shows.add(FilmEntity("t6",
                "Gotham",
                "Berakhir",
                "Inggris",
                "2014",
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5tSHzkJ1HBnyGdcpr6wSyw7jYnJ.jpg"))
        shows.add(FilmEntity("t7",
                "Grey's Anatomy",
                "Berlanjut",
                "Inggris",
                "2005",
                "Ikuti kehidupan pribadi dan profesional sekelompok dokter di Rumah Sakit Gray Sloan Memorial di Seattle.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"))
        shows.add(FilmEntity("t8",
                "Hanna",
                "Berlanjut",
                "Inggris",
                "2019",
                "Film thriller dan drama coming-of-age ini mengikuti perjalanan seorang gadis muda yang luar biasa saat dia menghindari pengejaran tanpa henti dari agen CIA di luar buku dan mencoba untuk mengungkap kebenaran di balik siapa dia. Berdasarkan film Joe Wright 2011.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg"))
        shows.add(FilmEntity("t9",
                "Marvel's Iron Fist",
                "Dibatalkan",
                "Inggris",
                "2017",
                "Danny Rand muncul kembali 15 tahun setelah dianggap meninggal. Sekarang, dengan kekuatan Iron Fist, dia berusaha merebut kembali masa lalunya dan memenuhi takdirnya.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/rioMBKotMSu2lRIpGAaGRiDauAe.jpg"))
        shows.add(FilmEntity("t10",
                "Naruto Shippuden",
                "Berakhir",
                "Jepang",
                "2007",
                "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qOxedwaJzdms2alAmIEHEnDeDzg.jpg"))

        return shows
    }

    fun generateDummyGenres(filmId: String): List<GenreEntity> {
        val genres = ArrayList<GenreEntity>()

        genres.add(GenreEntity(
            "{$filmId}g1",
                filmId,
                "Aksi"
        ))
        genres.add(GenreEntity(
                "{$filmId}g2",
                filmId,
                "Petualangan"
        ))
        genres.add(GenreEntity(
                "{$filmId}g3",
                filmId,
                "Drama"
        ))
        genres.add(GenreEntity(
                "{$filmId}g3",
                filmId,
                "Fantasi"
        ))
        genres.add(GenreEntity(
                "{$filmId}g3",
                filmId,
                "Fiksi"
        ))

        return genres
    }
}