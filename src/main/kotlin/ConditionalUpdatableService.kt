package org.polycreo.services

import java.io.Serializable
import org.polycreo.repositories.ConditionalUpdatableRepository

interface ConditionalUpdatableService<E, ID : Serializable, C> : UpdatableService<E, ID> {

    override val repository: ConditionalUpdatableRepository<E, ID, C>

    fun update(entity: E, condition: C?): E = repository.update(entity, condition)
}
