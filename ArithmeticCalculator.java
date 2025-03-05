import java.util.Scanner;
import java.util.Set;

public class ArithmeticCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> operator = Set.of("+", "-", "*", "/", "%");

        // 입력 중인 값을 저장하는 변수
        String input = " ";

        // 첫 번째 계산 값, 기호, 두 번째 계산 값을 저장하는 문자열 변수
        String firstValue = " ", secondValue = " ", sign = " ";

        // 나눗셈 할 때 나머지 여부를 확인하기 위한 변수
        boolean quotient = true;

        // 나숫셈을 할 때 나머지가 있으면 실수로 변환하여 계산하는 변수
        // num1~2 정수 계산
        int num1 = 0, num2 = 0;
        // num3~4 실수 계산
        double num3 = 0.0, num4 = 0.0;

        // 계산의 결괏값을 저장하는 변수
        String result = " ";

        // 계산의 진행도를 구분하는 변수 (1: 첫 번째 입력 상태, 2 두 번째 입력 상태, 3: 2 두 번째 입력 상태, 4: 결괏값 계산 상태)
        int progress = 1;

        // 재입력을 요청하는 변수 (참: 올바른 입력 상태, 거짓: 재입력이 필요한 상태)
        boolean reEnter = true;

        System.out.println("종료는 exit를 입력해주세요");
        do {
            // 입력된 값이 잘못되었을 때 재입력 요청 메세지 출력
            if (!reEnter) {
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
                    System.out.print("결괏값입니다.: ");
                    break;
                default:
                    System.out.print("잘못된 진행 상황입니다.");
                    input = "exit";
                    break;
            }
            // 콘솔로 값을 입력 받음
            input = scanner.nextLine();

            // 진행에 따라 입력 값이 올바른 입력 값이 맞는지 확인
            switch (progress) {
                case 1:
                    // 첫 입력 값이 숫자가 아니라면 재입력 요청
                    if (!input.matches("\\d+")) {
                        reEnter = false;
                    }
                    // 위의 조건이 아닐 경우 입력은 참으로 변경한다.
                    else {
                        reEnter = true;
                    }
                    break;
                case 2:
                    // 기호 입력 값이 정해진 문자가 아니라면 재입력 요청
                    if (!operator.contains(input)) {
                        reEnter = false;
                    }
                    // 위의 조건이 아닐 경우 입력은 참으로 변경한다.
                    else {
                        reEnter = true;
                    }
                    break;
                case 3:
                    // 두 번째 입력값이 숫자가 아니라면 재입력 요청
                    if (!input.matches("\\d+")) {
                        reEnter = false;
                    }
                    // 두 번째 입력값이 0일 때 기호가 / 또는 % 라면 재입력 요청
                    else if (input.matches("0") && (input.equals("/") || input.equals("%"))) {
                        reEnter = false;
                    }
                    // 위의 두 조건이 아닐 경우 입력은 참으로 변경한다.
                    else {
                        reEnter = true;
                    }
                    break;
            }

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
                        progress = 4;
                        break;
                }
            }
            // 입력 상태가 참이고 진행 상황이 4이라면 계산
            if (reEnter && progress == 4) {
                // 연산 기호가 나누기인 경우
                // 나머지가 0이 맞으면 참 아니라면 거짓
                if (sign.equals("/")) {
                    quotient = ((Integer.parseInt(firstValue) % Integer.parseInt(secondValue)) == 0);
                }

                // 나눌 때 0으로 떨어지지 않을 경우
                if (!quotient) {
                    // 입력값을 실수로 변환하여 계산용 변수에 기입
                    num3 = Double.parseDouble(firstValue);
                    num4 = Double.parseDouble(secondValue);

                    switch (sign) {
                        case "+":
                            num3 += num4;
                            break;
                        case "-":
                            num3 -= num4;
                            break;
                        case "*":
                            num3 *= num4;
                            break;
                        case "/":
                            num3 /= num4;
                            break;
                        case "%":
                            num3 %= num4;
                            break;
                    }
                    // 계산된 실수를 문자열로 변경한 후 결괏값 변수에 입력
                    result = String.valueOf(num3);
                }
                // 입력값이 정수로만 이루어진 경우
                else if ((firstValue.matches("\\d+") && secondValue.matches("\\d+"))) {
                    // 입력값을 정수로 변환하여 계산용 변수에 기입
                    num1 = Integer.parseInt(firstValue);
                    num2 = Integer.parseInt(secondValue);

                    switch (sign) {
                        case "+":
                            num1 += num2;
                            break;
                        case "-":
                            num1 -= num2;
                            break;
                        case "*":
                            num1 *= num2;
                            break;
                        case "/":
                            num1 /= num2;
                            break;
                        case "%":
                            num1 %= num2;
                            break;
                    }
                    // 계산된 정수를 문자열로 변경한 후 결괏값 변수에 입력
                    result = String.valueOf(num1);
                }
                // 진행이 첫 번째로 돌아간다
                progress = 1;
                // 결괏값을 출력한다.
                System.out.println("결괏값입니다.: " + result);
            }
        }
        // 종료 신호가 입력되었다면 반복문 종료
        while (!input.equals("exit"));
        // 계산을 하는 반복문이 종료 된 후 종료 메세지 출력
        System.out.print("계산기를 종료합니다.");
    }
}
