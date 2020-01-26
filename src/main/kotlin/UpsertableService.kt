package org.polycreo.services

import java.io.Serializable
import org.polycreo.repositories.UpsertableRepository

/**
 * Service interface to save (upsert) single entity.
 *
 * @param E the domain type the service manages
 * @param ID the type of the id of the entity the service manages
 */
interface UpsertableService<E, ID : Serializable> {

    val repository: UpsertableRepository<E, ID>

    /**
	 * Saves a given entity.  Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
	 *
	 * @param entity entity to save
	 * @return the saved entity
	 * @throws org.springframework.dao.DataAccessException if a data access error occurred
	 */
    fun save(entity: E): E = repository.save(entity)
}
