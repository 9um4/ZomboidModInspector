package io.github.vitelotte.zomboid.mod.iterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ModIterator {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "D:\\.games\\Steam\\steamapps\\workshop\\content\\108600";

        File[] folders = new File(path).listFiles(File::isDirectory);

        assert folders != null;
        Set<File> modFolders = new HashSet<>();

        for (File folder : folders) {
            modFolders.addAll(getModDirectories(folder));
        }
    }

    private static Set<File> getModDirectories(File folder) {
        Set<File> modDirectories = new HashSet<>();

        if (folder.getParentFile().getName().equals("mods")) {
            modDirectories.add(folder);
            return modDirectories;
        }
        else {
            File[] folders = folder.listFiles(File::isDirectory);
            assert folders != null;
            for (File child : folders) {
                modDirectories.addAll(getModDirectories(child));
            }
        }
        return modDirectories;
    }

    private static Map<String, String> getModInformation(File modFolder) {
        File modInfoFile = new File(modFolder.getPath() + "\\mod.info");
        if (modInfoFile.isFile()) {
            Map<String, String> modInfo = new HashMap<>();
            Scanner scanner = new Scanner(modInfoFile);
            while (scanner.hasNext()) {
                String rawText = scanner.nextLine();
                String[] parsed = rawText.split("=");
                modInfo.put(parsed[0], parsed[1]);
            }
            System.out.println(modInfo.values());
            return modInfo;
        }
        return null;
    }
}
