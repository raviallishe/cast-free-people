package news.services

import news.config.ApplicationConfig._
import news.dataaccess.MongoDBClient
import news.models._
import org.mongodb.scala.bson.BsonDocument
import org.mongodb.scala.result.DeleteResult
import org.mongodb.scala.{Completed, Document, SingleObservable}
import play.api.libs.json.Json

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

class URLStorageService() {

  //to-do: given more time, i would add integration tests for this class.

  def insertUrlWithScore(socialInteraction: NewsData): ResponseStatus = {
    val newsCollectorCollection = MongoDBClient.getMongoCollection(MongoDBNewsCollection)

    val jsonData = Json.toJson[NewsData](socialInteraction).toString()
    val userDocument = BsonDocument(jsonData)

    val response: SingleObservable[Completed] = newsCollectorCollection.insertOne(userDocument)
    val result = Await.result(response.toFuture().map(_.isInstanceOf[Completed]), Duration.Inf)

    if (result) {
      NewsInserted()
    } else {
      ServerError()
    }
  }

  def removeUrl(dataToRemove: NewsToRemove): ResponseStatus = {
    val newsCollectorCollection = MongoDBClient.getMongoCollection(MongoDBNewsCollection)

    val jsonData = Json.toJson[NewsToRemove](dataToRemove).toString()
    val userDocument = BsonDocument(jsonData)

    val response: SingleObservable[DeleteResult] = newsCollectorCollection.deleteOne(userDocument)
    val result = Await.result(response.toFuture(), Duration.Inf)

    if (result.getDeletedCount > 0) {
      NewsDeleted()
    } else {
      ServerError()
    }
  }

  def getAllData(): Seq[NewsData] = {
    val newsCollectorCollection = MongoDBClient.getMongoCollection(MongoDBNewsCollection)

    val response = newsCollectorCollection.find()
    val result: Seq[Document] = Await.result(response.toFuture(), Duration.Inf)

    result.map {
      doc =>
        Json.parse(doc.toJson).as[NewsData]
    }
  }
}