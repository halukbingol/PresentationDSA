import static java.lang.System.out;

public class UseExpr {
    public static void main(String[] args) {
        Expr x = new Expr.Var("x");
        Expr f = new Expr.Add(new Expr.Mul(new Expr.Num(3), new Expr.Mul(x, x)),    // 3x^2 + 2x + 1
                              new Expr.Add(new Expr.Mul(new Expr.Num(2), x), new Expr.Num(1)));
        out.println("f(x)    = " + Expr.show(f));
        out.println("f(2)    = " + Expr.eval(f, 2));
        Expr df = Expr.derive(f);
        out.println("f'(x)   = " + Expr.show(df));
        out.println("simpler = " + Expr.show(Expr.simplify(df)));
        out.println("f'(2)   = " + Expr.eval(df, 2));
        out.println(f.equals(Expr.simplify(f)) ? "records compare by value: f equals simplify(f)" : "different");
    }
}
