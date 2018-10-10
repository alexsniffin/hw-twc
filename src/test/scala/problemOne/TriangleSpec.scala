package problemOne

import org.scalatest.{FlatSpec, GivenWhenThen}

class TriangleSpec extends FlatSpec with GivenWhenThen {
	info("Running TriangleSpec")

	"Triangle check" should "return an instance of a valid EquilateralTriangle" in {
		Given("some points with equal distance")
		val (a, b, c) = (Point(2, 1), Point(7, 1), Point(4.5, 5.33))

		When("creating a triangle")
		val result = Triangle.check(a, b, c)

		Then("it should be a EquilateralTriangle")
		assert(result.get.isInstanceOf[EquilateralTriangle])
	}

	"Triangle check" should "return an instance of a valid ScaleneTriangle" in {
		Given("some points with unequal distance")
		val (a, b, c) = (Point(2, 2), Point(7, 3), Point(4.5, 5.33))

		When("creating a triangle")
		val result = Triangle.check(a, b, c)

		Then("it should be a ScaleneTriangle")
		assert(result.get.isInstanceOf[ScaleneTriangle])
	}

	"Triangle check" should "return an instance of a valid IsoscelesTriangle" in {
		Given("some points with two being equal distance")
		val (a, b, c) = (Point(2, 2), Point(7, 2), Point(4.5, 5.33))

		When("creating a triangle")
		val result = Triangle.check(a, b, c)

		Then("it should be a IsoscelesTriangle")
		assert(result.get.isInstanceOf[IsoscelesTriangle])
	}

	"Triangle check" should "return an instance of None" in {
		Given("some points with equal but invalid distance")
		val (a, b, c) = (Point(0, 0), Point(0, 0), Point(0, 0))

		When("creating a triangle")
		val result = Triangle.check(a, b, c)

		Then("it should be None")
		assert(result.isEmpty)
	}

	"Triangle distanceFormula" should "be a positive distance" in {
		Given("two points with different positions")
		val (a, b) = (Point(1, 0), Point(1, 1))

		When("calculating the distance")
		val result = Triangle.distanceFormula(a, b)

		Then("it should be positive")
		assert(result > 0)
	}
}

