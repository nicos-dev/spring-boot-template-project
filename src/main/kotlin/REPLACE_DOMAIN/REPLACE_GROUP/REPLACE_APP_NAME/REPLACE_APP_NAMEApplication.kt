package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME

import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.config.log.StartupLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import java.util.*

@EnableCaching
@ConfigurationPropertiesScan
@SpringBootApplication(exclude = [RedisAutoConfiguration::class])
class REPLACE_APP_NAMEApplication: CommandLineRunner {

	override fun run(vararg args: String?) {

	}
}

fun main(args: Array<String>) {
	runApplication<REPLACE_APP_NAMEApplication>(*args) {
		addListeners(StartupLogger())
	}
}
