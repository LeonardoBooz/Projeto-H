package script;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDataPython{
    //  Expressão regular com grupos de captura
    private ArrayList<String> texto;
    private ArrayList<String> pattern_class;
    private ArrayList<String> pattern_methods;
    private ArrayList<String> pattern_comentary;
    private ArrayList<String> class_py;
    private ArrayList<String> methods;
    private ArrayList<String> commentary;

    public ExtractDataPython(ArrayList<String> texto){
        this.texto = texto;
        this.pattern_methods = this.loadMethodsPattern();
        this.pattern_class = this.loadClassPattern();
        this.pattern_comentary = this.loadComentaryPattern();
        // this.class_py = this.ExtractClass();
        this.methods = this.ExtractMetodos();
        this.commentary = this.ExtractCommentary();
    }
    
    private ArrayList<String> loadClassPattern() {
        ArrayList<String> method1 = new ArrayList<>();
        method1.add("s");
        return method1;
    }

    private ArrayList<String> loadMethodsPattern() {
        ArrayList<String> method1 = new ArrayList<>(); 
        method1.add("def .{1,53}\\(.{0,300}\\):");

        return method1;
    }

    private ArrayList<String> loadComentaryPattern() {
        ArrayList<String> method1 = new ArrayList<>(); 
        method1.add("\"\"\".*?\"\"\"");

        return method1;
    }

    private ArrayList<String> findAll(ArrayList<String> pattern_list, String texto) {
        ArrayList<String> matchedMethods = new ArrayList<>();
        
        for (String pttrn : pattern_list) {
            Pattern pattern = Pattern.compile(pttrn);
            Matcher matcher = pattern.matcher(texto);
            while (matcher.find()) {
                System.out.println("Match encontrado: " + matcher.group());
                matchedMethods.add(matcher.group());
            }
        }
        
        return matchedMethods;
    }

    // private ArrayList<String> ExtractClass() {
    //     ArrayList<String> founded_first = findAll(pattern_class);
    //     ArrayList<String> founded_third = new ArrayList<>();
    //     ArrayList<String> result = new ArrayList<>();
        
    //     return result;
    // }
    
    private ArrayList<String> ExtractMetodos() {
        ArrayList<String> founded_first = new ArrayList<>();
        int ind = 0;
        for (String temp_text : texto){
            ind += 1;
            ArrayList<String> temp_text3 = new ArrayList<>();
            for (String temp_text2 : findAll(pattern_methods, temp_text)){
                temp_text3.add(String.valueOf(ind) + " - Line$@#" + temp_text2);
            }
            founded_first.addAll(temp_text3);
            System.out.println(founded_first);

        }

        return founded_first;
    }

    private ArrayList<String> ExtractCommentary() {
        ArrayList<String> founded_first = new ArrayList<>();
        int ind = 0;
        String temp_union_text = (texto.toString());
        ArrayList<String> temp_text3 = new ArrayList<>();
        for (String temp_text2 : findAll(pattern_comentary, temp_union_text)){
            ind += 1;
            temp_text3.add(String.valueOf(ind) + " - Line$@#" + temp_text2);
        }
        founded_first.addAll(temp_text3);
        System.out.println(founded_first);

        

        return founded_first;
    }

    public ArrayList<String> getClass_py(){
        return class_py;
    }
    public ArrayList<String> getMethods(){
        return methods;
    }
    public ArrayList<String> getComentary(){
        return commentary;
    }
}
