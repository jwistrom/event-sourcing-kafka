package se.wistrom.eventsourcing.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import se.wistrom.eventsourcing.domain.User
import se.wistrom.eventsourcing.service.UserService

@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(val userService: UserService){

    @GetMapping
    fun findAll(): ResponseEntity<Collection<User>> {
        return ResponseEntity.ok(userService.findAll())
    }

}
