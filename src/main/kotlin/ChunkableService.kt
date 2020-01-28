package org.polycreo.services

import java.io.Serializable
import org.polycreo.chunkrequests.Chunkable
import org.polycreo.repositories.ChunkableRepository

interface ChunkableService<E, ID>
    where ID : Serializable,
          ID : Comparable<ID> {

    val repository: ChunkableRepository<E, ID>

    fun findAll(chunkable: Chunkable): List<E> = repository.findAll(chunkable)
}
