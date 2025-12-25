package utils

class TreePrinter {
    static void printFoldersOnly(String path, String prefix = "", boolean isLast = true) {
        File dir = new File(path)
        if (!dir.exists() || !dir.isDirectory()) {
            println "Path not valid: $path"
            return
        }

        def folders = dir.listFiles().findAll { it.isDirectory() }.sort { it.name.toLowerCase() }
        folders.eachWithIndex { folder, i ->
            boolean last = (i == folders.size() - 1)
            def connector = last ? "└── " : "├── "
            println "${prefix}${connector}${folder.name}"

            def newPrefix = prefix + (last ? "    " : "│   ")
            printFoldersOnly(folder.path, newPrefix, last)
        }
    }
}