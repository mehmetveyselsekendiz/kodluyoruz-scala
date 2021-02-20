package dev.akif.kodluyoruz.streetfinder_my_solution
import java.io.File

/**
 * See CSV file at: https://github.com/makiftutuncu/kodluyoruz-scala/blob/main/data/streets.csv
 *
 * Original data: https://github.com/life/il-ilce-mahalle-sokak-cadde-sql
 */
object Application extends CsvLoader with StreetFinder {
  def main(args: Array[String]): Unit = {
    val searchParameters= Set("konyaaltı").map(i=>i.toUpperCase)
    val streets= loadCsv(new File("data/streets.csv"))
    print(findStreets(streets, searchParameters))
  }

  override def loadCsv(file: File): List[String] = {
    val streets= io.Source.fromFile (file).getLines().drop(1).toList
    return modification(streets)
  }

  def modification(list: List[String]): List[String]={
    return list.map(i=> i.split(",")(1)).map(i=>i.replaceAll("'",""))
  }

  override def findStreets(streets: List[String], names: Set[String]): List[String] = {
    return streets.filter(i => names.filter(j => i.contains(j)).toList.nonEmpty).distinct
  }
}
