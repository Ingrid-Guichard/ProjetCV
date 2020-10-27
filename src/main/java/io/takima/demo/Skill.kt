package com.CGO.myawesomeCV

import java.util.*
import javax.persistence.*

@Entity(name = "skills")
data class Skill(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        @Column(name = "name") var name: String?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var user_id: User?) {

    constructor() : this(null, null, null)
}