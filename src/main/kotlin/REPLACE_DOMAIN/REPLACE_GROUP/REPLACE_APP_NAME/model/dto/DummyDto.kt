package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.dto

import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.entities.DummyEntity

data class DummyDto(
    val id: Long,
    val name: String,
) {

    companion object {
        fun fromEntity(entity: DummyEntity): DummyDto {
            return DummyDto(
                id = entity.id!!,
                name = entity.name,
            )
        }
    }

}
