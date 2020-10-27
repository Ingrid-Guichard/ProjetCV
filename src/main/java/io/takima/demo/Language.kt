package com.CGO.myawesomeCV

import java.util.*
import javax.persistence.*

@Entity(name = "languages")
data class Language(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        @Column(name = "name") var name: String?,
        @Column(name = "level") var level: String?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var user_id: User?) {

    constructor() : this(null, null, null, null)
}