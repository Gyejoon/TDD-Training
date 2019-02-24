/**
 * Factory Method Pattern & TDD
 *
 * @author KJY
 */
public class Money implements Expression {
    protected int amount;
    protected String curreny;

    public Money(int amount, String curreny) {
        this.amount = amount;
        this.curreny = curreny;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, curreny);
    }

    public String currency() {
        return curreny;
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(curreny, to);
        return new Money(amount / rate, to);
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", curreny='" + curreny + '\'' +
                '}';
    }
}
