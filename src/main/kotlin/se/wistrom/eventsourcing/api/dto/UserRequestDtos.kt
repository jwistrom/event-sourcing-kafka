package se.wistrom.eventsourcing.api.dto

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import se.wistrom.eventsourcing.event.Event
import se.wistrom.eventsourcing.event.EventType

data class CreateUserDto(val firstName: String, val lastName: String): EventProducer{
    override fun toEvent(requester: String): Event = Event(EventType.CREATE_USER, toJson(), requester)

    private fun toJson() = """{"firstName": "$firstName", "lastName": "$lastName"}"""
}