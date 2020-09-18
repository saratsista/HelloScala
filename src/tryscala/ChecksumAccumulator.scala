package tryscala

import scala.collection.mutable.Map;

class ChecksumAccumulator {
  private var sum = 0;
  def add(b: Byte) {sum += b}
  def checkSum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private val cache = Map.empty[String, Int]

  def calculate(s: String): Int = {
    if(cache.contains(s))
      cache(s)
    else {
      val accumulator = new ChecksumAccumulator
      s.foreach(c => accumulator.add(c.toByte))
      val cs = accumulator.checkSum();
      cache += (s -> cs)
      cs
    }
  }
}
