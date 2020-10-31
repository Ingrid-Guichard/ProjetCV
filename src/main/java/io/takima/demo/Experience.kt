package io.takima.demo;

import com.fasterxml.jackson.annotation.JsonIgnore
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
        @JsonIgnore
        @JoinColumn(name = "user_id")
        var userId: User?) {
    
    constructor() : this(null, null, null, null, null, null, null)
}