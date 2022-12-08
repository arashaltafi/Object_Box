package com.arash.altafi.objectbox.sample2.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class User2(
    @Id var id: Long = 0,
    val userName: String,
    val userEmail: String
)
