import java.util.Scanner;

public class ArithmeticCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // 입력 중인 값을 저장하는 변수
        String input = " ";

        // 첫 번째 계산 값, 기호, 두 번째 계산 값을 저장하는 문자열 변수
        String firstValue = " ", secondValue = " ", sign = " ";

        // 계산의 결괏값을 저장하는 변수
        String result = " ";

        // 계산의 진행도를 구분하는 변수 (1: 첫 번째 입력 상태, 2 두 번째 입력 상태, 3: 2 두 번째 입력 상태, 4: 결괏값 계산 상태)
        int progress = 1;

        // 재입력을 요청하는 변수 (참: 올바른 입력 상태, 거짓: 재입력이 필요한 상태)
        boolean reEnter = true;

        System.out.println("종료는 exit를 입력해주세요");
        do {
            // 기록 확인
            if (input.equals("record")) {
                progress = 4;
            }
            // 입력된 값이 잘못되었을 때 기록 확인중이 아니라면 재입력 요청 메세지 출력
            if (!reEnter && progress != 4) {
                System.out.println("잘못된 값입니다.");
            }
            // 진행도에 따라 메세지를 출력
            switch (progress) {
                case 1:
                    System.out.print("첫 번째 숫자를 입력해주세요: ");
                    break;
                case 2:
                    System.out.print("기호를 입력해주세요: ");
                    break;
                case 3:
                    System.out.print("두 번째 숫자를 입력해주세요: ");
                    break;
                case 4:
                    // 기록을 보여주고 메세지와 함께 진행을 처음으로 돌린다.
                    System.out.println(calculator.getRecord());
                    progress = 1;
                    System.out.print("종료를 원하시면 exit 입력해주세요.\n계산을 원하시면 첫 번째 숫자를 입력해주세요: ");
                    break;
                default:
                    System.out.print("잘못된 진행 상황입니다.");
                    input = "exit";
                    break;
            }
            // 콘솔로 값을 입력 받음
            input = scanner.nextLine();

            // 진행 상황에 맞는 입력인지 확인하고 아니라면 재입력을 요청하는 메서드
            reEnter = Calculator.reEnter(input, progress);

            // 입력이 참일 때 진행에 맞는 동작을 진행한다.
            // 이후 다음 상태로 넘어간다.
            if (reEnter) {
                switch (progress) {
                    case 1:
                        // 첫 번째 변수를 입력 값으로 한다. 이후 두 번째 진행으로 넘어간다.
                        firstValue = input;
                        progress = 2;
                        break;
                    case 2:
                        // 두 번째 변수를 입력 값으로 한다. 이후 세 번째 진행으로 넘어간다.
                        sign = input;
                        progress = 3;
                        break;
                    case 3:
                        // 세 번째 변수를 입력 값으로 한다. 이후 네 번째 진행으로 넘어간다.
                        secondValue = input;
                        // 진행이 첫 번째로 돌아간다.
                        progress = 1;
                        // 계산을 진행 후 결괏값을 출력한다.
                        result = Calculator.calculator(firstValue, sign, secondValue);
                        System.out.println("결괏값입니다.: " + result);
                        // 배열의 크기가 8이 넘는다면 가장 오래된 기록을 삭제한다.
                        if (calculator.getRecordSize() >= 8) {
                            calculator.removeRecord();
                        }
                        // 리스트에 결괏값을 저장한다.
                        calculator.setRecord(result);
                        break;
                }
            }
        }
        // 종료 신호가 입력되었다면 반복문 종료
        while (!input.equals("exit"));
        // 계산을 하는 반복문이 종료 된 후 종료 메세지 출력
        System.out.print("계산기를 종료합니다.");
    }
}
