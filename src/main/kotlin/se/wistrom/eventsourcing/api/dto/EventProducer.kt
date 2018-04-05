package se.wistrom.eventsourcing.api.dto

import com.fasterxml.jackson.databind.ObjectMapper
import se.wistrom.eventsourcing.event.Event

interface EventProducer {
    fun toEvent(requester: String): Event

    fun toJson(): String {
        val mapper = ObjectMapper()
        return mapper.writeValueAsString(this)
    }

}