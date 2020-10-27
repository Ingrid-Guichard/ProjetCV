package io.takima.demo;

import javax.persistence.*

@Entity(name = "links")
data class Link(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        @Column(name = "title") var title: String?,
        @Column(name = "link") var link: String?,
        @Column(name = "is_checked") var isChecked: Boolean?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var userId: User?) {

    constructor() : this(null, null, null, false, null)
}