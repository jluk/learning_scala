package controllers

import net.s_mach.sfti._
import play.api.mvc.{Action, Controller}

/**
 * author:JustinLuk
 * date:3/8/15
 */

object Application extends Controller{

  def index = Action{
    Ok(views.html.index())

  }

  def chapter1_question1 = Action{
    val output = Chapter1.question_1()
    Ok(views.html.showOutput(output))
  }

  def chapter12_question1 = Action{
    val output = Chapter12.question_1()
    Ok(views.html.showOutput(output))
  }
}
