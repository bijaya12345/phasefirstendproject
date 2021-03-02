package com.hcl.VirtualKey.FileMethods;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class FileOperations {

	public Set<String> sortFiles() throws IOException {
		Set<String> fileList = new HashSet<String>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("."))) {
			for (Path path : stream) {
				if (!Files.isDirectory(path)) {
					fileList.add(path.getFileName().toString());
				}
			}
		}
		return fileList;
	}

	public void closeApp() {
		System.exit(0);
	}

}
