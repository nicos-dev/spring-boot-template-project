package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.model.db.entities

import javax.persistence.*

@Entity(name = "dummy")
@Table(name = "dummy")
class DummyEntity(

    @Id
    val id: String,

    @Column(name = "name", nullable = false)
    val name: String = "Dummy",

)