package com.formichelli.dailycodingproblem.day11to20

/*
Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

Note:

The name of a file contains at least a period and an extension.

The name of a directory or sub-directory will not contain a period.
*/
object Day17 {
    data class FileSystemNode(val name: String, val parent: FileSystemNode?, val children: MutableSet<FileSystemNode> = mutableSetOf()) {
        override fun hashCode(): Int {
            return name.hashCode()
        }
    }

    fun solution(fileSystem: String): Int {
        if (fileSystem.isEmpty())
            return 0

        val fileSeparator = "\n"
        val isFile = { fileName: String -> fileName.contains(".") }

        var longestPathToFile = 0
        var currentFileSystemNode = FileSystemNode("", null)
        var currentFileSystemLevel = -1
        fileSystem.split(fileSeparator).forEach {
            val fileLevel = getFileLevel(it)
            val fileName = it.substring(fileLevel)
            val fileLevelDifference = fileLevel - currentFileSystemLevel
            if (fileLevelDifference > 1) {
                throw IllegalArgumentException("Invalid filesystem")
            }

            for (i in 0 until -fileLevelDifference + 1) {
                currentFileSystemNode = currentFileSystemNode.parent ?: throw IllegalArgumentException("Invalid filesystem")
            }

            val fileNode = FileSystemNode(fileName, currentFileSystemNode)
            currentFileSystemNode.children.add(fileNode)
            if (isFile(fileName)) {
                longestPathToFile = Math.max(longestPathToFile, getPathToFileLength(fileNode))
                currentFileSystemLevel = fileLevel - 1
            } else {
                currentFileSystemNode = fileNode
                currentFileSystemLevel = fileLevel
            }

        }

        return longestPathToFile
    }

    private fun getPathToFileLength(fileNode: FileSystemNode): Int {
        return if (fileNode.parent?.parent == null) {
            fileNode.name.length
        } else {
            fileNode.name.length + getPathToFileLength(fileNode.parent) + 1
        }
    }

    private fun getFileLevel(fileWithLevel: String): Int {
        val fileLevel = "\t"

        for (i in 0..fileWithLevel.length) {
            if (!fileWithLevel.startsWith(fileLevel, i)) {
                return i
            }
        }

        throw IllegalArgumentException("fileWithLevel only contains '\\t': $fileWithLevel")
    }
}