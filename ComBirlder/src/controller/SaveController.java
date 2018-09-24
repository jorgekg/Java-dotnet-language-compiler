package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import model.Archive;

public class SaveController {

    private final Archive archive;
    private String error;

    public SaveController(String dir, String name, String code) {
        if (dir.split(".txt").length > 0) {
            dir = dir.split(".txt")[0];
        }
        this.archive = new Archive();
        this.archive.setDir(dir);
        this.archive.setName(name);
        this.archive.setCode(code);
    }

    public Archive save() {
        try {
            this.fileWrite();
        } catch (FileNotFoundException e) {
            this.error = "Verifique se a permissão da pasta: " + e.getMessage();
        } catch (IOException e) {
            this.error = "Verifique se tudo está correto: " + e.getMessage();
        } catch (Exception e) {
            this.error = "Aconteceu algo inesperado: " + e.getMessage();
        }
        return this.archive;
    }
    
    public String getError() {
        return this.error;
    }

    private void fileWrite() throws FileNotFoundException, IOException {
        File birldFile = new File(this.getArchivePath());
        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(birldFile))) {
            String[] words = this.archive.getCode().split(System.lineSeparator());
            for (String word : words) {
                bufferWriter.write(word);
                bufferWriter.newLine();
            }
        }
    }

    private String getArchivePath() {
        return this.archive.getDir() + "." + this.archive.getFileType();
    }

}
