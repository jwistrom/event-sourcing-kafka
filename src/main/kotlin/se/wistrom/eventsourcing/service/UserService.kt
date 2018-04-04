package se.wistrom.eventsourcing.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import se.wistrom.eventsourcing.domain.User
import se.wistrom.eventsourcing.persistence.UserRepository
import javax.annotation.PostConstruct

interface UserService {
    fun save(user: User): User
    fun findById(id: String): User?
    fun findAll(): Collection<User>
}

@Service
class UserServiceImpl @Autowired constructor(val userRepository: UserRepository): UserService{

    override fun save(user: User): User = userRepository.save(user)

    override fun findById(id: String): User? = userRepository.findById(id).orElse(null)

    override fun findAll(): Collection<User> = userRepository.findAll()

    @PostConstruct
    fun test(){
        userRepository.deleteAll()
        val u = User.new(firstName = "Johan", lastName = "Wiström")
        save(u)
    }

}