package se.wistrom.eventsourcing.event.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import se.wistrom.eventsourcing.event.Event
import se.wistrom.eventsourcing.event.EventSender

@Component
class EventSenderImpl @Autowired constructor(val kafkaTemplate: KafkaTemplate<String, Event>): EventSender {

    override fun send(event: Event) {
        logger.info("Sending event of type {} and payload='{}'. Initiated by {}", event.type, event.payload, event.userId)
        val sendResult = kafkaTemplate.send(topic, event)
        sendResult.addCallback({ result -> logger.info("Successfully sent event of type {} and payload='{}'. Initiated by {}. Offset: {}", event.type, event.payload, event.userId, result?.recordMetadata?.offset()?: 0) })
        { throwable -> logger.warn(String.format("Failed to send payload [%s] of event type [%s]", event.payload, event.type), throwable) }
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
        private const val topic = "event"
    }
}