package day0302;
// 기본형 데이터타입 01
// 정수형 데이터타입 

// 정수란?
// 소숫점이 존재하지 않는 온전한 숫자

// 프로그래밍에서는 정수형 기본 데이터타입에 4가지가 존재한다.
// 1. byte
//      크기: 8비트(=1byte)
//      범위: -2^7 ~ 2^7 -1

// 2. short
//      크기: 16비트(=2byte)
//      범위: -2^15 ~ 2^15 -1

// 3. int
//      크기: 32비트(=4byte)
//      범위: -2^31 ~ 2^31 -1

// 4. long
//      크기: 64비트(=8byte)
//      범위: -2^63 ~ 2^63 -1

// 비트
// 비트란 2진법 숫자의 자릿수를 뜻한다.
// 예를 들어 8비트의 경우에는 8자리 2진법 숫자를 뜻한다.

// 자바에서는 우리가 코드에 직접 적는 10진법 값을 
// 자동으로 int로 인식하고 알아서 형변환을 해주지만
// 더 작은 데이터타입의 경우, 만약 범위를 벗어나면 에러가 발생한다.

public class Ex06Integer {
    public static void main(String[] args) {
        //byte 변수 myByte 를 선언해보자
        byte myByte;
        
        // myByte에 10이란 값을 넣어보자
        myByte = 10;
        
        // 화면에 myByte에 현재 할당된 값을 출력해보자
        System.out.println(myByte);
        
        // int 변수 myInt 를 선언해보자
        int myInt;
        
        // myInt에 130 이란 값을 넣어보자
        myInt = 130;
        
        // 화면에 myInt에 현재 할당된 값을 출력해보자
        System.out.println(myInt);
        
        // 암시적 형변환 체험해보기
        
        // myInt에 myByte의 현재값을 할당해라
        
        // myInt의 데이터타입은 32비트인 int 이고
        // myByte의 데이터타입은 8비트인 byte 이기 때문에
        // myInt에 myByte의 값을 할당하면
        // 암시적 형변환이 발생하여 byte 값이 int로 변환되어
        // myInt에 할당된다.
        myInt = myByte;
        
        // myByte에 myInt의 현재값을 할당해라
        // 이때에는 myByte의 데이터타입이 myInt의 데이터타입보다 작으므로
        // 암시적 형변환이 일어날 수 없다.
        // 따라서 우리가 명시적으로 "이 데이터타입으로 바꿔" 라고 컴퓨터에게 지시를 내려야 한다.
        // 즉 명시적 형변환을 해야한다.
        myByte= (byte)myInt;
        
        // 오버플로우 경험해보기
        
        // myByte에 140을 할당해보자
        // 이때에는 java가 140이란 숫자를 미리 체크해서
        // byte가 표현 할수 없는 범위인것을 확인하고
        // 에러를 띄우므로 우리가 명시적 형변환을 통해서 
        // 140이란 값을 byte로 바꾸어야 한다.
       myByte = (byte)140;
       
       
       System.out.println(myByte);
       
       // 언더플로우 경험해보기
       // myByte에 -150을 할당해보자
       // -150= -129+ -21
       // byte 기준 -129는 127로 언더플로우가 되므로
       // -150= 127 + -21 이 된다.
       // 따라서 결과는 106이 된다.
       
       myByte = (byte) -150;
      System.out.println(myByte);
       
       // java에서는 정수형 값을 기본적으로 int로 받아들인다.
       // 즉 우리도 정수형 데이터타입이 필요할 경우 기본적으로 int를 쓰고
       // -20억~20억을 벗어날 경우에만 long을 쓰면 된다.
       
       
       
    }

}
