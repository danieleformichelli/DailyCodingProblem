package com.formichelli.dailycodingproblem.day51to60

/*
Implement a file syncing algorithm for two computers over a low-bandwidth network. What if we know the files in the two computers are mostly the same?
*/
object Day59 {
    // Very vague requirements
    class FileSystem {
        private class FileSystemNode(internal val content: String?) {
            val children = HashMap<String, FileSystemNode>()
        }

        private var syncedFileSystem: FileSystem? = null
        private val fileSystemRoot = FileSystemNode(null)

        fun syncTo(fileSystem: FileSystem) {
            syncedFileSystem = fileSystem
        }

        fun addOrUpdateFile(filePath: String, fileContent: String) {
            addOrUpdateFileOrDirectory(filePath, fileContent)
        }

        fun addDirectory(filePath: String) {
            addOrUpdateFileOrDirectory(filePath, null)
        }

        private fun addOrUpdateFileOrDirectory(filePath: String, fileContent: String?) {
            val currentFileSystemNode = navigateToPath(filePath)
                    ?: throw IllegalArgumentException("$filePath is not a valid file path")

            // if file already exists and we expect small changes, we could send just the diff
            val fileName = filePath.split("/").last()
            currentFileSystemNode.children[fileName] = FileSystemNode(fileContent)
            syncedFileSystem?.addOrUpdateFileOrDirectory(filePath, fileContent)
        }

        private fun navigateToPath(filePath: String): FileSystemNode? {
            var currentFileSystemNode = fileSystemRoot
            val filePathSplit = filePath.split("/")
            filePathSplit.forEachIndexed { index, fileName ->
                if (index != filePathSplit.lastIndex) {
                    currentFileSystemNode = currentFileSystemNode.children[fileName] ?: return null
                }
            }

            return currentFileSystemNode
        }

        fun deleteFileOrDirectory(filePath: String) {
            val currentFileSystemNode = navigateToPath(filePath)
                    ?: throw IllegalArgumentException("$filePath is not a valid file path")
            val fileName = filePath.split("/").last()
            currentFileSystemNode.children.remove(fileName)
            syncedFileSystem?.deleteFileOrDirectory(filePath)
        }

        fun getFileOrDirectory(filePath: String): String? {
            val currentFileSystemNode = navigateToPath(filePath)
            val fileName = filePath.split("/").last()
            return currentFileSystemNode?.children?.get(fileName)?.content
        }
    }
}
