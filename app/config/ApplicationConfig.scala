package config

object ApplicationConfig {

  lazy val MongoDBUrl: String = "127.0.0.1:27017"
  lazy val MongoDBName: String = "casteFreePeople"
  lazy val MongoDBPledgeCollection: String = "pledgeData"


}
