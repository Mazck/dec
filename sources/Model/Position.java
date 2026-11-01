package Model;

/* loaded from: KnightOnline_v403.jar:Model/Position.class */
public class Position {

    /* renamed from: x */
    public int f241x;

    /* renamed from: y */
    public int f242y;
    public int anchor;
    public byte depth;
    public short index;

    public Position() {
        this.depth = (byte) 0;
        this.index = (short) -1;
        this.f241x = 0;
        this.f242y = 0;
    }

    public Position(int i, int i2) {
        this.depth = (byte) 0;
        this.index = (short) -1;
        this.f241x = i;
        this.f242y = i2;
    }

    public Position(int i, int i2, int i3) {
        this.depth = (byte) 0;
        this.index = (short) -1;
        this.f241x = i;
        this.f242y = i2;
        this.anchor = i3;
    }

    public boolean setDetectX(int i, int i2) {
        if (CRes.abs(i - this.f241x) <= i2) {
            return true;
        }
        return false;
    }

    public boolean setDetectY(int i, int i2) {
        if (CRes.abs(i - this.f242y) <= i2) {
            return true;
        }
        return false;
    }
}
