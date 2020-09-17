package BaiThiModule2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DanhBaDao {
    private static final String DAU_PHAY = ",";
    private static final String XUONG_DONG = "\n";

    public static void write(List<DanhBa> list){
        File file = new File("D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\BaiThiModule2\\danhba.txt");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append("so dien thoai, nhom danh ba, ho ten, gioi tinh, ngay sinh, email");
            bufferedWriter.append(XUONG_DONG);
            for (DanhBa danhBa : list){
                bufferedWriter.append(danhBa.toString());
                bufferedWriter.append(XUONG_DONG);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileWriter != null){
                    if (bufferedWriter != null) bufferedWriter.close();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<DanhBa> read(){
        List<DanhBa> list = new ArrayList<>();
        File file = new File ("D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\BaiThiModule2\\danhba.txt");
        if (file.isFile()){
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                DanhBa danhBa;
                String[] temp ;
                String line = bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null){
                    temp = line.split(DAU_PHAY);
                    danhBa = new DanhBa(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]);
                    list.add(danhBa);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (fileReader != null){
                        if (bufferedReader != null)bufferedReader.close();
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
