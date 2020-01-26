package org.polycreo.services

import java.io.Serializable
import org.polycreo.repositories.DeletableRepository

interface DeletableService<E, ID : Serializable> {

    val repository: DeletableRepository<E, ID>

    fun delete(entity: E) = repository.delete(entity)

    fun deleteById(id: ID) = repository.deleteById(id)
}
