import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Calculator {

    // record 리스트 생성
    private List<String> record;

    // 리스트 초기화
    public Calculator() {
        record = new ArrayList<>();
    }

    // 리스트를 접근하여 수정
    public void setRecord(String value) {
        record.add(value);
    }

    // 리스트를 접근하여 확인
    public List<String> getRecord() {
        return record;
    }

    // 리스트를 접근하여 크기를 확인
    public int getRecordSize() {
        return record.size();
    }

    // 리스트를 접근하여 첫 번째 배열을 삭제
    public List<String> removeRecord() {
        if (!record.isEmpty()) {
            // 첫 번째 입력 삭제
            record.remove(0);
        }
        return record;
    }

    // 입력 값을 진행 상황과 재입력 상황에 따라 확인하는 메서드
    static boolean reEnter(String input, int progress) {
        // 연산 기호를 Set으로 묶음
        Set<String> operator = Set.of("+", "-", "*", "/", "%");
        // 반환될 결괏값
        boolean reEnter = true;

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
        return reEnter;
    }
    // 정수와 실수를 구분하여 계산
    static String calculator(String firstValue, String sign, String secondValue) {
        // num1~2 정수 계산
        int num1 = 0, num2 = 0;
        // num3~4 실수 계산
        double num3 = 0.0, num4 = 0.0;
        // 출력 값
        String result = " ";

        // 나누기를 할 때 정수에서 실수로 변경해야 할 경우를 구분 짓는 변수
        // 10 / 3 = 1: 실수로 변경
        boolean quotient = true;

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
        // 결괏값을 반환
        return result;
    }
}

