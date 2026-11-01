package InterfaceComponents;

/* loaded from: KnightOnline_v403.jar:InterfaceComponents/DataRebuildItem.class */
public class DataRebuildItem {

    /* renamed from: id */
    public short f149id;
    public short valueWing;

    /* renamed from: lv */
    public byte f150lv;
    public byte cat;
    public int priceCoin;
    public int priceGold;
    public byte[] mValue;

    public DataRebuildItem() {
    }

    public DataRebuildItem(byte b, int i, int i2, byte[] bArr) {
        this.f150lv = b;
        this.priceCoin = i;
        this.priceGold = i2;
        this.mValue = bArr;
    }

    public DataRebuildItem(short s, short s2) {
        this.f149id = s;
        this.valueWing = s2;
    }

    public DataRebuildItem(short s, byte b) {
        this.f149id = s;
        this.cat = b;
    }
}
