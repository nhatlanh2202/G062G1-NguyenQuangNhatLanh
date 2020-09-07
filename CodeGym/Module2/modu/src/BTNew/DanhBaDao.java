package BTNew;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DanhBaDao {
    private static final String DANHBA = "D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\BTNew\\danhba.txt";

    public void write(List<DanhBa> danhBaList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(DANHBA));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(danhBaList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<DanhBa> read() {
        List<DanhBa> danhBaList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(DANHBA));
            ois = new ObjectInputStream(fis);
            danhBaList = (List<DanhBa>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return danhBaList;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
