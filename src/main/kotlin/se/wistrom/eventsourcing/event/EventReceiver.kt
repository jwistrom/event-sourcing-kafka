package se.wistrom.eventsourcing.event

import org.apache.kafka.clients.consumer.ConsumerRecord

interface EventReceiver {
    fun receive(consumerRecord: ConsumerRecord<String, Event>)
}
