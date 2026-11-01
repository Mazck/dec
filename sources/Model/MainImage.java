package Model;

import CLib.mImage;

/* loaded from: KnightOnline_v403.jar:Model/MainImage.class */
public class MainImage {
    public mImage img;

    /* renamed from: w */
    public short f213w;

    /* renamed from: h */
    public short f214h;
    public int count;
    public int timeImageNull;

    public MainImage() {
        this.count = -1;
        this.timeImageNull = 0;
    }

    public MainImage(mImage mimage) {
        this.count = -1;
        this.timeImageNull = 0;
        this.img = mimage;
        this.count = 0;
        this.f213w = (short) mImage.getImageWidth(mimage.image);
        this.f214h = (short) mImage.getImageWidth(mimage.image);
    }
}
