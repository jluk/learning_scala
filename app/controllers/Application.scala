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

  def chapter14_question2 = Action{
    val output = Chapter14.question_2()
    Ok(views.html.showOutput(output))
  }

  def chapter14_question3 = Action{
    val output = Chapter14.question_3()
    Ok(views.html.showOutput(output))
  }

  def chapter14_question4 = Action{
    val output = Chapter14.question_4()
    Ok(views.html.showOutput(output))
  }

//  def chapter12_question3 = Action{
//    val output = Chapter12.question_3()
//    Ok(views.html.showOutput(output))
//  }
//
//  def chapter12_question5 = Action{
//    val output = Chapter12.question_5()
//    Ok(views.html.showOutput(output))
//  }
//
//  def chapter12_question6 = Action{
//    val output = Chapter12.question_6()
//    Ok(views.html.showOutput(output))
//  }
//
//  def chapter12_question7 = Action{
//    val output = Chapter12.question_7()
//    Ok(views.html.showOutput(output))
//  }
//
//  def chapter12_question8 = Action{
//    val output = Chapter12.question_8()
//    Ok(views.html.showOutput(output))
//  }

}


