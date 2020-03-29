package models

import play.api.data._
import play.api.data.Forms._

case class PledgeData(name: String, gender: String, birthDate: String, state: String, consent: String)

object PledgeForm {

  val form: Form[PledgeData] = Form(
    mapping(
      "name" -> nonEmptyText,
      "gender" -> nonEmptyText,
      "birthDate" -> nonEmptyText,
      "state" -> nonEmptyText,
      "consent" -> nonEmptyText
    )(PledgeData.apply)(PledgeData.unapply)
  )
}
