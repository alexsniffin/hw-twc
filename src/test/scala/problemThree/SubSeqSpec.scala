package problemThree

import org.scalatest.{FlatSpec, GivenWhenThen}

class SubSeqSpec extends FlatSpec with GivenWhenThen {
	info("Running SubSeqSpec")

	"SubSeq containsSequence" should "check whether one sequence contains the other" in {
		Given("two sequences")
		val seq1 = 1 to 10
		val seq2 = 2 to 9

		When("checking if seq2 is part of seq1")
		val result = SubSeq.containsSequence(seq1, seq2)

		Then("the result should be true")
		assert(result)
	}

	"SubSeq containsSequence" should "check whether one sequence doesn't contain the other" in {
		Given("two sequences")
		val seq1 = 1 to 10
		val seq2 = 2 to 11

		When("checking if seq2 is part of seq1")
		val result = SubSeq.containsSequence(seq1, seq2)

		Then("the result should be false")
		assert(!result)
	}

	"SubSeq containsSequence" should "check whether one sequence doesn't contain the other if there is a separation of the seq" in {
		Given("two sequences")
		val seq1 = (1 to 10) ++ (1 to 3) ++ (11 to 15)
		val seq2 = 2 to 15

		When("checking if seq2 is part of seq1")
		val result = SubSeq.containsSequence(seq1, seq2)

		Then("the result should be false")
		assert(!result)
	}
}
