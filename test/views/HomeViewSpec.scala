package views

import org.specs2.mutable.Specification
import org.jsoup.Jsoup

class HomeViewSpec extends Specification {


  "Home view page" should {
    def getHtml() = Jsoup.parse(views.html.home().body)
    getHtml().select("h1").text().contains("Welcome to Caste Free People!") mustEqual true
  }

}
