import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JavaDecode {
    public static void main(String[] args) {
       decode("coding_qual_input.txt");
    }

    public static void decode(String message_file){
        File fileName = new File(message_file);
        String [] text=new String[100];

        try {
            try (BufferedReader readerBuffer = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = readerBuffer.readLine()) != null) {
                    String[] words = line.split("\\s");
                    int number = Integer.parseInt(words[0]);
                    for (int numberOfLines=0;numberOfLines<99;numberOfLines++) {
                        if (number == ((numberOfLines * numberOfLines + numberOfLines)/2)){
                            text[numberOfLines]=words[1];
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int index = 0; index<text.length;index++){
            if (text[index] !=null){
                System.out.print(text[index]+" ");
            }
        }
    }
}