package GUI.interfaces;

/**
 * Created by Rick on 9/27/2014.
 */
public interface Box {
    void setSize(int hSize, int vSize);
    void setLocation(int hLocation, int vLocation);
    void setVisible(boolean isVisible);
    void setBackgroundColor(String hexColor);
    void setBorderWidth(int widthPx);
    void setTitle(String title);
    String getTitle();
    int getHSize();
    int getVSize();
    boolean isVisible();
    void setVisibility(boolean isVisible);
    void  setEnabled(boolean enabled);
    boolean isEnabled();
}
