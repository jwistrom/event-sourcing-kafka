package se.wistrom.eventsourcing.event.kafka

import org.apache.kafka.common.serialization.Serializer
import se.wistrom.eventsourcing.event.Event

class EventSerializer: Serializer<Event> {

    private var encoding = "UTF8"

    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun serialize(topic: String?, data: Event?): ByteArray = data?.toJson()?.toByteArray() ?: throw IllegalArgumentException("")


    override fun configure(configs: MutableMap<String, *>, isKey: Boolean) {
        val propertyName = if (isKey) "key.serializer.encoding" else "value.serializer.encoding"
        var encodingValue: Any? = configs.get(propertyName)
        if (encodingValue == null) {
            encodingValue = configs.get("serializer.encoding")
        }

        if (encodingValue != null && encodingValue is String) {
            this.encoding = encodingValue
        }
    }
}