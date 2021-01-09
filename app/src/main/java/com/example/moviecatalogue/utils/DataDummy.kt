package com.example.moviecatalogue.utils

import com.example.moviecatalogue.data.source.local.entity.FilmEntity
import com.example.moviecatalogue.data.source.local.entity.FilmWithGenre
import com.example.moviecatalogue.data.source.local.entity.GenreEntity
import com.example.moviecatalogue.data.source.remote.response.FilmResponse
import com.example.moviecatalogue.data.source.remote.response.GenreResponse

object DataDummy {
    fun generateDummyMovies(): List<FilmEntity> {
        val movies = ArrayList<FilmEntity>()

        movies.add(
            FilmEntity(
                11,
                "Gabriel's Inferno Part III",
                9.1,
                "2020-11-19",
                "en",
                "The final part of the film adaption of the erotic romance novel Gabriel's Inferno written by an anonymous Canadian author under the pen name Sylvain Reynard.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                0
            )
        )
        movies.add(
            FilmEntity(
                12,
                "Alita: Battle Angel",
                7.4,
                "Inggris",
                "14/02/2019",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                0
            )
        )
        movies.add(
            FilmEntity(
                13,
                "Aquaman",
                7.4,
                "Inggris",
                "21/12/2018",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                0

            )
        )
        movies.add(
            FilmEntity(
                14,
                "Bohemian Rhapsody",
                7.4,
                "Inggris",
                "02/11/2018",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                0
            )
        )
        movies.add(
            FilmEntity(
                15,
                "Cold Pursuit",
                7.4,
                "Inggris",
                "08/02/2019",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/cO802woIgZsLbOWPUSsleobKyDp.jpg",
                0
            )
        )
        movies.add(
            FilmEntity(
                16,
                "Creed",
                7.4,
                "Inggris",
                "25/11/2015",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg",
                0
            )
        )
        movies.add(
            FilmEntity(
                17,
                "Fantastic Beasts: The Crimes of Grindelwald",
                7.4,
                "Inggris",
                "11/16/2018",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                0
            )
        )
        movies.add(
            FilmEntity(
                18,
                "Glass",
                7.4,
                "Inggris",
                "01/18/2019",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                0
            )
        )
        movies.add(
            FilmEntity(
                19,
                "How to Train Your Dragon: The Hidden World",
                7.4,
                "Inggris",
                "02/22/2019",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                0
            )
        )
        movies.add(
            FilmEntity(
                110,
                "Avengers: Infinity War",
                7.4,
                "Inggris",
                "04/27/2018",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                0
            )
        )


        return movies
    }

    fun generateDummyTVShows(): List<FilmEntity> {
        val shows = ArrayList<FilmEntity>()

        shows.add(
            FilmEntity(
                21,
                "I Am Not an Animal",
                9.4,
                "2004-05-10",
                "en",
                "I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.",
                "https://image.tmdb.org/t/p/w500//qG59J1Q7rpBc1dvku4azbzcqo8h.jpg",
                1
            )
        )
        shows.add(
            FilmEntity(
                22,
                "Dragon Ball",
                7.4,
                "Jepang",
                "1986",
                "Dahulu kala di pegunungan, seorang master pertempuran yang dikenal sebagai Gohan menemukan seorang bocah aneh yang ia beri nama Goku. Gohan membesarkannya dan melatih Goku dalam seni bela diri sampai dia mati. Bocah muda dan sangat kuat itu sendirian, tetapi mudah dikelola. Kemudian suatu hari, Goku bertemu dengan seorang gadis remaja bernama Bulma, yang pencariannya untuk bola naga membawanya ke rumah Goku. Bersama-sama, mereka berangkat untuk menemukan ketujuh bola naga dalam sebuah petualangan yang akan mengubah hidup Goku selamanya. Lihat bagaimana Goku bertemu teman-teman seumur hidupnya Bulma, Yamcha, Krillin, Master Roshi dan banyak lagi.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/6sMyV1KRpvnOTsry7ZUT0k2tDmk.jpg",
                1
            )
        )
        shows.add(
            FilmEntity(
                23,
                "Fairy Tail",
                7.4,
                "Jepang",
                "2009",
                "Lucy adalah seorang gadis berusia 17 tahun, yang ingin menjadi penyihir sejati. Suatu hari ketika mengunjungi Kota Harujion, dia bertemu dengan Natsu, seorang pemuda yang mudah sakit oleh semua jenis transportasi. Tapi Natsu bukan sembarang anak biasa, dia anggota salah satu serikat penyihir paling terkenal di dunia: Fairy Tail.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/r6SjKZSsVbdwVZhdutu4qvRe63c.jpg",
                1
            )
        )
        shows.add(
            FilmEntity(
                24,
                "Family Guy",
                7.4,
                "Inggris",
                "1999",
                "Seri animasi animasi Freakin 'Sweet yang sakit, terpelintir, dan salah, menampilkan petualangan keluarga Griffin yang disfungsional. Peter yang kikuk dan Lois yang sudah lama menderita memiliki tiga anak. Stewie (bayi yang brilian tetapi sadis yang bertekad membunuh ibunya dan mengambil alih dunia), Meg (yang tertua, dan merupakan gadis yang paling tidak populer di kota) dan Chris (anak tengah, dia tidak terlalu cerdas tetapi memiliki hasrat untuk film ). Anggota terakhir keluarga itu adalah Brian - anjing yang bisa bicara dan lebih dari sekadar hewan peliharaan, ia menjaga Stewie, sementara menghirup Martinis dan memilah-milah masalah hidupnya sendiri.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/q3E71oY6qgAEiw6YZIHDlHSLwer.jpg",
                1
            )
        )
        shows.add(
            FilmEntity(
                25,
                "The Flash",
                7.4,
                "Inggris",
                "2014",
                "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.\"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                1
            )
        )
        shows.add(
            FilmEntity(
                26,
                "Gotham",
                7.4,
                "Inggris",
                "2014",
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5tSHzkJ1HBnyGdcpr6wSyw7jYnJ.jpg",
                1
            )
        )
        shows.add(
            FilmEntity(
                27,
                "Grey's Anatomy",
                7.4,
                "Inggris",
                "2005",
                "Ikuti kehidupan pribadi dan profesional sekelompok dokter di Rumah Sakit Gray Sloan Memorial di Seattle.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                1
            )
        )
        shows.add(
            FilmEntity(
                28,
                "Hanna",
                7.4,
                "Inggris",
                "2019",
                "Film thriller dan drama coming-of-age ini mengikuti perjalanan seorang gadis muda yang luar biasa saat dia menghindari pengejaran tanpa henti dari agen CIA di luar buku dan mencoba untuk mengungkap kebenaran di balik siapa dia. Berdasarkan film Joe Wright 2011.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
                1
            )
        )
        shows.add(
            FilmEntity(
                29,
                "Marvel's Iron Fist",
                7.4,
                "Inggris",
                "2017",
                "Danny Rand muncul kembali 15 tahun setelah dianggap meninggal. Sekarang, dengan kekuatan Iron Fist, dia berusaha merebut kembali masa lalunya dan memenuhi takdirnya.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/rioMBKotMSu2lRIpGAaGRiDauAe.jpg",
                1
            )
        )
        shows.add(
            FilmEntity(
                210,
                "Naruto Shippuden",
                7.4,
                "Jepang",
                "2007",
                "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qOxedwaJzdms2alAmIEHEnDeDzg.jpg",
                1
            )
        )

        return shows
    }

