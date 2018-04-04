package se.wistrom.eventsourcing.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class User private constructor(@Id val id: String, val firstName: String, val lastName: String) {

    @Version
    @JsonIgnore
    val version: String? = null

    companion object {
        fun new(id: String = UUID.randomUUID().toString(), firstName: String, lastName: String): User = User(id, firstName, lastName)
    }

}

