package com.formichelli.dailycodingproblem.day1to100.day81to90

import java.util.*
import kotlin.collections.ArrayList

/*
A rule looks like this:

A NE B

This means this means point A is located northeast of point B.

A SW C

means that point A is southwest of C.

Given a list of rules, check if the sum of the rules validate. For example:

A N B
B NE C
C N A
does not validate, since A cannot be both north and south of C.

A NW B
A N B
is considered valid.
*/
object Day87 {
    fun solution(rules: List<String>): Boolean {
        val southOf = HashMap<String, MutableList<String>>()
        val westOf = HashMap<String, MutableList<String>>()

        rules.forEach {
            val ruleSplit = it.split(" ")
            val from = ruleSplit[0]
            val to = ruleSplit[2]

            val rule = ruleSplit[1]
            if (rule.contains("N")) {
                addRelation(southOf, to, from)
            }
            if (rule.contains("S")) {
                addRelation(southOf, from, to)
            }
            if (rule.contains("W")) {
                addRelation(westOf, from, to)
            }
            if (rule.contains("E")) {
                addRelation(westOf, to, from)
            }
        }

        return isRelationValid(southOf) && isRelationValid(westOf)
    }

    private fun isRelationValid(relationMap: HashMap<String, MutableList<String>>): Boolean {
        var isValid = true
        relationMap.forEach outerForEach@{ from, to ->
            to.forEach {
                if (relationMap[it]?.contains(from) == true) {
                    isValid = false
                    return@outerForEach
                }
            }
        }

        return isValid
    }

    private fun addRelation(relationMap: HashMap<String, MutableList<String>>, from: String, to: String) {
        relationMap.computeIfAbsent(from) { ArrayList() }.add(to)

        // reflect the relation to the other points

        // if we are adding "A S B" and we know "C S A", then "C S A"
        relationMap.forEach { _, oldRelationToList ->
            if (oldRelationToList.contains(from)) {
                oldRelationToList.add(to)
            }
        }

        // if we are adding "A S B" and we know "B S C", then "A S C"
        relationMap.computeIfAbsent(to) { ArrayList() }.forEach {
            relationMap[from]!!.add(it)
        }
    }
}