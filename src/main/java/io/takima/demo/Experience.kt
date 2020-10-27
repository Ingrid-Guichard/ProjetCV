package com.CGO.myawesomeCV

import java.util.*
import javax.persistence.*

@Entity(name = "experiences")
data class Experience(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        @Column(name = "title") var title: String?,
        @Column(name = "place") var place: String?,
        @Column(name = "starting_date") var startingDate: Date?,
        @Column(name = "final_date") var finalDate: Date?,
        @Column(name = "summary") var summary: String?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var user_id: User?) {
    
    constructor() : this(null, null, null, null, null, null, null)
}