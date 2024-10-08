package gnu.kawa.lispexpr;

import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class ResolveNamespace extends Syntax {
    public static final ResolveNamespace resolveNamespace;
    public static final ResolveNamespace resolveQName = new ResolveNamespace("$resolve-qname", true);
    boolean resolvingQName;

    static {
        ResolveNamespace resolveNamespace2 = new ResolveNamespace("$resolve-namespace$", false);
        resolveNamespace = resolveNamespace2;
        resolveNamespace2.setName("$resolve-namespace$");
    }

    public ResolveNamespace(String name, boolean resolvingQName2) {
        super(name);
        this.resolvingQName = resolvingQName2;
    }

    public Expression rewriteForm(Pair form, Translator tr) {
        Pair pair = (Pair) form.getCdr();
        Namespace namespace = tr.namespaceResolvePrefix(tr.rewrite_car(pair, false));
        if (namespace == null) {
            String pstr = pair.getCar().toString();
            if (pstr == "[default-element-namespace]") {
                namespace = Namespace.EmptyNamespace;
            } else {
                Object savePos = tr.pushPositionOf(pair);
                tr.error('e', "unknown namespace prefix " + pstr);
                tr.popPositionOf(savePos);
                namespace = Namespace.valueOf(pstr, pstr);
            }
        }
        if (this.resolvingQName) {
            return new QuoteExp(namespace.getSymbol(((Pair) pair.getCdr()).getCar().toString()));
        }
        return new QuoteExp(namespace);
    }
}
