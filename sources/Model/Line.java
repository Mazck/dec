package Model;

/* loaded from: KnightOnline_v403.jar:Model/Line.class */
public class Line {

    /* renamed from: x0 */
    public int f200x0;

    /* renamed from: y0 */
    public int f201y0;

    /* renamed from: x1 */
    public int f202x1;

    /* renamed from: y1 */
    public int f203y1;

    /* renamed from: vx */
    public int f204vx;

    /* renamed from: vy */
    public int f205vy;

    /* renamed from: f */
    public int f206f;
    public int fRe;
    public int idColor;
    public boolean is2Line = false;

    public void setLine(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        this.f200x0 = i;
        this.f201y0 = i2;
        this.f202x1 = i3;
        this.f203y1 = i4;
        this.f204vx = i5;
        this.f205vy = i6;
        this.is2Line = z;
    }

    public void update() {
        this.f200x0 += this.f204vx;
        this.f202x1 += this.f204vx;
        this.f201y0 += this.f205vy;
        this.f203y1 += this.f205vy;
        this.f206f++;
    }
}
