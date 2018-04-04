package se.wistrom.eventsourcing.domain

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class User private constructor(@Id val id: String, val name: String) {

    @Version
    private val version: String? = null

    companion object {
        fun new(id: String = UUID.randomUUID().toString(), name: String): User = User(id, name)
    }

}

