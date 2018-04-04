package se.wistrom.eventsourcing.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import se.wistrom.eventsourcing.api.dto.CreateUserDto
import se.wistrom.eventsourcing.domain.User
import se.wistrom.eventsourcing.event.EventSender
import se.wistrom.eventsourcing.service.UserService

@RestController
@RequestMapping("/{requester}/user")
class UserController @Autowired constructor(val userService: UserService, val eventSender: EventSender){

    @PostMapping
    fun create(@PathVariable requester: String, @RequestBody body: CreateUserDto): ResponseEntity<String> {

        val requestingUser: User = userService.findById(requester) ?: throw IllegalArgumentException("No user with id '$requester' exists")

        val event = body.toEvent(requestingUser.id)

        eventSender.send(event)

        return ResponseEntity.accepted().body(event.id)

    }

}
