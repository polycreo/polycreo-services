package org.polycreo.services

import java.io.Serializable
import org.polycreo.chunkrequests.Chunkable
import org.polycreo.chunks.Chunk
import org.polycreo.chunks.ChunkFactory
import org.polycreo.repositories.ChunkableRepository

interface ChunkableService<E, ID>
    where ID : Serializable,
          ID : Comparable<ID> {

    val chunkFactory: ChunkFactory

    val repository: ChunkableRepository<E, ID>

    fun findAll(chunkable: Chunkable): Chunk<E> {
        val found = repository.findAll(chunkable)
        return chunkFactory.createChunk(found, chunkable)
    }
}
