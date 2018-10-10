package problemThree

object SubSeq {

  /**
    * Checks whether one sequence is in the other sequence
    *
    * Complexity - O(n)
    *
    * @param parentSeq parent sequence
    * @param subSeq    sub sequence
    * @tparam T        type of sequences
    * @return          whether the sub sequence is in the parent
    */
  def containsSequence[T](parentSeq: Seq[T], subSeq: Seq[T]): Boolean =
    parentSeq.foldLeft(subSeq)((acc, x) => {
      if (acc.isEmpty) return true // Short-circuit
      else if (acc.head.equals(x)) acc.tail
      else subSeq
    }).isEmpty

}
