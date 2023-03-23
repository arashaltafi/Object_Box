package com.arash.altafi.objectbox.sample1

import io.objectbox.annotation.*

@Entity
data class User(
    @Id
    var id: Long = 0,

//    @Index @Unique(onConflict = ConflictStrategy.REPLACE)
    var username: String? = null
)