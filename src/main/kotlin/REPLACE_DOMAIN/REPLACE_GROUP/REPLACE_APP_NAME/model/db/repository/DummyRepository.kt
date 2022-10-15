package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.repository

import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.entities.DummyEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DummyRepository: CrudRepository<DummyEntity, String> {
}