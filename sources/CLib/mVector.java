package CLib;

import java.util.Vector;

/* loaded from: KnightOnline_v403.jar:CLib/mVector.class */
public class mVector {

    /* renamed from: a */
    private Vector f7a;
    private String name;

    public mVector() {
        this.f7a = new Vector();
        this.name = "EffectManager";
    }

    public mVector(String str) {
        this.f7a = new Vector();
        this.name = str;
    }

    public mVector(Vector vector) {
        this.f7a = vector;
        this.name = "No Name";
    }

    public void addElement(Object obj) {
        this.f7a.addElement(obj);
    }

    public boolean contains(Object obj) {
        if (this.f7a.contains(obj)) {
            return true;
        }
        return false;
    }

    public int size() {
        if (this.f7a == null) {
            return 0;
        }
        return this.f7a.size();
    }

    public Object elementAt(int i) {
        if (i > -1 && i < this.f7a.size()) {
            return this.f7a.elementAt(i);
        }
        return null;
    }

    public void setElementAt(Object obj, int i) {
        if (i > -1 && i < this.f7a.size()) {
            this.f7a.setElementAt(obj, i);
        }
    }

    public int indexOf(Object obj) {
        return this.f7a.indexOf(obj);
    }

    public void removeElementAt(int i) {
        if (i > -1 && i < this.f7a.size()) {
            this.f7a.removeElementAt(i);
        }
    }

    public void removeElement(Object obj) {
        this.f7a.removeElement(obj);
    }

    public void removeAllElements() {
        this.f7a.removeAllElements();
    }

    public void insertElementAt(Object obj, int i) {
        this.f7a.insertElementAt(obj, i);
    }

    public Object firstElement() {
        return this.f7a.firstElement();
    }

    public Object lastElement() {
        return this.f7a.lastElement();
    }
}
