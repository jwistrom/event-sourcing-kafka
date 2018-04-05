package se.wistrom.eventsourcing.api.dto

import org.junit.Assert.assertEquals
import org.junit.Test

class CreateUserDtoTest {

    @Test
    fun shouldGenerateJson() {
        val dto = CreateUserDto("johan", "wiström")

        //ACTION
        val result = dto.toJson()

        //VERIFY
        assertEquals("""{"firstName":"johan","lastName":"wiström"}""", result)
    }

}