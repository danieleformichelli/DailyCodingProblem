package com.formichelli.dailycodingproblem.day31to40

/*
The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.
*/
object Day37 {
    fun <T> solution(set: List<T>): Set<Set<T>> {
        return solutionHelper(set, 0)
    }

    private fun <T> solutionHelper(set: List<T>, startFrom: Int): Set<Set<T>> {
        if (startFrom == set.size) {
            return setOf(setOf())
        }

        val superSetsOfSubProblem = solutionHelper(set, startFrom + 1)
        val superSets = superSetsOfSubProblem.toMutableSet()
        for (superSetOfSubProblem in superSetsOfSubProblem) {
            val superSetOfSubProblemIncludingElement = superSetOfSubProblem.toMutableSet()
            superSetOfSubProblemIncludingElement.add(set[startFrom])
            superSets.add(superSetOfSubProblemIncludingElement)
        }

        return superSets
    }
}
