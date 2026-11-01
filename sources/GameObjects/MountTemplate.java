package GameObjects;

/* loaded from: KnightOnline_v403.jar:GameObjects/MountTemplate.class */
public class MountTemplate {
    public short idTemplate;
    public short idImage;

    /* renamed from: lv */
    public short f88lv;
    public byte typemove;
    public String name = "";
    public static final byte NGUA_NAU = 0;
    public static final byte NGUA_TRANG = 1;
    public static final byte NGUA_CHIENGIAP = 2;
    public static final byte NGUA_DO = 3;
    public static final byte NGUA_DEN = 4;

    /* renamed from: me */
    public static MountTemplate f89me;
    public static byte[] speed;
    public static byte[][] FRAME_VE_TRUOC;
    public static byte[][] DY_CHAR_STAND;
    public static byte[][] DY_CHAR_MOVE;

    /* renamed from: dx */
    public static byte[][] f90dx;
    public static byte[] Arr_Fly;

    /* renamed from: dy */
    public static byte[][] f91dy;
    public static byte[][] FRAME_MOVE_LR;
    public static byte[][] FRAME_MOVE_DOWN;
    public static byte[][] FRAME_MOVE_UP;

    /* renamed from: gI */
    public static MountTemplate m2gI() {
        if (f89me != null) {
            return f89me;
        }
        MountTemplate mountTemplate = new MountTemplate();
        f89me = mountTemplate;
        return mountTemplate;
    }
}
