package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.services.base.dummy

import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.dto.DummyDto

interface DummyBaseService {
    fun getAllDummyObjects(): List<DummyDto>
}