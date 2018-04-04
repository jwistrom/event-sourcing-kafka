package se.wistrom.eventsourcing.event

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class Event(val type: EventType, payload: String, requester: String){

    val userId: String = UUID.fromString(requester).toString()
    val id: String = UUID.randomUUID().toString()
    val payload: String = try {
        JSONObject(payload)
        payload
    } catch (e: JSONException){
        try {
            JSONArray(payload)
            payload
        } catch (e: JSONException){
            throw IllegalArgumentException("Invalid JSON string: $payload")
        }
    }

    fun toJson() = """{"requester": "$userId", "id": "$id", "payload": $payload}"""


}

enum class EventType{
    CREATE_USER,
    EDIT_USER,
    DELETE_USER
}