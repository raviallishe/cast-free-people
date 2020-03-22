package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import org.specs2.mock.Mockito
import play.api.test._
import play.api.test.Helpers._
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 */
class HomeControllerSpec extends Specification with Mockito {

  "HomeController GET" should {

    "render the home page from from the application" in {
      val controller = new HomeController(stubControllerComponents())
      val home = controller.home().apply(FakeRequest(GET, "/"))

      status(home) mustEqual  OK
      contentType(home) mustEqual Some("text/html")
      contentAsString(home).contains("Welcome to Caste Free People!") mustEqual true
    }
  }
}
