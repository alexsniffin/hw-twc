package problemTwo

/**
	* Two solutions to this problem, one using `sliding`, the other using a Queue.
	*/
object FifthElement {

	/**
		* Returns the 5th element from the end of a list given the algorithm strategy
		*
		* @param list elements to search
		* @param strategy function to execute
		* @tparam T element type
		* @return 5th element from end
		*/
	def findFifthFromEnd[T](list: Seq[T])(strategy: (Seq[T], Int) => Option[T]): Option[T] = strategy(list, 5)

	/**
		* Queue implementation for finding the nth element from the end of a singly linked list without using `reverse`,
		* `length` or `size`. List can only be traversed once
		*
		* Complexity - O(n)
		*
		* @param list elements to search
		* @param windowSize size to window over
		* @return 5th element from end
		*/
	def findQueue[T](list: Seq[T], windowSize: Int): Option[T] = {
		var queue: List[T] = List[T]()

		list.foreach(element => {
			if (queue.size == windowSize) queue = queue.take(windowSize - 1)

			queue = element :: queue // prepend instead of append for C time
		})

		if (queue.size < windowSize) None else Some(queue.last)
	}

	/**
		* Sliding implementation for finding the nth element from the end of a singly linked list without using `reverse`,
		* `length` or `size`. List can only be traversed once
		*
		* Complexity - O(n)
		*
		* @param list elements to search
		* @param windowSize size to window over
		* @return 5th element from end
		*/
	def findSliding[T](list: Seq[T], windowSize: Int): Option[T] = {
		val slidedList = list.sliding(windowSize).toList

		if (slidedList.last.size < windowSize) None else Some(slidedList.last.head)
	}

}
