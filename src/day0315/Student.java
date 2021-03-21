package day0315;
// 구조체(Struct)

// 2세대 언어에서는 우리가 여러가지 데이터타입을 섞어서
// 필요한 한가지 데이터타입으로 만들어주던 구조체 라는 특수한 데이터타입이 있었다.
// 예를 들어서 우리가 학생의 구조체를 만든다고 한다면
// 그안에
// 번호, 이름, 국어 점수, 영어 점수, 수학 점수를 넣어서
// 하나의 student이라는 데이터타입으로 만들어 주게 되는 것이다. 

// 하지만 3세대 언어인 자바에서는 구조체가 존재하지 않는다.(이유는 나중에 설명)
// 그렇지만 우리가 구조체를 비스무리 하게 만들어 줄 수는 있다.
// 바로 아래가 student라는 구조체를 비스무리 하게 만드는 방법이다. 

// 전혀 여러분들이 길게 기억할 필요 없는 자바에서 구조체 만드는 방법

/*
public class Student {
    // 필요한 데이터의 종류를 여기에 적는다.
    int id;
    String name;
    int korean;
    int english;
    int math;
}
*/

// 
//자바가 구조체가 없는 이유는
//자바가 기본적으로 구조체 보다 더 좋은 걸 갖고 있기 때문이다.
//자바가 갖고 있는 구조체보다 더 좋은 것이 바로 클래스이다.

// 클래스란?
// 자바가 제안하는 프로그램의 최소단위가 바로 클래스이다.
// 클래스는 필드와 메소드로 이루어져 있다.
// 필드: 해당 클래스의 객체들이 저장할 정보들의 종류를 규정한 것
//   필드는 우리가 변수를 선언하는 것과 매우 유사하지만,
//   필드의 초기화는 우리가 직접 하지 않고, 그 객체를 생성할 때
//   생성자 혹은 우리가 직접 값을 넣어주는 방식등을 사용하여 
//   "객체만의 고유한 정보"를 저장 가능하게 만들어 주는 것이다. 

// 메소드: 해당 클래스의 객체들이 가지고 있는 기능을 규정한 것
//       우리가 클래스 안에 선언과 구현한 메소드는
//       해당 클래스의 모든 객체들이 가지고 있게 된다!

// 즉 우리가 클래스를 만드는 것은 어떻게 보면
// 해당 객체의 설계도를 미리 만드는 것과 같다.

// 설계도를 만든다는 것은?
// 우리 객체가 어떤 정보를 가지고 어떤 행동을 할지를 정해주는 것
// 예시: 우리가 만약 삼성전자 디자이너이고 다음 갤럭시를 설계하는 것.
//   다음 갤럭시에 들어갈 정보들: 시리얼 번호, 모델명, 메모리 용량 같은 정보 
//   다음 갤럭시에 들어갈 기능들: 사진 촬영하기(), 지문 인식하기(), 삼성페이로 돈 내기()

// 우리는 이렇게 대략적인 설계도만 만들고,
// 그리고 메인 메소드나 다른 메소드가 필요하다면 이 설계도로 객체를 직접 만들어서
// 쓰게 되는 것이다.

// 아래의 student라는 클래스를 기준으로 생각해보자
// 우리가 기존에 성적관리 프로그램에서 다 따로 만들던 변수는 
// 결국 학생 한명의 번호, 이름, 국어, 영어, 수학 점수가 되게 된다.

// 또한 학생 클래스의 객체라면
// 총점 계산, 평균 계산, 성적 예쁘게 출력해주기 의 기능이 필요하게 될 것이다.
// 그렇다면 우리는 그것을 student 클래스 내부에 만들어주고
// 그 메소드의 실행은? 그 student  클래스 객체가 따로 해주면 되는 것이다!

public class Student {
    // 필요한 데이터의 종류를 여기에 적는다.
    public int id;
    public String name;
    public int korean;
    public int english;
    public int math;
    private final int SIZE=3;

    // 우리가 객체의 메소드는 static을 써주지 않는다.
    // 왜냐하면, 해당 메소드는 반드시 우리가
    // student s = new student();
    // 이런식으로 객체를 만든 다음에 객체가 개별적으로
    // 실행하기 때문이다.
    public int calculateSum() {
        return korean + english + math;
    }

    public double calculateAverage() {
        return calculateSum() / (double) SIZE;
    }

    public void showInfo() {
        System.out.printf("번호: %02d 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", calculateSum(), calculateAverage());
    }

    // 생성자
    // 파라미터가 있는 생성자
    public Student(int id, String name, int korean, int english, int math) {
        // 파라미터로 넘어온 값들을
        // 우리 필드에 넣을 때 한가지 주의할 점이 있다.
        // 필드의 이름과 파라미터의 이름이 같은 경우,
        // 그냥 이름만 적으면, 필드가 아닌 파라미터를 가리키게 된다.
        // 따라서 아래의 코드는
        // 파라미터 id에 파라미터 id의 현재값을 할당해라 라는 의미가 된다.
        // id=id;
        // 하지만 우리가 원하던 것은
        // 이 메소드를 실행시키는 객체의 필드 id에 파라미터 id의 현재값을 할당해라 이므로
        // 다음과 같이
        // 객체의 필드 id를 특별하게 지정해야 한다.
        this.id = id;
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    // 파라미터 없는 생성자
    public Student() {
        id = -1;
        name = new String("아직 입력 안됨");
        korean = -1;
        english = -1;
        math = -1;
    }

    // 오버라이드 메소드
    // 1. equals
    public boolean equals(Object o) {
        // 해당 메소드의 내용은 다음과 같다.
        // 1. 파라미터로 넘어온 object 객체 o가 student 클래스 객체인지 확인
        // 2. 맞을 경우, student 클래스 객체로 명시적 형변환을 한다.
        // 3. 명시적 형변환된 객체와 equals 메소드를 실행하는 객체의 특정 필드를 비교하여
        // 같을 시에는 return true 해준다.
        // 4. 만약 위의 단계 중 하나라도 통과 못하면 무조건 return false를 해준다.

        if (o instanceof Student) {
            // instanceof 라는 예약어는
            // 앞의 변수가 뒤의 클래스의 실체화 되어있는 객체인지 확인하여
            // 맞으면 true, 틀리면 false 가 된다.
            // 실체화 되어있는 객체 라는 의미는
            // 단순히 데이터타입만이 같다 라는 의미가 아닌
            // 데이터 타입이 같고, 해당 클래스의 생성자를 통해 초기화가 되어있는 상태의 객체를
            // 실체화 되어있는 객체 라고 한다.
            // 또는 instance라고 부르기도 한다.

            // 같은 클래스의 객체이므로 typecasting 을 통하여
            // 우리가 임시적으로 student 클래스 객체로 만들어 줄 수 있다.
            Student s = (Student) o;

            // o를 타입캐스팅해서 만든 s와 이 메소드를 실행하는 객체의
            // 특정 필드값만 비교해서
            // 그 필드값들이 같을 경우엔 return true 해준다.
            if (id == s.id && name.equals(s.name)) {
                return true;
            }
        }
        return false;
    }
}













