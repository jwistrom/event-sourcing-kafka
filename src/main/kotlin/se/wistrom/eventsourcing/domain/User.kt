package se.wistrom.eventsourcing.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class User (@Id val id: String = UUID.randomUUID().toString(), val firstName: String, val lastName: String) {

    @Version
    @JsonIgnore
    val version: String? = null

}