    fun generateDummyGenres(filmId: Int): List<GenreEntity> {
        val genres = ArrayList<GenreEntity>()

        genres.add(
            GenreEntity(
                1,
                31,
                filmId,
                "Aksi"
            )
        )
        genres.add(
            GenreEntity(
                2,
                32,
                filmId,
                "Petualangan"
            )
        )
        genres.add(
            GenreEntity(
                3,
                33,
                filmId,
                "Drama"
            )
        )
        genres.add(
            GenreEntity(
                4,
                34,
                filmId,
                "Fantasi"
            )
        )
        genres.add(
            GenreEntity(
                5,
                35,
                filmId,
                "Fiksi"
            )
        )

        return genres
    }

    fun generateRemoteDummyMovies(): List<FilmResponse> {
        val movies = ArrayList<FilmResponse>()

        movies.add(
            FilmResponse(
                11,
                "Gabriel's Inferno Part III",
                9.1,
                "en",
                "2020-11-19",
                "The final part of the film adaption of the erotic romance novel Gabriel's Inferno written by an anonymous Canadian author under the pen name Sylvain Reynard.",
                "https://image.tmdb.org/t/p/w500/fYtHxTxlhzD4QWfEbrC1rypysSD.jpg",
                ArrayList<GenreResponse>(),
                0
            )
        )
        movies.add(
            FilmResponse(
                12,
                "Alita: Battle Angel",
                7.4,
                "Inggris",
                "14/02/2019",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                ArrayList<GenreResponse>(),
                0
            )
        )
        movies.add(
            FilmResponse(
                13,
                "Aquaman",
                7.4,
                "Inggris",
                "21/12/2018",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                ArrayList<GenreResponse>(),
                0

            )
        )
        movies.add(
            FilmResponse(
                14,
                "Bohemian Rhapsody",
                7.4,
                "Inggris",
                "02/11/2018",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                ArrayList<GenreResponse>(),
                0
            )
        )
        movies.add(
            FilmResponse(
                15,
                "Cold Pursuit",
                7.4,
                "Inggris",
                "08/02/2019",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/cO802woIgZsLbOWPUSsleobKyDp.jpg",
                ArrayList<GenreResponse>(),
                0
            )
        )
        movies.add(
            FilmResponse(
                16,
                "Creed",
                7.4,
                "Inggris",
                "25/11/2015",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg",
                ArrayList<GenreResponse>(),
                0
            )
        )
        movies.add(
            FilmResponse(
                17,
                "Fantastic Beasts: The Crimes of Grindelwald",
                7.4,
                "Inggris",
                "11/16/2018",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                ArrayList<GenreResponse>(),
                0
            )
        )
        movies.add(
            FilmResponse(
                18,
                "Glass",
                7.4,
                "Inggris",
                "01/18/2019",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                ArrayList<GenreResponse>(),
                0
            )
        )
        movies.add(
            FilmResponse(
                19,
                "How to Train Your Dragon: The Hidden World",
                7.4,
                "Inggris",
                "02/22/2019",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                ArrayList<GenreResponse>(),
                0
            )
        )
        movies.add(
            FilmResponse(
                110,
                "Avengers: Infinity War",
                7.4,
                "Inggris",
                "04/27/2018",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                ArrayList<GenreResponse>(),
                0
            )
        )


        return movies
    }

    fun generateDummyFilmWithGenres(film: FilmEntity, bookmarked: Boolean): FilmWithGenre {
        film.bookmarked = bookmarked
        return FilmWithGenre(film, generateDummyGenres(film.filmId))
    }
}