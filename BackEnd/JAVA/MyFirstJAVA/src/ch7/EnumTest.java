package ch7;

enum Direction {
    EAST(1,">"),SOUTH(2,"V"),WEST(3,"<"),NORTH(4,"^");
    private final int value;
    private final String symbol;

    Direction(int value,String symbol){
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue(){return value;}
    public String getSymbol(){return symbol;}

}
public class EnumTest {
    public static void main(String[] args) {
        for (Direction d: Direction.values()) {
            System.out.printf("%s=%d\n",d.name(), d.getValue());
        }
    }


}
