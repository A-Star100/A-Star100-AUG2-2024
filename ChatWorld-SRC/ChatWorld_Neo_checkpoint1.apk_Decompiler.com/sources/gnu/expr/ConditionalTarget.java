package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Type;

public class ConditionalTarget extends Target {
    public Label ifFalse;
    public Label ifTrue;
    Language language;
    public boolean trueBranchComesFirst = true;

    public ConditionalTarget(Label ifTrue2, Label ifFalse2, Language language2) {
        this.ifTrue = ifTrue2;
        this.ifFalse = ifFalse2;
        this.language = language2;
    }

    public Type getType() {
        return Type.booleanType;
    }

    public void compileFromStack(Compilation comp, Type stackType) {
        CodeAttr code = comp.getCode();
        switch (stackType.getSignature().charAt(0)) {
            case 'D':
                code.emitPushDouble(0.0d);
                break;
            case 'F':
                code.emitPushFloat(0.0f);
                break;
            case 'J':
                code.emitPushLong(0);
                break;
            case 'L':
            case '[':
                Language language2 = this.language;
                comp.compileConstant(language2 == null ? Boolean.FALSE : language2.booleanObject(false));
                break;
            default:
                if (this.trueBranchComesFirst) {
                    code.emitGotoIfIntEqZero(this.ifFalse);
                    code.emitGoto(this.ifTrue);
                    return;
                }
                code.emitGotoIfIntNeZero(this.ifTrue);
                code.emitGoto(this.ifFalse);
                return;
        }
        if (this.trueBranchComesFirst) {
            code.emitGotoIfEq(this.ifFalse);
        } else {
            code.emitGotoIfNE(this.ifTrue);
        }
        emitGotoFirstBranch(code);
    }

    public final void emitGotoFirstBranch(CodeAttr code) {
        code.emitGoto(this.trueBranchComesFirst ? this.ifTrue : this.ifFalse);
    }
}
