package com.formichelli.dailycodingproblem.day101to200.day151to160

/*
Given a 2-D matrix representing an image, a location of a pixel in the screen and a color C, replace the color of the given pixel and all adjacent same colored pixels with C.

For example, given the following matrix, and location pixel of (2, 2), and 'G' for green:

B B W
W W W
W W W
B B B
Becomes

B B G
G G G
G G G
B B B
*/
object Day151 {
    fun solution(image: Array<CharArray>, pixel: Pair<Int, Int>, color: Char): Array<CharArray> {
        if (image[pixel.first][pixel.second] == color) {
            return image
        }

        solutionHelper(image, pixel, color, image[pixel.first][pixel.second])
        return image
    }

    private fun solutionHelper(image: Array<CharArray>, pixel: Pair<Int, Int>, newColor: Char, colorToReplace: Char) {
        if (pixel.first < 0 || pixel.first >= image.size) {
            return
        }

        if (pixel.second < 0 || pixel.second >= image[pixel.first].size) {
            return
        }

        if (image[pixel.first][pixel.second] != colorToReplace) {
            return
        }

        image[pixel.first][pixel.second] = newColor
        solutionHelper(image, Pair(pixel.first - 1, pixel.second), newColor, colorToReplace)
        solutionHelper(image, Pair(pixel.first + 1, pixel.second), newColor, colorToReplace)
        solutionHelper(image, Pair(pixel.first, pixel.second - 1), newColor, colorToReplace)
        solutionHelper(image, Pair(pixel.first, pixel.second + 1), newColor, colorToReplace)
    }
}