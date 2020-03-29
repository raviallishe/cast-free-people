package dataaccess

import config.ApplicationConfig._
import org.mongodb.scala.{Document, MongoClient, MongoCollection, MongoDatabase}

object MongoDBClient {

  private val connectionSettings = "maxPoolSize=200&waitQueueMultiple=10"
  private val connectionURL = s"mongodb://$MongoDBUrl/$MongoDBName?$connectionSettings"

  val mongoClient: MongoClient = MongoClient(connectionURL)
  val database: MongoDatabase = mongoClient.getDatabase(MongoDBName)

  def getMongoCollection(collectionName: String): MongoCollection[Document] ={
    database.getCollection(collectionName)
  }
}
