package se.wistrom.eventsourcing.event

interface EventSender {

    fun send(event: Event)

}