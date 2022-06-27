package com.utflnx.who.knows.backend.repository.impl

import com.utflnx.who.knows.backend.entity.Room
import com.utflnx.who.knows.backend.repository.IRoomRepository
import org.apache.lucene.search.Query
import org.hibernate.search.jpa.FullTextEntityManager
import org.hibernate.search.jpa.Search
import org.hibernate.search.query.dsl.QueryBuilder
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
abstract class RoomRepository: IRoomRepository {
    @PersistenceContext
    lateinit var entityManager: EntityManager

    open fun search(terms: String?, limit: Int, offset: Int): List<Room?>? {
        val fullTextEntityManager: FullTextEntityManager = Search.getFullTextEntityManager(entityManager)
        val queryBuilder: QueryBuilder = fullTextEntityManager.searchFactory
            .buildQueryBuilder().forEntity(Room::class.java).get()
        val luceneQuery: Query = queryBuilder
            .keyword()
            .onFields("title", "description")
            .matching(terms)
            .createQuery()

        // wrap Lucene query in a javax.persistence.Query
        val jpaQuery: javax.persistence.Query =
            fullTextEntityManager.createFullTextQuery(luceneQuery, Room::class.java)
        jpaQuery.maxResults = limit
        jpaQuery.firstResult = offset

        // execute search
        return jpaQuery.resultList
    }
}
 **/
