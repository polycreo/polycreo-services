package org.polycreo.services

import java.io.Serializable
import java.util.Optional
import org.polycreo.repositories.ReadableRepository

/**
 * Service interface to retrieve single entity.
 *
 * @param E the domain type the service manages
 * @param ID the type of the ID of the entity the service manages
 */
interface ReadableService<E, ID : Serializable> {

    val repository: ReadableRepository<E, ID>

    /**
     * Retrieves an entity by its [id].
     *
     * @return the entity
	 * @throws IllegalArgumentException if [id] is `null`
     * @throws NotFoundException if the entity is not found
     * @throws org.springframework.dao.DataAccessException if database access is failed
     */
    fun findByIdOrThrow(id: ID): E = repository.findById(id)
        .orElseThrow { NotFoundException("The entity [$id] is not found.") }

    /**
     * Find entity by [id].
     *
     * @return the entity or empty if not found
	 * @throws IllegalArgumentException if [id] is `null`
     * @throws org.springframework.dao.DataAccessException if database access is failed
     */
    fun findById(id: ID): Optional<E> = repository.findById(id)

    /**
     * Returns whether an entity with the given id exists.
     *
     * @return `true` if the entity identified by [id] exists
	 * @throws IllegalArgumentException if [id] is `null`
     * @throws org.springframework.dao.DataAccessException if database access is failed
     */
    fun existsById(id: ID): Boolean = repository.existsById(id)
}
