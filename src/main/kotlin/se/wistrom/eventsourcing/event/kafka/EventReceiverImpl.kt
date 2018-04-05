package se.wistrom.eventsourcing.event.kafka

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import se.wistrom.eventsourcing.event.Event
import se.wistrom.eventsourcing.event.EventReceiver

@Component
class EventReceiverImpl : EventReceiver {

    @KafkaListener(topics = ["event"])
    override fun receive(consumerRecord: ConsumerRecord<String, Event>) {
//        LOGGER.info("received event with id='{}' on topic {}", consumerRecord.value().id, consumerRecord.topic())
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(EventReceiverImpl::class.java)
    }

}