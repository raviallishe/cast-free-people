package controllers

import javax.inject.Inject
import models.PledgeForm
import play.api.i18n.I18nSupport
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import services.PledgeStorageService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class PledgeController @Inject()(cc: ControllerComponents, pledgeStorageService: PledgeStorageService)
  extends AbstractController(cc) with I18nSupport {

  def pledge() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.pledge(PledgeForm.form))
  }

  def savePledgeData(): Action[AnyContent] = Action.async {
    implicit request => {
      PledgeForm.form.bindFromRequest().fold(
        formWithErrors => Future.successful(BadRequest(views.html.pledge(formWithErrors))),
        formWithSuccess => Future.successful(Redirect(routes.HomeController.home()))
      )

    }
  }
}
