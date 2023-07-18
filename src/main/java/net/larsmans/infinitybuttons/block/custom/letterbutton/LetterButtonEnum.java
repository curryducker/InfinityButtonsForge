package net.larsmans.infinitybuttons.block.custom.letterbutton;

import net.minecraft.util.IStringSerializable;

public enum LetterButtonEnum implements IStringSerializable {

    NONE("none"),
    A("a"),
    B("b"),
    C("c"),
    D("d"),
    E("e"),
    F("f"),
    G("g"),
    H("h"),
    I("i"),
    J("j"),
    K("k"),
    L("l"),
    M("m"),
    N("n"),
    O("o"),
    P("p"),
    Q("q"),
    R("r"),
    S("s"),
    T("t"),
    U("u"),
    V("v"),
    W("w"),
    X("x"),
    Y("y"),
    Z("z"),
    _0("0"),
    _1("1"),
    _2("2"),
    _3("3"),
    _4("4"),
    _5("5"),
    _6("6"),
    _7("7"),
    _8("8"),
    _9("9"),
    DOT("dot"),
    COMMA("comma"),
    Q_MARK("q_mark"),
    EX_MARK("ex_mark"),
    MINUS("minus"),
    PLUS("plus"),
    COLON("colon"),
    EQUALS("equals"),
    HASHTAG("hashtag"),
    BRACKET_OPEN("br_open"),
    BRACKET_CLOSE("br_close"),
    SLASH("slash"),
    ;

    private final String name;

    LetterButtonEnum(String name) {
        this.name = name;
    }

    @Override
    public String getString() {
        return this.name;
    }
}
