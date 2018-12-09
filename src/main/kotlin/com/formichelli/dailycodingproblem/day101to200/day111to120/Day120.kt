package com.formichelli.dailycodingproblem.day101to200.day111to120

/*
Implement the singleton pattern with a twist. First, instead of storing one instance, store two instances. And in every even call of getInstance(), return the first instance and in every odd call of getInstance(), return the second instance.
*/
object Day120 {
    public class Doubleton private constructor() {
        companion object {
            fun getInstance(): Doubleton {
                // TODO
                return Doubleton()
            }
        }
    }
}