package IOTextFile.bai_tap.DocFileCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderCSV {
    public static void main(String[] args) throws IOException {
        String fileCSV = "D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\IOTextFile\\bai_tap\\DocFileCSV\\ReaderCSV";
        BufferedReader bufferedReader = null;
        String line = "";
        String splitCSV = ",";

        try {
            bufferedReader = new BufferedReader(new FileReader(fileCSV));
            while ((line = bufferedReader.readLine()) != null){
                String[] country = line.split(splitCSV);
                System.out.println("Country [code = " + country[0] + "," + country[2] + "," +
                                        country[3] + "," + country[4] + "," + country[5] + "]");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
