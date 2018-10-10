package problemTwo

import org.scalatest.{FlatSpec, GivenWhenThen}
import FifthElement._

class FifthElementSpec extends FlatSpec with GivenWhenThen {
	info("Running FifthElementSpec")

	"FifthElement findFifthFromEnd findQueue" should "return the 5th element from the end of a list" in {
		Given("a list of 10 elements")
		val list = 1 to 9 toList

		When("finding the 5th from the end of the list with queue finding implementation")
		val result = FifthElement.findFifthFromEnd(list)(findQueue)

		Then("it should be 5")
		assert(result.get.equals(5))
	}

	"FifthElement findFifthFromEnd findQueue" should "return none" in {
		Given("a list of 4 elements")
		val list = 1 to 4 toList

		When("finding the 5th from the end of the list with queue finding implementation")
		val result = FifthElement.findFifthFromEnd(list)(findQueue)

		Then("it should be none")
		assert(result.isEmpty)
	}

	"FifthElement findFifthFromEnd findSliding" should "return the 5th element from the end of a list" in {
		Given("a list of 10 elements")
		val list = 1 to 9 toList

		When("finding the 5th from the end of the list with sliding finding implementation")
		val result = FifthElement.findFifthFromEnd(list)(findSliding)

		Then("it should be 5")
		assert(result.get.equals(5))
	}

	"FifthElement findFifthFromEnd findSliding" should "return none" in {
		Given("a list of 4 elements")
		val list = 1 to 4 toList

		When("finding the 5th from the end of the list with queue finding implementation")
		val result = FifthElement.findFifthFromEnd(list)(findSliding)

		Then("it should be none")
		assert(result.isEmpty)
	}
}
