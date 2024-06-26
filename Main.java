import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import script.ExtractDataPython;

public class Main{
    public static void main(String[] args){
        File path_main = new File("C:\\APR_Robos\\");
        ArrayList<String>s = (ArrayList<String>) path_tree(path_main);
        String path_file = "C:\\LeonardoBooz\\Projeto H\\script.py";
        ArrayList<String> texto = new ArrayList<>();
        
        try {
            texto = getTexto(path_file);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.println(texto);
        ExtractDataPython vasbt1 = new ExtractDataPython(texto);
        ArrayList<String> ssds = vasbt1.getMethods();

        System.out.println(ssds);

        for (String ss : vasbt1.getMethods()){
            System.out.println(ss);
        }



    }

    private static ArrayList<String> getTexto(String path_file) throws IOException {
        ArrayList<String> conteudo = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path_file), "UTF-8"));
            String linha;

            while ((linha = br.readLine()) != null) {
                conteudo.add(linha);
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

        return conteudo;
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