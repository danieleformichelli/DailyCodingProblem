package com.formichelli.dailycodingproblem.day51to60

import org.junit.Assert
import org.junit.Test

class Day59Test {
    @Test
    fun solution() {
        val fs1 = Day59.FileSystem()
        val fs2 = Day59.FileSystem()
        fs1.syncTo(fs2)

        fs1.addDirectory("dir1")
        fs1.addDirectory("dir2")
        fs1.addDirectory("dir3")
        fs1.addDirectory("dir1/dir1.1")
        val fileName = "dir1/dir1.1/filename"
        val fileContent = "filecontent"
        fs1.addOrUpdateFile(fileName, fileContent)

        checkFileContent(fileName, fileContent, fs1)
        checkFileContent(fileName, fileContent, fs2)

        fs1.deleteFileOrDirectory(fileName)

        checkFileContent(fileName, null, fs1)
        checkFileContent(fileName, null, fs2)
    }

    private fun checkFileContent(fileName: String, fileContent: String?, fs: Day59.FileSystem) {
        Assert.assertEquals("Content of $fileName should be $fileContent", fileContent, fs.getFileOrDirectory(fileName))
    }
}