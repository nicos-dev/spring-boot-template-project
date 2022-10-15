package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.controller

import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.constants.ApiVersion
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.dto.*
import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.services.base.dummy.DummyBaseService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Dummy Controller")
@RequestMapping("api/${ApiVersion.VERSION_1}/dummy-objects")
@RestController
class TaskController(
    val dummyBaseService: DummyBaseService
) {

    @Operation(summary = "Get all dummy objects.")
    @GetMapping(produces = ["application/hal+json"])
    fun getAllDummyObjects(): ResponseEntity<ListResponse<DummyDto>> {
        return dummyBaseService.getAllDummyObjects().buildResponse()
    }

}