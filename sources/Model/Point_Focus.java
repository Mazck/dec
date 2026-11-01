package Model;

/* loaded from: KnightOnline_v403.jar:Model/Point_Focus.class */
public class Point_Focus {
    public boolean isSpeedUp = false;

    /* renamed from: x */
    public int f236x;

    /* renamed from: y */
    public int f237y;
    public int dis;
    public int fRe;

    /* renamed from: f */
    public int f238f;
    public int frame;

    /* renamed from: vx */
    public int f239vx;

    /* renamed from: vy */
    public int f240vy;
    public int toX;
    public int toY;
    public int maxdis;
    int goc;

    public Point_Focus(int i, int i2, int i3, int i4, int i5) {
        this.f236x = i;
        this.f237y = i2;
        this.toX = i3;
        this.toY = i4;
        this.maxdis = i5;
    }

    public Point_Focus() {
    }

    public void createNormal() {
        this.f239vx = CRes.random_Am(0, 5);
        this.f240vy = CRes.random_Am(0, 5);
    }

    public boolean update() {
        if (this.f236x < this.toX) {
            if (this.f239vx < 4) {
                this.f239vx++;
            }
        } else if (this.f239vx > -4) {
            this.f239vx--;
        }
        if (this.f237y < this.toY) {
            if (this.f240vy < 4) {
                this.f240vy++;
            }
        } else if (this.f240vy > -4) {
            this.f240vy--;
        }
        int i = this.toX - this.f236x;
        int i2 = this.toY - this.f237y;
        if (CRes.abs(i) < this.maxdis && CRes.abs(i2) < this.maxdis) {
            this.f239vx = 0;
            this.f240vy = 0;
            return true;
        }
        this.f236x += this.f239vx;
        this.f237y += this.f240vy;
        return false;
    }

    public void update_Vx_Vy() {
        this.f238f++;
        this.f236x += this.f239vx;
        this.f237y += this.f240vy;
    }
}
