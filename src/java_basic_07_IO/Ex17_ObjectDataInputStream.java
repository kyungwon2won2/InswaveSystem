package java_basic_07_IO;

import java_basic_07_IO.kr.or.kosa.UserInfo;

import java.io.*;

//복원시키는 작업 (역직렬화)
public class Ex17_ObjectDataInputStream {
    public static void main(String[] args) {
        String fileName = "UserData.txt";

        FileInputStream fis = null;
        BufferedInputStream bis = null; //버퍼 -> 성능을 위해서 끼는것.
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream(fileName);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis); // 원래 제품으로 복원 (역직렬화)

            //복원
//            UserInfo r1 = (UserInfo) ois.readObject(); //객체 하나..
//            UserInfo r2 = (UserInfo) ois.readObject(); //객체 둘...
//
//            System.out.println(r1.toString());
//            System.out.println(r2.toString());
            //->객체가 10개 저장되어 있을지, 1개 저장되어 있을지 어떻게 알아!!
            //답) ArrayList ... add(UserInfo) .... >> 객체를 한개만 저장
            //답) HashMAp
            Object users = null;
            while((users = ois.readObject()) != null) {
                System.out.println(((UserInfo)users).toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재하지 않아요" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("끝" + e.getMessage());
        }catch (IOException e) {
            System.out.println("파일을 읽을 수 없어요" + e.getMessage());
        }catch (ClassNotFoundException e) {
            System.out.println("해당 객체가 없어요" + e.getMessage());
        } catch (Exception e) {
            System.out.println("나머지 예외" + e.getMessage());
        }finally {
            try{
                ois.close();
                bis.close();
                fis.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    }
}
