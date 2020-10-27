package io.takima.demo;

import java.util.*
import javax.persistence.*

@Entity(name = "projects")
data class Project(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        @Column(name = "title") var title: String?,
        @Column(name = "summary") var summary: String?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var userId: User?) {

    constructor() : this(null, null, null, null)
}