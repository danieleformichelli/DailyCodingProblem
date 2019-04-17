package com.formichelli.dailycodingproblem.day101to200.day141to150

/*
Implement 3 stacks using a single list:

class Stack:
    def __init__(self):
        self.list = []

    def pop(self, stack_number):
        pass

    def push(self, item, stack_number):
        pass
*/
object Day141 {
    class MultiStack(stacksCount: Int, private val totalSize: Int) {
        class StackInfo(private val stacksArray: IntArray, private val stacksInfo: List<StackInfo>, private val stacksInfoIndex: Int, private var startIndex: Int, private var capacity: Int) {
            var size = 0

            fun pop(): Int {
                if (size == 0) {
                    throw NoSuchElementException()
                }

                --size
                return stacksArray[(startIndex + size) % stacksArray.size]
            }

            fun push(value: Int) {
                if (size == capacity) {
                    next().shiftStack()
                }

                stacksArray[(startIndex + size) % stacksArray.size] = value
                ++size
            }

            private fun prev(): StackInfo = stacksInfo[(stacksInfo.size + stacksInfoIndex - 1) % stacksInfo.size]

            private fun next(): StackInfo = stacksInfo[(stacksInfoIndex + 1) % stacksInfo.size]

            private fun shiftStack() {
                if (size == capacity) {
                    next().shiftStack()
                }

                for (i in startIndex until startIndex + size) {
                    stacksArray[(i + 1) % stacksArray.size] = stacksArray[i % stacksArray.size]
                }
                startIndex = (startIndex + 1) % stacksArray.size
                --capacity
                ++prev().capacity
            }
        }

        private val stacksArray = IntArray(totalSize)
        private val stacksInfo = ArrayList<StackInfo>()

        init {
            val stackCapacity = totalSize / stacksCount
            for (i in 0 until stacksCount - 1) {
                val newStackInfo = StackInfo(stacksArray, stacksInfo, i, i * stackCapacity, stackCapacity)
                stacksInfo.add(newStackInfo)
            }
            val lastStackIndex = (stacksCount - 1) * stackCapacity
            val lastStack = StackInfo(stacksArray, stacksInfo, stacksCount - 1, lastStackIndex, totalSize - lastStackIndex)
            stacksInfo.add(lastStack)
        }

        fun pop(stackNumber: Int) = stacksInfo[stackNumber].pop()

        fun push(stackNumber: Int, value: Int) {
            if (stacksInfo.sumBy { it.size } == totalSize) {
                throw IllegalStateException()
            }

            stacksInfo[stackNumber].push(value)
        }
    }
}