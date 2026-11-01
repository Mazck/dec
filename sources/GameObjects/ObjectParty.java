package GameObjects;

/* loaded from: KnightOnline_v403.jar:GameObjects/ObjectParty.class */
public class ObjectParty {

    /* renamed from: Lv */
    public short f99Lv;
    public String name;
    public byte idArea;
    public int idMap;

    /* renamed from: x */
    public int f100x;

    /* renamed from: y */
    public int f101y;

    /* renamed from: hp */
    public int f102hp;
    public int maxhp;
    public boolean isRemove = false;
    public boolean ischeck = true;

    public ObjectParty(String str, short s, int i, byte b) {
        this.idArea = b;
        this.idMap = i;
        this.name = str;
        this.f99Lv = s;
    }
}
