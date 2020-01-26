package org.polycreo.services

/**
 * Domain exception thrown when the entity does not exist.
 */
class NotFoundException : RuntimeException {
    constructor(message: String, cause: Exception?) : super(message, cause)
    constructor(message: String) : super(message)
    constructor(cause: Exception) : super(cause)
}
