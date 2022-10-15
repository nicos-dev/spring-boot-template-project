package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME

import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.config.log.StartupLogger
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.entities.goal.GoalEntity
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.entities.project.ProjectEntity
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.entities.task.TaskEntity
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.entities.task.TaskImpactEntity
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.entities.task.TaskTypeEntity
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.entities.task.TaskUrgencyEntity
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.entities.user.UserEntity
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.repository.goal.GoalMotivationRepository
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.repository.goal.GoalRepository
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.repository.project.ProjectRepository
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.repository.task.TaskImpactRepository
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.repository.task.TaskRepository
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.repository.task.TaskTypeRepository
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.repository.task.TaskUrgencyRepository
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.repository.user.UserRepository
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
	runApplication<CoreServiceApplication>(*args) {
		addListeners(StartupLogger())
	}
}
