package dev.akif.kodluyoruz.streetfinder_my_solution

import java.io.File

trait CsvLoader {
  def loadCsv(file: File): List[String]
}


