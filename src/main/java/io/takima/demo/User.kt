package io.takima.demo;

import java.util.*
import javax.persistence.*

@Entity(name = "users")
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

        @OneToMany(mappedBy = "userId", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var languages:List<Language>?,

        @OneToMany(mappedBy = "userId", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var educations:List<Education>?,
        @OneToMany(mappedBy = "userId", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var experiences:List<Experience>?,
        @OneToMany(mappedBy = "userId", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var links:List<Link>?,
        @OneToMany(mappedBy = "userId", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var projects:List<Project>?,
        @OneToMany(mappedBy = "userId", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var skills:List<Skill>?) {
    constructor() : this(null, null, null, null, null, null, null, null, null, null, null, null, null, null)
}
