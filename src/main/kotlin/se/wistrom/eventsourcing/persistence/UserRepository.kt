package se.wistrom.eventsourcing.persistence

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import se.wistrom.eventsourcing.domain.User

@Repository
interface UserRepository: MongoRepository<User, String>