/** An expression tree as a sealed hierarchy of records (Java 21). */
public sealed interface Expr permits Expr.Num, Expr.Var, Expr.Add, Expr.Mul {
    record Num(double v) implements Expr { }
    record Var(String name) implements Expr { }
    record Add(Expr l, Expr r) implements Expr { }
    record Mul(Expr l, Expr r) implements Expr { }

    static double eval(Expr e, double x) {                 // postorder
        return switch (e) {
            case Num n -> n.v();
            case Var v -> x;
            case Add(Expr l, Expr r) -> eval(l, x) + eval(r, x);
            case Mul(Expr l, Expr r) -> eval(l, x) * eval(r, x);
        };                                                 // no default: the compiler checks all cases
    }

    static String show(Expr e) {                           // inorder with brackets
        return switch (e) {
            case Num n -> n.v() == Math.rint(n.v()) ? String.valueOf((long) n.v()) : String.valueOf(n.v());
            case Var v -> v.name();
            case Add(Expr l, Expr r) -> "(" + show(l) + " + " + show(r) + ")";
            case Mul(Expr l, Expr r) -> show(l) + " * " + show(r);
        };
    }

    static Expr derive(Expr e) {                           // d/dx, builds a new tree
        return switch (e) {
            case Num n -> new Num(0);
            case Var v -> new Num(1);
            case Add(Expr l, Expr r) -> new Add(derive(l), derive(r));
            case Mul(Expr l, Expr r) -> new Add(new Mul(derive(l), r), new Mul(l, derive(r)));
        };
    }

    static Expr simplify(Expr e) {                         // postorder: children first
        return switch (e) {
            case Add(Expr l, Expr r) -> {
                Expr a = simplify(l), b = simplify(r);
                if (a instanceof Num(double v) && v == 0) yield b;
                if (b instanceof Num(double v) && v == 0) yield a;
                yield new Add(a, b);
            }
            case Mul(Expr l, Expr r) -> {
                Expr a = simplify(l), b = simplify(r);
                if (a instanceof Num(double v) && v == 0 || b instanceof Num(double w) && w == 0) yield new Num(0);
                if (a instanceof Num(double v) && v == 1) yield b;
                if (b instanceof Num(double v) && v == 1) yield a;
                yield new Mul(a, b);
            }
            default -> e;
        };
    }
}
