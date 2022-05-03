package com.arash.altafi.objectbox

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class User(
    @Id
    var id: Long = 0,
    var name: String? = null
)