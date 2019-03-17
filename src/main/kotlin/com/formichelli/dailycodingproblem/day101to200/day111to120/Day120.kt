package com.formichelli.dailycodingproblem.day101to200.day111to120

/*
Implement the singleton pattern with a twist. First, instead of storing one instance, store two instances. And in every even call of getInstance(), return the first instance and in every odd call of getInstance(), return the second instance.
*/
object Day120 {
    class Doubleton private constructor() {
        companion object {
            private val instances = Array(2) { Doubleton() }
            private var nextIndex = 0

            fun getInstance(): Doubleton {
                nextIndex = (nextIndex + 1) % 2
                return instances[nextIndex]
            }
        }
    }
}