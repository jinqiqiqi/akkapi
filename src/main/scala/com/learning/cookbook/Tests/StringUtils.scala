package com.learning.cookbook.Tests

/**
  * Created by kinch on 12/6/15.
  */
object StringUtils {

  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)
    def decrement = s.map(c => (c - 1).toChar)
    def hideAll = s.map(c => "*")
  }
}

