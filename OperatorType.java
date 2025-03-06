import java.util.Map;
import java.util.HashMap;

public enum OperatorType {
    SUM("+"),
    DIF("-"),
    MUL("*"),
    QUO("/"),
    REM("%");

    private String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    // SYMAP이라는 맵을 선언
    private static final Map<String, OperatorType> SYMAP = new HashMap<>();

    static {
        // OperatorType의 상수와 필드 값들을 출력
        for (OperatorType op : OperatorType.values()) {
            // 출력된 상수와 필드 값을 SYMAP에 저장
            SYMAP.put(op.getSymbol(), op);
        }
    }

    // String 타입의 입력 Key값에 맞는 Value 값으로 반환해주는 메서드
    public static OperatorType fromSymbol(String symbol) {
        return SYMAP.get(symbol);
    }

    // OperatorType의 input에 입력한 value의 유무를 알리는 메서드
    public static boolean containsSymbol(OperatorType input) {
        return SYMAP.containsValue(input);
    }

}
