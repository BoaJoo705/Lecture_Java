package day0318;

// 학생관리 프로그램을
// 인덱스가 아니라 학생 번호를 기준으로 하여 
// 관리 되는 프로그램으로 만드시오
// 중복 학생인지 아닌지는
// 번호로만 판단하도록 합니다.
import util.ScannerUtil;
import java.util.Scanner;
import day0316.Student;
import java.util.ArrayList;
public class GradeBook01 {
    // 학생의 목록을 저장할 ArrayList 객체 list
    private static ArrayList<Student> list = new ArrayList<>();
    // 점수의 최소값을 가지고 있는 상수 SCORE_MIN
    private static final int SCORE_MIN = 0;
    // 점수의 최대값을 가지고 있는 상수 SCORE_MAX
    private static final int SCORE_MAX = 100;
    // 입력을 처리해줄 Scanner 객체 scanner
    private static Scanner scanner = new Scanner(System.in);
    private static int currentId = 1;

    // 메인 메소드
    public static void main(String[] args) {
        showMenu();
    }

    // 메뉴 메소드
    private static void showMenu() {
        while (true) {
            System.out.println("============================");
            System.out.println("         비트고등학교          ");
            System.out.println("       성적 관리 프로그램       ");
            System.out.println("============================");
            String message = new String("1. 입력\n2. 목록 보기\n3. 종료");
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                // 입력 메소드 실행
                insert();

            } else if (userChoice == 2) {
                // 목록 보기 메소드 실행
                printAll();
            } else if (userChoice == 3) {
                // 종료 실행
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    // 입력 메소드
    private static void insert() {
        Student s = new Student();

        s.setId(currentId++);

        String message = new String("학생의 이름을 입력해주세요.");
        s.setName(ScannerUtil.nextLine(scanner, message));

        message = new String("학생의 국어점수를 입력해주세요.");
        s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = new String("학생의 영어점수를 입력해주세요.");
        s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = new String("학생의 수학점수를 입력해주세요.");
        s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        list.add(s);
    }

    // 출력 메소드
    private static void printAll() {

        while (true) {
            if (list.size() == 0) {
                System.out.println();
                System.out.println("아직 입력된 학생의 정보가 존재하지 않습니다.");
                System.out.println();
                break;
            }

            System.out.println();

            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d. %s \n", list.get(i).getId(), list.get(i).getName());
            }
            System.out.println();

            String message = new String("개별 보기할 학생의 번호를 선택해주세요. 뒤로가기는 0을 입력해주세요");
            int userChoice = ScannerUtil.nextInt(scanner, message);// *

            Student s = new Student();
            s.setId(userChoice);

            while (!(userChoice == 0 || list.contains(s))) {
                System.out.println("해당 학생 번호는 유효하지 않습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
                s.setId(userChoice);
            }
            if (userChoice == 0) {
                System.out.println();
                System.out.println("메뉴로 돌아갑니다");
                System.out.println();
                break;
            } else {
                printOne(userChoice);
            }
        }
    }

    private static int findIndex(int id) {
        Student s = new Student();
        s.setId(id);
        return list.indexOf(s);
//        int index = list.indexOf(s); 인덱스가 따로 하는일이 없기에
//        return index;인덱스자리에 바로 넣어준다.
    }

    // 개별 보기 메소드
    private static void printOne(int id) {

        int index = findIndex(id);

        if (index == -1) {
            System.out.println();
            System.out.println("해당 학생 번호는 존재하지 않는 번호입니다.");
            System.out.println();
        } else {
            list.get(index).showInfo();
            String message = new String("1. 수정  2. 삭제  3. 뒤로 가기");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                update(id);
                printOne(id);
            } else if (userChoice == 2) {
                delete(id);
            }
        }
    }

    // 수정 메소드
    private static void update(int id) {
        int index = findIndex(id);

        if (index == -1) {
            System.out.println();
            System.out.println("해당 학생은 유효하지 않는 번호입니다.");
            System.out.println();
        } else {

            String message = new String("학생의 국어점수를 수정해주세요.");
            list.get(index).setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

            message = new String("학생의 영어점수를 수정해주세요.");
            list.get(index).setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

            message = new String("학생의 수학점수를 수정해주세요.");
            list.get(index).setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
            printOne(id);

        }

    }

    // 삭제 메소드
    private static void delete(int id) {

        int index = findIndex(id);
        if (index == -1) {
            System.out.println();
            System.out.println("해당 학생번호는 유효하지 않은 번호입니다.");
            System.out.println();
        } else {
            String message = new String("정말로 삭제하시겠습니까? 삭제하실려면 Y 혹은 y를 입력해주세요.");
            String yesNo = new String(ScannerUtil.nextLine(scanner, message));

            if (yesNo.equalsIgnoreCase("Y")) {
                list.remove(index);
            } else {
                printOne(id);
            }
        }
    }
}
