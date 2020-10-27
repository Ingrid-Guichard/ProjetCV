package com.CGO.myawesomeCV

import java.util.*
import javax.persistence.*

@Entity(name = "user")
data class User(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        @Column(name = "first_name") var firstName: String?,
        @Column(name = "last_name") var lastName: String?,
        @Column(name = "age") var age: Int?,
        @Column(name = "address") var address: String?,
        @Column(name = "job_status") var jobStatus: String?,
        @Column(name = "mail") var mail: String?,
        @Column(name= "photo") var photo: String?,

        @OneToMany(mappedBy = "languages", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var languages:List<Language>?) {
    constructor() : this(null, null, null, null, null, null, null, null, null)
}
