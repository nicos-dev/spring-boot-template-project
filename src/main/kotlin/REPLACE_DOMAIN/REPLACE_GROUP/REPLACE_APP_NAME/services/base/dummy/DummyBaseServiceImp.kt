package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.services.base.dummy

import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.repository.DummyRepository
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.dto.DummyDto
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class DummyBaseServiceImp(
    val dummyRepository: DummyRepository,
): DummyBaseService {

    @Cacheable("dummy:objects", key = "'all'")
    override fun getAllDummyObjects(): List<DummyDto> {
        return dummyRepository.findAll()
            .map { DummyDto.fromEntity(it) }
    }

}