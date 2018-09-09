package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.Archive;

public class OpenController {
    
    private final Archive archive;
    private String error;
    
    public OpenController(String dir) {
        this.archive = new Archive();
        this.archive.setDir(dir);
    }
    
    public Archive getArchive() {
        try {
            this.load();
        } catch (FileNotFoundException e) {
            this.error = "Arquivo não encontrado: "  + e.getMessage();
        } catch (IOException e) {
            this.error = "Arquivo não encontrado: "  + e.getMessage();
        } catch (ClassNotFoundException e) {
            this.error = "Arquivo inválido: "  + e.getMessage();
        } catch (Exception e) {
            this.error = "Erro inesperado: "  + e.getMessage();
        }
        return this.archive;
    }
    
    public String GetError() {
        return this.error;
    }
    
    private void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        File birld = new File(this.archive.getDir());
        BufferedReader inputStream = new BufferedReader(new FileReader(birld));
        String words = "";
        for (String word = inputStream.readLine(); word != null; word = inputStream.readLine()) {
            words += word + System.lineSeparator();
        }
        this.archive.setCode(words);
    }
    
}
