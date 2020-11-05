package unionfind;

public interface UF {

    int getsize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);

}
