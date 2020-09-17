package Demo.Commons;

import Demo.Models.LopCha;
import Demo.Models.LopCon1;
import Demo.Models.LopCon2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {
    private static final String XUONG_DONG = "\n";
    private static final String DAU_PHAY = ",";
    private static final String PATH = "D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\Demo\\Data\\Product";

    public static void write(List<LopCha> list) {
        File file = new File(PATH);
        if (file.isFile()) {
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
            try {
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.append(XUONG_DONG);
                for (LopCha element : list) {
                    bufferedWriter.append(element.showInfo());
                    bufferedWriter.append(XUONG_DONG);
                }
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileWriter != null) {
                        if (bufferedWriter != null) bufferedWriter.close();
                        fileWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<LopCha> read() {
        List<LopCha> list = new ArrayList<>();
        File file = new File(PATH);
        if (file.isFile()) {
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                LopCha lopCha = null;
                String[] temp;
                String line = bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null) {
                    temp = line.split(DAU_PHAY);
                    if (temp.length == 9) {
                        lopCha = new LopCon1(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
                    }
                    if (temp.length == 8) {
                        lopCha = new LopCon2(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);
                    }
                    list.add(lopCha);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileReader != null) {
                        if (bufferedReader != null) bufferedReader.close();
                        fileReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
