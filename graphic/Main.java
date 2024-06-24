package ISEE.graphic;

import java.io.File;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args){
        File path_main = new File("C:\\APR_Robos\\APRTech\\APRAtividade001.py");
        ArrayList<String>s = (ArrayList<String>) path_tree(path_main);
        String path_file = "C:\\APR_Robos\\APRTech\\APRAtividade001.py";

        String texto = getTexto(path_file);

      
        System.out.println(texto);


    }

    private static String getTexto(String path_file) {
        String linha;
        String texto = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path_file))) {
            while ((linha = br.readLine()) != null) {
                // Exibindo cada linha do arquivo
                texto += linha + "\n";
            }
        } catch (IOException e) {
            // Tratamento de exceção caso ocorra algum erro de E/S
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return texto;
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