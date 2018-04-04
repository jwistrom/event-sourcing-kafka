package se.wistrom.eventsourcing.event

import org.junit.Test
import java.util.*

class EventTest {


    @Test(expected = IllegalArgumentException::class)
    fun shouldNotCreateEventWithInvalidUserIdFormat() {
        Event(EventType.CREATE_USER, "{}", "incorrectFormat")
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldNotCreateEventWithInvalidPayloadFormat() {
        Event(EventType.CREATE_USER, "hej", UUID.randomUUID().toString())
    }

}