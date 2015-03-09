package controllers

import net.s_mach.sfti.Chapter1
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
}
