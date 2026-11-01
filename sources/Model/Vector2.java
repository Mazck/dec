package Model;

/* loaded from: KnightOnline_v403.jar:Model/Vector2.class */
public class Vector2 {

    /* renamed from: x */
    public float f247x;

    /* renamed from: y */
    public float f248y;

    public Vector2() {
        this.f247x = 0.0f;
        this.f248y = 0.0f;
    }

    public Vector2(float f, float f2) {
        this.f247x = f;
        this.f248y = f2;
    }

    public void set(Vector2 vector2) {
        this.f247x = vector2.f247x;
        this.f248y = vector2.f248y;
    }

    public Vector2 substract(Vector2 vector2) {
        this.f247x -= vector2.f247x;
        this.f248y -= vector2.f248y;
        return this;
    }

    public Vector2 add(Vector2 vector2) {
        this.f247x += vector2.f247x;
        this.f248y += vector2.f248y;
        return this;
    }

    public Vector2 add(float f, float f2) {
        this.f247x += f;
        this.f248y += f2;
        return this;
    }

    public Vector2 mul(Vector2 vector2) {
        this.f247x += vector2.f247x;
        this.f248y += vector2.f248y;
        return this;
    }

    public float length() {
        return CRes.sqrt((this.f247x * this.f247x) + (this.f248y * this.f248y));
    }

    public Vector2 normalize() {
        float length = length();
        if (length != 0.0f) {
            this.f247x /= length;
            this.f248y /= length;
        }
        return this;
    }

    public static float distance(Vector2 vector2, Vector2 vector22) {
        float f = vector22.f247x - vector2.f247x;
        float f2 = vector22.f248y - vector2.f248y;
        return CRes.sqrt((f * f) + (f2 * f2));
    }

    public static Vector2 substract(Vector2 vector2, Vector2 vector22) {
        return new Vector2(vector22.f247x - vector2.f247x, vector22.f248y - vector2.f248y);
    }
}
