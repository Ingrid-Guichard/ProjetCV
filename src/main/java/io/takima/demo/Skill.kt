package io.takima.demo;

import java.util.*
import javax.persistence.*

@Entity(name = "skills")
data class Skill(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        @Column(name = "name") var name: String?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var userId: User?) {

    constructor() : this(null, null, null)
}