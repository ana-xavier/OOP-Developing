import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Renumber {
    private Map<String, String[]> basic;

    public Renumber(){
        basic = new TreeMap<>();
    }
    
    public void loadProgram(String arq){
        Integer nmNovo = 10;
        String currDir = Paths.get("").toAbsolutePath().toString(); 
        String nameComplete = currDir + "\\" + arq; 
        Path path2 = Paths.get(nameComplete); 
        try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))){ 
            while(sc.hasNextLine()) { 
            String line = sc.nextLine(); 
            String[] tokens = line.split(" ");
            String nmAntigo = tokens[0];
            tokens[0] = nmNovo.toString();
            nmNovo+= 10;
            basic.put(nmAntigo, tokens);
            
        } 
        }catch (IOException x){ 
            System.err.format("Erro de E/S: %s%n", x); 
        } 
    }

    public void impPrograma(){
        for(String nmAntigo: basic.keySet()){
            String[] tokens = basic.get(nmAntigo);
            for(String token: tokens){
                System.out.print(token + " ");
            }
            System.out.println();
        }
    }

    public void renumPrograma(){
        for(String nmAntigo: basic.keySet()){
            String[] line = basic.get(nmAntigo);
            for(int i = 0; i < line.length; i++){
                if(line[i].equals("gosub")){
                    String numero = line[i+1];
                    String nmNovo = basic.get(numero)[0];
                    line[i + 1] = nmNovo;
                    break;
                }
            }
        }
        for(String nmAntigo: basic.keySet()){
            String[] line = basic.get(nmAntigo);
            for(int i = 0; i < line.length; i++){
                if(line[i].equals("goto")){
                    String numero = line[i+1];
                    String nmNovo = basic.get(numero)[0];
                    line[i + 1] = nmNovo;
                    break;
                }
            }
        }
    }

    public void writePrograma(String nvArq){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir + "\\" + "Prog1-rn.bas";
        Path path = Paths.get(nameComplete);

        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
            for(String nmNovo: basic.keySet()){
                String[] line = basic.get(nmNovo);

                for(int i = 0; i < line.length; i++){
                    if(line[i] == line[0]){
                        writer.println();
                    }
                    writer.print(line[i] + " ");
                }
            }
        }catch(IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}
