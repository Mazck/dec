package Model;

import CLib.mGraphics;
import CLib.mVector;
import GameScreen.GameScreen;

/* loaded from: KnightOnline_v403.jar:Model/Point.class */
public class Point {
    public static final byte DAU_CHAN = 0;
    public static final byte DONG_NUOC = 1;

    /* renamed from: x */
    public int f225x;

    /* renamed from: y */
    public int f226y;

    /* renamed from: g */
    public int f227g;

    /* renamed from: v */
    public int f228v;

    /* renamed from: w */
    public int f229w;

    /* renamed from: h */
    public int f230h;
    public int limitY;

    /* renamed from: vx */
    public int f231vx;

    /* renamed from: vy */
    public int f232vy;

    /* renamed from: x2 */
    public int f233x2;

    /* renamed from: y2 */
    public int f234y2;
    public int dis;

    /* renamed from: f */
    public int f235f;
    public int fRe;
    public int frame;
    public int maxframe;
    public int fSmall;
    public mVector vecEffPoint;
    public String name;
    public static FrameImage[] FraEffInMap;
    public int color = 0;
    public boolean isRemove = false;
    public boolean isSmall = false;

    public Point() {
    }

    public Point(int i, int i2) {
        this.f225x = i;
        this.f226y = i2;
    }

    public void update() {
        this.f235f++;
        this.f225x += this.f231vx;
        this.f226y += this.f232vy;
    }

    public void paint(mGraphics mgraphics) {
        if (!this.isRemove) {
            int i = 0;
            if (this.isSmall && this.f235f >= this.fSmall) {
                i = 1;
            }
            FraEffInMap[this.color].drawFrame((this.frame / 2) + i, this.f225x, this.f226y, this.dis, 3, mgraphics);
        }
    }

    public void updateInMap() {
        boolean z = true;
        if (this.color == 0 && GameScreen.vecStep.size() < 10) {
            z = false;
        }
        if (!z) {
            return;
        }
        this.f235f++;
        if (this.maxframe > 1) {
            this.frame++;
            if (this.frame / 2 >= this.maxframe) {
                this.frame = 0;
            }
        }
        if (this.f235f >= this.fRe) {
            this.isRemove = true;
        }
    }
}
