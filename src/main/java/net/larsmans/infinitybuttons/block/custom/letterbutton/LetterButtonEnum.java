package net.larsmans.infinitybuttons.block.custom.letterbutton;

import net.minecraft.util.IStringSerializable;

public enum LetterButtonEnum implements IStringSerializable {

    NONE("none", 0),
    A("a", 1),
    B("b", 2),
    C("c", 3),
    D("d", 4),
    E("e", 5),
    F("f", 6),
    G("g", 7),
    H("h", 8),
    I("i", 9),
    J("j", 10),
    K("k", 11),
    L("l", 12),
    M("m", 13),
    N("n", 14),
    O("o", 15),
    P("p", 16),
    Q("q", 17),
    R("r", 18),
    S("s", 19),
    T("t", 20),
    U("u", 21),
    V("v", 22),
    W("w", 23),
    X("x", 24),
    Y("y", 25),
    Z("z", 26),
    _0("0", 27),
    _1("1", 28),
    _2("2", 29),
    _3("3", 30),
    _4("4", 31),
    _5("5", 32),
    _6("6", 33),
    _7("7", 34),
    _8("8", 35),
    _9("9", 36),
    DOT("dot", 37),
    COMMA("comma", 38),
    Q_MARK("q_mark", 39),
    EX_MARK("ex_mark", 40),
    MINUS("minus", 41),
    PLUS("plus", 42),
    COLON("colon", 43),
    EQUALS("equals", 44),
    HASHTAG("hashtag", 45),
    BRACKET_OPEN("br_open", 46),
    BRACKET_CLOSE("br_close", 47),
    SLASH("slash", 48),
    ;

    private final String name;
    private final int id;

    LetterButtonEnum(String name, int enumId) {
        this.name = name;
        this.id = enumId;
    }

    @Override
    public String getString() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
