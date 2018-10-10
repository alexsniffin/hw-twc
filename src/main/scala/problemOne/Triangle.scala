package problemOne

/**
	* A triangle
	*
	* @param a first point
	* @param b second point
	* @param c third point
	*/
sealed abstract class Triangle(val a: Point, val b: Point, val c: Point)

case class EquilateralTriangle(
	override val a: Point,
	override val b: Point,
	override val c: Point) extends Triangle(a: Point, b: Point, c: Point)

case class IsoscelesTriangle(
	override val a: Point,
	override val b: Point,
	override val c: Point) extends Triangle(a: Point, b: Point, c: Point)

case class ScaleneTriangle(
	override val a: Point,
	override val b: Point,
	override val c: Point) extends Triangle(a: Point, b: Point, c: Point)

/**
	* Companion of `Triangle`, constructs a new instance and checks whether it's equilateral, scalene, isosceles or
	* a degenerate triangle
	*/
object Triangle {

	def apply: (Point, Point, Point) => Option[Triangle] = (a: Point, b: Point, c: Point) => check(a, b, c)

	/**
		* Check a triangle to determine what type of triangle it is. A triangle can be invalid when it's sides A, B and C meet
		* the following condition A + B <= C || A + C <= B || B + C <= A, this is known as a degenerate triangle, thus None
		* will be returned
		*
		* @param a first point
		* @param b second point
		* @param c third point
		* @return  Option of type Triangle
		*/
	def check(a: Point, b: Point, c: Point): Option[Triangle] = {
		val (d1, d2, d3): (Double, Double, Double) =
			(distanceFormula(a, b), distanceFormula(b, c), distanceFormula(c, a))

		// Check for degenerate triangle
		if (d1 + d2 <= d3 || d1 + d3 <= d2 || d2 + d3 <= d1) None
		else if (eqTol(d1, d2) && eqTol(d2, d3)) Some(EquilateralTriangle(a, b, c))
		else if (!eqTol(d1, d2) && !eqTol(d2, d3) && !eqTol(d3, d1)) Some(ScaleneTriangle(a, b, c))
		else if (eqTol(d1, d2) || eqTol(d2, d3) || eqTol(d3, d1)) Some(IsoscelesTriangle(a, b, c))
		else None
	}

	/**
		* The distance from one `Point` to another `Point`
		*
		* @return distance
		*/
	def distanceFormula: (Point, Point) => Double = (a: Point, b: Point) =>
		Math.sqrt(Math.pow(a.x - b.x, 2.0) + Math.pow(a.y - b.y, 2.0))


	/**
		* Equal within some tolerance. Could be an implicit class
		*
		* @param x         first value
		* @param y         second value
		* @param precision the precision
		* @return          whether equal
		*/
	def eqTol(x: Double, y: Double, precision: Double = 0.001): Boolean = {
		if ((x - y).abs < precision) true
		else false
	}
}
