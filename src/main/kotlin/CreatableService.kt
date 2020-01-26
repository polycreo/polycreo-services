package org.polycreo.services

import java.io.Serializable
import org.polycreo.repositories.CreatableRepository
import org.springframework.dao.DuplicateKeyException

interface CreatableService<E, ID : Serializable> {

    val repository: CreatableRepository<E, ID>

    fun create(entity: E): E {
        try {
            return repository.create(entity)
        } catch (e: DuplicateKeyException) {
            throw AlreadyExistsException("The ID of the entity $entity is duplicated.", e)
        }
    }
}

class AlreadyExistsException(message: String, e: DuplicateKeyException) : RuntimeException(message, e)
