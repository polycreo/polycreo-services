package org.polycreo.services

import java.io.Serializable
import org.polycreo.repositories.TruncatableRepository

interface TruncatableService<E, ID : Serializable> {

    val repository: TruncatableRepository<E, ID>

    fun deleteAll() = repository.deleteAll()
}
