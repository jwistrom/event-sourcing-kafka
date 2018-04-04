package se.wistrom.eventsourcing.api.dto

import se.wistrom.eventsourcing.event.Event

interface EventProducer {
    fun toEvent(requester: String): Event
}