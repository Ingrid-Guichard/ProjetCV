package io.takima.demo;

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
        var userId: User?) {

    constructor() : this(null, null, null, null)
}