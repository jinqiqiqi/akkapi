package com.learning.basic

/**
  * Created by kinch on 11/3/16.
  */
object Addressbook extends App{
  case class Person(name: String, age: Int)

  class AddressBook(a: Person*) {
    private val people: List[Person] = a.toList

    def toXHTML =
      <table cellpadding="2" cellspacing="0">
        <tr>
          <td>Name</td>
          <td>Age</td>
        </tr>
        {
        for (p <- people) yield
          <tr>
            <td>{ p.name }</td>
            <td>{ p.age.toString() }</td>
          </tr>

        }
      </table>
  }

  val header =
    <head>
      <title>{ "My Address Book" }</title>
      <style type="text/css">
        {"""
        table { border-right: 1px solid #CCC; }
        th { background-color: #CCC; }
        td { border-left: 1px solid #acacac; border-bottom: 1px solid #acacac;}
        """}
      </style>
    </head>

  val people = new AddressBook(
    Person("Tom", 20),
    Person("Bob", 22),
    Person("James", 19)
  )

  val page =
    <html>
      { header }
      <body>
        { people.toXHTML }
      </body>
    </html>

  println(page)
}
