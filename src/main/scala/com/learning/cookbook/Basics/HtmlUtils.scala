package com.learning.cookbook.Basics

/**
  * Created by kinch on 11/1/16.
  */
object HtmlUtils {
  def removeMarkup(input: String) = {
    input.replaceAll("""</?\w[^>]*>""", "")
        .replaceAll("<.*>", "")
  }
}
