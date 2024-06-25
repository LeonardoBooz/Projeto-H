import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args){
        File path_main = new File("C:\\APR_Robos\\");
        ArrayList<String>s = (ArrayList<String>) path_tree(path_main);
        String path_file = "C:\\LeonardoBooz\\Projeto H\\script.py";
        String texto = "";

        try {
            texto = getTexto(path_file);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

      
        System.out.println(texto);

        ArrayList<String> pattern_methods = new ArrayList<>();
        pattern_methods.add("def .{1,53}\\(.{0,300}\\):(?=@@#\\$\\$@#)");
        pattern_methods.add("\"\"\".+\"\"\"");

        ArrayList<String> matchedMethods = new ArrayList<>();
        
        for (String pttrn : pattern_methods) {
            Pattern pattern = Pattern.compile(pttrn);
            Matcher matcher = pattern.matcher(texto);
            while (matcher.find()) {
                System.out.println("Match encontrado: " + matcher.group());
                matchedMethods.add(matcher.group());
            }
        }
    }

    private static String getTexto(String path_file) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path_file));
            String linha;

            while ((linha = br.readLine()) != null) {
                conteudo.append(linha);
                conteudo.append("@@#$$@#"); // Adiciona a quebra de linha removida pelo readLine()
            }
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar o BufferedReader: " + e.getMessage());
                }
            }
        }

        return conteudo.toString();
    }

    private static ArrayList<String> path_tree(File path_main) {
        ArrayList<String> diretorios = new ArrayList<>();
        int tamanho_anterior = 0;
        diretorios = extracted(path_main, diretorios);
        while(true){
            
            ArrayList<String> interable_diretorios = (ArrayList<String>)diretorios.clone();
            for(String diretorio : interable_diretorios){
                System.out.println(diretorio);

                for (String sun : new File(diretorio).list()){
                    String path_abs = diretorio + "\\" + sun + "\\";
                    if (new File(path_abs).isDirectory()){
                        if (diretorios.contains(path_abs) != true){
                            diretorios.add(path_abs);

                        }
                    }
                }
            } 
            if (interable_diretorios.size() == tamanho_anterior){
                break;
            }else{
                tamanho_anterior = interable_diretorios.size();
            }
        }
        return diretorios;
    }

    private static ArrayList<String> extracted(File path_main, ArrayList<String> diretorios) {
        for (String sun: path_main.list()){
            System.out.println(sun);
            String path_abs = path_main + "\\" +  sun + "\\";
            if (new File(path_abs).isDirectory()){
                diretorios.add(path_abs);
            }
        }
        return diretorios;
    }
}