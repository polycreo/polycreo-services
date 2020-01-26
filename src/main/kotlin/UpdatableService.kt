package org.polycreo.services

import java.io.Serializable
import org.polycreo.repositories.UpdatableRepository
import org.springframework.dao.IncorrectResultSizeDataAccessException

/**
 * Service interface to update and read single entity.
 *
 * @param E the domain type the service manages
 * @param ID the type of the id of the entity the service manages
 */
interface UpdatableService<E, ID : Serializable> : ReadableService<E, ID> {

    override val repository: UpdatableRepository<E, ID>

    /**
     * Update entity.
     *
     * @throws NotFoundException if the entity is not found
     * @throws org.springframework.dao.DataIntegrityViolationException
     * @throws org.springframework.dao.DataAccessException if database access is failed
     */
    fun update(entity: E): E {
        try {
            return repository.update(entity)
        } catch (e: IncorrectResultSizeDataAccessException) {
            throw NotFoundException(e)
        }
    }
}
