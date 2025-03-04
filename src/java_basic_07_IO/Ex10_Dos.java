package java_basic_07_IO;

import java.io.*;
import java.util.Scanner;

public class Ex10_Dos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("명령어 입력 : ");
        String cmd = sc.nextLine();

        if (cmd.equals("move")) {
            System.out.print("이동시킬 파일 또는 폴더 : ");
            String orgPath = sc.nextLine();

            System.out.print("이동할 대상 폴더 : ");
            String tarPath = sc.nextLine();

            File org = new File(orgPath);
            File tar = new File(tarPath);

            if (!org.exists()) {
                System.out.println("유효하지 않은 경로입니다: " + orgPath);
                return;
            }

            if (!tar.exists()) {
                tar.mkdirs(); // 폴더가 없으면 생성
            }

            move(org, tar);
        } else if (cmd.equals("copy")) {
            System.out.print("복사할 파일 또는 폴더 : ");
            String orgPath = sc.nextLine().trim();

            System.out.print("복사할 대상 폴더 : ");
            String tarPath = sc.nextLine().trim();

            File org = new File(orgPath);
            File tar = new File(tarPath);

            if (!org.exists()) {
                System.out.println("유효하지 않은 경로입니다: " + orgPath);
                return;
            }

            if (!tar.exists()) {
                tar.mkdirs(); // 폴더가 없으면 생성
            }

            copy(org, tar);
        }
        sc.close();
    }

    public static void move(File org, File tar) {
        File targetFile = new File(tar, org.getName());

        if (org.isFile()) { // 파일인 경우
            if (org.renameTo(targetFile)) {
                System.out.println("파일을 이동하였습니다: " + targetFile.getAbsolutePath());
            } else {
                System.out.println("파일 이동에 실패하였습니다.");
            }
        } else { // 디렉토리인 경우
            copy(org, targetFile);
            delete(org);
            System.out.println("폴더를 이동하였습니다.");
        }
    }

    public static void copy(File org, File tar) {
        if (org.isFile()) { // 파일 복사
            try (FileInputStream fis = new FileInputStream(org);
                 FileOutputStream fos = new FileOutputStream(new File(tar, org.getName()))) {

                byte[] buf = new byte[4096];
                int cnt;
                while ((cnt = fis.read(buf)) != -1) {
                    fos.write(buf, 0, cnt);
                }
                System.out.println("파일을 복사하였습니다: " + org.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { // 폴더 복사
            if (!tar.exists()) {
                tar.mkdirs();
            }

            File[] origin_files = org.listFiles();
            if (origin_files != null) {
                for (File f : origin_files) {
                    File temp = new File(tar, f.getName());
                    copy(f, temp);
                }
            }
        }
    }

    public static void delete(File folder) {
        if (!folder.exists()) return;

        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    delete(f);
                }
                f.delete();
            }
        }
        folder.delete();
    }
}
