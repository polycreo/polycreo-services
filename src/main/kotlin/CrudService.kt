package org.polycreo.services

import java.io.Serializable
import org.polycreo.repositories.CrudRepository

abstract class CrudService<E, ID : Serializable>(override val repository: CrudRepository<E, ID>) :
        CreatableService<E, ID>,
        UpdatableService<E, ID>,
        DeletableService<E, ID>
