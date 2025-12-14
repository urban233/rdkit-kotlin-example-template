package io.github.urban233


fun main() {
  System.loadLibrary("GraphMolWrap")
  val depict = DepictSmiles()
  depict.create2DPng("c1ccc(C)c(C)c1C")
}
