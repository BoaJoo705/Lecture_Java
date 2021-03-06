package day0310;
// 게시판 프로그램

// 게시글에는 제목, 작성자, 내용이 있다.
// 이 프로그램은 총 6개의 게시글을 관리할 수 있다.
// 단, 중복된 제목의 글은 작성할 수 없다.
// 또한 입력과 출력은 분리되어있다.

import java.util.Scanner;

public class Board01Answer {
    static final int BOARD_SIZE = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 제목을 담당하는 String 배열
        String[] titleArray = new String[BOARD_SIZE];

        // 작성자를 담당하는 String 배열
        String[] writersArray = new String[BOARD_SIZE];

        // 내용을 담당하는 String 배열

        String[] contentArray = new String[BOARD_SIZE];

        // 현재 인덱스를 저장한 int index
        int idx = 0;

        while (true) {
            System.out.println();
            System.out.println("1. 입력  2. 출력  3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                // 글 작성

                // 1. 먼저 우리가 글을 쓸 칸이 남아있는지 체크해서 없을 시에는 경고 메시지만 출력
                if (idx < BOARD_SIZE) {
                    // 글 쓸 칸이 존재하므로 글 쓰는 것을 시작한다.

                    // 2. 제목을 입력 받는다.
                    // 단, 제목이 기존칸에 있는 제목들과 비교해서 만약 이미 있는 제목이면
                    // 중복이 아닐때까지 다시 입력을 받는다.
                    scanner.nextLine();
                    System.out.println("제목");
                    System.out.print("> ");
                    String title = new String(scanner.nextLine());

                    // 중복이면 false, 중복이 아니면 true가 할당되는 boolean 변수 titleChecker
                    boolean titleChecker = true;

                    // 우리가 index 변수의 값이 3이라고 가정한다면, 우리 배열에는 0 1 2 까지만 값이 들어있고.
                    // 3, 4, 5 에는 null 이다.
                    // 그렇다면, 굳이 3, 4, 5를 체크할 필요가 있을까?

                    for (int i = 0; i < idx; i++) {
                        if (title.equals(titleArray[i])) {
                            titleChecker = false;
                            break;
                        }
                    }

                    while (!titleChecker) {
                        System.out.println("중복된 제목입니다");
                        System.out.println("제목");
                        System.out.print("> ");
                        title = new String(scanner.nextLine());
                        titleChecker=true;
                        
                        for (int i = 0; i < idx; i++) {
                            if (title.equals(titleArray[i])) {
                                titleChecker = false;
                                break;
                            }
                        }
                    }

                    titleArray[idx] = new String(title);

                    // 3. 작성자를 입력 받는다.
                    System.out.println("작성자");
                    System.out.print("> ");
                    writersArray[idx] = new String(scanner.nextLine());

                    // 4. 내용을 입력 받는다.
                    System.out.println("내용");
                    System.out.print("> ");
                    contentArray[idx] = new String(scanner.nextLine());

                    // 5. idx++ 해준다.
                    idx++;
                } else {
                    // 글 쓸 칸이 없으므로 경고 메시지만 출력
                    System.out.println("더 이상 글을 작성하실 수 없습니다.");

                }

            } else if (userChoice == 2) {
                // 글 보기
                if (idx > 0) {
                    // 작성된 글이 존재하므로 for문을 사용하여 출력
                    for (int i = 0; i < idx; i++) {
                        System.out.println();
                        System.out.println("==============================");
                        System.out.printf("제목: %s  작성자:%s ", titleArray[i],writersArray[i]);
                        System.out.println("                         내용");
                        System.out.println("------------------------------");
                        System.out.println(contentArray[i]);
                        System.out.println("==============================");
                        
                        System.out.println();

                    }

                } else {
                    // 작성된 글이 없으므로 경고메시지만 출력
                    System.out.println();
                    System.out.println("아직 입력된 게시글이 존재하지 않습니다");
                    System.out.println();
                }

            } else if (userChoice == 3) {
                // 종료
                System.out.println("사용해주셔서 감사합니다");
                break;

            }

        }

        scanner.close();
    }
}
