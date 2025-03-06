Java로 계산기 만들기

Lv2

변경점 1
계산과 입력 값을 구분하는 코드가 Calculator 클래스로 이동하며 ArithmeticCalculator에 있던 변수와 Set이 같이 이동하였다.
  계산을 하는 int 타입, double 타입 변수
  나누기를 할 때 나머지 여부를 확인하는 boolean 타입 변수
  
변경점 2
  Calculator 

변경점 3
  기록 확인 코드가 추가됨에 따라 진행도 4번의 역활이 계산&결괏값 출력에서 기록 확인으로 변경되었다.
    진행도 4 메세지 출력이 결괏값 출력으로 변경되었다.
    잘못된 입력을 출력하는 메세지 조건에 '기록 확인중이 아니라면'이라는 조건이 추가되었다.
      기록 확인 중이 아니라면 == 진행도 4가 아니라면
  
추가된 점 1
  Calculator 클래스 생성
    결괏값을 저장하는 List 생성 및 간접 조작을 하게 해주는 메서드 추가 
    input을 구분하게 해주는 코드를 Calculator 클래스로 이동하여 메서드로 활용하고 가시성 증가
    계산을 하는 코드를 Calculator 클래스로 이동하여 메서드로 활용하고 가시성 증가
    
추가된 점 2
  String 타입의 List를 생성하여 저장되는 결괏값은 String 타입으로 변환하여 저장한다.
    결괏값이 정수일지 실수일지 모르기에 String 타입으로 저장
    setter를 사용하여 간접적으로 저장

추가된 점 3
  getter를 활용하여 리스트에 접근하여 데이터를 확인한다.
    Size를 같이 활용하여 리스트의 크기를 확인하고 if문으로 크기가 일정 이상일 때 삭제할 수 있게할 수 있게하였다.
      isEmpty()를 사용하여 비어있는 값이 아니라면 remove.(index0)를 활용하여 가장 먼저 저장된 기록을 삭제한다.
