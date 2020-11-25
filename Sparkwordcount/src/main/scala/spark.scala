import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
object spark {


    def main(args: Array[String]) {
      val master=args(1)
      // create Spark context with Spark configuration
      val sc = new SparkContext(new SparkConf().setAppName("Spark Count").setMaster(master))

      // get threshold


      // read in text file and split each document into words
      val tokenized = sc.textFile(args(0)).flatMap(_.split(" "))

      // count the occurrence of each word
      val wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)

      // filter out words with fewer than threshold occurrences

      // count characters
      val charCounts = wordCounts.flatMap(_._1.toCharArray).map((_, 1)).reduceByKey(_ + _)

      System.out.println(charCounts.collect().mkString(", "))
    }

}
