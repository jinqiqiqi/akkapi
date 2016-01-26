package com.testing.traits

import java.io.StringWriter

/**
  * Created by kinch on 1/26/16.
  */
object DecoratorExample extends App {
  val apartmentApplication = new Check with CreditCheck with CriminalRecordCheck
  println(apartmentApplication check)

  val employmentApplication = new Check with CriminalRecordCheck with EmploymentCheck
  println(employmentApplication.check())

  val myWriterProfanityFirst = new StringWriterDelegate with UpperCaseWriter with ProfanityFilterWriter
  val myWriterProfanityLast = new StringWriterDelegate with ProfanityFilterWriter with UpperCaseWriter

  myWriterProfanityFirst writeMessage "There is no sin except stupidity"
  myWriterProfanityLast writeMessage "There is no sin except stupidity"

  println(myWriterProfanityFirst)
  println(myWriterProfanityLast)
}

abstract class Check {
  def check(): String = "Checked Application Details..."
}

trait CreditCheck extends Check {
  override def check(): String = "Checked Credit..."+ super.check()
}

trait EmploymentCheck extends Check {
  override def check(): String = "Checked Employment..."+ super.check()
}

trait CriminalRecordCheck extends Check {
  override def check(): String = "Checked Criminal Records..."+ super.check()
}


// Writer and writeMessage
abstract class Writer {
  def writeMessage(message: String)
}

trait UpperCaseWriter extends Writer {
  abstract override def writeMessage(message: String) = {
    super.writeMessage(message.toUpperCase)
  }
}

trait ProfanityFilterWriter extends Writer {
  abstract override def writeMessage(message: String) = {
    super.writeMessage(message.replace("stupid", "s*****"))
  }
}

class StringWriterDelegate extends Writer {
  val writer = new StringWriter()

  def writeMessage(message: String) = writer.write(message)
  override def toString(): String = writer.toString
}



